package com.walmart.countries.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.walmart.countries.R
import com.walmart.countries.data.Country

/**
 * RecyclerView adapter for displaying countries in a table format
 * Includes a header row and supports multiple view types
 * Displays countries ordered by their position in the JSON response
 */
class CountriesAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    
    private var countries = mutableListOf<Country>()
    
    companion object {
        private const val VIEW_TYPE_HEADER = 0
        private const val VIEW_TYPE_COUNTRY = 1
    }
    
    /**
     * Updates the countries list and refreshes the RecyclerView
     * The list maintains the order from the API response
     */
    fun updateCountries(newCountries: List<Country>) {
        countries.clear()
        countries.addAll(newCountries)
        notifyDataSetChanged()
    }
    
    override fun getItemViewType(position: Int): Int {
        return if (position == 0) VIEW_TYPE_HEADER else VIEW_TYPE_COUNTRY
    }
    
    override fun getItemCount(): Int {
        // +1 for the header row
        return countries.size + 1
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_HEADER -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_country_header, parent, false)
                HeaderViewHolder(view)
            }
            else -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_country, parent, false)
                CountryViewHolder(view)
            }
        }
    }
    
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HeaderViewHolder -> {
                // Header doesn't need binding, it's static
            }
            is CountryViewHolder -> {
                val country = countries[position - 1] // -1 because of header
                holder.bind(country)
            }
        }
    }
    
    /**
     * ViewHolder for the table header row
     */
    class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    
    /**
     * ViewHolder for country data rows
     * Binds country data to the table format as specified in requirements
     */
    class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.tv_name)
        private val regionTextView: TextView = itemView.findViewById(R.id.tv_region)
        private val codeTextView: TextView = itemView.findViewById(R.id.tv_code)
        private val capitalTextView: TextView = itemView.findViewById(R.id.tv_capital)
        
        fun bind(country: Country) {
            nameTextView.text = country.name
            regionTextView.text = country.region
            codeTextView.text = country.code
            capitalTextView.text = country.capital
        }
    }
}
