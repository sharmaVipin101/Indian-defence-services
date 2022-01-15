package com.example.indiandefenselovers.view.adapters.homeAdapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.indiandefenselovers.BaseFiles.clickableCallback
import com.example.indiandefenselovers.R
import com.example.indiandefenselovers.repository.model.Clickable
import com.example.indiandefenselovers.view.viewHolders.HomeItemsVH

class HomeItemsAdapter(private val clickable: clickableCallback): RecyclerView.Adapter<HomeItemsVH>() {

    private val homeItemList = arrayListOf<Clickable?>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeItemsVH {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.home_item, parent, false)
            val vh = HomeItemsVH(view)
            vh.itemView.setOnClickListener {
                clickable.onItemClick(homeItemList[vh.adapterPosition])
            }
            return vh
    }

    override fun onBindViewHolder(holder: HomeItemsVH, position: Int) {
        val currentItem = homeItemList[position]
        holder.setData(currentItem)
    }

    override fun getItemCount(): Int {
        return homeItemList.size
    }

    fun updateList(list: List<Clickable?>) {
        homeItemList.clear()
        homeItemList.addAll(list)
        notifyDataSetChanged()
    }
}