package com.example.spendidly

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
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

        // todo: put these strings in constants obj
        bind(tag = "connectivityManager") from singleton { applicationContext!!.getSystemService(
            Context.CONNECTIVITY_SERVICE) as ConnectivityManager }
        bind(tag = "api") from singleton { SPENDiDAPI.invoke(instance(tag = "connectivityManager")) }
        bind(tag = "database") from singleton { AppDatabase.getInstance(context = applicationContext) }
        bind(tag = "spendiDRepository") from singleton { SpendiDRepository(instance(tag = "api"), (instance(tag = "database") as AppDatabase)
            .demographicsXDao(), (instance(tag = "database") as AppDatabase).budgetXDao()) }
    }
}