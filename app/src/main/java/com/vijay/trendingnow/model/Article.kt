package com.vijay.trendingnow.model

import com.google.gson.annotations.SerializedName

class Article {
    @SerializedName("title")
    lateinit var title: String
    @SerializedName("timeAgo")
    lateinit var timeAgo: String
    @SerializedName("source")
    lateinit var source: String
    @SerializedName("image")
    lateinit var image: Image
    @SerializedName("url")
    lateinit var url: String
    @SerializedName("snippet")
    lateinit var snippet: String
}