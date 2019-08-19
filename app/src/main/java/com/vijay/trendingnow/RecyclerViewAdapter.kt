package com.vijay.trendingnow

import android.content.Context
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.vijay.trendingnow.db.TrendingData
import org.w3c.dom.Text

class RecyclerViewAdapter(val context: Context, val recyclerView: RecyclerView, var listItems: List<TrendingData>) : RecyclerView.Adapter<RecyclerViewAdapter.CustomViewHolder>() {
    var mExpandedPosition = -1
    var mPreviousExpandedPosition = -1
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

        val isExpanded = position == mExpandedPosition
        holder.moreDetails.visibility = if (isExpanded) View.VISIBLE else View.GONE
        holder.moreDetails.isActivated = isExpanded

        if (isExpanded) {
            mPreviousExpandedPosition = position
        }
        holder.inflatedView.setOnClickListener {
            mExpandedPosition = if (isExpanded) -1 else position
            notifyItemChanged(mPreviousExpandedPosition)
            notifyItemChanged(mExpandedPosition)
        }
    }


    inner class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val inflatedView = view;
        val title = view.findViewById<TextView>(R.id.tv_title)
        val views = view.findViewById<TextView>(R.id.tv_count)
        val link = view.findViewById<TextView>(R.id.tv_link)
        val imageView = view.findViewById<ImageView>(R.id.iv_image)
        val moreDetails = view.findViewById<TextView>(R.id.tv_more_details)
    }
}