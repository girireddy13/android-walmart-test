package com.walmart.countries

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.walmart.countries.adapter.CountriesAdapter
import com.walmart.countries.databinding.ActivityMainBinding
import com.walmart.countries.viewmodel.CountriesViewModel
import kotlinx.coroutines.launch

/**
 * MainActivity that displays the list of countries in a table format
 * Implements proper error handling and supports device rotation
 * as specified in the requirements
 */
class MainActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: CountriesViewModel
    private lateinit var adapter: CountriesAdapter
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        setupViewModel()
        setupRecyclerView()
        setupObservers()
        setupClickListeners()
    }
    
    /**
     * Initialize the ViewModel
     * ViewModel survives configuration changes automatically
     */
    private fun setupViewModel() {
        viewModel = ViewModelProvider(this)[CountriesViewModel::class.java]
    }
    
    /**
     * Setup RecyclerView with adapter and layout manager
     * Includes dividers for better table appearance
     */
    private fun setupRecyclerView() {
        adapter = CountriesAdapter()
        
        binding.rvCountries.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
            
            // Add dividers between rows for table appearance
            val dividerItemDecoration = DividerItemDecoration(
                this@MainActivity,
                LinearLayoutManager.VERTICAL
            )
            addItemDecoration(dividerItemDecoration)
        }
    }
    
    /**
     * Setup observers for ViewModel state changes
     * Handles loading states, data updates, and error states
     */
    private fun setupObservers() {
        // Observe countries data
        lifecycleScope.launch {
            viewModel.countries.collect { countries ->
                if (countries.isNotEmpty()) {
                    adapter.updateCountries(countries)
                    showContent()
                }
            }
        }
        
        // Observe loading state
        lifecycleScope.launch {
            viewModel.isLoading.collect { isLoading ->
                if (isLoading) {
                    showLoading()
                }
            }
        }
        
        // Observe error state
        lifecycleScope.launch {
            viewModel.errorMessage.collect { errorMessage ->
                errorMessage?.let {
                    showError(it)
                }
            }
        }
    }
    
    /**
     * Setup click listeners for retry functionality
     */
    private fun setupClickListeners() {
        binding.btnRetry.setOnClickListener {
            viewModel.loadCountries()
        }
    }
    
    /**
     * Show loading state
     * Hides other views and shows progress bar
     */
    private fun showLoading() {
        binding.apply {
            pbLoading.visibility = View.VISIBLE
            rvCountries.visibility = View.GONE
            tvError.visibility = View.GONE
            btnRetry.visibility = View.GONE
        }
    }
    
    /**
     * Show content state
     * Hides loading and error views, shows RecyclerView
     */
    private fun showContent() {
        binding.apply {
            pbLoading.visibility = View.GONE
            rvCountries.visibility = View.VISIBLE
            tvError.visibility = View.GONE
            btnRetry.visibility = View.GONE
        }
    }
    
    /**
     * Show error state
     * Hides other views and shows error message with retry button
     */
    private fun showError(errorMessage: String) {
        binding.apply {
            pbLoading.visibility = View.GONE
            rvCountries.visibility = View.GONE
            tvError.visibility = View.VISIBLE
            tvError.text = errorMessage
            btnRetry.visibility = View.VISIBLE
        }
    }
}
