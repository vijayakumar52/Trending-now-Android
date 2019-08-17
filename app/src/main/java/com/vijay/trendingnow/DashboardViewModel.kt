package com.vijay.trendingnow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vijay.trendingnow.db.TrendingData

class DashboardViewModel() : ViewModel() {
    val repository = DashboardRepository(AppController.instance.appDatabase)
    private val googleTrendingList: MutableLiveData<List<TrendingData>> = MutableLiveData()

    fun getGoogleTrendingList(): LiveData<List<TrendingData>> = repository.getGoogleTrendings()
}