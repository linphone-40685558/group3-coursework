package com.napier.gp3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CityDAOUnitTest {

    private CityDAO cityDAO;
    private Connection mockConnection;
    private PreparedStatement mockPreparedStatement;
    private ResultSet mockResultSet;

    /**
     * Setup for testing
     *
     * @throws SQLException
     */
    @BeforeEach
    void setUp() throws SQLException {
        // Mock the Connection, PreparedStatement, and ResultSet
        mockConnection = mock(Connection.class);
        mockPreparedStatement = mock(PreparedStatement.class);
        mockResultSet = mock(ResultSet.class);

        // Initialize the CityDAO with the mocked connection
        cityDAO = new CityDAO(mockConnection);
    }

    /**
     * Test Getting All Cities by Population in World
     *
     * @throws SQLException
     */
    @Test
    void testGetAllCitiesByPopulation() throws SQLException {
        // Define the SQL query result
        when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        // Mock ResultSet behavior for multiple rows
        when(mockResultSet.next()).thenReturn(true, true, false); // Two rows, then stop
        mockCityResultSet();

        // Call the method
        List<City> cities = cityDAO.getAllCitiesByPopulation();

        // Assertions Equal
        assertEquals(2, cities.size());
        verify(mockPreparedStatement).executeQuery();

        // reset the mock and throw the Exception to that prepareStatement
        reset(mockPreparedStatement);
        when(mockConnection.prepareStatement(Mockito.anyString())).thenThrow(new SQLException("Mock SQL Exception"));
        List<City> cities2 = cityDAO.getAllCitiesByPopulation();

        // Assertions for the exception check notNull and it is empty list
        assertNotNull(cities2, "This is not null cities DAO");
        assertTrue(cities2.isEmpty(), "Is cities array empty?");

        verify(mockConnection, times(2)).prepareStatement(Mockito.anyString());
    }

    /**
     * Test Getting Cities by a Continent
     *
     * @throws SQLException
     */
    @Test
    void testGetCitiesByContinent() throws SQLException {
        // Define the SQL query result
        when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        // Mock ResultSet behavior for multiple rows
        when(mockResultSet.next()).thenReturn(true, true, false); // Two rows, then stop
        mockCityResultSet();

        // Call the method
        List<City> cities = cityDAO.getCitiesByContinent("Asia");

        // Assertions Equal
        assertEquals(2, cities.size());
        verify(mockPreparedStatement).executeQuery();

        // reset the mock and throw the Exception to that prepareStatement
        reset(mockPreparedStatement);
        when(mockConnection.prepareStatement(Mockito.anyString())).thenThrow(new SQLException("Mock SQL Exception"));
        List<City> cities2 = cityDAO.getCitiesByContinent("Asia");

        // Assertions for the exception check notNull and it is empty list
        assertNotNull(cities2, "This is not null cities by continent DAO");
        assertTrue(cities2.isEmpty(), "Is cities by continent array empty?");

        verify(mockConnection, times(2)).prepareStatement(Mockito.anyString());
    }

    /**
     * Test Getting Cities by a Region
     *
     * @throws SQLException
     */
    @Test
    void testGetCitiesByRegion() throws SQLException {
        // Define the SQL query result
        when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        // Mock ResultSet behavior for multiple rows
        when(mockResultSet.next()).thenReturn(true, true, false); // Two rows, then stop
        mockCityResultSet();

        // Call the method
        List<City> cities = cityDAO.getCitiesByRegion("Southern Asia");

        // Assertions Equal
        assertEquals(2, cities.size());
        verify(mockPreparedStatement).executeQuery();

        // reset the mock and throw the Exception to that prepareStatement
        reset(mockPreparedStatement);
        when(mockConnection.prepareStatement(Mockito.anyString())).thenThrow(new SQLException("Mock SQL Exception"));
        List<City> cities2 = cityDAO.getCitiesByRegion("Southern Asia");

        // Assertions for the exception check notNull and it is empty list
        assertNotNull(cities2, "This is not null cities by region DAO");
        assertTrue(cities2.isEmpty(), "Is cities by region array empty?");

        verify(mockConnection, times(2)).prepareStatement(Mockito.anyString());
    }

    /**
     * Test Getting Cities by a country
     *
     * @throws SQLException
     */
    @Test
    void testGetCitiesByCountry() throws SQLException {
        // Define the SQL query result
        when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        // Mock ResultSet behavior for multiple rows
        when(mockResultSet.next()).thenReturn(true, true, false); // Two rows, then stop
        mockCityResultSet();

        // Call the method
        List<City> cities = cityDAO.getCitiesByCountry("MMR");

        // Assertions Equal
        assertEquals(2, cities.size());
        verify(mockPreparedStatement).executeQuery();

        // reset the mock and throw the Exception to that prepareStatement
        reset(mockPreparedStatement);
        when(mockConnection.prepareStatement(Mockito.anyString())).thenThrow(new SQLException("Mock SQL Exception"));
        List<City> cities2 = cityDAO.getCitiesByCountry("MMR");

        // Assertions for the exception check notNull and it is empty list
        assertNotNull(cities2, "This is not null cities by country DAO");
        assertTrue(cities2.isEmpty(), "Is cities by country array empty?");

        verify(mockConnection, times(2)).prepareStatement(Mockito.anyString());
    }

    /**
     * Test Getting Cities by a district
     *
     * @throws SQLException
     */
    @Test
    void testGetCitiesByDistrict() throws SQLException {
        // Define the SQL query result
        when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        // Mock ResultSet behavior for multiple rows
        when(mockResultSet.next()).thenReturn(true, true, false); // Two rows, then stop
        mockCityResultSet();

        // Call the method
        List<City> cities = cityDAO.getCitiesByDistrict("Mandalay");

        // Assertions Equal
        assertEquals(2, cities.size());
        verify(mockPreparedStatement).executeQuery();

        // reset the mock and throw the Exception to that prepareStatement
        reset(mockPreparedStatement);
        when(mockConnection.prepareStatement(Mockito.anyString())).thenThrow(new SQLException("Mock SQL Exception"));
        List<City> cities2 = cityDAO.getCitiesByDistrict("Mandalay");

        // Assertions for the exception check notNull and it is empty list
        assertNotNull(cities2, "This is not null cities by district DAO");
        assertTrue(cities2.isEmpty(), "Is cities by district array empty?");

        verify(mockConnection, times(2)).prepareStatement(Mockito.anyString());
    }

    /**
     * Test Getting Top N Populated Cities in the World
     *
     * @throws SQLException
     */
    @Test
    void testGetTopNPopulatedCitiesInWorld() throws SQLException {
        // Define the SQL query result
        when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        // Mock ResultSet behavior for multiple rows
        when(mockResultSet.next()).thenReturn(true, true, false); // Two rows, then stop
        mockCityResultSet();

        // Call the method
        List<City> cities = cityDAO.getTopNPopulatedCitiesInWorld(2);

        // Assertions
        assertEquals(2, cities.size());
        verify(mockPreparedStatement).executeQuery();

        // reset the mock and throw the Exception to that prepareStatement
        reset(mockPreparedStatement);
        when(mockConnection.prepareStatement(Mockito.anyString())).thenThrow(new SQLException("Mock SQL Exception"));
        List<City> cities2 = cityDAO.getTopNPopulatedCitiesInWorld(2);

        // Assertions for the exception check notNull and it is empty list
        assertNotNull(cities2, "This is not null top N populated cities DAO");
        assertTrue(cities2.isEmpty(), "Is top N populated cities array empty?");

        verify(mockConnection, times(2)).prepareStatement(Mockito.anyString());
    }

    /**
     * Test Getting Top N Populated Cities in a Continent
     *
     * @throws SQLException
     */
    @Test
    void testGetTopNPopulatedCitiesInContinent() throws SQLException {
        // Define the SQL query result
        when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        // Mock ResultSet behavior for multiple rows
        when(mockResultSet.next()).thenReturn(true, true, false); // Two rows, then stop
        mockCityResultSet();

        // Call the method
        List<City> cities = cityDAO.getTopNPopulatedCitiesInContinent("Asia", 2);

        // Assertions Equal
        assertEquals(2, cities.size());
        verify(mockPreparedStatement).executeQuery();

        // reset the mock and throw the Exception to that prepareStatement
        reset(mockPreparedStatement);
        when(mockConnection.prepareStatement(Mockito.anyString())).thenThrow(new SQLException("Mock SQL Exception"));
        List<City> cities2 = cityDAO.getTopNPopulatedCitiesInContinent("Asia",2);

        // Assertions for the exception check notNull and it is empty list
        assertNotNull(cities2, "This is not null top N populated cities by continent DAO");
        assertTrue(cities2.isEmpty(), "Is top N populated cities by continent array empty?");

        verify(mockConnection, times(2)).prepareStatement(Mockito.anyString());
    }

    /**
     * Test Getting Top N Populated Cities in a Region
     *
     * @throws SQLException
     */
    @Test
    void testGetTopNPopulatedCitiesInRegion() throws SQLException {
        // Define the SQL query result
        when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        // Mock ResultSet behavior for multiple rows
        when(mockResultSet.next()).thenReturn(true, true, false); // Two rows, then stop
        mockCityResultSet();

        // Call the method
        List<City> cities = cityDAO.getTopNPopulatedCitiesInRegion("Southern Asia", 2);

        // Assertions Equal
        assertEquals(2, cities.size());
        verify(mockPreparedStatement).executeQuery();

        // reset the mock and throw the Exception to that prepareStatement
        reset(mockPreparedStatement);
        when(mockConnection.prepareStatement(Mockito.anyString())).thenThrow(new SQLException("Mock SQL Exception"));
        List<City> cities2 = cityDAO.getTopNPopulatedCitiesInRegion("Southern Asia",2);

        // Assertions for the exception check notNull and it is empty list
        assertNotNull(cities2, "This is not null top N populated cities by region DAO");
        assertTrue(cities2.isEmpty(), "Is top N populated cities by region array empty?");

        verify(mockConnection, times(2)).prepareStatement(Mockito.anyString());
    }

    /**
     * Test Getting Top N Populated Cities in a Country
     *
     * @throws SQLException
     */
    @Test
    void testGetTopNPopulatedCitiesInCountry() throws SQLException {
        // Define the SQL query result
        when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        // Mock ResultSet behavior for multiple rows
        when(mockResultSet.next()).thenReturn(true, true, false); // Two rows, then stop
        mockCityResultSet();

        // Call the method
        List<City> cities = cityDAO.getTopNPopulatedCitiesInCountry("Myanmar", 2);

        // Assertions Equal
        assertEquals(2, cities.size());
        verify(mockPreparedStatement).executeQuery();

        // reset the mock and throw the Exception to that prepareStatement
        reset(mockPreparedStatement);
        when(mockConnection.prepareStatement(Mockito.anyString())).thenThrow(new SQLException("Mock SQL Exception"));
        List<City> cities2 = cityDAO.getTopNPopulatedCitiesInCountry("Myanmar",2);

        // Assertions for the exception check notNull and it is empty list
        assertNotNull(cities2, "This is not null top N populated cities by country DAO");
        assertTrue(cities2.isEmpty(), "Is top N populated cities by country array empty?");

        verify(mockConnection, times(2)).prepareStatement(Mockito.anyString());
    }

    /**
     * Test Getting Top N Populated Cities in a District
     *
     * @throws SQLException
     */
    @Test
    void testGetTopNPopulatedCitiesInDistrict() throws SQLException {
        // Define the SQL query result
        when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        // Mock ResultSet behavior for multiple rows
        when(mockResultSet.next()).thenReturn(true, true, false); // Two rows, then stop
        mockCityResultSet();

        // Call the method
        List<City> cities = cityDAO.getTopNPopulatedCitiesInDistrict("Mandalay", 2);

        // Assertions Equal
        assertEquals(2, cities.size());
        verify(mockPreparedStatement).executeQuery();

        // reset the mock and throw the Exception to that prepareStatement
        reset(mockPreparedStatement);
        when(mockConnection.prepareStatement(Mockito.anyString())).thenThrow(new SQLException("Mock SQL Exception"));
        List<City> cities2 = cityDAO.getTopNPopulatedCitiesInDistrict("Mandalay",2);

        // Assertions for the exception check notNull and it is empty list
        assertNotNull(cities2, "This is not null top N populated cities by district DAO");
        assertTrue(cities2.isEmpty(), "Is top N populated cities by district array empty?");

        verify(mockConnection, times(2)).prepareStatement(Mockito.anyString());
    }

    /**
     * Mocks the ResultSet values for cities
     */
    private void mockCityResultSet() throws SQLException {
        // Row 1
        when(mockResultSet.getInt("ID")).thenReturn(1);
        when(mockResultSet.getString("Name")).thenReturn("Washington D.C.");
        when(mockResultSet.getString("CountryName")).thenReturn("United States");
        when(mockResultSet.getString("CountryCode")).thenReturn("USA");
        when(mockResultSet.getString("District")).thenReturn("District of Columbia");
        when(mockResultSet.getInt("Population")).thenReturn(700000);

        // Row 2
        when(mockResultSet.getInt("ID")).thenReturn(2);
        when(mockResultSet.getString("Name")).thenReturn("Beijing");
        when(mockResultSet.getString("CountryName")).thenReturn("China");
        when(mockResultSet.getString("CountryCode")).thenReturn("CHN");
        when(mockResultSet.getString("District")).thenReturn("Beijing");
        when(mockResultSet.getInt("Population")).thenReturn(21540000);
    }

}
