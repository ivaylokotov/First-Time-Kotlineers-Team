package com.example.spendidly.viewmodels

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.test.data.DemographicsX
import kotlinx.coroutines.launch

class MainActivityViewModel(application: Application) : BaseViewModel(application) {
    var demographicsX: LiveData<List<DemographicsX>?> = MutableLiveData(null)

    fun getAllDemographics(): LiveData<List<DemographicsX>?> {
        demographicsX = spendiDRepository.getAllDemographicsXCache()
        return demographicsX
    }
}