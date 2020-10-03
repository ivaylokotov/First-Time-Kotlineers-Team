package com.example.spendidly.repos

import com.example.spendidly.api.SPENDiDAPI
import com.example.spendidly.models.ResponseState
import com.example.spendidly.persistence.DemographicsXDao
import com.example.spendidly.persistence.BudgetXDao
import com.example.test.data.BudgetX
import com.example.test.data.Demographics
import retrofit2.HttpException

class SpendiDRepository(
    private val spendIdApi: SPENDiDAPI,
    private val demographicsXDao: DemographicsXDao,
    private val budgetXDao: BudgetXDao
) {

    // TODO: Maybe have requests return a generic response?
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
}