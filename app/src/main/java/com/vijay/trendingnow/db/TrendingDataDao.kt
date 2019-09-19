package com.vijay.trendingnow.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Flowable

@Dao
interface TrendingDataDao {
    @Query("SELECT * FROM ${GoogleTrendingData.TABLE_NAME}")
    fun getAllDataLiveData(): Flowable<List<GoogleTrendingData>>

    @Query("SELECT * FROM ${GoogleTrendingData.TABLE_NAME} WHERE Date is :date")
    fun getTrendingDataLiveData(date: String): Flowable<List<GoogleTrendingData>>

    @Query("SELECT * FROM ${GoogleTrendingData.TABLE_NAME} WHERE Date is :date")
    fun getTrendingData(date: String): List<GoogleTrendingData>

    @Insert
    fun addData(users: GoogleTrendingData)

    @Insert
    fun addData(users: List<GoogleTrendingData>)

    @Delete
    fun deleteData(user: GoogleTrendingData)

    @Query("DELETE FROM ${GoogleTrendingData.TABLE_NAME} WHERE Date is :date")
    fun deleteData(date: String)

    @Query("DELETE FROM ${GoogleTrendingData.TABLE_NAME}")
    fun flushTable()
}