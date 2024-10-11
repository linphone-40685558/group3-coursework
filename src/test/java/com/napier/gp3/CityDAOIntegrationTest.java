package com.napier.gp3;

import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CityDAOIntegrationTest {
    static Connection con;
    static CityDAO cityDAO;

    @BeforeAll
    void init() {
        // Initialize the database connection
        try {
            App conn = new App();
            conn.connect_function("localhost:33060", 15000);
            con = conn.getCon();
            assertNotNull(con, "Database connection should not be null");
            cityDAO = new CityDAO(con);
        } catch (Exception e) {
            fail("Failed to initialize database connection: " + e.getMessage());
        }
    }

    /**
     * test all cities by population
     */
    @Test
    public void testGetAllCitiesByPopulation() {
        List<City> cities = cityDAO.getAllCitiesByPopulation();
        assertNotNull(cities);
        assertFalse(cities.isEmpty(), "City list should not be empty");
    }

    /**
     * test cities by continent
     */
    @Test
    public void testGetCitiesByContinent() {
        List<City> cities = cityDAO.getCitiesByContinent("Asia");
        assertNotNull(cities);
        assertFalse(cities.isEmpty(), "City list for continent 'Asia' should not be empty");
    }

    /**
     * test cities by region
     */
    @Test
    public void testGetCitiesByRegion() {
        List<City> cities = cityDAO.getCitiesByRegion("Western Europe");
        assertNotNull(cities);
        assertFalse(cities.isEmpty(), "City list for region 'Western Europe' should not be empty");
    }

    /**
     * test cities by country
     */
    @Test
    public void testGetCitiesByCountry() {
        List<City> cities = cityDAO.getCitiesByCountry("USA");
        assertNotNull(cities);
        assertFalse(cities.isEmpty(), "City list for country 'USA' should not be empty");
    }

    /**
     * test cities by district
     */
    @Test
    public void testGetCitiesByDistrict() {
        List<City> cities = cityDAO.getCitiesByDistrict("California");
        assertNotNull(cities);
        assertFalse(cities.isEmpty(), "City list for district 'California' should not be empty");
    }

    /**
     *
     */
    @Test
    public void testGetTopNPopulatedCitiesInWorld() {
        List<City> cities = cityDAO.getTopNPopulatedCitiesInWorld(5);
        assertNotNull(cities);
        assertEquals(5, cities.size(), "Should return 5 cities");
    }

    @Test
    public void testGetTopNPopulatedCitiesInContinent() {
        List<City> cities = cityDAO.getTopNPopulatedCitiesInContinent("Asia", 5);
        assertNotNull(cities);
        assertEquals(5, cities.size(), "Should return 5 cities");
    }

    @Test
    public void testGetTopNPopulatedCitiesInRegion() {
        List<City> cities = cityDAO.getTopNPopulatedCitiesInRegion("Western Europe", 5);
        assertNotNull(cities);
        assertEquals(5, cities.size(), "Should return 5 cities");
    }

    @Test
    public void testGetTopNPopulatedCitiesInCountry() {
        List<City> cities = cityDAO.getTopNPopulatedCitiesInCountry("USA", 5);
        assertNotNull(cities);
        assertEquals(5, cities.size(), "Should return 5 cities");
    }

    @Test
    public void testGetTopNPopulatedCitiesInDistrict() {
        List<City> cities = cityDAO.getTopNPopulatedCitiesInDistrict("California", 5);
        assertNotNull(cities);
        assertEquals(5, cities.size(), "Should return 5 cities");
    }
}
