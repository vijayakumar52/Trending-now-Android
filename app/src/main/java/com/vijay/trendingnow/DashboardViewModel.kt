package com.vijay.trendingnow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vijay.trendingnow.db.GoogleTrendingData
import com.vijay.trendingnow.model.Default

class DashboardViewModel() : ViewModel() {
    val repository = DashboardRepository(AppController.instance.applicationContext, AppController.instance.appDatabase)
    private val googleTrendingList: MutableLiveData<List<GoogleTrendingData>> = MutableLiveData()

    fun getGoogleTrendingList(): LiveData<List<GoogleTrendingData>> = repository.getGoogleTrendingList()
}