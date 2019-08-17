package com.vijay.trendingnow.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(TrendingData::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun trendingDao(): TrendingDataDao
}