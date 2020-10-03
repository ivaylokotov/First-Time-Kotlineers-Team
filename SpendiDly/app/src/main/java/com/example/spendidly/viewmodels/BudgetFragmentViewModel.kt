package com.example.spendidly.viewmodels

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.test.data.BudgetX

// abstract viewmodel containing a budget (different references & instances for different fragments down the line)
abstract class BudgetFragmentViewModel(application: Application) : BaseViewModel(application) {
    // TODO: Implement the ViewModel
    var budget: LiveData<BudgetX?> = MutableLiveData<BudgetX?>() // fetched budget from cache (average/latest)
}