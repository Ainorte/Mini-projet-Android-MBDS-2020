package com.mbds.bmp.newsletter.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.mbds.bmp.newsletter.R
import com.mbds.bmp.newsletter.adapters.FilterAdapter
import com.mbds.bmp.newsletter.data.Data
import com.mbds.bmp.newsletter.databinding.FragmentSelectorsBinding

class HomeFragment : Fragment() {

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

        val recyclerView = binding.recyclerView
        val categoriesAdapter = FilterAdapter(Data.getFilterList())

        recyclerView.layoutManager = GridLayoutManager(view.context, 2)
        recyclerView.hasFixedSize()
        recyclerView.adapter = categoriesAdapter

        activity?.setTitle(R.string.app_name)
    }

}