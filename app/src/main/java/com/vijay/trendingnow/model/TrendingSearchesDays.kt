package com.vijay.trendingnow.model

import com.google.gson.annotations.SerializedName

class TrendingSearchesDays {
    @SerializedName("date")
    lateinit var date: String
    @SerializedName("formattedDate")
    lateinit var formattedDate: String
    @SerializedName("trendingSearches")
    lateinit var trendingSearches: ArrayList<TrendingSearches>
}