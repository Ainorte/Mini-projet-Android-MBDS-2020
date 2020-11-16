package com.mbds.bmp.newsletter.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mbds.bmp.newsletter.R
import com.mbds.bmp.newsletter.databinding.FragmentArticleBinding
import com.mbds.bmp.newsletter.model.Article
import com.mbds.bmp.newsletter.tools.getCleanContent
import com.mbds.bmp.newsletter.tools.setImageFromUrl

class ArticleFragment : Fragment() {
    private var article: Article? = null
    private lateinit var binding: FragmentArticleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            article = it.getSerializable(ARG_ARTICLE) as Article
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentArticleBinding.inflate(inflater, container, false)

        binding.author.text = article?.author
        binding.content.text = article?.getCleanContent()
        binding.description.text = article?.description
        binding.date.text = article?.publishedAt?.toString()
        binding.source.text = article?.source?.name
        binding.title.text = article?.title
        binding.url.text = article?.url
        binding.image.setImageFromUrl(
            article?.urlToImage ?: "",
            R.drawable.placeholder_article,
            binding.root
        )

        return binding.root
    }

    companion object {

        val ARG_ARTICLE = "Article"

        @JvmStatic
        fun newInstance(article: Article) =
            ArticleFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_ARTICLE, article)
                }
            }
    }
}