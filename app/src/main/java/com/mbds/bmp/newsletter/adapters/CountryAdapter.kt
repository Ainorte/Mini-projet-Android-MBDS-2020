package com.mbds.bmp.newsletter.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mbds.bmp.newsletter.MainActivity
import com.mbds.bmp.newsletter.R

import com.mbds.bmp.newsletter.databinding.ItemPaysBinding
import com.mbds.bmp.newsletter.fragments.ArticlesFragment
import com.mbds.bmp.newsletter.model.Category
import com.mbds.bmp.newsletter.model.Country
import com.mbds.bmp.newsletter.tools.getName
import com.mbds.bmp.newsletter.tools.setImageFromUrl


class CountryAdapter (private val dataSet: List<Country>)
    : RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

    class ViewHolder(private val root: View) : RecyclerView.ViewHolder(root) {

        internal lateinit var binding: ItemPaysBinding

        fun bind(item: Country) {
            binding.paysImage.setImageFromUrl(item.image, R.drawable.placeholder_category, root)
            binding.paysName.text = item.getName(root.context)

            binding.paysItem.setOnClickListener {
                val mainActivity = (root.context as MainActivity)
                mainActivity.changeFragment(ArticlesFragment.newInstance(Category(0, "", ""), item))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category, parent, false)
        val viewHolder = ViewHolder(rootView)
        viewHolder.binding = ItemPaysBinding.bind(rootView)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount(): Int = dataSet.size

}