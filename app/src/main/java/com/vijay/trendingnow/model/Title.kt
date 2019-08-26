package com.vijay.trendingnow.model

import com.google.gson.annotations.SerializedName

class Title {
    @SerializedName("query")
    lateinit var query: String
    @SerializedName("exploreLink")
    lateinit var exploreLink: String
}