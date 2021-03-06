package com.example.spendidly.persistence

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.test.data.DemographicsX

@Dao
interface DemographicsXDao : BaseDao<DemographicsX> {
    @Query("SELECT * FROM demographics ORDER BY insertTime DESC")
    fun getAllDemographicsX() : LiveData<List<DemographicsX>?>

    @Query("SELECT * FROM demographics ORDER BY insertTime DESC LIMIT 1")
    suspend fun getLatestDemographicsX() : DemographicsX?
}