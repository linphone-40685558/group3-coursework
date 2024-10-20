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

class CountryDAOUnitTest {

    private CountryDAO countryDAO;
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

        // Initialize the CountryDAO with the mocked connection
        countryDAO = new CountryDAO(mockConnection);
    }

    /**
     * Test Getting Countries in the World
     *
     * @throws SQLException
     */
    @Test
    void testGetAllCountriesByPopulation() throws SQLException {
        // Define the SQL query result
        when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        // Mock ResultSet behavior for multiple rows
        when(mockResultSet.next()).thenReturn(true, true, false); // Two rows, then stop
        mockCountryResultSet();

        // Call the method
        List<Country> countries = countryDAO.getAllCountriesByPopulation();

        // Assertions
        assertEquals(2, countries.size());
        verify(mockPreparedStatement).executeQuery();

        // Reset the mock and throw the exception to that prepareStatement
        reset(mockPreparedStatement);
        when(mockConnection.prepareStatement(Mockito.anyString())).thenThrow(new SQLException("Mock SQL Exception"));
        List<Country> countriesWithException = countryDAO.getAllCountriesByPopulation();

        // Assertions for the exception check notNull and it is an empty list
        assertNotNull(countriesWithException);
        assertTrue(countriesWithException.isEmpty());

        // Verify prepareStatement is call
        verify(mockConnection, times(2)).prepareStatement(Mockito.anyString());
    }

    /**
     * Test Getting Countries in a Continent
     *
     * @throws SQLException
     */
    @Test
    void testGetCountriesByContinent() throws SQLException {
        // Define the SQL query result
        when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        // Mock ResultSet behavior for multiple rows
        when(mockResultSet.next()).thenReturn(true, true, false); // Two rows, then stop
        mockCountryResultSet();

        // Call the method
        List<Country> countries = countryDAO.getCountriesByContinent("Asia");

        // Assertions
        assertEquals(2, countries.size());
        verify(mockPreparedStatement).executeQuery();

        // Reset the mock and throw the exception to that prepareStatement
        reset(mockPreparedStatement);
        when(mockConnection.prepareStatement(Mockito.anyString())).thenThrow(new SQLException("Mock SQL Exception"));
        List<Country> countriesWithException = countryDAO.getCountriesByContinent("Asia");

        // Assertions for the exception check notNull and it is an empty list
        assertNotNull(countriesWithException);
        assertTrue(countriesWithException.isEmpty());

        // Verify prepareStatement is called twice
        verify(mockConnection, times(2)).prepareStatement(Mockito.anyString());
    }

    /**
     * Test Getting Countries in a Region
     *
     * @throws SQLException
     */
    @Test
    void testGetCountriesByRegion() throws SQLException {
        // Define the SQL query result
        when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        // Mock ResultSet behavior for multiple rows
        when(mockResultSet.next()).thenReturn(true, true, false); // Two rows, then stop
        mockCountryResultSet();

        // Call the method
        List<Country> countries = countryDAO.getCountriesByRegion("Southeast Asia");

        // Assertions
        assertEquals(2, countries.size());
        verify(mockPreparedStatement).executeQuery();

        // Reset the mock and throw the exception to that prepareStatement
        reset(mockPreparedStatement);
        when(mockConnection.prepareStatement(Mockito.anyString())).thenThrow(new SQLException("Mock SQL Exception"));
        List<Country> countriesWithException = countryDAO.getCountriesByRegion("Southeast Asia");

        // Assertions for the exception check notNull and it is an empty list
        assertNotNull(countriesWithException);
        assertTrue(countriesWithException.isEmpty());

        // Verify prepareStatement is called twice
        verify(mockConnection, times(2)).prepareStatement(Mockito.anyString());
    }

    /**
     * Test Getting Top N Populated Countries in the World
     *
     * @throws SQLException
     */
    @Test
    void testGetTopNPopulatedCountries() throws SQLException {
        // Define the SQL query result
        when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        // Mock ResultSet behavior for multiple rows
        when(mockResultSet.next()).thenReturn(true, true, false); // Two rows, then stop
        mockCountryResultSet();

        // Call the method
        List<Country> countries = countryDAO.getTopNPopulatedCountries(2);

        // Assertions
        assertEquals(2, countries.size());
        verify(mockPreparedStatement).executeQuery();

        // Reset the mock and throw the exception to that prepareStatement
        reset(mockPreparedStatement);
        when(mockConnection.prepareStatement(Mockito.anyString())).thenThrow(new SQLException("Mock SQL Exception"));
        List<Country> countriesWithException = countryDAO.getTopNPopulatedCountries(2);

        // Assertions for the exception check notNull and it is an empty list
        assertNotNull(countriesWithException);
        assertTrue(countriesWithException.isEmpty());

        // Verify prepareStatement is called twice
        verify(mockConnection, times(2)).prepareStatement(Mockito.anyString());
    }

    /**
     * Test Getting Top N Populated Countries in Continent
     *
     * @throws SQLException
     */
    @Test
    void testGetTopNPopulatedCountriesInContinent() throws SQLException {
        // Define the SQL query result
        when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        // Mock ResultSet behavior for multiple rows
        when(mockResultSet.next()).thenReturn(true, true, false); // Two rows, then stop
        mockCountryResultSet();

        // Call the method
        List<Country> countries = countryDAO.getTopNPopulatedCountriesInContinent("Asia", 2);

        // Assertions
        assertEquals(2, countries.size());
        verify(mockPreparedStatement).executeQuery();

        // Reset the mock and throw the exception to that prepareStatement
        reset(mockPreparedStatement);
        when(mockConnection.prepareStatement(Mockito.anyString())).thenThrow(new SQLException("Mock SQL Exception"));
        List<Country> countriesWithException = countryDAO.getTopNPopulatedCountriesInContinent("Asia", 2);

        // Assertions for the exception check notNull and it is an empty list
        assertNotNull(countriesWithException);
        assertTrue(countriesWithException.isEmpty());

        // Verify prepareStatement is called twice
        verify(mockConnection, times(2)).prepareStatement(Mockito.anyString());
    }

    /**
     * Test Getting Top N Populated Countries in Region
     *
     * @throws SQLException
     */
    @Test
    void testGetTopNPopulatedCountriesInRegion() throws SQLException {
        // Define the SQL query result
        when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        // Mock ResultSet behavior for multiple rows
        when(mockResultSet.next()).thenReturn(true, true, false); // Two rows, then stop
        mockCountryResultSet();

        // Call the method
        List<Country> countries = countryDAO.getTopNPopulatedCountriesInRegion("Southeast Asia", 2);

        // Assertions
        assertEquals(2, countries.size());
        verify(mockPreparedStatement).executeQuery();

        // Reset the mock and throw the exception to that prepareStatement
        reset(mockPreparedStatement);
        when(mockConnection.prepareStatement(Mockito.anyString())).thenThrow(new SQLException("Mock SQL Exception"));
        List<Country> countriesWithException = countryDAO.getTopNPopulatedCountriesInRegion("Southeast Asia", 2);

        // Assertions for the exception check notNull and it is an empty list
        assertNotNull(countriesWithException);
        assertTrue(countriesWithException.isEmpty());

        // Verify prepareStatement is called twice
        verify(mockConnection, times(2)).prepareStatement(Mockito.anyString());
    }

    /**
     * Mocks the ResultSet values for countries
     */
    private void mockCountryResultSet() throws SQLException {
        // Row 1
        when(mockResultSet.getString("Code")).thenReturn("USA");
        when(mockResultSet.getString("Name")).thenReturn("United States");
        when(mockResultSet.getString("Continent")).thenReturn("North America");
        when(mockResultSet.getString("Region")).thenReturn("Northern America");
        when(mockResultSet.getLong("Population")).thenReturn(331000000L);
        when(mockResultSet.getInt("Capital")).thenReturn(1);
        when(mockResultSet.getString("CapitalName")).thenReturn("Washington D.C.");

        // Row 2
        when(mockResultSet.getString("Code")).thenReturn("CHN");
        when(mockResultSet.getString("Name")).thenReturn("China");
        when(mockResultSet.getString("Continent")).thenReturn("Asia");
        when(mockResultSet.getString("Region")).thenReturn("Eastern Asia");
        when(mockResultSet.getLong("Population")).thenReturn(1400000000L);
        when(mockResultSet.getInt("Capital")).thenReturn(2);
        when(mockResultSet.getString("CapitalName")).thenReturn("Beijing");

        // Row 3
        when(mockResultSet.getString("Code")).thenReturn("MM");
        when(mockResultSet.getString("Name")).thenReturn("Myanmar");
        when(mockResultSet.getString("Continent")).thenReturn("Asia");
        when(mockResultSet.getString("Region")).thenReturn("Southeast Asia");
        when(mockResultSet.getLong("Population")).thenReturn(40000000L);
        when(mockResultSet.getInt("Capital")).thenReturn(3);
        when(mockResultSet.getString("CapitalName")).thenReturn("Yangon");
    }
}
