package com.example.test.data

import com.google.gson.annotations.Expose

data class Demographics(
    @Expose // TODO: Add a GSONConverter for this; might need it if response here is null
    val demographics: DemographicsX
)