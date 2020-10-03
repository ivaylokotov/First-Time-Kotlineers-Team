package com.example.test.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// 36 properties = 12 * 3 (3 properties per cardview) = (2 * 6 * 3 =
// 6 rows with 2 cardviews (contains 3 semantically grouped properties) each

@Entity(tableName = "budgets") // actually keeps the last model only through db trigger
data class BudgetX(
    @PrimaryKey(autoGenerate = true)
    val id: Int, // id used to show which iteration the user is for his generated model (the last one is always kept)

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
    // needed for average calculation
    operator fun plus(model: BudgetX): BudgetX {
        return BudgetX(
            0,
            this.alcoholic_beverages + model.alcoholic_beverages,
            this.prescription_drugs + model.prescription_drugs,
            this.tobacco_and_smoking + model.tobacco_and_smoking,
            this.cash_contributions + model.cash_contributions,
            this.education + model.education,
            this.personal_care + model.personal_care,
            this.cellular_phone_service + model.cellular_phone_service,
            this.residential_phone_service + model.residential_phone_service,
            this.media_hardware_and_services + model.media_hardware_and_services,
            this.health_insurance + model.health_insurance,
            this.life_and_personal_insurance + model.life_and_personal_insurance,
            this.vehicle_insurance + model.vehicle_insurance,
            this.clothing_items_and_services + model.clothing_items_and_services,
            this.fees_and_admissions + model.fees_and_admissions,
            this.miscellaneous + model.miscellaneous,
            this.electricity + model.electricity,
            this.water_and_public_services + model.water_and_public_services,
            this.savings + model.savings,
            this.public_and_other_transportation + model.public_and_other_transportation,
            this.vehicle_maintenance_and_repairs + model.vehicle_maintenance_and_repairs,
            this.vehicle_purchase_and_lease + model.vehicle_purchase_and_lease,
            this.home_maintenance_and_repairs + model.home_maintenance_and_repairs,
            this.household_operations + model.household_operations,
            this.housekeeping_supplies + model.housekeeping_supplies,
            this.food_home + model.food_home,
            this.food_out + model.food_out,
            this.furniture_and_appliances + model.furniture_and_appliances,
            this.heating_fuels_other + model.heating_fuels_other,
            this.natural_gas + model.natural_gas,
            this.gasoline + model.gasoline,
            this.medical_services + model.medical_services,
            this.medical_supplies + model.medical_supplies,
            this.mortgage_and_rent + model.mortgage_and_rent,
            this.other_debt_payments + model.other_debt_payments,
            this.other_lodging + model.other_lodging,
            this.pets + model.pets,
            this.reading + model.reading,
            this.toys_and_hobbies + model.toys_and_hobbies
        )
    }

    operator fun div(divisor: Int): BudgetX{
        return BudgetX(
            0,
            this.alcoholic_beverages / divisor,
            this.prescription_drugs / divisor,
            this.tobacco_and_smoking / divisor,
            this.cash_contributions / divisor,
            this.education / divisor,
            this.personal_care / divisor,
            this.cellular_phone_service / divisor,
            this.residential_phone_service / divisor,
            this.media_hardware_and_services / divisor,
            this.health_insurance / divisor,
            this.life_and_personal_insurance / divisor,
            this.vehicle_insurance / divisor,
            this.clothing_items_and_services / divisor,
            this.fees_and_admissions / divisor,
            this.miscellaneous / divisor,
            this.electricity / divisor,
            this.water_and_public_services / divisor,
            this.savings / divisor,
            this.public_and_other_transportation / divisor,
            this.vehicle_maintenance_and_repairs / divisor,
            this.vehicle_purchase_and_lease / divisor,
            this.home_maintenance_and_repairs / divisor,
            this.household_operations / divisor,
            this.housekeeping_supplies / divisor,
            this.food_home / divisor,
            this.food_out / divisor,
            this.furniture_and_appliances / divisor,
            this.heating_fuels_other / divisor,
            this.natural_gas / divisor,
            this.gasoline / divisor,
            this.medical_services / divisor,
            this.medical_supplies / divisor,
            this.mortgage_and_rent / divisor,
            this.other_debt_payments / divisor,
            this.other_lodging / divisor,
            this.pets / divisor,
            this.reading / divisor,
            this.toys_and_hobbies / divisor
        )
    }
}