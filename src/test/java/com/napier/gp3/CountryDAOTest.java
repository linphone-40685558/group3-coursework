package com.napier.gp3;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CountryDAOTest {

    @Test
    public void testGetAllCountriesByPopulation() throws SQLException {
        // Mocking dependencies
        Connection mockConnection = Mockito.mock(Connection.class);
        PreparedStatement mockStatement = Mockito.mock(PreparedStatement.class);
        ResultSet mockResultSet = Mockito.mock(ResultSet.class);

        // Define behavior for mock objects
        Mockito.when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockStatement);
        Mockito.when(mockStatement.executeQuery()).thenReturn(mockResultSet);
        Mockito.when(mockResultSet.next()).thenReturn(true).thenReturn(false);  // Return one result, then stop
        Mockito.when(mockResultSet.getString("Code")).thenReturn("USA");
        Mockito.when(mockResultSet.getString("Name")).thenReturn("United States");
        Mockito.when(mockResultSet.getString("Continent")).thenReturn("North America");
        Mockito.when(mockResultSet.getString("Region")).thenReturn("Northern America");
        Mockito.when(mockResultSet.getLong("Population")).thenReturn(331002651L);
        Mockito.when(mockResultSet.getString("CapitalName")).thenReturn("Washington D.C.");

        // Test the DAO method
        CountryDAO countryDAO = new CountryDAO(mockConnection);
        List<Country> countries = countryDAO.getAllCountriesByPopulation();

        // Assertions
        assertNotNull(countries);
        assertEquals(1, countries.size());
        assertEquals("USA", countries.get(0).getCode());
        assertEquals("United States", countries.get(0).getName());
        assertEquals("North America", countries.get(0).getContinent());
        assertEquals("Northern America", countries.get(0).getRegion());
        assertEquals(331002651L, countries.get(0).getPopulation());
        assertEquals("Washington D.C.", countries.get(0).getCapitalName());
    }
}
