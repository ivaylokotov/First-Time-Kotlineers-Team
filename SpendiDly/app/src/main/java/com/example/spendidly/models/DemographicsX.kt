package com.example.test.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "demographics")
data class DemographicsX(
    @PrimaryKey(autoGenerate = false)
    var insertTime: Long? = null,
    @ColumnInfo(name = "age")
    var age: Int,
    @ColumnInfo(name = "gross_annual_income")
    val gross_annual_income: Int,
    @ColumnInfo(name = "household_members")
    val household_members: Int,
    @ColumnInfo(name = "is_homeowner")
    val is_homeowner: Boolean,
    @ColumnInfo(name = "net_annual_income")
    val net_annual_income: Int,
    @ColumnInfo(name = "zip")
    val zip: String
)
