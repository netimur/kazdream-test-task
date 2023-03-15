package com.netimur.kazdream.data.datasource.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.netimur.kazdream.data.model.embeddedcity.EmbeddedCity


@Database(entities = [EmbeddedCity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getEmbeddedCityDao(): EmbeddedCityDao

    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE =
                        Room.databaseBuilder(context, AppDatabase::class.java, "app_database")
                            .createFromAsset("database/app_database.db") .build()
                }
            }
            return INSTANCE!!
        }
    }
}