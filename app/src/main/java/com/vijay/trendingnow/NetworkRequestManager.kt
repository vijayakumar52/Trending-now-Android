package com.vijay.trendingnow

import android.net.Uri
import com.google.gson.GsonBuilder
import com.vijay.androidutils.exceptions.UnknownException
import com.vijay.androidutils.network.*
import com.vijay.trendingnow.model.Default
import io.reactivex.Single


class NetworkRequestManager {

    fun getGoogleTrendingList(date: String?, progressView: NetworkProgressView?): Single<Default> {
        return Single.create {
            val baseURL = "https://trends.google.com/trends/api/dailytrends?hl=en-US&tz=-330&geo=US&ns=15"
            val url = Uri.Builder().encodedPath(baseURL)
            if (date != null) {
                NetworkRequest.addQueryParams(url, HashMap<String, String>().apply { put("ed", date) })
            }
            val requestData = RequestData.RequestDataBuilder(url.build().toString()).setRequestMethod(NetworkRequest.GET).setCallback(object : AsyncTaskListener {
                override fun onSuccess(response: Any, extras: Any?) {
                    val responseString = response.toString().removeRange(0, 6)
                    val gson = GsonBuilder().create()
                    val result = gson.fromJson(responseString, Default::class.java)
                    it.onSuccess(result)
                }

                override fun onError(errorObject: ErrorObject, extras: Any?) {
                    it.onError(UnknownException())
                }

            }).setProgressView(progressView).setReturnTypeAsBytes(false).setWho("GOOGLE TRENDING LIST").build()
            MakeNetworkRequest(requestData).executeAsyncTask()
        }
    }
}