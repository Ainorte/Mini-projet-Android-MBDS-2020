package com.mbds.bmp.newsletter.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.mbds.bmp.newsletter.R
import com.mbds.bmp.newsletter.adapters.CountryAdapter
import com.mbds.bmp.newsletter.data.Data
import com.mbds.bmp.newsletter.databinding.FragmentSelectorsBinding

class CountriesFragment: Fragment() {

    lateinit var binding: FragmentSelectorsBinding

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
        val countries = Data.getCountryList()
        val countriesAdapter = CountryAdapter(countries)

        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.hasFixedSize()
        recyclerView.adapter = countriesAdapter

        activity?.setTitle(R.string.countries)



    }
}