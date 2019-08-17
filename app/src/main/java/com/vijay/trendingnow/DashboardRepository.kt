package com.vijay.trendingnow

import androidx.lifecycle.LiveData
import com.vijay.trendingnow.db.AppDatabase
import com.vijay.trendingnow.db.TrendingData

class DashboardRepository(private val databaseInstance: AppDatabase) {

    init {
        databaseInstance.trendingDao().addData(TrendingData("Google"), TrendingData("Twitter"))
    }

    fun getGoogleTrendings(): LiveData<List<TrendingData>> {
        return databaseInstance.trendingDao().getAllTrendingData()
    }
}