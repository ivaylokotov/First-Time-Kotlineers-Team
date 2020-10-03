package com.example.spendidly.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserInputFragmentViewModel(application: Application) : BaseViewModel(application) {
    // TODO: Implement the ViewModel
    // two-way databinding for user input here instead of in view?


    // LiveData of generic Response?
    fun getBudgetX() {
        viewModelScope.launch {
            // TODO: Use repository instance here and make API call;
        }
    }
}