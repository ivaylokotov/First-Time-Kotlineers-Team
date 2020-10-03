package com.example.spendidly.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.test.data.BudgetX
import kotlinx.coroutines.launch

class AverageBudgetFragmentViewModel(application: Application) : BudgetFragmentViewModel(application) {
    // TODO: use database cache as single source of truth
    fun getAverageBudgetX(): LiveData<BudgetX?> {
        viewModelScope.launch {
            budget = MutableLiveData(spendiDRepository.getAverageBudgetXCache())

            Log.i("AverageVM", "fetchedAverageBudget${budget.value}")
        }
        return budget
    }
}