package com.example.spendidly

import android.app.Application
import com.example.spendidly.api.SPENDiDAPI
import com.example.spendidly.persistence.AppDatabase
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

class MainApplication : Application(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        bind(tag = "apiService") from singleton { SPENDiDAPI.invoke() }
        bind(tag = "database") from singleton { AppDatabase.getInstance(context = applicationContext) }
    }
}