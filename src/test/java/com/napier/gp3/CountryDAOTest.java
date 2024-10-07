package com.napier.gp3;

import org.junit.jupiter.api.*;
import org.mockito.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CountryDAOTest {

    @Mock
    private Connection connection;

    @Mock
    private PreparedStatement preparedStatement;

    @Mock
    private ResultSet resultSet;

    private CountryDAO countryDAO;

    @BeforeEach
    public void setUp() throws SQLException {
        // Initialize the mocks
        MockitoAnnotations.openMocks(this);

        // Set up the mock behavior for connection and statements
        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);

        // Initialize CountryDAO with the mocked connection
        countryDAO = new CountryDAO(connection);
    }

    @Test
    public void testGetAllCountriesByPopulation() throws SQLException {
        // Mocking the result set
        when(resultSet.next()).thenReturn(true, true, false);  // Simulate 2 countries
        when(resultSet.getString("Code")).thenReturn("USA", "CHN");
        when(resultSet.getString("Name")).thenReturn("United States", "China");
        when(resultSet.getString("Continent")).thenReturn("North America", "Asia");
        when(resultSet.getString("Region")).thenReturn("Northern America", "Eastern Asia");
        when(resultSet.getInt("Population")).thenReturn(331002651, 1439323776);
        when(resultSet.getString("CapitalName")).thenReturn("Washington D.C.", "Beijing");

        // Call the method
        List<Country> countries = countryDAO.getAllCountriesByPopulation();

        // Verify the results
        assertNotNull(countries);
        assertEquals(2, countries.size());
        assertEquals("United States", countries.get(0).getName());
        assertEquals("China", countries.get(1).getName());
    }

    @Test
    public void testGetTopNPopulatedCountries() throws SQLException {
        // Mocking the result set
        when(resultSet.next()).thenReturn(true, true, false); // Simulate 2 countries
        when(resultSet.getString("Code")).thenReturn("USA", "CHN");
        when(resultSet.getString("Name")).thenReturn("United States", "China");
        when(resultSet.getString("Continent")).thenReturn("North America", "Asia");
        when(resultSet.getString("Region")).thenReturn("Northern America", "Eastern Asia");
        when(resultSet.getInt("Population")).thenReturn(331002651, 1439323776);
        when(resultSet.getString("CapitalName")).thenReturn("Washington D.C.", "Beijing");

        // Call the method
        List<Country> countries = countryDAO.getTopNPopulatedCountries(2);

        // Verify the results
        assertNotNull(countries);
        assertEquals(2, countries.size());
        assertEquals("United States", countries.get(0).getName());
        assertEquals("China", countries.get(1).getName());
    }

    @AfterEach
    public void tearDown() {
        // Close mocks after each test
        Mockito.framework().clearInlineMocks();
    }
}
