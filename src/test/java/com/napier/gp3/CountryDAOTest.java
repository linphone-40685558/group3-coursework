package com.napier.gp3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class CountryDAOTest {

    private CountryDAO countryDAO;
    private Connection mockConnection;
    private PreparedStatement mockPreparedStatement;
    private ResultSet mockResultSet;

    @BeforeEach
    void setUp() throws SQLException {
        // Mock the Connection, PreparedStatement, and ResultSet
        mockConnection = mock(Connection.class);
        mockPreparedStatement = mock(PreparedStatement.class);
        mockResultSet = mock(ResultSet.class);

        // Initialize the CountryDAO with the mocked connection
        countryDAO = new CountryDAO(mockConnection);
    }

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
    }

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
    }

    @Test
    void testGetCountriesByRegion() throws SQLException {
        // Define the SQL query result
        when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        // Mock ResultSet behavior for multiple rows
        when(mockResultSet.next()).thenReturn(true, true, false); // Two rows, then stop
        mockCountryResultSet();

        // Call the method
        List<Country> countries = countryDAO.getCountriesByRegion("Southern Asia");

        // Assertions
        assertEquals(2, countries.size());
        verify(mockPreparedStatement).executeQuery();
    }

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
    }

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
    }

    @Test
    void testGetTopNPopulatedCountriesInRegion() throws SQLException {
        // Define the SQL query result
        when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        // Mock ResultSet behavior for multiple rows
        when(mockResultSet.next()).thenReturn(true, true, false); // Two rows, then stop
        mockCountryResultSet();

        // Call the method
        List<Country> countries = countryDAO.getTopNPopulatedCountriesInRegion("Southern Asia", 2);

        // Assertions
        assertEquals(2, countries.size());
        verify(mockPreparedStatement).executeQuery();
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
    }
}
