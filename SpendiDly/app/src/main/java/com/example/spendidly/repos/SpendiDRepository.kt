package com.example.spendidly.repos

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.spendidly.api.SPENDiDAPI
import com.example.spendidly.models.ResponseState
import com.example.spendidly.persistence.DemographicsXDao
import com.example.spendidly.persistence.BudgetXDao
import com.example.test.data.BudgetX
import com.example.test.data.Demographics
import com.example.test.data.DemographicsX
import retrofit2.HttpException

class SpendiDRepository(
    private val spendIdApi: SPENDiDAPI,
    private val demographicsXDao: DemographicsXDao,
    private val budgetXDao: BudgetXDao
) {

    suspend fun getBudgetXAsync(demographics: Demographics): ResponseState {
        demographicsXDao.insert(demographics.demographics)

        return try {
            val budget = spendIdApi.getBudgetAsync(demographics)

            Log.i("SpendidRepository", "com.example.spendidly.models.Budget fetched:$budget")

            budgetXDao.insert(budget.budget)

            ResponseState.Success(budget)
        } catch(ex: Exception) { // the only way of handling multiple exceptions rn
            when (ex) {
                // TODO: probably add custom exception if the user has no access to Internet
                is HttpException -> ResponseState.Error.NetworkError(ex.code()) // api errors
                is SPENDiDAPI.NoConnectivityException -> ResponseState.Error.NoConnectivityError // connection errors
                else -> ResponseState.Unknown
            }
        }
    }

    // latest cache
    fun getLatestBudgetXCache(): LiveData<BudgetX?> = budgetXDao.getLatestBudgetX()

    // average cache
    fun getAverageBudget() : LiveData<BudgetX?> = budgetXDao.getAverageBudget()

    // TODO: for use in other fragment, listing all demographics
    suspend fun getAllDemographicsXCache(): List<DemographicsX>? = demographicsXDao.getAllDemographicsX()

    suspend fun getLatestDemographicsXCache(): DemographicsX? = demographicsXDao.getLatestDemographicsX()
}