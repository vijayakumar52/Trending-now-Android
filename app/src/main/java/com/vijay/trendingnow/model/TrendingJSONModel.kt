package com.vijay.trendingnow.model

import com.google.gson.annotations.SerializedName

class TrendingJSONModel {
    @SerializedName("endDateForNextRequest")
    lateinit var endDateForNextRequest: String
    @SerializedName("trendingSearchesDays")
    lateinit var trendingSearchDays: ArrayList<TrendingSearchesDays>

}