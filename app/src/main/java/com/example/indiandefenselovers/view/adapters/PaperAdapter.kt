package com.example.indiandefenselovers.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.indiandefenselovers.R
import com.example.indiandefenselovers.repository.model.Paper
import com.example.indiandefenselovers.repository.model.QA
import com.example.indiandefenselovers.view.viewHolders.PaperViewHolder

class PaperAdapter: RecyclerView.Adapter<PaperViewHolder>() {

    private var list = arrayListOf<Paper?>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaperViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.paper, parent, false)
        val vh = PaperViewHolder(view)
        return vh
    }

    override fun onBindViewHolder(holder: PaperViewHolder, position: Int) {
        val current = list[position]
        holder.updateViews(current)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun update(list: List<Paper?>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }
}

interface IPaperClick {
    fun onReadOnlineClick(qa: QA?)
    fun onDownloadClick(qa: QA?)
    fun onToggleClick(view: View)
}