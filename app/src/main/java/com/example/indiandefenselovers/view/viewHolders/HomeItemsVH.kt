package com.example.indiandefenselovers.view.viewHolders

import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.indiandefenselovers.R
import com.example.indiandefenselovers.repository.model.Clickable
import com.google.android.material.textview.MaterialTextView

class HomeItemsVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val title = itemView.findViewById<MaterialTextView>(R.id.home_item_card_heading)
    private val subtitle = itemView.findViewById<MaterialTextView>(R.id.home_item_card_desc)
    private val banner = itemView.findViewById<ImageView>(R.id.banner_image)

    fun setData(data: Clickable?) {
        title.text = data?.title
        subtitle.text = data?.subTitleA
        data?.image.let {
            Glide.with(itemView.context).load(it).into(banner)
        }
    }
}