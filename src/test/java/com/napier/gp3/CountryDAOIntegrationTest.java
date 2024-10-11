package com.napier.gp3;

import org.junit.jupiter.api.*;

import java.sql.Connection;
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
            conn.connect_function("localhost:33060", 15000);
            con = conn.getCon();
            assertNotNull(con, "Database connection should not be null");
            countryDAO = new CountryDAO(con);
        } catch (Exception e) {
            fail("Failed to initialize database connection: " + e.getMessage());
        }
    }

    @BeforeEach
    void setup() {
        // Initialize CapitalDAO with the connection
        countryDAO = new CountryDAO(con);
    }

    /**
     * test all countries by population
     */
    @Test
    void testGetAllCountriesByPopulation() {
        List<Country> countries = countryDAO.getAllCountriesByPopulation();
        assertNotNull(countries, "Countries list should not be null");
        assertFalse(countries.isEmpty(), "Countries list should not be empty");

        // check whether first data of country is China around the world
        Country firstCountry = countries.get(0);
        assertEquals("CHN", firstCountry.getCode(), "The first country by population should be China (CHN)");
        assertTrue(firstCountry.getPopulation() > 0, "The population of the first country should be greater than zero");
    }
    /**
     * test all countries by continent
     */
    @Test
    void testGetCountriesByContinent() {
        List<Country> countries = countryDAO.getCountriesByContinent("Asia");
        assertNotNull(countries, "Countries list should not be null for continent Asia");
        assertFalse(countries.isEmpty(), "Countries list for Asia should not be empty");

        // check whether first data of country is China in Asia continent
        Country firstCountry = countries.get(0);
        assertEquals("CHN", firstCountry.getCode(), "The first country in Asia should be China (CHN)");
        assertEquals("Asia", firstCountry.getContinent(), "The continent of the first country should be Asia");
    }

    /**
     * test countries by region
     */
    @Test
    void testGetCountriesByRegion() {
        List<Country> countries = countryDAO.getCountriesByRegion("Eastern Europe");
        assertNotNull(countries, "Countries list should not be null for region Eastern Europe");
        assertFalse(countries.isEmpty(), "Countries list for Eastern Europe should not be empty");

        // check whether first data of country is Russia in Eastern Europe region
        Country firstCountry = countries.get(0);
        assertEquals("RUS", firstCountry.getCode(), "The first country in Eastern Europe should be Russia (RUS)");
        assertEquals("Eastern Europe", firstCountry.getRegion(), "The region of the first country should be Eastern Europe");
    }

    /**
     * test Top N populated Countries around the world
     */
    @Test
    void testGetTopNPopulatedCountries() {
        List<Country> countries = countryDAO.getTopNPopulatedCountries(5);
        assertNotNull(countries, "Top N populated countries list should not be null");
        assertEquals(5, countries.size(), "The size of the list should be 5 for the top N populated countries");

        // check whether first data of country is China around the world
        Country firstCountry = countries.get(0);
        assertEquals("CHN", firstCountry.getCode(), "The first country by population should be China (CHN)");
    }

    /**
     * test Top N populated Countries in continent
     */
    @Test
    void testGetTopNPopulatedCountriesInContinent() {
        List<Country> countries = countryDAO.getTopNPopulatedCountriesInContinent("Asia", 3);
        assertNotNull(countries, "Top N populated countries list for Asia should not be null");
        assertEquals(3, countries.size(), "The size of the list should be 3 for top N populated countries in Asia");

        // check whether countries are only from Asia continent
        for (Country country : countries) {
            assertEquals("Asia", country.getContinent(), "All countries should be from the continent Asia");
        }
    }
    /**
     * test Top N populated Countries in region
     */
    @Test
    void testGetTopNPopulatedCountriesInRegion() {
        List<Country> countries = countryDAO.getTopNPopulatedCountriesInRegion("Western Europe", 3);
        assertNotNull(countries, "Top N populated countries list for Western Europe should not be null");
        assertEquals(3, countries.size(), "should return 3 countries in Western Europe");

        // check whether countries are only from Western Europe region
        for (Country country : countries) {
            assertEquals("Western Europe", country.getRegion(), "All countries should be from the region Western Europe");
        }
    }

    @AfterAll
    static void tearDownDatabaseConnection() {
        // close database connection after country Integration test
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (Exception e) {
            fail("Failed to close database connection: " + e.getMessage());
        }
    }
}
