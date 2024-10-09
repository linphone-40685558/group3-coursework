package com.napier.gp3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        List<City> cities = cityDAO.getCitiesByCountry("Myanmar");

        // Assertions Equal
        assertEquals(2, cities.size());
        verify(mockPreparedStatement).executeQuery();
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
