package com.example.indiandefenselovers.view.viewHolders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.indiandefenselovers.R

class MentorsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val userId = itemView.findViewById<TextView>(R.id.userId)
    val title = itemView.findViewById<TextView>(R.id.title)
    val body = itemView.findViewById<TextView>(R.id.body)
}