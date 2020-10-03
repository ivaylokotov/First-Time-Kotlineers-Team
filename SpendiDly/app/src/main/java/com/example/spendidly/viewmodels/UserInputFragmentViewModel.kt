package com.example.spendidly.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test.data.Demographics
import com.example.test.data.DemographicsX
import kotlinx.coroutines.launch

class UserInputFragmentViewModel(application: Application) : BaseViewModel(application) {
    // TODO: Implement the ViewModel
    // two-way databinding for user input here instead of in view?


    // LiveData of generic Response?
    fun getBudgetX() {
        viewModelScope.launch {
            spendiDRepository.getBudgetXAsync(Demographics(
                DemographicsX(
                    System.currentTimeMillis() / 1000,
                0,
                0,
                0,
                false,
                0,
                "21324") // Placeholder; TODO: To be replaced with values from databinding input fields
                )
            )
        }
    }
}