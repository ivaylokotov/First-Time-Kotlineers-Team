package com.example.spendidly.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.test.data.BudgetX
import kotlinx.coroutines.launch

class AverageBudgetFragmentViewModel(application: Application) : BudgetFragmentViewModel(application) {
    fun getAverageBudgetX(): LiveData<BudgetX?> {
        budget = spendiDRepository.getAverageBudget()

        Log.i("AverageVM", "fetchedAverageBudget${budget.value}")

        return budget
    }
}