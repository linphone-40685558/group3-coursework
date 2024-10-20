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

public class CapitalDAOUnitTest {

    private CapitalDAO capitalDAO;
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

        // Initialize the CapitalDAO with the mocked connection
        capitalDAO = new CapitalDAO(mockConnection);
    }

    /**
     * Test Getting All Capital Cities by Population in World
     *
     * @throws SQLException
     */
    @Test
    void testGetAllCapitalCitiesByPopulation() throws SQLException {
        // Define the SQL query result
        when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        // Mock ResultSet behavior for multiple rows
        when(mockResultSet.next()).thenReturn(true, true, false); // Two rows, then stop
        mockCapitalResultSet();

        // Call the method
        List<Capital> capitals = capitalDAO.getAllCapitalCitiesByPopulation();

        // Assertions
        assertEquals(2, capitals.size());
        verify(mockPreparedStatement).executeQuery();

        // Reset the mock and throw the exception to that prepareStatement
        reset(mockPreparedStatement);
        when(mockConnection.prepareStatement(Mockito.anyString())).thenThrow(new SQLException("Mock SQL Exception"));
        List<Capital> capitalsWithException = capitalDAO.getAllCapitalCitiesByPopulation();

        // Assertions for the exception check notNull and it is empty list
        assertNotNull(capitalsWithException);
        assertTrue(capitalsWithException.isEmpty());

        // Verify prepareStatement is called twice
        verify(mockConnection, times(2)).prepareStatement(Mockito.anyString());
    }

    /**
     * Test Getting Capital Cities by Continent
     *
     * @throws SQLException
     */
    @Test
    void testGetCapitalCitiesByContinent() throws SQLException {
        // Define the SQL query result
        when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        // Mock ResultSet behavior for multiple rows
        when(mockResultSet.next()).thenReturn(true, true, false); // Two rows, then stop
        mockCapitalResultSet();

        // Call the method
        List<Capital> capitals = capitalDAO.getCapitalCitiesByContinent("Asia");

        // Assertions
        assertEquals(2, capitals.size());
        verify(mockPreparedStatement).executeQuery();

        // Reset the mock and throw the exception to that prepareStatement
        reset(mockPreparedStatement);
        when(mockConnection.prepareStatement(Mockito.anyString())).thenThrow(new SQLException("Mock SQL Exception"));
        List<Capital> capitalsWithException = capitalDAO.getCapitalCitiesByContinent("Asia");

        // Assertions for the exception check notNull and it is empty list
        assertNotNull(capitalsWithException);
        assertTrue(capitalsWithException.isEmpty());

        // Verify prepareStatement is called twice
        verify(mockConnection, times(2)).prepareStatement(Mockito.anyString());
    }

    /**
     * Test Getting Capital Cities by Region
     *
     * @throws SQLException
     */
    @Test
    void testGetCapitalCitiesByRegion() throws SQLException {
        // Define the SQL query result
        when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        // Mock ResultSet behavior for multiple rows
        when(mockResultSet.next()).thenReturn(true, true, false); // Two rows, then stop
        mockCapitalResultSet();

        // Call the method
        List<Capital> capitals = capitalDAO.getCapitalCitiesByRegion("Southern Asia");

        // Assertions
        assertEquals(2, capitals.size());
        verify(mockPreparedStatement).executeQuery();

        // Reset the mock and throw the exception to that prepareStatement
        reset(mockPreparedStatement);
        when(mockConnection.prepareStatement(Mockito.anyString())).thenThrow(new SQLException("Mock SQL Exception"));
        List<Capital> capitalsWithException = capitalDAO.getCapitalCitiesByRegion("Southern Asia");

        // Assertions for the exception check notNull and it is empty list
        assertNotNull(capitalsWithException);
        assertTrue(capitalsWithException.isEmpty());

        // Verify prepareStatement is called twice
        verify(mockConnection, times(2)).prepareStatement(Mockito.anyString());
    }


    /**
     * Test Getting Top N Populated Capital Cities in the World
     *
     * @throws SQLException
     */
    @Test
    void testGetTopNPopulatedCapitalCitiesInWorld() throws SQLException {
        // Define the SQL query result
        when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        // Mock ResultSet behavior for multiple rows
        when(mockResultSet.next()).thenReturn(true, true, false); // Two rows, then stop
        mockCapitalResultSet();

        // Call the method
        List<Capital> capitals = capitalDAO.getTopNPopulatedCapitalCitiesInWorld(2);

        // Assertions
        assertEquals(2, capitals.size());
        verify(mockPreparedStatement).executeQuery();

        // Reset the mock and throw the exception to that prepareStatement
        reset(mockPreparedStatement);
        when(mockConnection.prepareStatement(Mockito.anyString())).thenThrow(new SQLException("Mock SQL Exception"));
        List<Capital> capitalsWithException = capitalDAO.getTopNPopulatedCapitalCitiesInWorld(2);

        // Assertions for the exception check notNull and it is empty list
        assertNotNull(capitalsWithException);
        assertTrue(capitalsWithException.isEmpty());

        // Verify prepareStatement is called twice
        verify(mockConnection, times(2)).prepareStatement(Mockito.anyString());
    }

    /**
     * Test Getting Top N Populated Capital Cities in a Continent
     *
     * @throws SQLException
     */
    @Test
    void testGetTopNPopulatedCapitalCitiesInContinent() throws SQLException {
        // Define the SQL query result
        when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        // Mock ResultSet behavior for multiple rows
        when(mockResultSet.next()).thenReturn(true, true, false); // Two rows, then stop
        mockCapitalResultSet();

        // Call the method
        List<Capital> capitals = capitalDAO.getTopNPopulatedCapitalCitiesInContinent("Asia", 2);

        // Assertions
        assertEquals(2, capitals.size());
        verify(mockPreparedStatement).executeQuery();

        // Reset the mock and throw the exception to that prepareStatement
        reset(mockPreparedStatement);
        when(mockConnection.prepareStatement(Mockito.anyString())).thenThrow(new SQLException("Mock SQL Exception"));
        List<Capital> capitalsWithException = capitalDAO.getTopNPopulatedCapitalCitiesInContinent("Asia", 2);

        // Assertions for the exception check notNull and it is empty list
        assertNotNull(capitalsWithException);
        assertTrue(capitalsWithException.isEmpty());

        // Verify prepareStatement is called twice
        verify(mockConnection, times(2)).prepareStatement(Mockito.anyString());
    }

    /**
     * Test Getting Top N Populated Capital Cities in a Region
     *
     * @throws SQLException
     */
    @Test
    void testGetTopNPopulatedCapitalCitiesInRegion() throws SQLException {
        // Define the SQL query result
        when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        // Mock ResultSet behavior for multiple rows
        when(mockResultSet.next()).thenReturn(true, true, false); // Two rows, then stop
        mockCapitalResultSet();

        // Call the method
        List<Capital> capitals = capitalDAO.getTopNPopulatedCapitalCitiesInRegion("Southern Asia", 2);

        // Assertions
        assertEquals(2, capitals.size());
        verify(mockPreparedStatement).executeQuery();


        // reset the mock and throw the exception to that prepareStatement
        reset(mockPreparedStatement);
        when(mockConnection.prepareStatement(Mockito.anyString())).thenThrow(new SQLException("Mock SQL Exception"));
        List<Capital> capitalsWithException = capitalDAO.getTopNPopulatedCapitalCitiesInRegion("Southern Asia", 2);

        // Assertions for the exception check notNull and it is empty list
        assertNotNull(capitalsWithException);
        assertTrue(capitalsWithException.isEmpty());

        // Verify prepareStatement is work
        verify(mockConnection, times(2)).prepareStatement(Mockito.anyString());

    }


    /**
     * Mocks the ResultSet values for capitals
     */
    private void mockCapitalResultSet() throws SQLException {
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
