package com.vijay.trendingnow.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "trending")
data class TrendingData(
        @ColumnInfo(name = "name") val name: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0

    @ColumnInfo(name = "views")
    var views: String? = null

    @ColumnInfo(name = "imageURL")
    var imageURL: String? = null

    @ColumnInfo(name = "link")
    var link: String? = null
}