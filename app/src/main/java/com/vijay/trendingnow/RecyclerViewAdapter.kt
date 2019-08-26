package com.vijay.trendingnow

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.Group
import androidx.recyclerview.widget.RecyclerView
import com.vijay.trendingnow.model.Default

class RecyclerViewAdapter(val context: Context, val recyclerView: RecyclerView, var listItems: List<Default>) : RecyclerView.Adapter<RecyclerViewAdapter.CustomViewHolder>() {
    var mExpandedPosition = -1
    var mPreviousExpandedPosition = -1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview_elements, parent, false))
    }

    fun updateItems(newElements: List<Default>) {
        listItems = newElements
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val item = listItems.get(position)
       /* holder.title.text = item.name
        holder.views.text = getViews(item.views!!)
        //holder.link.text = item.description
        Picasso.get().load(item.imageURL).into(holder.imageView)

        //setting news
        if (item.news != null) {
            for (i in 0 until item.news!!.size) {
                val newsItem = item.news!![i]
                val newsTitle = newsItem.title
                val newsContent = newsItem.details
                val newsSource = newsItem.source
                if (i == 0) {
                    holder.news_1_title.text = Html.fromHtml(newsTitle)
                    holder.news_1_content.text = Html.fromHtml(newsContent)
                    holder.news_1_source.text = newsSource
                } else {

                }
            }
        }*/

        val isExpanded = position == mExpandedPosition
        holder.newsGroup.visibility = if (isExpanded) View.VISIBLE else View.GONE
        holder.newsGroup.isActivated = isExpanded

        if (isExpanded) {
            mPreviousExpandedPosition = position
        }
        holder.inflatedView.setOnClickListener {
            mExpandedPosition = if (isExpanded) -1 else position
            notifyItemChanged(mPreviousExpandedPosition)
            notifyItemChanged(mExpandedPosition)
        }
    }

    private fun getViews(views: Long): String {
        return if (views >= 1000000) {
            String.format("%dM", views / 1000000)
        } else if (views >= 1000) {
            String.format("%dK", views / 1000)
        } else {
            return views.toString()
        }
    }


    inner class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val inflatedView = view;
        val title = view.findViewById<TextView>(R.id.tv_title)
        val views = view.findViewById<TextView>(R.id.tv_count)
        val link = view.findViewById<TextView>(R.id.tv_link)
        val imageView = view.findViewById<ImageView>(R.id.iv_image)
        val news_1_title = view.findViewById<TextView>(R.id.tv_news_title1)
        val news_1_content = view.findViewById<TextView>(R.id.tv_news_content1)
        val news_1_source = view.findViewById<TextView>(R.id.tv_news_source1)
        val newsGroup = view.findViewById<Group>(R.id.news_group)
    }
}