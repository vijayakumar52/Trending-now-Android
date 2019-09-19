package com.vijay.trendingnow.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.vijay.trendingnow.model.TrendingSearches
import com.vijay.trendingnow.typeconverters.TrendingSearchesConverter

@Entity(tableName = GoogleTrendingData.TABLE_NAME)
class GoogleTrendingData {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @Transient
    var id: Long = 0

    @ColumnInfo(name = "Date")
    var date: Long = 0

    @ColumnInfo(name = "Formatted Date")
    lateinit var formattedDate: String

    @ColumnInfo(name = "TrendingSearches")
    @TypeConverters(TrendingSearchesConverter::class)
    lateinit var trendingSearches: List<TrendingSearches>

    companion object {
        const val TABLE_NAME = "googleTrending"
    }
}