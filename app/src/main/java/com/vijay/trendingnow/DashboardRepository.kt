package com.vijay.trendingnow

import androidx.lifecycle.LiveData
import com.vijay.trendingnow.db.AppDatabase
import com.vijay.trendingnow.db.TrendingData
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class DashboardRepository(private val databaseInstance: AppDatabase) {
    val networkManager = NetworkRequestManager()
    val compositeDisposable = CompositeDisposable()

    fun getGoogleTrendingList(): LiveData<List<TrendingData>> {
        compositeDisposable.add(networkManager.getGoogleTrendingList().subscribeOn(Schedulers.io()).subscribe({ rssItems ->
            val trendingList = ArrayList<TrendingData>()
            for (item in rssItems) {
                trendingList.add(TrendingData(item.title).apply {
                    imageURL = item.imageURL
                    views = item.views
                    link = item.link
                })
            }
            addRecord(trendingList)
        }, {

        }))
        return databaseInstance.trendingDao().getAllTrendingData()
    }

    //Add records to table

    fun addRecord(list: List<TrendingData>) {
        databaseInstance.trendingDao().removeOldData()
        databaseInstance.trendingDao().addData(list)
    }
}