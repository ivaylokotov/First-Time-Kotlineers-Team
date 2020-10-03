package com.example.spendidly

import android.app.Application
import com.example.spendidly.api.SPENDiDAPI
import com.example.spendidly.persistence.AppDatabase
import com.example.spendidly.repos.SpendiDRepository
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton


class MainApplication : Application(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@MainApplication))

        bind(tag = "api") from singleton { SPENDiDAPI.invoke() }
        bind(tag = "database") from singleton { AppDatabase.getInstance(context = applicationContext) }
        bind(tag = "spendiDRepository") from singleton { SpendiDRepository(instance(tag = "api"), (instance(tag = "database") as AppDatabase)
            .demographicsXDao(), (instance(tag = "database") as AppDatabase).budgetXDao()) }
    }
}