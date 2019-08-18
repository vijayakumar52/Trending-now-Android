package com.vijay.trendingnow

import com.vijay.trendingnow.rssparser.RssItem
import com.vijay.trendingnow.rssparser.RssReader
import io.reactivex.Single
import java.net.URL


class NetworkRequestManager {
    fun getGoogleTrendingList(): Single<List<RssItem>> {
        return Single.create {
            val url = URL("https://trends.google.com/trends/trendingsearches/daily/rss?geo=US")
            val feed = RssReader.read(url)
            it.onSuccess(feed.rssItems)
        }
    }
}