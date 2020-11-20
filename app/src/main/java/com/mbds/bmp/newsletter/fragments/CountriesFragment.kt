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
import com.mbds.bmp.newsletter.adapters.CountryAdapter
import com.mbds.bmp.newsletter.data.Data
import com.mbds.bmp.newsletter.databinding.FragmentSelectorsBinding
import com.mbds.bmp.newsletter.model.Category
import com.mbds.bmp.newsletter.model.Country

class CountriesFragment: Fragment() {

    lateinit var binding: FragmentSelectorsBinding
    var categories: List<Category>? = null
    lateinit var countries: List<Country>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            val categoryArray = it.getSerializable(ARG_CATEGORIES) as ArrayList<Category>?
            categories = categoryArray?.toList() as List<Category>
        }
        activity?.setTitle(R.string.results)
    }

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

        //On creer la liste des pays et on l'affiche dans le fragment

        val recyclerView = binding.recyclerView
        countries = Data.getCountryList()
        countries.forEach { country ->
            country.active = true

            //listen change on category to block button when no category is selected.
            country.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
                override fun onPropertyChanged(observable: Observable, i: Int) {
                    binding.nextButton.isEnabled = countries.map { country -> country.active }
                        .reduce { c1, c2 -> c1 || c2 }
                }
            })
        }
        val countriesAdapter = CountryAdapter(countries)

        recyclerView.layoutManager = GridLayoutManager(view.context, 2)
        recyclerView.tag = R.layout.item_country
        recyclerView.hasFixedSize()
        recyclerView.adapter = countriesAdapter

        binding.nextButton.text = context?.getText(R.string.select_editors)
        binding.nextButton.setOnClickListener {
            goToNextSelector()
        }

        activity?.setTitle(R.string.countries)
    }

    private fun goToNextSelector() {
        //Go To Editor Fragment
        val result = countries.filter { country -> country.countryCode != null }
        val mainActivity = activity as MainActivity
        mainActivity.changeFragment(EditorsFragment())
    }

    companion object {
        private const val ARG_CATEGORIES = "categories"

        @JvmStatic
        fun newInstance(categories: List<Category>) =
            CountriesFragment().apply {
                arguments = Bundle().apply {
                    val categoriesArray = ArrayList<Category>()
                    categoriesArray.addAll(categories)
                    putSerializable(ARG_CATEGORIES, categoriesArray)
                }
            }
    }
}