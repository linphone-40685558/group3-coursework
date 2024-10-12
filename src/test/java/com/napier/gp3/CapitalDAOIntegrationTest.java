package com.napier.gp3;

import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CapitalDAOIntegrationTest {

    static Connection con;
    static CapitalDAO capitalDAO;

    @BeforeAll
    void init() {
        // Initialize the database connection
        try {
            App conn = new App();
            conn.connect_function("localhost:33060", 5000);
            con = conn.getCon();
            assertNotNull(con, "Database connection should not be null");
            capitalDAO = new CapitalDAO(con);
        } catch (Exception e) {
            fail("Failed to initialize database connection: " + e.getMessage());
        }
    }

    @BeforeEach
    void setup() {
        // Initialize CapitalDAO with the connection
        capitalDAO = new CapitalDAO(con);
    }

    /**
     * test all capital cities by population
     */
    @Test
    public void testGetAllCapitalCitiesByPopulation() {
        List<Capital> capitals = capitalDAO.getAllCapitalCitiesByPopulation();
        assertNotNull(capitals);
        assertFalse(capitals.isEmpty(), "Capital cities list should not be empty");

        // Verify that the capital cities are sorted by population in descending order
        assertTrue(capitals.get(0).getPopulation() >= capitals.get(1).getPopulation(),
                "The list should be sorted by population in descending order");
    }

    /**
     * test capital cities by continent
     */
    @Test
    public void testGetCapitalCitiesByContinent() {
        String continent = "Asia";
        List<Capital> capitals = capitalDAO.getCapitalCitiesByContinent(continent);
        assertNotNull(capitals);
        assertFalse(capitals.isEmpty(), "The capital cities list should not be empty in the continent");
    }

    /**
     * test capital cities by region
     */
    @Test
    public void testGetCapitalCitiesByRegion() {
        String region = "Eastern Europe";
        List<Capital> capitals = capitalDAO.getCapitalCitiesByRegion(region);
        assertNotNull(capitals);
        assertFalse(capitals.isEmpty(), "he capital cities list should not be empty in the region");
    }

    /**
     * test top n populated capital cities in world
     */
    @Test
    public void testGetTopNPopulatedCapitalCitiesInWorld() {
        int N = 5;
        List<Capital> capitals = capitalDAO.getTopNPopulatedCapitalCitiesInWorld(N);
        assertNotNull(capitals);
        assertEquals(N, capitals.size(), "Should return N capital cities");
    }

    /**
     * test top n populated capital cities in continent
     */
    @Test
    public void testGetTopNPopulatedCapitalCitiesInContinent() {
        String continent = "Europe";
        int N = 3;
        List<Capital> capitals = capitalDAO.getTopNPopulatedCapitalCitiesInContinent(continent, N);
        assertNotNull(capitals);
        assertEquals(N, capitals.size(), "Should return N capital cities in the continent");
    }

    /**
     * test top n populated capital cities in region
     */
    @Test
    public void testGetTopNPopulatedCapitalCitiesInRegion() {
        String region = "Western Africa";
        int N = 2;
        List<Capital> capitals = capitalDAO.getTopNPopulatedCapitalCitiesInRegion(region, N);
        assertNotNull(capitals);
        assertEquals(N, capitals.size(), "Should return N capital cities in the region");
    }

    @AfterAll
    static void tearDownDatabaseConnection() {
        // close database connection after capitalDAO Integration test
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (Exception e) {
            fail("Failed to close database connection: " + e.getMessage());
        }
    }
}
