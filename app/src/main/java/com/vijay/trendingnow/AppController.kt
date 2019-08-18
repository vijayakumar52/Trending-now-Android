package com.vijay.trendingnow

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.vijay.trendingnow.db.AppDatabase

class AppController : Application() {
    lateinit var appDatabase: AppDatabase
    override fun onCreate() {
        super.onCreate()
        instance = this
        appDatabase = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, "trending-database"
        ).allowMainThreadQueries().addCallback(object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
               /* val tableName = "trending"
                val trigger = ("CREATE TRIGGER IF NOT EXISTS p AFTER INSERT ON " + tableName //No i18n
                        + " BEGIN " +
                        "DELETE FROM $tableName WHERE id NOT IN (SELECT MAX(id) FROM $tableName)" +
                        " END") //No i18n

                db.execSQL(trigger)*/
            }
        }).build()
    }

    companion object {
        lateinit var instance: AppController
    }
}