package com.example.spendidly.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.spendidly.repos.SpendiDRepository
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

// base viewModel class for all viewModels
abstract class BaseViewModel(application: Application) : AndroidViewModel(application), KodeinAware {
    override val kodein: Kodein by kodein(application.applicationContext) // delegate Kodein instance through appcontext
    val spendiDRepository: SpendiDRepository by instance(tag = "spendiDRepository")
}