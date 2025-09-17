package com.walmart.countries

import com.walmart.countries.data.Country
import org.junit.Test
import org.junit.Assert.*

/**
 * Simple unit test for the Country data class
 * Verifies that the data model works correctly
 */
class CountryTest {
    
    @Test
    fun country_creation_isCorrect() {
        val country = Country(
            name = "United States of America",
            region = "NA",
            code = "US",
            capital = "Washington, D.C."
        )
        
        assertEquals("United States of America", country.name)
        assertEquals("NA", country.region)
        assertEquals("US", country.code)
        assertEquals("Washington, D.C.", country.capital)
    }
    
    @Test
    fun country_equality_isCorrect() {
        val country1 = Country("USA", "NA", "US", "Washington")
        val country2 = Country("USA", "NA", "US", "Washington")
        val country3 = Country("Canada", "NA", "CA", "Ottawa")
        
        assertEquals(country1, country2)
        assertNotEquals(country1, country3)
    }
}
