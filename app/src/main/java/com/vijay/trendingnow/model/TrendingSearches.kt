package com.vijay.trendingnow.model

import com.google.gson.annotations.SerializedName

class TrendingSearches {
    @SerializedName("title")
    lateinit var title: Title
    @SerializedName("formattedTraffic")
    lateinit var formattedTraffic: String
    @SerializedName("relatedQueries")
    lateinit var relatedQueries: ArrayList<Title>
    @SerializedName("image")
    lateinit var image: Image
    @SerializedName("articles")
    lateinit var articles: ArrayList<Article>
}