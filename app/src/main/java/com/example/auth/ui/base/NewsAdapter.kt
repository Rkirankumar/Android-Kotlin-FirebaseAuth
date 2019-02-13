package com.example.auth.ui.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.auth.R

class NewsAdapter(private val newsList: ArrayList<News>) : RecyclerView.Adapter<NewsAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textViewTitle.text = newsList[position].title
        holder.textViewInfo.text = newsList[position].info
    }


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val textViewTitle = itemView.findViewById<TextView>(R.id.text_view_title)!!
        val textViewInfo = itemView.findViewById<TextView>(R.id.text_view_info)!!

    }
}