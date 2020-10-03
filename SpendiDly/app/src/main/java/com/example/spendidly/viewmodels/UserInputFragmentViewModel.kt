package com.example.spendidly.viewmodels

import android.app.Application
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test.data.Demographics
import com.example.test.data.DemographicsX
import kotlinx.coroutines.launch

class UserInputFragmentViewModel(application: Application) : BaseViewModel(application), Observable {
    // TODO: Implement the ViewModel
    // two-way databinding for user input here instead of in view?

    @Bindable
    val age = MutableLiveData<String>()

    @Bindable
    val grossAnnualIncome = MutableLiveData<String>()

    @Bindable
    val members = MutableLiveData<String>()

    @Bindable
    val netAnnualIncome = MutableLiveData<String>()

    @Bindable
    val zipCode = MutableLiveData<String>()

    @Bindable
    val isHomeowner = MutableLiveData<Boolean>(false)


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

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("Not yet implemented")
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("Not yet implemented")
    }
}