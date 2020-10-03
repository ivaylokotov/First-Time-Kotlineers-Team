package com.example.spendidly.persistence

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class AppDatabase : RoomDatabase() {

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context) : AppDatabase {
            synchronized(this) {
                var instance = this.instance
                if(instance == null) {
                    instance = Room.databaseBuilder(context.applicationContext,
                        AppDatabase::class.java, "app_database.db")
                        .build()
                }
                return instance
            }
        }
    }
    
    abstract fun demographicsXDao() : DemographicsXDao

    abstract fun budgetXDao() : BudgetXDao
}