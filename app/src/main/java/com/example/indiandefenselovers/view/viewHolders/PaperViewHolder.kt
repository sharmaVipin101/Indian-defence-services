package com.example.indiandefenselovers.view.viewHolders

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import com.example.indiandefenselovers.R
import com.example.indiandefenselovers.repository.model.Paper
import com.example.indiandefenselovers.repository.model.QA
import com.example.indiandefenselovers.view.adapters.IPaperClick
import com.google.android.material.button.MaterialButton

class PaperViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val year: TextView = itemView.findViewById(R.id.year)
    val papers: LinearLayout = itemView.findViewById(R.id.papers)

    fun updateViews(paper: Paper?) {
        papers.removeAllViews()
        year.text = paper?.year
        paper?.phaseOne?.qPaper?.let { list ->
            for (element in list.indices) {
                val view = LayoutInflater.from(itemView.context)
                    .inflate(R.layout.read_download_buttons, papers, false)

                view.findViewById<TextView>(R.id.subject_name).text = list[element]?.paperName
                view.findViewById<Button>(R.id.download).setOnClickListener {
                    clickable.onReadOnlineClick(list[element])
                }
                view.findViewById<Button>(R.id.read_offline).setOnClickListener {
                    clickable.onDownloadClick(list[element])
                }
                view.findViewById<MaterialButton>(R.id.paper_toggle).setOnClickListener {
                    clickable.onToggleClick(view)
                }
                papers.addView(view)
            }
        }
    }

    private var clickable = object : IPaperClick {
        override fun onReadOnlineClick(qa: QA?) {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(qa?.paperLink))
            itemView.context.startActivity(intent)
        }

        override fun onDownloadClick(qa: QA?) {

        }

        override fun onToggleClick(view: View) {
            if (view.findViewById<LinearLayout>(R.id.paper_body).visibility == View.VISIBLE) {
                view.findViewById<LinearLayout>(R.id.paper_body).visibility = View.GONE
                view.findViewById<MaterialButton>(R.id.paper_toggle).background = ContextCompat.getDrawable(itemView.context,R.drawable.ic_up)
                } else {
                view.findViewById<LinearLayout>(R.id.paper_body).visibility = View.VISIBLE
                view.findViewById<MaterialButton>(R.id.paper_toggle).background = ContextCompat.getDrawable(itemView.context,R.drawable.ic_down)
                }
        }

    }

}