package com.napier.gp3;

import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CountryDAOTest {
    private Connection connection;
    private CountryDAO countryDAO;

    @BeforeEach
    public void setUp() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database (updated connection string)
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:33060/world?allowPublicKeyRetrieval=true&useSSL=false",
                    "root",
                    "group3"
            );

            // Initialize the DAO with the connected database
            countryDAO = new CountryDAO(connection);

        } catch (ClassNotFoundException e) {
            fail("SQL Driver Loading Failed: " + e.getMessage());
        } catch (SQLException e) {
            fail("Database connection failed: " + e.getMessage());
        }
    }

    @Test
    public void testGetAllCountriesByPopulation() {
        // Test if the list is correctly populated and ordered by population
        List<Country> countries = countryDAO.getAllCountriesByPopulation();
        assertNotNull(countries, "Country list should not be null");
        assertFalse(countries.isEmpty(), "Country list should not be empty");
        assertTrue(countries.get(0).getPopulation() >= countries.get(1).getPopulation(),
                "Countries should be ordered by population in descending order");
    }

    @Test
    public void testGetCountriesByContinent() {
        // Test if countries for a specific continent are correctly fetched
        List<Country> countries = countryDAO.getCountriesByContinent("Europe");
        assertNotNull(countries, "Country list should not be null");
        assertFalse(countries.isEmpty(), "Country list for Europe should not be empty");
        for (Country country : countries) {
            assertEquals("Europe", country.getContinent(), "Continent should be Europe");
        }
    }

    @Test
    public void testGetCountriesByRegion() {
        // Test if countries for a specific region are correctly fetched
        List<Country> countries = countryDAO.getCountriesByRegion("Southern Europe");
        assertNotNull(countries, "Country list should not be null");
        assertFalse(countries.isEmpty(), "Country list for Southern Europe should not be empty");
        for (Country country : countries) {
            assertEquals("Southern Europe", country.getRegion(), "Region should be Southern Europe");
        }
    }

    @Test
    public void testGetTopNPopulatedCountries() {
        // Test if the top N populated countries are correctly fetched
        int N = 5;
        List<Country> countries = countryDAO.getTopNPopulatedCountries(N);
        assertNotNull(countries, "Country list should not be null");
        assertEquals(N, countries.size(), "Should return exactly " + N + " countries");
    }

    @Test
    public void testGetTopNPopulatedCountriesInContinent() {
        int N = 5;
        String continent = "Asia";
        List<Country> countries = countryDAO.getTopNPopulatedCountriesInContinent(continent, N);

        assertNotNull(countries, "Country list should not be null");
        assertEquals(N, countries.size(), "Should return exactly " + N + " countries");
        for (Country country : countries) {
            assertEquals(continent, country.getContinent(), "Country should be in " + continent);
        }
    }

    @Test
    public void testGetTopNPopulatedCountriesInRegion() {
        int N = 5;
        String region = "Southern Europe";
        List<Country> countries = countryDAO.getTopNPopulatedCountriesInRegion(region, N);

        assertNotNull(countries, "Country list should not be null");
        assertEquals(N, countries.size(), "Should return exactly " + N + " countries");
        for (Country country : countries) {
            assertEquals(region, country.getRegion(), "Country should be in " + region);
        }
    }


    @AfterEach
    public void tearDown() {
        // Close the connection after each test
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}
