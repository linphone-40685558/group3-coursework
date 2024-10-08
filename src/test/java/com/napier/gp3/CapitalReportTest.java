package com.napier.gp3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class CapitalReportTest {

    private Capital_report capitalReport;
    private CapitalDAO mockCapitalDAO;
    private Connection mockConnection;

    /**
     * Set up for testing
     */
    @BeforeEach
    void setUp() {
        // Mocking the Connection and CapitalDAO
        mockConnection = mock(Connection.class);
        mockCapitalDAO = mock(CapitalDAO.class);

        // Initializing Capital_report with the mocked DAO
        capitalReport = new Capital_report(mockConnection);
        capitalReport.capitalDAO = mockCapitalDAO; // Inject the mock DAO into Capital_report
    }

    /**
     * Test printing all capital cities by population
     */
    @Test
    void testPrintCapitalsByPopulation() {
        // Prepare mock data
        List<Capital> mockCapitals = new ArrayList<>();
        mockCapitals.add(new Capital(1, "Washington D.C.", "United States", "USA", "District of Columbia", 705749));
        mockCapitals.add(new Capital(2, "Beijing", "China", "CHN", "Beijing", 21540000));

        // Define behavior for the mock DAO
        when(mockCapitalDAO.getAllCapitalCitiesByPopulation()).thenReturn(mockCapitals);

        // Call the method
        capitalReport.printCapitalsByPopulation();

        // Verify that the DAO method was called
        verify(mockCapitalDAO).getAllCapitalCitiesByPopulation();
    }

    /**
     * Test printing capital cities by continent
     */
    @Test
    void testPrintCapitalsByContinent() {
        // Prepare mock data
        List<Capital> mockCapitals = new ArrayList<>();
        mockCapitals.add(new Capital(1, "Washington D.C.", "United States", "USA", "District of Columbia", 705749));

        // Define behavior for the mock DAO
        when(mockCapitalDAO.getCapitalCitiesByContinent("North America")).thenReturn(mockCapitals);

        // Call the method
        capitalReport.printCapitalsByContinent("North America");

        // Verify that the DAO method was called
        verify(mockCapitalDAO).getCapitalCitiesByContinent("North America");
    }

    /**
     * Test printing capital cities by region
     */
    @Test
    void testPrintCapitalsByRegion() {
        // Prepare mock data
        List<Capital> mockCapitals = new ArrayList<>();
        mockCapitals.add(new Capital(2, "Beijing", "China", "CHN", "Beijing", 21540000));

        // Define behavior for the mock DAO
        when(mockCapitalDAO.getCapitalCitiesByRegion("Eastern Asia")).thenReturn(mockCapitals);

        // Call the method
        capitalReport.printCapitalsByRegion("Eastern Asia");

        // Verify that the DAO method was called
        verify(mockCapitalDAO).getCapitalCitiesByRegion("Eastern Asia");
    }

    /**
     * Test printing top n populated capital cities in the world
     */
    @Test
    void testPrintTopNPopulatedCapitalCitiesInWorld() {
        // Prepare mock data
        List<Capital> mockCapitals = new ArrayList<>();
        mockCapitals.add(new Capital(2, "Beijing", "China", "CHN", "Beijing", 21540000));
        mockCapitals.add(new Capital(1, "Washington D.C.", "United States", "USA", "District of Columbia", 705749));

        // Define behavior for the mock DAO
        when(mockCapitalDAO.getTopNPopulatedCapitalCitiesInWorld(2)).thenReturn(mockCapitals);

        // Call the method
        capitalReport.printTopNPopulatedCapitalCitiesInWorld(2);

        // Verify that the DAO method was called
        verify(mockCapitalDAO).getTopNPopulatedCapitalCitiesInWorld(2);
    }

    /**
     * Test printing top n populated capital cities by continent
     */
    @Test
    void testPrintTopNPopulatedCapitalCitiesInContinent() {
        // Prepare mock data
        List<Capital> mockCapitals = new ArrayList<>();
        mockCapitals.add(new Capital(1, "Washington D.C.", "United States", "USA", "District of Columbia", 705749));

        // Define behavior for the mock DAO
        when(mockCapitalDAO.getTopNPopulatedCapitalCitiesInContinent("North America", 1)).thenReturn(mockCapitals);

        // Call the method
        capitalReport.printTopNPopulatedCapitalCitiesInContinent(1, "North America");

        // Verify that the DAO method was called
        verify(mockCapitalDAO).getTopNPopulatedCapitalCitiesInContinent("North America", 1);
    }

    /**
     * Test printing top n populated capital cities by region
     */
    @Test
    void testPrintTopNPopulatedCapitalCitiesInRegion() {
        // Prepare mock data
        List<Capital> mockCapitals = new ArrayList<>();
        mockCapitals.add(new Capital(2, "Beijing", "China", "CHN", "Beijing", 21540000));

        // Define behavior for the mock DAO
        when(mockCapitalDAO.getTopNPopulatedCapitalCitiesInRegion("Eastern Asia", 1)).thenReturn(mockCapitals);

        // Call the method
        capitalReport.printTopNPopulatedCapitalCitiesInRegion(1, "Eastern Asia");

        // Verify that the DAO method was called
        verify(mockCapitalDAO).getTopNPopulatedCapitalCitiesInRegion("Eastern Asia", 1);
    }
}
