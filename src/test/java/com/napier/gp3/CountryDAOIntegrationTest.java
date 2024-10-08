package com.napier.gp3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CountryDAOIntegrationTest {

    static Connection con;
    static CountryDAO countryDAO;

    @BeforeAll
    void init() {
        // Initialize the database connection
        try {
            App conn = new App();
            conn.connect_function("localhost:33060", 15000);  // This will call the connection method in App
            con = conn.getConnection();  // Make sure App has a method to return the connection object
            assertNotNull(con, "Database connection should not be null");
            countryDAO = new CountryDAO(con);
        } catch (Exception e) {
            fail("Failed to initialize database connection: " + e.getMessage());
        }
    }

    @Test
    void testGetAllCountriesByPopulation() {
        List<Country> countries = countryDAO.getAllCountriesByPopulation();
        assertNotNull(countries, "Countries list should not be null");
        assertFalse(countries.isEmpty(), "Countries list should not be empty");

        Country firstCountry = countries.get(0);
        assertEquals("CHN", firstCountry.getCode(), "The first country by population should be China (CHN)");
        assertTrue(firstCountry.getPopulation() > 0, "The population of the first country should be greater than zero");
    }

    @Test
    void testGetCountriesByContinent() {
        List<Country> countries = countryDAO.getCountriesByContinent("Asia");
        assertNotNull(countries, "Countries list should not be null for continent Asia");
        assertFalse(countries.isEmpty(), "Countries list for Asia should not be empty");

        Country firstCountry = countries.get(0);
        assertEquals("CHN", firstCountry.getCode(), "The first country in Asia should be China (CHN)");
        assertEquals("Asia", firstCountry.getContinent(), "The continent of the first country should be Asia");
    }

    @Test
    void testGetTopNPopulatedCountries() {
        List<Country> countries = countryDAO.getTopNPopulatedCountries(5);
        assertNotNull(countries, "Top N populated countries list should not be null");
        assertEquals(5, countries.size(), "The size of the list should be 5 for the top N populated countries");

        Country firstCountry = countries.get(0);
        assertEquals("CHN", firstCountry.getCode(), "The first country by population should be China (CHN)");
    }

    @Test
    void testGetCountriesByRegion() {
        List<Country> countries = countryDAO.getCountriesByRegion("Eastern Europe");
        assertNotNull(countries, "Countries list should not be null for region Eastern Europe");
        assertFalse(countries.isEmpty(), "Countries list for Eastern Europe should not be empty");

        Country firstCountry = countries.get(0);
        assertEquals("RUS", firstCountry.getCode(), "The first country in Eastern Europe should be Russia (RUS)");
        assertEquals("Eastern Europe", firstCountry.getRegion(), "The region of the first country should be Eastern Europe");
    }

    @Test
    void testGetTopNPopulatedCountriesInContinent() {
        List<Country> countries = countryDAO.getTopNPopulatedCountriesInContinent("Asia", 3);
        assertNotNull(countries, "Top N populated countries list for Asia should not be null");
        assertEquals(3, countries.size(), "The size of the list should be 3 for top N populated countries in Asia");

        for (Country country : countries) {
            assertEquals("Asia", country.getContinent(), "All countries should be from the continent Asia");
        }
    }

    @Test
    void testGetTopNPopulatedCountriesInRegion() {
        List<Country> countries = countryDAO.getTopNPopulatedCountriesInRegion("Western Europe", 3);
        assertNotNull(countries, "Top N populated countries list for Western Europe should not be null");
        assertEquals(3, countries.size(), "The size of the list should be 3 for top N populated countries in Western Europe");

        for (Country country : countries) {
            assertEquals("Western Europe", country.getRegion(), "All countries should be from the region Western Europe");
        }
    }
}
