package com.vijay.trendingnow

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.vijay.trendingnow.db.TrendingData

class RecyclerViewAdapter(val context: Context, var listItems: List<TrendingData>) : RecyclerView.Adapter<RecyclerViewAdapter.CustomViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview_elements, parent, false))
    }

    fun updateItems(newElements: List<TrendingData>) {
        listItems = newElements
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val item = listItems.get(position)
        holder.title.text = item.name
        holder.views.text = item.views
        holder.link.text = item.link
        Picasso.get().load(item.imageURL).into(holder.imageView)
    }


    inner class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.findViewById<TextView>(R.id.tv_title)
        val views = view.findViewById<TextView>(R.id.tv_count)
        val link = view.findViewById<TextView>(R.id.tv_link)
        val imageView = view.findViewById<ImageView>(R.id.iv_image)
    }
}