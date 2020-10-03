package com.example.spendidly.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.test.data.BudgetX
import com.example.test.data.DemographicsX

@Database(entities = [DemographicsX::class, BudgetX::class], version = 1, exportSchema = false)
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