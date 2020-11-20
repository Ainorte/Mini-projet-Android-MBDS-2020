package com.mbds.bmp.newsletter.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mbds.bmp.newsletter.R
import com.mbds.bmp.newsletter.databinding.ItemCountryBinding
import com.mbds.bmp.newsletter.model.Country


class CountryAdapter(private val dataSet: List<Country>) :
    RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

    class ViewHolder(private val root: View, private val dataSet: List<Country>) :
        RecyclerView.ViewHolder(root) {

        internal val binding = ItemCountryBinding.bind(root)

        fun bind(item: Country) {

            binding.country = item
            binding.countryImage.setImageDrawable(item.getFlag(root.context))
            binding.countryName.text = item.getName(root.context)

            binding.countryCard.setOnClickListener {
                if (item.countryCode == null) {
                    //Set reverse of All box to everyone
                    val newValue = !item.active
                    dataSet.forEach { country ->
                        country.active = newValue
                    }
                } else {
                    item.active = !item.active

                    //Check new state of "All" box
                    val newValueForNullChecked =
                        dataSet.filter { country -> country.countryCode != null }
                            .map { country -> country.active }
                            .reduce { c1, c2 -> c1 && c2 }

                    //Set new value of "All" box
                    dataSet.filter { country -> country.countryCode == null }
                        .forEach { country -> country.active = newValueForNullChecked }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_country, parent, false)
        return ViewHolder(rootView, dataSet)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount(): Int = dataSet.size

}