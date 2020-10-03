package com.example.spendidly.repos

import com.example.spendidly.api.SPENDiDAPI
import com.example.spendidly.persistence.DemographicsXDao
import com.example.spendidly.persistence.BudgetXDao

class SpendiDRepository(
    private val spendIdApi: SPENDiDAPI,
    private val demographicsXDao: DemographicsXDao,
    private val budgetXDao: BudgetXDao
) {
    // TODO: Implement repository
}