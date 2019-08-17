package com.vijay.trendingnow

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vijay.trendingnow.db.TrendingData

class RecyclerViewAdapter(val context: Context, var listItems: List<TrendingData>) : RecyclerView.Adapter<RecyclerViewAdapter.CustomViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview_elements, null))
    }

    fun updateItems(newElements: List<TrendingData>) {
        listItems = newElements
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.text.text = listItems.get(position).name
    }


    inner class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val text = view.findViewById<TextView>(R.id.tv_name)
    }
}