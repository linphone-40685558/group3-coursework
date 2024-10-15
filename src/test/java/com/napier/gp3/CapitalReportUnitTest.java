package com.napier.gp3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class CapitalReportUnitTest {

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

    }

    /**
     * Test printing all capital cities by population with null, empty list, and null members in the list.
     */
    @Test
    void testPrintCapitalsByPopulation_NullEmptyAndNullMembers() {
        // Test with null
        when(mockCapitalDAO.getAllCapitalCitiesByPopulation()).thenReturn(null);
        capitalReport.printCapitalsByPopulation();

        // Test with empty list
        when(mockCapitalDAO.getAllCapitalCitiesByPopulation()).thenReturn(new ArrayList<>());
        capitalReport.printCapitalsByPopulation();

        // Test with null member
        List<Capital> mockCapitalsWithNullMembers = new ArrayList<>();
        mockCapitalsWithNullMembers.add(new Capital(1, "Washington D.C.", "United States", "USA", "District of Columbia", 705749));
        mockCapitalsWithNullMembers.add(null);
        when(mockCapitalDAO.getAllCapitalCitiesByPopulation()).thenReturn(mockCapitalsWithNullMembers);
        capitalReport.printCapitalsByPopulation();
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

    }

    /**
     * Test printing capital cities by continent with null, empty list, and null members in the list.
     */
    @Test
    void testPrintCapitalsByContinent_NullEmptyAndNullMembers() {
        // Test with null
        when(mockCapitalDAO.getCapitalCitiesByContinent("North America")).thenReturn(null);
        capitalReport.printCapitalsByContinent("North America");

        // Test with empty list
        when(mockCapitalDAO.getCapitalCitiesByContinent("North America")).thenReturn(new ArrayList<>());
        capitalReport.printCapitalsByContinent("North America");

        // Test with null member
        List<Capital> mockCapitalsWithNullMembers = new ArrayList<>();
        mockCapitalsWithNullMembers.add(new Capital(1, "Washington D.C.", "United States", "USA", "District of Columbia", 705749));
        mockCapitalsWithNullMembers.add(null);
        when(mockCapitalDAO.getCapitalCitiesByContinent("North America")).thenReturn(mockCapitalsWithNullMembers);
        capitalReport.printCapitalsByContinent("North America");
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

    }

    /**
     * Test printing capital cities by region with null, empty list, and null members in the list.
     */
    @Test
    void testPrintCapitalsByRegion_NullEmptyAndNullMembers() {
        // Test with null
        when(mockCapitalDAO.getCapitalCitiesByRegion("Eastern Asia")).thenReturn(null);
        capitalReport.printCapitalsByRegion("Eastern Asia");

        // Test with empty list
        when(mockCapitalDAO.getCapitalCitiesByRegion("Eastern Asia")).thenReturn(new ArrayList<>());
        capitalReport.printCapitalsByRegion("Eastern Asia");

        // Test with null member
        List<Capital> mockCapitalsWithNullMembers = new ArrayList<>();
        mockCapitalsWithNullMembers.add(new Capital(2, "Beijing", "China", "CHN", "Beijing", 21540000));
        mockCapitalsWithNullMembers.add(null);
        when(mockCapitalDAO.getCapitalCitiesByRegion("Eastern Asia")).thenReturn(mockCapitalsWithNullMembers);
        capitalReport.printCapitalsByRegion("Eastern Asia");
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

    }

    /**
     * Test printing top n populated capital cities in the world with null, empty list, and null members in the list.
     */
    @Test
    void testPrintTopNPopulatedCapitalCitiesInWorld_NullEmptyAndNullMembers() {
        // Test with null
        when(mockCapitalDAO.getTopNPopulatedCapitalCitiesInWorld(2)).thenReturn(null);
        capitalReport.printTopNPopulatedCapitalCitiesInWorld(2);

        // Test with empty list
        when(mockCapitalDAO.getTopNPopulatedCapitalCitiesInWorld(2)).thenReturn(new ArrayList<>());
        capitalReport.printTopNPopulatedCapitalCitiesInWorld(2);

        // Test with null member
        List<Capital> mockCapitalsWithNullMembers = new ArrayList<>();
        mockCapitalsWithNullMembers.add(new Capital(2, "Beijing", "China", "CHN", "Beijing", 21540000));
        mockCapitalsWithNullMembers.add(null);
        when(mockCapitalDAO.getTopNPopulatedCapitalCitiesInWorld(2)).thenReturn(mockCapitalsWithNullMembers);
        capitalReport.printTopNPopulatedCapitalCitiesInWorld(2);
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

    }

    /**
     * Test printing top n populated capital cities by continent with null, empty list, and null members in the list.
     */
    @Test
    void testPrintTopNPopulatedCapitalCitiesInContinent_NullEmptyAndNullMembers() {
        // Test with null
        when(mockCapitalDAO.getTopNPopulatedCapitalCitiesInContinent("North America", 1)).thenReturn(null);
        capitalReport.printTopNPopulatedCapitalCitiesInContinent(1, "North America");

        // Test with empty list
        when(mockCapitalDAO.getTopNPopulatedCapitalCitiesInContinent("North America", 1)).thenReturn(new ArrayList<>());
        capitalReport.printTopNPopulatedCapitalCitiesInContinent(1, "North America");

        // Test with null member
        List<Capital> mockCapitalsWithNullMembers = new ArrayList<>();
        mockCapitalsWithNullMembers.add(new Capital(1, "Washington D.C.", "United States", "USA", "District of Columbia", 705749));
        mockCapitalsWithNullMembers.add(null);
        when(mockCapitalDAO.getTopNPopulatedCapitalCitiesInContinent("North America", 1)).thenReturn(mockCapitalsWithNullMembers);
        capitalReport.printTopNPopulatedCapitalCitiesInContinent(1, "North America");
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

    }

    /**
     * Test printing top n populated capital cities by region with null, empty list, and null members in the list.
     */
    @Test
    void testPrintTopNPopulatedCapitalCitiesInRegion_NullEmptyAndNullMembers() {
        // Test with null
        when(mockCapitalDAO.getTopNPopulatedCapitalCitiesInRegion("Eastern Asia", 1)).thenReturn(null);
        capitalReport.printTopNPopulatedCapitalCitiesInRegion(1, "Eastern Asia");

        // Test with empty list
        when(mockCapitalDAO.getTopNPopulatedCapitalCitiesInRegion("Eastern Asia", 1)).thenReturn(new ArrayList<>());
        capitalReport.printTopNPopulatedCapitalCitiesInRegion(1, "Eastern Asia");

        // Test with null member
        List<Capital> mockCapitalsWithNullMembers = new ArrayList<>();
        mockCapitalsWithNullMembers.add(new Capital(2, "Beijing", "China", "CHN", "Beijing", 21540000));
        mockCapitalsWithNullMembers.add(null);
        when(mockCapitalDAO.getTopNPopulatedCapitalCitiesInRegion("Eastern Asia", 1)).thenReturn(mockCapitalsWithNullMembers);
        capitalReport.printTopNPopulatedCapitalCitiesInRegion(1, "Eastern Asia");
    }
}
