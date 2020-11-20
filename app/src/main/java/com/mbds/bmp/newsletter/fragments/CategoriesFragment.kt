package com.mbds.bmp.newsletter.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.Observable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.mbds.bmp.newsletter.MainActivity
import com.mbds.bmp.newsletter.R
import com.mbds.bmp.newsletter.adapters.CategoryAdapter
import com.mbds.bmp.newsletter.data.Data
import com.mbds.bmp.newsletter.databinding.FragmentSelectorsBinding
import com.mbds.bmp.newsletter.model.Category


class CategoriesFragment: Fragment() {

    lateinit var binding: FragmentSelectorsBinding
    lateinit var categories: List<Category>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSelectorsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //On creer la liste des categories et on l'affiche dans le fragment

        val recyclerView = binding.recyclerView
        categories = Data.getCategoryList()
        categories.forEach { category ->
            category.active = true

            //listen change on category to block button when no category is selected.
            category.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
                override fun onPropertyChanged(observable: Observable, i: Int) {
                    binding.nextButton.isEnabled = categories.map { category -> category.active }
                        .reduce { cat1, cat2 -> cat1 || cat2 }
                }
            })
        }
        val categoriesAdapter = CategoryAdapter(categories)

        recyclerView.layoutManager = GridLayoutManager(view.context, 2)
        recyclerView.hasFixedSize()
        recyclerView.adapter = categoriesAdapter

        activity?.setTitle(R.string.categories)
        binding.nextButton.text = context?.getText(R.string.select_countries)
        binding.nextButton.setOnClickListener {
            goToNextSelector()
        }
    }

    private fun goToNextSelector() {
        val result = categories.filter { category -> !category.key.isNullOrBlank() }
        val mainActivity = activity as MainActivity
        mainActivity.changeFragment(CountriesFragment())
    }
}