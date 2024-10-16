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

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EachPopulationDAOUnitTest {

    private Connection mockConnection;
    private EachPopulationDAO eachPopulationDAO;
    private PreparedStatement mockPreparedStatement;
    private ResultSet mockResultSet;

    /**
     * setup for testing
     *
     * @throws SQLException
     */
    @BeforeEach
    void setUp() throws SQLException {
        // mock the connection, PreparedStatement, and ResultSet
        mockConnection = mock(Connection.class);
        mockPreparedStatement = mock(PreparedStatement.class);
        mockResultSet = mock(ResultSet.class);
        // Initialize EachPopulationDAO with the connection
        eachPopulationDAO = new EachPopulationDAO(mockConnection);
    }

    /**
     * test to get population for each continent
     *
     * @throws SQLException
     */
    @Test
    public void testGetPopulationByEachContinent() throws SQLException {
        // Define the SQL query result
        when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        // Mock ResultSet behavior for multiple rows
        when(mockResultSet.next()).thenReturn(true, true, false); // Two rows, then stop

        // Mock the values that the ResultSet will return
        when(mockResultSet.getString("Continent")).thenReturn("Asia", "Europe");
        when(mockResultSet.getLong("TotalPopulation")).thenReturn(4600000000L, 740000000L);
        when(mockResultSet.getLong("UrbanPopulation")).thenReturn(2300000000L, 567000000L);

        // Call the method to test
        List<Population> populations = eachPopulationDAO.getPopulationByEachContinent();

        // Assertions
        assertNotNull(populations);
        assertFalse(populations.isEmpty(), "Population for each continent list can't be empty");
        assertEquals(2, populations.size());


        // Verify that the executeQuery method was called once
        verify(mockPreparedStatement).executeQuery();
    }

}
