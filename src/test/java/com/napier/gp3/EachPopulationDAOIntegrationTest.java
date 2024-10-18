package com.napier.gp3;

import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EachPopulationDAOIntegrationTest {

    static Connection con;
    static EachPopulationDAO eachPopulationDAO;

    @BeforeAll
    void init() {
        // Initialize the database connection
        try {
            App conn = new App();
            conn.connect_function("localhost:33060", 5000);
            con = conn.getCon();

            // check connection param
            assertNotNull(con, "Database connection can't be null");
            eachPopulationDAO = new EachPopulationDAO(con);
        } catch (Exception e) {
            fail("Initializing the database connection Fail!!: " + e.getMessage());
        }
    }

    @BeforeEach
    void setup() {
        // Initialize EachPopulationDAO with the connection
        eachPopulationDAO = new EachPopulationDAO(con);
    }

    /**
     * test to get population per continent
     */
    @Test
    public void testGetPopulationByEachContinent() {

        // Call the DAO method to fetch population data
        List<Population> populations = eachPopulationDAO.getPopulationByEachContinent();

        // make sure the result is not Null, empty
        assertNotNull(populations, "Population list should not be null");
        assertFalse(populations.isEmpty(), "Population for each continent list can't be empty");

        // check first continent is "North America" and check total population, urban population, rural population, urban population percentage, rural population percentage of first continent
        Population firstPopulationByEachContinent = populations.get(0);
        assertEquals("North America", firstPopulationByEachContinent.getName(), "First continent must be 'North America'");
        assertTrue(firstPopulationByEachContinent.getTotalPopulation() > 0, "Total population must be greater than 0");
        assertTrue(firstPopulationByEachContinent.getUrbanPopulation() >= 0, "North America's urban population should not be negative");
        assertTrue(firstPopulationByEachContinent.getRuralPopulation() >= 0, "North America's rural population should not be negative");

        // Validate the percentage calculations
        assertTrue(firstPopulationByEachContinent.getUrbanPopulationPercentage() >= 0, "North America's urban population percentage should not be negative");
        assertTrue(firstPopulationByEachContinent.getRuralPopulationPercentage() >= 0, "North America's rural population percentage should not be negative");
    }

    /**
     * test to get population per region
     */
    @Test
    public void testGetPopulationByEachRegion() {

        // Call the DAO method to fetch population data
        List<Population> populations = eachPopulationDAO.getPopulationByEachRegion();

        // make sure the result is not Null and empty arraylist
        assertNotNull(populations, "Population list should not be null");
        assertFalse(populations.isEmpty(), "Population for each region list can't be empty");

        // check first region is "Caribbean" and check total population, urban population, rural population, urban population percentage, rural population percentage of first region
        Population firstPopulationByEachRegion = populations.get(0);
        assertEquals("Caribbean", firstPopulationByEachRegion.getName(), "First region must be 'Caribbean'");
        assertTrue(firstPopulationByEachRegion.getTotalPopulation() > 0, "Total population must be greater than 0");
        assertTrue(firstPopulationByEachRegion.getUrbanPopulation() >= 0, "Caribbean's urban population should not be negative");
        assertTrue(firstPopulationByEachRegion.getRuralPopulation() >= 0, "Caribbean's rural population should not be negative");

        // Validate the percentage calculations
        assertTrue(firstPopulationByEachRegion.getUrbanPopulationPercentage() >= 0, "Caribbean's urban population percentage should not be negative");
        assertTrue(firstPopulationByEachRegion.getRuralPopulationPercentage() >= 0, "Caribbean's rural population percentage should not be negative");
    }

    /**
     * test to get population per country
     */
    @Test
    public void testGetPopulationByEachCountry() {

        // Call the DAO method to fetch population data
        List<Population> populations = eachPopulationDAO.getPopulationByEachCountry();

        // make sure the result is not Null and empty arraylist
        assertNotNull(populations, "Population list should not be null");
        assertFalse(populations.isEmpty(), "Population for each country list can't be empty");

        // check first country is "Aruba" and check total population, urban population, rural population, urban population percentage, rural population percentage of first country
        Population firstPopulationByEachCountry = populations.get(0);
        assertEquals("Aruba", firstPopulationByEachCountry.getName(), "First country must be 'Aruba'");
        assertTrue(firstPopulationByEachCountry.getTotalPopulation() > 0, "Total population must be greater than 0");
        assertTrue(firstPopulationByEachCountry.getUrbanPopulation() >= 0, "Aruba's urban population should not be negative");
        assertTrue(firstPopulationByEachCountry.getRuralPopulation() >= 0, "Aruba's rural population should not be negative");

        // Validate the percentage calculations
        assertTrue(firstPopulationByEachCountry.getUrbanPopulationPercentage() >= 0, "Aruba's urban population percentage should not be negative");
        assertTrue(firstPopulationByEachCountry.getRuralPopulationPercentage() >= 0, "Aruba's rural population percentage should not be negative");
    }

    @AfterAll
    static void tearDownDatabaseConnection() {
        // Close the database connection after PopulationDAO integration test
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (Exception e) {
            fail("Failed to tear down the database connection!!: " + e.getMessage());
        }
    }

}
