package com.vijay.trendingnow

import android.app.Application
import androidx.room.Room
import com.vijay.trendingnow.db.AppDatabase

class AppController : Application() {
    lateinit var appDatabase: AppDatabase
    override fun onCreate() {
        super.onCreate()
        instance = this
        appDatabase = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, "trending-database"
        ).allowMainThreadQueries().build()
    }

    companion object {
        lateinit var instance: AppController
    }
}