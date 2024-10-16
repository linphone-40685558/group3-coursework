package com.napier.gp3;

import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EachPopulationDAOUnitTest {
    static Connection con;
    static EachPopulationDAO eachPopulationDAO;

    @BeforeAll
    void init(){
        // Initialize the database connection
        try {
            App conn = new App();
            conn.connect_function("localhost:33060", 5000);
            con = conn.getCon();
            assertNotNull(con, "Database connection can't be null");
            eachPopulationDAO = new EachPopulationDAO(con);
        } catch (Exception e) {
            fail("Initializing the database connection Fail!!: " + e.getMessage());
        }
    }

    @BeforeEach
    void setUp(){
        // Initialize EachPopulationDAO with the connection
        eachPopulationDAO = new EachPopulationDAO(con);
    }


    /**
     * test to get population of the world
     */
    @Test
    public void testGetPopulationByEachContinent() {
        List<Population> populations = eachPopulationDAO.getPopulationByEachContinent();
        assertNotNull(populations);
        assertFalse(populations.isEmpty(), "Population for each continent list can't be empty");

        Population firstcontinentpopulation = populations.get(0);
        assertEquals("North America", firstcontinentpopulation.getName(), "Name must be 'World'");
        assertTrue(firstcontinentpopulation.getTotalPopulation() > 0, "Total population must greater than 0");
    }

}
