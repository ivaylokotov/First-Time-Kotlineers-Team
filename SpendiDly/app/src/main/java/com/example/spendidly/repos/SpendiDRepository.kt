package com.example.spendidly.repos

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

            budgetXDao.insert(budget.budget)

            ResponseState.Success(budget)
        } catch(ex: Exception) { // the only way of handling multiple exceptions rn
            when (ex) {
                // TODO: probably add custom exception if the user has no access to Internet
                is HttpException -> ResponseState.Error.NetworkError(ex.code()) // api errors
                else -> ResponseState.Unknown // unknown errors
            }
        }
    }

    fun getLatestBudgetXCache(): LiveData<BudgetX?> = budgetXDao.getLatestBudgetX()

    suspend fun getAllBudgetXCache(): List<BudgetX>? = budgetXDao.getAllBudgetX()

    suspend fun getAverageBudgetXCache(): BudgetX? {
        val allBudgetX = getAllBudgetXCache()
        if(allBudgetX != null) {
            return allBudgetX.reduce { f: BudgetX, s: BudgetX -> f + s } / allBudgetX.size
            // should work; FIXME if something bugs here (from reduce possibly)
        }
        return null
    }

    suspend fun getAllDemographicsXCache(): List<DemographicsX>? = demographicsXDao.getAllDemographicsX()

    fun getLatestDemographicsXCache(): LiveData<DemographicsX?> = demographicsXDao.getLatestDemographicsX()
}