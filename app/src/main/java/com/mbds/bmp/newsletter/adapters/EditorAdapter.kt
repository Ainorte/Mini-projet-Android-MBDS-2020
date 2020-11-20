package com.mbds.bmp.newsletter.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mbds.bmp.newsletter.MainActivity
import com.mbds.bmp.newsletter.R
import com.mbds.bmp.newsletter.databinding.ItemEditorBinding
import com.mbds.bmp.newsletter.model.Editor

class EditorAdapter(private val dataSet: List<Editor>) :
    RecyclerView.Adapter<EditorAdapter.ViewHolder>() {

    class ViewHolder(private val root: View) : RecyclerView.ViewHolder(root) {

        internal val binding = ItemEditorBinding.bind(root)

        fun bind(item: Editor) {
            binding.name.text = item.name

            binding.item.setOnClickListener {
                val mainActivity = (root.context as MainActivity)
                //mainActivity.changeFragment()
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