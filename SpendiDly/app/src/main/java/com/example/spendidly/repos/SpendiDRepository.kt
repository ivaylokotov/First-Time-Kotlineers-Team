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

    fun getLatestBudgetXCache(): LiveData<BudgetX?> = budgetXDao.getLatestBudgetX()

    private suspend fun getAllBudgetXCache(): List<BudgetX>? = budgetXDao.getAllBudgetX()

    suspend fun getAverageBudgetXCache(): BudgetX? {
        val allBudgetX = getAllBudgetXCache()
        Log.i("SpendidRepo", "allBudgetsFetched$allBudgetX")
        if(allBudgetX != null && allBudgetX.isNotEmpty()) {
            return allBudgetX.reduce(BudgetX::plus) / allBudgetX.size
            // should work; FIXME if something bugs here (from reduce possibly)
        }
        return null
    }

    fun getAllDemographicsXCache(): LiveData<List<DemographicsX>?> = demographicsXDao.getAllDemographicsX()

    suspend fun getLatestDemographicsXCache(): DemographicsX? = demographicsXDao.getLatestDemographicsX()
}