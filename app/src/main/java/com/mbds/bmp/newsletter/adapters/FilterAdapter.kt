package com.mbds.bmp.newsletter.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mbds.bmp.newsletter.MainActivity
import com.mbds.bmp.newsletter.R
import com.mbds.bmp.newsletter.databinding.ItemSelectorBinding
import com.mbds.bmp.newsletter.model.Filter
import com.mbds.bmp.newsletter.tools.setImageFromUrl

class FilterAdapter(private val dataSet: List<Filter>) :
    RecyclerView.Adapter<FilterAdapter.ViewHolder>() {

    class ViewHolder(private val root: View) : RecyclerView.ViewHolder(root) {

        internal val binding = ItemSelectorBinding.bind(root)

        fun bind(item: Filter) {
            binding.image.setImageFromUrl(item.image, R.drawable.placeholder_small, root)
            binding.name.text = root.context.getText(item.nameId)

            binding.item.setOnClickListener {
                val mainActivity = (root.context as MainActivity)
                mainActivity.changeFragment(item.fragment)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_selector, parent, false)
        return ViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount(): Int = dataSet.size

}