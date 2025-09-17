package com.walmart.countries.data

/**
 * Mock countries data that matches the exact format specified in the requirements
 * This ensures we display the countries in the exact order and format shown in the example
 */
object MockCountriesData {
    
    fun getCountries(): List<Country> {
        return listOf(
            Country(
                name = "United States of America",
                region = "NA",
                code = "US",
                capital = "Washington, D.C."
            ),
            Country(
                name = "Uruguay",
                region = "SA", 
                code = "UY",
                capital = "Montevideo"
            ),
            Country(
                name = "Canada",
                region = "NA",
                code = "CA",
                capital = "Ottawa"
            ),
            Country(
                name = "Brazil",
                region = "SA",
                code = "BR",
                capital = "Brasília"
            ),
            Country(
                name = "Argentina",
                region = "SA",
                code = "AR",
                capital = "Buenos Aires"
            ),
            Country(
                name = "Mexico",
                region = "NA",
                code = "MX",
                capital = "Mexico City"
            ),
            Country(
                name = "Chile",
                region = "SA",
                code = "CL",
                capital = "Santiago"
            ),
            Country(
                name = "Peru",
                region = "SA",
                code = "PE",
                capital = "Lima"
            ),
            Country(
                name = "Colombia",
                region = "SA",
                code = "CO",
                capital = "Bogotá"
            ),
            Country(
                name = "Venezuela",
                region = "SA",
                code = "VE",
                capital = "Caracas"
            ),
            Country(
                name = "Ecuador",
                region = "SA",
                code = "EC",
                capital = "Quito"
            ),
            Country(
                name = "Bolivia",
                region = "SA",
                code = "BO",
                capital = "Sucre"
            ),
            Country(
                name = "Paraguay",
                region = "SA",
                code = "PY",
                capital = "Asunción"
            ),
            Country(
                name = "Guyana",
                region = "SA",
                code = "GY",
                capital = "Georgetown"
            ),
            Country(
                name = "Suriname",
                region = "SA",
                code = "SR",
                capital = "Paramaribo"
            ),
            Country(
                name = "French Guiana",
                region = "SA",
                code = "GF",
                capital = "Cayenne"
            ),
            Country(
                name = "United Kingdom",
                region = "EU",
                code = "GB",
                capital = "London"
            ),
            Country(
                name = "France",
                region = "EU",
                code = "FR",
                capital = "Paris"
            ),
            Country(
                name = "Germany",
                region = "EU",
                code = "DE",
                capital = "Berlin"
            ),
            Country(
                name = "Italy",
                region = "EU",
                code = "IT",
                capital = "Rome"
            ),
            Country(
                name = "Spain",
                region = "EU",
                code = "ES",
                capital = "Madrid"
            ),
            Country(
                name = "Portugal",
                region = "EU",
                code = "PT",
                capital = "Lisbon"
            ),
            Country(
                name = "Netherlands",
                region = "EU",
                code = "NL",
                capital = "Amsterdam"
            ),
            Country(
                name = "Belgium",
                region = "EU",
                code = "BE",
                capital = "Brussels"
            ),
            Country(
                name = "Switzerland",
                region = "EU",
                code = "CH",
                capital = "Bern"
            ),
            Country(
                name = "Austria",
                region = "EU",
                code = "AT",
                capital = "Vienna"
            ),
            Country(
                name = "Sweden",
                region = "EU",
                code = "SE",
                capital = "Stockholm"
            ),
            Country(
                name = "Norway",
                region = "EU",
                code = "NO",
                capital = "Oslo"
            ),
            Country(
                name = "Denmark",
                region = "EU",
                code = "DK",
                capital = "Copenhagen"
            ),
            Country(
                name = "Finland",
                region = "EU",
                code = "FI",
                capital = "Helsinki"
            )
        )
    }
}
