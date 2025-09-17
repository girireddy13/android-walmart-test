package com.walmart.countries.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.walmart.countries.data.ApiResponse
import com.walmart.countries.data.Country
import com.walmart.countries.repository.CountriesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel for managing countries data and UI state
 * Handles loading states, error states, and data persistence across configuration changes
 * This ensures robust handling of device rotation as required
 */
class CountriesViewModel : ViewModel() {
    
    private val repository = CountriesRepository()
    
    // StateFlow for countries data - survives configuration changes
    private val _countries = MutableStateFlow<List<Country>>(emptyList())
    val countries: StateFlow<List<Country>> = _countries.asStateFlow()
    
    // StateFlow for loading state
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()
    
    // StateFlow for error state
    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage.asStateFlow()
    
    init {
        // Load countries when ViewModel is created
        loadCountries()
    }
    
    /**
     * Loads countries from the API
     * Handles all response states: loading, success, and error
     */
    fun loadCountries() {
        viewModelScope.launch {
            repository.getCountries().collect { response ->
                when (response) {
                    is ApiResponse.Loading -> {
                        _isLoading.value = true
                        _errorMessage.value = null
                    }
                    is ApiResponse.Success -> {
                        _isLoading.value = false
                        _countries.value = response.data
                        _errorMessage.value = null
                    }
                    is ApiResponse.Error -> {
                        _isLoading.value = false
                        _errorMessage.value = response.exception.message ?: "An unknown error occurred"
                    }
                }
            }
        }
    }
    
    /**
     * Clears any error message
     * Useful for dismissing error dialogs or snackbars
     */
    fun clearError() {
        _errorMessage.value = null
    }
}
