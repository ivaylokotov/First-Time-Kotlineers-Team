package com.example.test.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// 36 properties = 12 * 3 (3 properties per cardview) = (2 * 6 * 3 =
// 6 rows with 2 cardviews (contains 3 semantically grouped properties) each

@Entity(tableName = "budgets") // actually keeps the last model only through db trigger
data class BudgetX(
    @PrimaryKey(autoGenerate = true)
    val id: Int?, // id used to show which iteration the user is for his generated model (the last one is always kept)

    @ColumnInfo(name = "alcoholic_beverages")
    val alcoholic_beverages: Int,
    @ColumnInfo(name = "prescription_drugs")
    val prescription_drugs: Int,
    @ColumnInfo(name = "tobacco_and_smoking")
    val tobacco_and_smoking: Int,

    @ColumnInfo(name = "cash_contributions")
    val cash_contributions: Int,
    @ColumnInfo(name = "education")
    val education: Int,
    @ColumnInfo(name = "personal_care")
    val personal_care: Int,

    @ColumnInfo(name = "cellular_phone_service")
    val cellular_phone_service: Int,
    @ColumnInfo(name = "residential_phone_service")
    val residential_phone_service: Int,
    @ColumnInfo(name = "media_hardware_and_services")
    val media_hardware_and_services: Int,

    @ColumnInfo(name = "health_insurance")
    val health_insurance: Int,
    @ColumnInfo(name = "life_and_personal_insurance")
    val life_and_personal_insurance: Int,
    @ColumnInfo(name = "vehicle_insurance")
    val vehicle_insurance: Int,

    @ColumnInfo(name = "clothing_items_and_services")
    val clothing_items_and_services: Int,
    @ColumnInfo(name = "fees_and_admissions")
    val fees_and_admissions: Int,
    @ColumnInfo(name = "miscellaneous")
    val miscellaneous: Int,

    @ColumnInfo(name = "electricity")
    val electricity: Int,
    @ColumnInfo(name = "water_and_public_services")
    val water_and_public_services: Int,
    @ColumnInfo(name = "savings")
    val savings: Int,

    @ColumnInfo(name = "public_and_other_transportation")
    val public_and_other_transportation: Int,
    @ColumnInfo(name = "vehicle_maintenance_and_repairs")
    val vehicle_maintenance_and_repairs: Int,
    @ColumnInfo(name = "vehicle_purchase_and_lease")
    val vehicle_purchase_and_lease: Int,

    @ColumnInfo(name = "home_maintenance_and_repairs")
    val home_maintenance_and_repairs: Int,
    @ColumnInfo(name = "household_operations")
    val household_operations: Int,
    @ColumnInfo(name = "housekeeping_supplies")
    val housekeeping_supplies: Int,

    @ColumnInfo(name = "food_home")
    val food_home: Int,
    @ColumnInfo(name = "food_out")
    val food_out: Int,
    @ColumnInfo(name = "furniture_and_appliances")
    val furniture_and_appliances: Int,

    @ColumnInfo(name = "heating_fuels_other")
    val heating_fuels_other: Int,
    @ColumnInfo(name = "natural_gas")
    val natural_gas: Int,
    @ColumnInfo(name = "gasoline")
    val gasoline: Int,

    @ColumnInfo(name = "medical_services")
    val medical_services: Int,
    @ColumnInfo(name = "medical_supplies")
    val medical_supplies: Int,

    @ColumnInfo(name = "mortgage_and_rent")
    val mortgage_and_rent: Int,
    @ColumnInfo(name = "other_debt_payments")
    val other_debt_payments: Int,
    @ColumnInfo(name = "other_lodging")
    val other_lodging: Int,

    @ColumnInfo(name = "pets")
    val pets: Int,
    @ColumnInfo(name = "reading")
    val reading: Int,
    @ColumnInfo(name = "toys_and_hobbies")
    val toys_and_hobbies: Int
) {
    fun isValid(): Boolean {
        return this.mortgage_and_rent != 0 // should always be different from 0 if the response is correct
    }
}
