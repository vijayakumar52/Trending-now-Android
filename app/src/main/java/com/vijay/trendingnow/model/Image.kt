package com.vijay.trendingnow.model

import com.google.gson.annotations.SerializedName

class Image {
    @SerializedName("newsUrl")
    lateinit var newsURL: String
    @SerializedName("source")
    lateinit var source: String
    @SerializedName("imageUrl")
    lateinit var imageURL: String
}