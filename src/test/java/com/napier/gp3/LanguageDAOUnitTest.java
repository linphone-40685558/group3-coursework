package com.napier.gp3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class LanguageDAOUnitTest {
    private LanguageDAO languageDAO;
    private Connection mockConnection;
    private PreparedStatement mockPreparedStatement;
    private ResultSet mockResultSet;

    /**
     * Set up before each test
     */
    @BeforeEach
    void setUp() throws SQLException {
        // Mocking the Connection, PreparedStatement, and ResultSet
        mockConnection = mock(Connection.class);
        mockPreparedStatement = mock(PreparedStatement.class);
        mockResultSet = mock(ResultSet.class);

        // Mocking the behavior of the Connection to return a PreparedStatement
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);

        // Initializing LanguageDAO with the mocked Connection
        languageDAO = new LanguageDAO(mockConnection);
    }

    /**
     * Test the method getLanguagesByNumberOfPeople
     */
    @Test
    void testGetLanguagesByNumberOfPeople() throws SQLException {
        // Mock the world population retrieval
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true, true, false); // Two languages, then stop
        when(mockResultSet.getString("language")).thenReturn("Chinese", "English");
        when(mockResultSet.getLong("numberOfPeople")).thenReturn(1400000000L, 1200000000L);

        // Mock the world population query
        PreparedStatement mockPopulationPreparedStatement = mock(PreparedStatement.class);
        ResultSet mockPopulationResultSet = mock(ResultSet.class);
        when(mockConnection.prepareStatement(contains("total_population"))).thenReturn(mockPopulationPreparedStatement);
        when(mockPopulationPreparedStatement.executeQuery()).thenReturn(mockPopulationResultSet);
        when(mockPopulationResultSet.next()).thenReturn(true);
        when(mockPopulationResultSet.getLong("total_population")).thenReturn(7800000000L); // Example world population

        // Call the method to test
        List<Language> languages = languageDAO.getLanguagesByNumberOfPeople();

        verify(mockPopulationPreparedStatement, times(1)).executeQuery();
        verify(mockPreparedStatement, times(1)).executeQuery();

        assertNotNull(languages);
        assertEquals(2, languages.size());

        assertEquals("Chinese", languages.get(0).getLanguage());
        assertEquals(1400000000L, languages.get(0).getNumberOfPeople());
        assertEquals(15.38, languages.get(0).getPopulation_percentage(), 0.01);

        assertEquals("English", languages.get(1).getLanguage());
        assertEquals(1200000000L, languages.get(1).getNumberOfPeople());
        assertEquals(15.38, languages.get(1).getPopulation_percentage(), 0.01);

        // reset the mock and throw the exception to that prepareStatement
        reset(mockPreparedStatement);
        when(mockConnection.prepareStatement(Mockito.anyString())).thenThrow(new SQLException("Mock SQL Exception"));
        List<Language> languagesWithException = languageDAO.getLanguagesByNumberOfPeople();

        // Assertions for the exception check notNull and it is an empty list
        assertNotNull(languagesWithException);
        assertTrue(languagesWithException.isEmpty());

        // Verify prepareStatement is call
        verify(mockConnection, times(2)).prepareStatement(Mockito.anyString());
    }
}


