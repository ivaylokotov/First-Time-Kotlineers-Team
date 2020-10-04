package com.example.spendidly.persistence

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.test.data.BudgetX

@Dao
interface BudgetXDao : BaseDao<BudgetX> {
    @Query("SELECT AVG(alcoholic_beverages) as alcoholic_beverages, " +
                "AVG(prescription_drugs) as prescription_drugs, " +
                "AVG(tobacco_and_smoking) as tobacco_and_smoking, " +
                "AVG(cash_contributions) as cash_contributions, " +
                "AVG(education) as education, " +
                "AVG(personal_care) as personal_care, " +
                "AVG(cellular_phone_service) as cellular_phone_service, " +
                "AVG(residential_phone_service) as residential_phone_service, " +
                "AVG(media_hardware_and_services) as media_hardware_and_services, " +
                "AVG(health_insurance) as health_insurance, " +
                "AVG(life_and_personal_insurance) as life_and_personal_insurance, " +
                "AVG(vehicle_insurance) as vehicle_insurance, " +
                "AVG(clothing_items_and_services) as clothing_items_and_services, " +
                "AVG(fees_and_admissions) as fees_and_admissions, " +
                "AVG(miscellaneous) as miscellaneous, " +
                "AVG(electricity) as electricity, " +
                "AVG(water_and_public_services) as water_and_public_services, " +
                "AVG(savings) as savings, " +
                "AVG(public_and_other_transportation) as public_and_other_transportation, " +
                "AVG(vehicle_maintenance_and_repairs) as vehicle_maintenance_and_repairs, " +
                "AVG(vehicle_purchase_and_lease) as vehicle_purchase_and_lease, " +
                "AVG(home_maintenance_and_repairs) as home_maintenance_and_repairs, " +
                "AVG(household_operations) as household_operations, " +
                "AVG(housekeeping_supplies) as housekeeping_supplies, " +
                "AVG(food_home) as food_home, " +
                "AVG(food_out) as food_out, " +
                "AVG(furniture_and_appliances) as furniture_and_appliances, " +
                "AVG(heating_fuels_other) as heating_fuels_other, " +
                "AVG(natural_gas) as natural_gas, " +
                "AVG(gasoline) as gasoline, " +
                "AVG(medical_services) as medical_services, " +
                "AVG(medical_supplies) as medical_supplies, " +
                "AVG(mortgage_and_rent) as mortgage_and_rent, " +
                "AVG(other_debt_payments) as other_debt_payments, " +
                "AVG(other_lodging) as other_lodging, " +
                "AVG(pets) as pets, " +
                "AVG(reading) as reading, " +
                "AVG(toys_and_hobbies) as toys_and_hobbies" +
                " from budgets;")
    fun getAverageBudget() : LiveData<BudgetX?>

    @Query("SELECT * FROM budgets ORDER BY id DESC LIMIT 1")
    fun getLatestBudgetX() : LiveData<BudgetX?> // gets the latest inserted budgetX
}