package com.napier.gp3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class PopulationDAOUnitTest {

    private PopulationDAO populationDAO;
    private Connection mockConnection;
    private PreparedStatement mockPreparedStatement;
    private ResultSet mockResultSet;

    /**
     * Set up for testing
     *
     * @throws SQLException
     */
    @BeforeEach
    void setUp() throws SQLException {
        // Mock the Connection, PreparedStatement, and ResultSet
        mockConnection = mock(Connection.class);
        mockPreparedStatement = mock(PreparedStatement.class);
        mockResultSet = mock(ResultSet.class);

        // Initialize the PopulationDAO with the mocked connection
        populationDAO = new PopulationDAO(mockConnection);
    }

    /**
     * Test Getting Total World Population
     *
     * @throws SQLException
     */
    @Test
    void testGetTotalWorldPopulation() throws SQLException {
        // Define the SQL query result
        when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        // Mock ResultSet behavior
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getLong("TotalPopulation")).thenReturn(7800000000L); // 7.8 billion

        // Call the method
        long totalPopulation = populationDAO.getTotalWorldPopulation();

        // Assertions
        assertEquals(7800000000L, totalPopulation);
        verify(mockPreparedStatement).executeQuery();
    }

    /**
     * Test Getting World Population
     *
     * @throws SQLException
     */
    @Test
    void testGetWorldPopulation() throws SQLException {
        // Define the SQL query result
        when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        // Mock ResultSet behavior
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getLong("TotalPopulation")).thenReturn(7800000000L); // 7.8 billion
        when(mockResultSet.getLong("UrbanPopulation")).thenReturn(5000000000L); // 5 billion

        // Call the method
        List<Population> populations = populationDAO.getWorldPopulation();

        // Assertions
        assertNotNull(populations);
        assertEquals(1, populations.size());
        assertEquals("World", populations.get(0).getName());
        assertEquals(7800000000L, populations.get(0).getTotalPopulation());
        assertEquals(5000000000L, populations.get(0).getUrbanPopulation());
        assertEquals(2800000000L, populations.get(0).getRuralPopulation());
    }

    /**
     * Test Getting Population by Continent
     *
     * @throws SQLException
     */
    @Test
    void testGetPopulationByContinent() throws SQLException {
        // Define the SQL query result
        when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        // Mock ResultSet behavior
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getLong("TotalPopulation")).thenReturn(1000000000L); // 1 billion
        when(mockResultSet.getLong("UrbanPopulation")).thenReturn(600000000L); // 600 million

        // Call the method
        List<Population> populations = populationDAO.getPopulationByContinent("Asia");

        // Assertions
        assertNotNull(populations);
        assertEquals(1, populations.size());
        assertEquals("Asia", populations.get(0).getName());
        assertEquals(1000000000L, populations.get(0).getTotalPopulation());
        assertEquals(600000000L, populations.get(0).getUrbanPopulation());
        assertEquals(400000000L, populations.get(0).getRuralPopulation());
    }

    /**
     * Test Getting Population by Region
     *
     * @throws SQLException
     */
    @Test
    void testGetPopulationByRegion() throws SQLException {
        // Define the SQL query result
        when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        // Mock ResultSet behavior
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getLong("TotalPopulation")).thenReturn(500000000L); // 500 million
        when(mockResultSet.getLong("UrbanPopulation")).thenReturn(300000000L); // 300 million

        // Call the method
        List<Population> populations = populationDAO.getPopulationByRegion("Southeast Asia");

        // Assertions
        assertNotNull(populations);
        assertEquals(1, populations.size());
        assertEquals("Southeast Asia", populations.get(0).getName());
        assertEquals(500000000L, populations.get(0).getTotalPopulation());
        assertEquals(300000000L, populations.get(0).getUrbanPopulation());
        assertEquals(200000000L, populations.get(0).getRuralPopulation());
    }

    /**
     * Test Getting Population by Country
     *
     * @throws SQLException
     */
    @Test
    void testGetPopulationByCountry() throws SQLException {
        // Define the SQL query result
        when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        // Mock ResultSet behavior
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getString("CountryName")).thenReturn("India");
        when(mockResultSet.getLong("TotalPopulation")).thenReturn(1390000000L); // 1.39 billion
        when(mockResultSet.getLong("UrbanPopulation")).thenReturn(500000000L); // 500 million

        // Call the method
        List<Population> populations = populationDAO.getPopulationByCountry("IND");

        // Assertions
        assertNotNull(populations);
        assertEquals(1, populations.size());
        assertEquals("India", populations.get(0).getName());
        assertEquals(1390000000L, populations.get(0).getTotalPopulation());
        assertEquals(500000000L, populations.get(0).getUrbanPopulation());
        assertEquals(890000000L, populations.get(0).getRuralPopulation());
    }

    /**
     * Test Getting Population by District
     *
     * @throws SQLException
     */
    @Test
    void testGetPopulationByDistrict() throws SQLException {
        // Define the SQL query result
        when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        // Mock ResultSet behavior
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getLong("UrbanPopulation")).thenReturn(3000000L); // 3 million

        // Call the method
        List<Population> populations = populationDAO.getPopulationByDistrict("Central District");

        // Assertions
        assertNotNull(populations);
        assertEquals(1, populations.size());
        assertEquals("Central District", populations.get(0).getName());
        assertEquals(3000000L, populations.get(0).getTotalPopulation());
        assertEquals(3000000L, populations.get(0).getUrbanPopulation());
        assertEquals(0, populations.get(0).getRuralPopulation());
    }

    /**
     * Test Getting Population by City
     *
     * @throws SQLException
     */
    @Test
    void testGetPopulationByCity() throws SQLException {
        // Define the SQL query result
        when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        // Mock ResultSet behavior
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getLong("Population")).thenReturn(1200000L); // 1.2 million

        // Call the method
        List<Population> populations = populationDAO.getPopulationByCity("Some City");

        // Assertions
        assertNotNull(populations);
        assertEquals(1, populations.size());
        assertEquals("Some City", populations.get(0).getName());
        assertEquals(1200000L, populations.get(0).getTotalPopulation());
        assertEquals(1200000L, populations.get(0).getUrbanPopulation());
        assertEquals(0, populations.get(0).getRuralPopulation());
    }
}
