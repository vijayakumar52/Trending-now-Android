package com.vijay.trendingnow

import android.content.Context
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.Group
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.vijay.androidutils.AndroidUtils
import com.vijay.trendingnow.model.ListData

class RecyclerViewAdapter(val context: Context, var listItems: List<ListData>) : RecyclerView.Adapter<RecyclerViewAdapter.CustomViewHolder>() {
    var mExpandedPosition = -1
    var mPreviousExpandedPosition = -1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview_parent_element, parent, false))
    }

    fun updateItems(newElements: List<ListData>) {
        listItems = newElements
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val item = listItems.get(position)
        holder.title.text = item.title
        holder.date.text = getRelativeTime(item.date)
        holder.views.text = item.views

        if(item.articles.isEmpty()){
            return
        }

        val firstArticle = item.articles.first()
        Picasso.get().load(firstArticle.image.imageURL).into(holder.imageView)
        holder.image_source.text = firstArticle.image.source
        holder.description.text = Html.fromHtml(firstArticle.snippet)
        holder.source.text = firstArticle.source
        holder.dot.text = Html.fromHtml("\u2022")
        //holder.source.text = item.source



        /* //setting news
         for (i in item.relatedNews.indices) {
             val newsItem = item.news!![i]
             val newsTitle = newsItem.title
             val newsContent = newsItem.details
             val newsSource = newsItem.source
             if (i == 0) {
                 val view = LayoutInflater.from(context).inflate()
                 holder.news_1_title.text = Html.fromHtml(newsTitle)
                 holder.news_1_content.text = Html.fromHtml(newsContent)
                 holder.news_1_source.text = newsSource
             } else {

             }
         }

         val isExpanded = position == mExpandedPosition
         holder.newsGroup.visibility = if (isExpanded) View.VISIBLE else View.GONE
         holder.newsGroup.isActivated = isExpanded

         if (isExpanded) {
             mPreviousExpandedPosition = position
         }
         holder.inflatedView.setOnClickListener
         {
             mExpandedPosition = if (isExpanded) -1 else position
             notifyItemChanged(mPreviousExpandedPosition)
             notifyItemChanged(mExpandedPosition)
         }*/
    }

    fun getRelativeTime(date: Long): String {
        return "5h ago"
    }

    inner class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val inflatedView = view;
        val title = view.findViewById<TextView>(R.id.parent_title)
        val description = view.findViewById<TextView>(R.id.parent_description)
        val imageView = view.findViewById<ImageView>(R.id.parent_image)
        val views = view.findViewById<TextView>(R.id.parent_views)
        val source = view.findViewById<TextView>(R.id.parent_source)
        val date = view.findViewById<TextView>(R.id.parent_date)
        val image_source = view.findViewById<TextView>(R.id.tv_image_source)
        val dot = view.findViewById<TextView>(R.id.parent_dot)
    }
}