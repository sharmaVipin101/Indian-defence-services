package com.example.indiandefenselovers.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.indiandefenselovers.BaseFiles.BaseCustomView
import com.example.indiandefenselovers.R
import com.example.indiandefenselovers.view.viewHolders.MentorsViewHolder

class MentorsAdapter(private val context: Context): RecyclerView.Adapter<MentorsViewHolder>() {

    private var list: ArrayList<BaseCustomView> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MentorsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.mentor_list_view, parent, false)
        return MentorsViewHolder(view)
    }

    override fun onBindViewHolder(holder: MentorsViewHolder, position: Int) {
        val curr = list[position]
        holder.body.text = curr.user.description
        holder.title.text = curr.user.email
        holder.userId.text = curr.user.fee?.halfHour.toString()
    }

    override fun getItemCount(): Int {
        return list.size
    }

   fun update(list: List<BaseCustomView>) {
       this.list.addAll(list)
        notifyDataSetChanged()
    }

}