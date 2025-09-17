package com.walmart.countries.data

/**
 * Sealed class to represent different states of API responses
 * This helps with proper error handling and loading states
 */
sealed class ApiResponse<out T> {
    object Loading : ApiResponse<Nothing>()
    data class Success<out T>(val data: T) : ApiResponse<T>()
    data class Error(val exception: Throwable) : ApiResponse<Nothing>()
}
