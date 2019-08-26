package com.vijay.trendingnow.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.vijay.trendingnow.model.TrendingSearches

class TrendingSearchesConverter {
    @TypeConverter
    fun toList(countryLang: List<TrendingSearches>?): String? {
        if (countryLang == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<TrendingSearches>>() {

        }.type
        return gson.toJson(countryLang, type)
    }

    @TypeConverter
    fun fromList(countryLangString: String?): List<TrendingSearches>? {
        if (countryLangString == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<TrendingSearches>>() {

        }.type
        return gson.fromJson<List<TrendingSearches>>(countryLangString, type)
    }
}