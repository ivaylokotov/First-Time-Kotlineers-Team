package com.example.spendidly.repos

import com.example.spendidly.api.SPENDiDAPI
import com.example.spendidly.persistence.DemographicsXDao
import com.example.spendidly.persistence.BudgetXDao
import com.example.test.data.BudgetX
import com.example.test.data.Demographics

class SpendiDRepository(
    private val spendIdApi: SPENDiDAPI,
    private val demographicsXDao: DemographicsXDao,
    private val budgetXDao: BudgetXDao
) {

    // TODO: Maybe have requests return a generic response?
    suspend fun getBudgetXAsync(demographics: Demographics): BudgetX {
        val budgetX = spendIdApi.getBudgetAsync(demographics).budget
        budgetXDao.insert(budgetX) // insert budget into room
        return budgetX
    }
}