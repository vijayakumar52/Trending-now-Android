package com.vijay.trendingnow

import android.content.Context
import androidx.lifecycle.LiveData
import com.vijay.androidutils.Logger
import com.vijay.androidutils.PrefUtils
import com.vijay.trendingnow.db.AppDatabase
import com.vijay.trendingnow.db.GoogleTrendingData
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.*
import kotlin.collections.ArrayList

class DashboardRepository(val context: Context, private val databaseInstance: AppDatabase) {
    val networkManager = NetworkRequestManager()
    val compositeDisposable = CompositeDisposable()

    fun getGoogleTrendingList(): LiveData<List<GoogleTrendingData>> {
        val calendar = Calendar.getInstance()
        var month = (calendar.get(Calendar.MONTH) + 1).toString()
        val year = calendar.get(Calendar.YEAR).toString()
        val day = calendar.get(Calendar.DAY_OF_MONTH).toString()

        if (month.length == 1) {
            month = "0${month}"
        }


        val date = year + month + day

        //val date = if ("" == endDataForNextRequest) null else endDataForNextRequest
        val isAvailableInDB = databaseInstance.trendingDao().getTrendingData(date).isNotEmpty()
        Logger.d(TAG, "isAvailableInDB: $isAvailableInDB")
        if (!isAvailableInDB) {
            getGoogleTrendingList(date)
        }
        return databaseInstance.trendingDao().getAllDataLiveData()
    }

    fun getGoogleTrendingList(date: String) {
        compositeDisposable.add(networkManager.getGoogleTrendingList(date, null).subscribeOn(Schedulers.io()).subscribe({ data ->
            val googleTrendingList = ArrayList<GoogleTrendingData>()
            val trendingSearchDays = data.default.trendingSearchDays
            for (eachDay in trendingSearchDays) {
                val trendingData = GoogleTrendingData()
                trendingData.date = eachDay.date
                trendingData.formattedDate = eachDay.formattedDate
                trendingData.trendingSearches = eachDay.trendingSearches
                googleTrendingList.add(trendingData)
            }

            databaseInstance.trendingDao().addData(googleTrendingList)
        }, {

        }))
    }

    companion object {
        val TAG: String = DashboardRepository::class.java.simpleName
    }
}