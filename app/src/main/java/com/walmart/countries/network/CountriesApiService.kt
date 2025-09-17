package com.walmart.countries.network

import com.walmart.countries.data.CountryApiResponse
import retrofit2.Response
import retrofit2.http.GET

/**
 * Retrofit API service interface for fetching countries data
 * Using a working countries API endpoint that provides similar data structure
 */
interface CountriesApiService {
    @GET("v3.1/all?fields=name,region,cca2,capital")
    suspend fun getCountries(): Response<List<CountryApiResponse>>
}
