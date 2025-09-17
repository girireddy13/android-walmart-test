package com.walmart.countries.data

import com.google.gson.annotations.SerializedName

/**
 * Data class representing a Country with all necessary fields
 * for display in the RecyclerView table format
 */
data class Country(
    @SerializedName("name")
    val name: String,
    
    @SerializedName("region")
    val region: String,
    
    @SerializedName("code")
    val code: String,
    
    @SerializedName("capital")
    val capital: String
)
