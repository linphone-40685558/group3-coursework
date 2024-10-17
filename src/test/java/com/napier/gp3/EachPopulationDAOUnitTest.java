package com.napier.gp3;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EachPopulationDAOUnitTest {

    private Connection mockConnection;
    private EachPopulationDAO eachPopulationDAO;
    private PreparedStatement mockPreparedStatement1;
    private PreparedStatement mockPreparedStatement2;
    private ResultSet mockResultSet1;
    private ResultSet mockResultSet2;

    @BeforeEach
    public void setUp() throws SQLException {
        // Mock the database connection, prepared statement, and result set
        mockConnection = mock(Connection.class);
        mockPreparedStatement1 = mock(PreparedStatement.class);
        mockPreparedStatement2 = mock(PreparedStatement.class);
        mockResultSet1 = mock(ResultSet.class);
        mockResultSet2 = mock(ResultSet.class);

        // Initialize the eachPopulationDAO
        eachPopulationDAO = new EachPopulationDAO(mockConnection);
    }

    /**
     * test population for every continent
     *
     * @throws SQLException
     */
    @Test
    public void testGetPopulationByEachContinent() throws SQLException {
        // Mock the first query (total population per continent)
        when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockPreparedStatement1);
        when(mockPreparedStatement1.executeQuery()).thenReturn(mockResultSet1);
        when(mockResultSet1.next()).thenReturn(true, true, false); // Two rows, then stop

        // Mock data for the first query
        when(mockResultSet1.getString("Continent")).thenReturn("Asia").thenReturn("Europe"); // continent
        when(mockResultSet1.getLong("TotalPopulation")).thenReturn(4600000000L).thenReturn(740000000L); // total population

        // Mock the second query (urban population per continent)
        when(mockConnection.prepareStatement(Mockito.contains("SUM(city.Population)"))).thenReturn(mockPreparedStatement2);
        when(mockPreparedStatement2.executeQuery()).thenReturn(mockResultSet2);
        when(mockResultSet2.next()).thenReturn(true, true, false); // Two rows, then stop

        // Mock data for the second query
        when(mockResultSet2.getLong("UrbanPopulation")).thenReturn(2300000000L).thenReturn(500000000L); // urban population

        // Call the method to test
        List<Population> populations = eachPopulationDAO.getPopulationByEachContinent();

        // Assertions
        assertNotNull(populations);
        assertEquals(2, populations.size()); // Two continents

        // Verify first continent (Asia)
        Population asiaPopulation = populations.get(0);
        assertEquals("Asia", asiaPopulation.getName());
        assertEquals(4600000000L, asiaPopulation.getTotalPopulation());
        assertEquals(2300000000L, asiaPopulation.getUrbanPopulation());
        assertEquals(2300000000L, asiaPopulation.getRuralPopulation());
        assertEquals(50.0f, asiaPopulation.getUrbanPopulationPercentage());
        assertEquals(50.0f, asiaPopulation.getRuralPopulationPercentage());

        // Verify second continent (Europe)
        Population europePopulation = populations.get(1);
        assertEquals("Europe", europePopulation.getName());
        assertEquals(740000000L, europePopulation.getTotalPopulation());
        assertEquals(500000000L, europePopulation.getUrbanPopulation());
        assertEquals(240000000L, europePopulation.getRuralPopulation());
        assertEquals(67.57f, europePopulation.getUrbanPopulationPercentage(), 0.01);
        assertEquals(32.43f, europePopulation.getRuralPopulationPercentage(), 0.01);

        // Verify execution of SQL queries
        verify(mockPreparedStatement1).executeQuery();
        verify(mockPreparedStatement2, times(2)).executeQuery(); // Called twice for two continents
    }

}

