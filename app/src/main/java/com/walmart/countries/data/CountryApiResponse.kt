package com.walmart.countries.data

import com.google.gson.annotations.SerializedName

/**
 * API response model for the REST Countries API
 * Maps the API response to our internal Country model
 */
data class CountryApiResponse(
    @SerializedName("name")
    val name: CountryName,
    
    @SerializedName("region")
    val region: String,
    
    @SerializedName("cca2")
    val code: String,
    
    @SerializedName("capital")
    val capital: List<String>?
)

data class CountryName(
    @SerializedName("common")
    val common: String
)

/**
 * Extension function to convert API response to our internal Country model
 */
fun CountryApiResponse.toCountry(): Country {
    return Country(
        name = this.name.common,
        region = this.region,
        code = this.code,
        capital = this.capital?.firstOrNull() ?: "N/A"
    )
}
