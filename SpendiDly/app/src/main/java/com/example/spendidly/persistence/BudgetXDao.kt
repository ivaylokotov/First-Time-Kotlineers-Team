package com.example.spendidly.persistence

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.test.data.BudgetX

@Dao
interface BudgetXDao : BaseDao<BudgetX> {
    @Query("SELECT * FROM budgets")
    suspend fun getAllBudgetX() : List<BudgetX>

    @Query("SELECT * FROM budgets ORDER BY id DESC LIMIT 1")
    fun getLastBudgetX() : LiveData<BudgetX> // gets the latest inserted budgetX
}