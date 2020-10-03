package com.example.spendidly.viewmodels

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.test.data.BudgetX
import kotlinx.coroutines.launch

class LatestBudgetFragmentViewModel(application: Application) :
    BudgetFragmentViewModel(application) {
    // TODO: Implement the ViewModel
    // TODO: use database cache as single source of truth
    fun getLatestBudget(): LiveData<BudgetX?> {
        viewModelScope.launch {
            budget = spendiDRepository.getLatestBudgetXCache()
        }
        return budget
    }
}