package com.vijay.trendingnow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vijay.trendingnow.db.GoogleTrendingData
import com.vijay.trendingnow.model.Article
import com.vijay.trendingnow.model.ListData
import io.reactivex.disposables.CompositeDisposable

class DashboardViewModel() : ViewModel() {
    val context = AppController.instance.applicationContext
    val compositeDisposable = CompositeDisposable()
    val repository = DashboardRepository(AppController.instance.applicationContext, AppController.instance.appDatabase)
    private val googleTrendingList: MutableLiveData<List<ListData>> = MutableLiveData()

    init {
        compositeDisposable.add(repository.getGoogleTrendingList().subscribe({
            //Sort by date then by views
            it!!
            it.sortedWith(compareBy({ it.date }))
            googleTrendingList.postValue(getListData(it))
        }, {

        }))
    }

    fun getGoogleTrendingList(): LiveData<List<ListData>> {
        return googleTrendingList
    }

    fun getListData(googleTrendingData: List<GoogleTrendingData>): List<ListData> {
        val listItems = ArrayList<ListData>()
        for (trendingData in googleTrendingData) {
            val date = trendingData.date
            val searches = trendingData.trendingSearches
            for (search in searches) {
                val listData = ListData()
                val title = search.title
                val views = search.formattedTraffic
                val articles = search.articles

                val allArticles = ArrayList<Article>()
                for (eachNews in articles) {
                    allArticles.add(eachNews)
                }

                listData.title = title.query
                listData.views = views
                listData.date = date
                listData.articles = allArticles
                listItems.add(listData)
            }
        }
        return listItems
    }

    fun deleteAllData(){
        repository.deleteAllData()
    }
}