package com.napier.gp3;

import org.junit.jupiter.api.*;
import java.sql.Connection;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PopulationDAOIntegrationTest {

    static Connection con;
    static PopulationDAO populationDAO;

    @BeforeAll
    void init() {
        // Initialize the database connection
        try {
            App conn = new App();
            conn.connect_function("localhost:33060", 5000);
            con = conn.getCon();
            assertNotNull(con, "Database connection can't be null");
            populationDAO = new PopulationDAO(con);
        } catch (Exception e) {
            fail("Initializing the database connection Fail!!: " + e.getMessage());
        }
    }

    @BeforeEach
    void setup() {
        // Initialize PopulationDAO with the connection
        populationDAO = new PopulationDAO(con);
    }

    /**
     * test to get population of the world
     */
    @Test
    public void testGetWorldPopulation() {
        List<Population> populations = populationDAO.getWorldPopulation();
        assertNotNull(populations);
        assertFalse(populations.isEmpty(), "World population list can't be empty");

        Population worldPopulation = populations.get(0);
        assertEquals("World", worldPopulation.getName(), "Name must be 'World'");
        assertTrue(worldPopulation.getTotalPopulation() > 0, "Total population must greater than 0");
    }

    /**
     * test to get population by continent
     */
    @Test
    public void testGetPopulationByContinent() {
        String continent = "Asia";
        List<Population> populations = populationDAO.getPopulationByContinent(continent);
        assertNotNull(populations);
        assertFalse(populations.isEmpty(), "Population of continent can't be empty");

        Population population = populations.get(0);
        assertEquals(continent, population.getName(), "Not match with the provided continent name");
        assertTrue(population.getTotalPopulation() > 0, "Total population must greater than 0");
    }

    /**
     * test to get population by region
     */
    @Test
    public void testGetPopulationByRegion() {
        String region = "Western Europe";
        List<Population> populations = populationDAO.getPopulationByRegion(region);
        assertNotNull(populations);
        assertFalse(populations.isEmpty(), "Population of region can't be empty");

        Population population = populations.get(0);
        assertEquals(region, population.getName(), "Not match with the provided region name");
        assertTrue(population.getTotalPopulation() > 0, "Total population must greater than 0");
    }

    /**
     * test to get population by country
     */
    @Test
    public void testGetPopulationByCountry() {
        String countryCode = "USA";
        List<Population> populations = populationDAO.getPopulationByCountry(countryCode);
        assertNotNull(populations);
        assertFalse(populations.isEmpty(), "Population of country can't be empty");

        Population population = populations.get(0);
        assertEquals("United States", population.getName(), "Not match with the provided country name");
        assertTrue(population.getTotalPopulation() > 0, "Total population should be greater than 0");
    }

    /**
     * Test to get population by district
     */
    @Test
    public void testGetPopulationByDistrict() {
        String district = "California";
        List<Population> populations = populationDAO.getPopulationByDistrict(district);
        assertNotNull(populations);
        assertFalse(populations.isEmpty(), "Population of district must not be empty");

        Population population = populations.get(0);
        assertEquals(district, population.getName(), "Not match with the provided district name");
        assertTrue(population.getTotalPopulation() > 0, "Total population should be greater than 0");
    }

    /**
     * Test to get population by city
     */
    @Test
    public void testGetPopulationByCity() {
        String cityName = "Los Angeles";
        List<Population> populations = populationDAO.getPopulationByCity(cityName);
        assertNotNull(populations);
        assertFalse(populations.isEmpty(), "Population list for city should not be empty");

        Population population = populations.get(0);
        assertEquals(cityName, population.getName(), "Not match with the provided City name");
        assertTrue(population.getTotalPopulation() > 0, "Total population should be greater than 0");
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
