package com.mbds.bmp.newsletter.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import com.mbds.bmp.newsletter.R
import com.mbds.bmp.newsletter.adapters.ArticleAdapter
import com.mbds.bmp.newsletter.databinding.FragmentArticlesBinding
import com.mbds.bmp.newsletter.listener.ArticlesScrollListener
import com.mbds.bmp.newsletter.model.Article
import com.mbds.bmp.newsletter.model.Category
import com.mbds.bmp.newsletter.model.Country
import com.mbds.bmp.newsletter.model.Editor
import com.mbds.bmp.newsletter.repositories.ArticleRepository
import com.mbds.bmp.newsletter.tools.isOnline
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ArticlesFragment : Fragment() {

    lateinit var binding: FragmentArticlesBinding
    private var category: Category? = null
    private var country: Country? = null
    private var editor: Editor? = null
    private val articleRepository = ArticleRepository()
    private val articleAdapter = ArticleAdapter(mutableListOf())
    private val articlesScrollListener = ArticlesScrollListener()

    private var isLoading = false

    private var errorSnackBar: Snackbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            category = it.getSerializable(ARG_CATEGORY) as Category
            country = it.getSerializable(ARG_COUNTRY) as Country
            editor = it.getSerializable(ARG_EDITOR) as Editor
        }

        activity?.setTitle(R.string.results)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentArticlesBinding.inflate(inflater, container, false)

        val recyclerView = binding.articlesView

        recyclerView.layoutManager = LinearLayoutManager(view?.context)
        recyclerView.hasFixedSize()
        recyclerView.adapter = articleAdapter

        articlesScrollListener.loadMoreCallback = {
            launchQuery()
        }

        launchQuery()

        return binding.root
    }

    private fun launchQuery() {
        if (!isLoading) {
            isLoading = true
            lifecycleScope.launch {
                articleAdapter.dataSet.add(null)
                articleAdapter.notifyItemInserted(articleAdapter.itemCount - 1)
                binding.articlesView.removeOnScrollListener(articlesScrollListener)
                getData()
            }
        }
    }

    private suspend fun getData() {
        withContext(Dispatchers.IO)
        {
            if (context?.isOnline() == true) {
                val result = articleRepository.list(category, country, editor)
                if (result != null) {
                    bindData(result)
                } else {
                    displayError(R.string.request_error)
                }
            } else {
                displayError(R.string.no_internet_error)
            }
        }
    }

    private suspend fun bindData(result: List<Article>) {
        withContext(Dispatchers.Main)
        {
            articleAdapter.dataSet.removeLast()
            articleAdapter.notifyItemRemoved(articleAdapter.itemCount)

            articleAdapter.dataSet.addAll(result)
            articleAdapter.notifyDataSetChanged()

            binding.articlesView.addOnScrollListener(articlesScrollListener)
            isLoading = false
        }
    }

    private suspend fun displayError(@StringRes errorId: Int) {
        withContext(Dispatchers.Main)
        {
            errorSnackBar = Snackbar.make(
                binding.root,
                errorId,
                BaseTransientBottomBar.LENGTH_INDEFINITE
            )
            errorSnackBar?.setAction(R.string.retry) {
                launchQuery()
            }
            errorSnackBar?.show()

            articleAdapter.dataSet.removeLast()
            articleAdapter.notifyItemRemoved(articleAdapter.itemCount)
            binding.articlesView.addOnScrollListener(articlesScrollListener)
            isLoading = false
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        errorSnackBar?.dismiss()
    }



    companion object {
        private const val ARG_CATEGORY = "category"
        private const val ARG_COUNTRY = "country"
        private const val ARG_EDITOR = "editor"

        @JvmStatic
        fun newInstance(category: Category?, country: Country?, editor: Editor) =
            ArticlesFragment().apply {
                arguments = Bundle().apply {
                    category.let {
                        putSerializable(ARG_CATEGORY, it)
                    }
                    country.let {
                        putSerializable(ARG_COUNTRY, it)
                    }
                    editor.let {
                        putSerializable(ARG_EDITOR, it)
                    }
                }
            }
    }
}