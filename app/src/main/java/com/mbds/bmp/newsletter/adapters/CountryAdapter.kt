package com.mbds.bmp.newsletter.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mbds.bmp.newsletter.MainActivity
import com.mbds.bmp.newsletter.R
import com.mbds.bmp.newsletter.databinding.ItemCategoryBinding
import com.mbds.bmp.newsletter.fragments.EditorsFragment
import com.mbds.bmp.newsletter.model.Country


class CountryAdapter (private val dataSet: List<Country>)
    : RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

    class ViewHolder(private val root: View) : RecyclerView.ViewHolder(root) {

        internal val binding = ItemCategoryBinding.bind(root)

        fun bind(item: Country) {

            binding.image.setImageDrawable(item.getFlag(root.context))
            binding.name.text = item.getName(root.context)

            binding.item.setOnClickListener {
                val mainActivity = (root.context as MainActivity)
                mainActivity.changeFragment(EditorsFragment())
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category, parent, false)
        return ViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount(): Int = dataSet.size

}