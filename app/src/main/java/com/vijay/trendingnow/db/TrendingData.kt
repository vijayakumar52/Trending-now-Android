package com.vijay.trendingnow.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "trending")
data class TrendingData(
        @ColumnInfo(name = "name") val name: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}