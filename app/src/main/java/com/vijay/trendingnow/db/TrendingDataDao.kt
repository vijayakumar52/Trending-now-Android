package com.vijay.trendingnow.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TrendingDataDao {
    @Query("SELECT * FROM trending")
    fun getAllTrendingData(): LiveData<List<TrendingData>>

    @Insert
    fun addData(users: List<TrendingData>)

    @Delete
    fun deleteData(user: TrendingData)


    @Query("DELETE FROM trending WHERE id NOT IN (SELECT id FROM trending ORDER BY id LIMIT 20);")
    fun removeOldData()
}