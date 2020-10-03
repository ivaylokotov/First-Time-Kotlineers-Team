package com.example.spendidly.viewmodels

import android.app.Application
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
            // TODO: Use repository instance here and make API call;
        }
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("Not yet implemented")
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("Not yet implemented")
    }
}