package com.example.spendidly.viewmodels

import android.app.Application
import android.util.Log
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.*
import com.example.spendidly.models.ResponseState
import com.example.test.data.Demographics
import com.example.test.data.DemographicsX
import kotlinx.coroutines.launch
import java.util.*

class UserInputFragmentViewModel(application: Application) : BaseViewModel(application), Observable {
    // TODO: Implement the ViewModel
    // two-way databinding for user input here instead of in view?

    @delegate:Transient
    private val callBacks: PropertyChangeRegistry by lazy { PropertyChangeRegistry() }

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
    fun getBudgetX(): LiveData<ResponseState> =
        liveData { // liveData builder constructs a liveData object
            spendiDRepository.getBudgetXAsync(
                getDemographicsFields()
            ).also {
                emit(it)
            }
    }

    private fun getDemographicsFields(): Demographics {
        val demographics = DemographicsX(
            Calendar.getInstance().timeInMillis / 1000,
            age.value!!.toInt(),
            grossAnnualIncome.value!!.toInt(),
            members.value!!.toInt(),
            isHomeowner.value!!,
            netAnnualIncome.value!!.toInt(),
            zipCode.value!! // ex: "35210"
        )

        Log.i("UserInputFragViewModel", "Demographics sent:" + demographics.toString())

        return Demographics(demographics = demographics)
    }

    fun setIsHomeowner(isHomeowner: Boolean) = this.isHomeowner.postValue(isHomeowner)

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) = callBacks.add(callback)

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) = callBacks.remove(callback)
}