package com.vijay.trendingnow.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.vijay.trendingnow.typeconverters.TrendingSearchesConverter

@Database(entities = arrayOf(GoogleTrendingData::class), version = 1)
@TypeConverters(TrendingSearchesConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun trendingDao(): TrendingDataDao
}