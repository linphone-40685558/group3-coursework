package com.napier.gp3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class LanguageDAOTest {
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

        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        // Initializing LanguageDAO with the mocked Connection
        languageDAO = new LanguageDAO(mockConnection);
    }

    /**
     * Test the method getLanguagesByNumberOfPeople
     */
    @Test
    void testGetLanguagesByNumberOfPeople() throws SQLException {
        // Mock the total world population
        when(mockResultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
        when(mockResultSet.getLong("total_population")).thenReturn(7800000000L);

        // Mock the languages query
        when(mockResultSet.getString("language")).thenReturn("Chinese").thenReturn("English");
        when(mockResultSet.getLong("numberOfPeople")).thenReturn(1700000000L).thenReturn(1800000000L);

        // Call the method
        List<Language> languages = languageDAO.getLanguagesByNumberOfPeople();

        // Verify the prepared statement
        verify(mockConnection, times(2)).prepareStatement(anyString());
        verify(mockPreparedStatement, times(2)).executeQuery();

        // Verify the process of result
        verify(mockResultSet, times(2)).getString("language");
        verify(mockResultSet, times(2)).getLong("numberOfPeople");

        // Assert the results
        assertNotNull(languages);
        assertEquals(2, languages.size());

        assertEquals("Chinese", languages.get(0).getLanguage());
        assertEquals(1700000000L, languages.get(0).getNumberOfPeople());
        assertEquals(17.95, languages.get(0).getPopulation_percentage(), 0.01); // Expected percentage: (1400000000 / 7800000000) * 100
        assertEquals("English", languages.get(1).getLanguage());
        assertEquals(1800000000L, languages.get(1).getNumberOfPeople());
        assertEquals(15.38, languages.get(1).getPopulation_percentage(), 0.01); // Expected percentage: (1200000000 / 7800000000) * 100
    }
}
