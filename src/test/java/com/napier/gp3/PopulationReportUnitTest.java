package com.napier.gp3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * @PopulationReportUnitTest
 */
class PopulationReportUnitTest {

    /**
     * @populationReport
     */
    private Population_report populationReport;
    /**
     * @mockPopulationDAO
     */
    private PopulationDAO mockPopulationDAO;
    /**
     * @mockConnection
     */
    private Connection mockConnection;

    /**
     * Set up for testing
     */
    @BeforeEach
    void setUp() {
        // Mocking the Connection and PopulationDAO
        mockConnection = mock(Connection.class);
        mockPopulationDAO = mock(PopulationDAO.class);

        // Initializing Population_report with the mocked DAO
        populationReport = new Population_report(mockConnection);
        populationReport.populationDAO = mockPopulationDAO; // Inject the mock DAO into Population_report
    }

    /**
     * Test printing world population
     */
    @Test
    void testPrintWorldPopulation() {
        // Prepare mock data
        List<Population> mockWorldPopulation = new ArrayList<>();
        mockWorldPopulation.add(new Population("World", 7800000000L, 4000000000L, 3800000000L, (4000000000L / 7800000000f) * 100, (3800000000L / 7800000000f) * 100));

        // Define behavior for the mock DAO
        when(mockPopulationDAO.getWorldPopulation()).thenReturn(mockWorldPopulation);

        // Call the method
        populationReport.printWorldPopulation();

        // Verify output methods were called
        verify(mockPopulationDAO).getWorldPopulation();
    }

    /**
     * Test printing world population with null, empty list, and null members in the list.
     */
    @Test
    void testPrintWorldPopulation_NullEmptyAndNullMembers() {
        // Test with null
        when(mockPopulationDAO.getWorldPopulation()).thenReturn(null);
        populationReport.printWorldPopulation();

        // Test with empty list
        when(mockPopulationDAO.getWorldPopulation()).thenReturn(new ArrayList<>());
        populationReport.printWorldPopulation();

        // Test with null member
        List<Population> mockPopulationsWithNullMembers = new ArrayList<>();
        mockPopulationsWithNullMembers.add(new Population("World", 7800000000L, 4000000000L, 3800000000L, (4000000000L / 7800000000f) * 100, (3800000000L / 7800000000f) * 100));
        mockPopulationsWithNullMembers.add(null);
        when(mockPopulationDAO.getWorldPopulation()).thenReturn(mockPopulationsWithNullMembers);
        populationReport.printWorldPopulation();
    }

    /**
     * Test printing population by continent
     */
    @Test
    void testPrintPopulationByContinent() {
        // Prepare mock data
        List<Population> mockContinentPopulation = new ArrayList<>();
        mockContinentPopulation.add(new Population("North America", 579000000L, 330000000L, 249000000L, (330000000L / 579000000f) * 100, (249000000L / 579000000f) * 100));

        // Define behavior for the mock DAO
        when(mockPopulationDAO.getPopulationByContinent("North America")).thenReturn(mockContinentPopulation);

        // Call the method
        populationReport.printPopulationByContinent("North America");

        // Verify output methods were called
        verify(mockPopulationDAO).getPopulationByContinent("North America");
    }

    /**
     * Test printing population by continent with null, empty list, and null members in the list.
     */
    @Test
    void testPrintPopulationByContinent_NullEmptyAndNullMembers() {
        // Test with null
        when(mockPopulationDAO.getPopulationByContinent("North America")).thenReturn(null);
        populationReport.printPopulationByContinent("North America");

        // Test with empty list
        when(mockPopulationDAO.getPopulationByContinent("North America")).thenReturn(new ArrayList<>());
        populationReport.printPopulationByContinent("North America");

        // Test with null member
        List<Population> mockPopulationsWithNullMembers = new ArrayList<>();
        mockPopulationsWithNullMembers.add(new Population("North America", 579000000L, 330000000L, 249000000L, (330000000L / 579000000f) * 100, (249000000L / 579000000f) * 100));
        mockPopulationsWithNullMembers.add(null);
        when(mockPopulationDAO.getPopulationByContinent("North America")).thenReturn(mockPopulationsWithNullMembers);
        populationReport.printPopulationByContinent("North America");
    }

    /**
     * Test printing population by region
     */
    @Test
    void testPrintPopulationByRegion() {
        // Prepare mock data
        List<Population> mockRegionPopulation = new ArrayList<>();
        mockRegionPopulation.add(new Population("Northern America", 331000000L, 330000000L, 1000000L, (330000000L / 331000000f) * 100, (1000000L / 331000000f) * 100));

        // Define behavior for the mock DAO
        when(mockPopulationDAO.getPopulationByRegion("Northern America")).thenReturn(mockRegionPopulation);

        // Call the method
        populationReport.printPopulationByRegion("Northern America");

        // Verify output methods were called
        verify(mockPopulationDAO).getPopulationByRegion("Northern America");
    }

    /**
     * Test printing population by region with null, empty list, and null members in the list.
     */
    @Test
    void testPrintPopulationByRegion_NullEmptyAndNullMembers() {
        // Test with null
        when(mockPopulationDAO.getPopulationByRegion("Northern America")).thenReturn(null);
        populationReport.printPopulationByRegion("Northern America");

        // Test with empty list
        when(mockPopulationDAO.getPopulationByRegion("Northern America")).thenReturn(new ArrayList<>());
        populationReport.printPopulationByRegion("Northern America");

        // Test with null member
        List<Population> mockPopulationsWithNullMembers = new ArrayList<>();
        mockPopulationsWithNullMembers.add(new Population("Northern America", 331000000L, 330000000L, 1000000L, (330000000L / 331000000f) * 100, (1000000L / 331000000f) * 100));
        mockPopulationsWithNullMembers.add(null);
        when(mockPopulationDAO.getPopulationByRegion("Northern America")).thenReturn(mockPopulationsWithNullMembers);
        populationReport.printPopulationByRegion("Northern America");
    }

    /**
     * Test printing population by country
     */
    @Test
    void testPrintPopulationByCountry() {
        // Prepare mock data
        List<Population> mockCountryPopulation = new ArrayList<>();
        mockCountryPopulation.add(new Population("USA", 331000000L, 329000000L, 2000000L, (329000000L / 331000000f) * 100, (2000000L / 331000000f) * 100));

        // Define behavior for the mock DAO
        when(mockPopulationDAO.getPopulationByCountry("USA")).thenReturn(mockCountryPopulation);

        // Call the method
        populationReport.printPopulationByCountry("USA");

        // Verify output methods were called
        verify(mockPopulationDAO).getPopulationByCountry("USA");
    }

    /**
     * Test printing population by country with null, empty list, and null members in the list.
     */
    @Test
    void testPrintPopulationByCountry_NullEmptyAndNullMembers() {
        // Test with null
        when(mockPopulationDAO.getPopulationByCountry("USA")).thenReturn(null);
        populationReport.printPopulationByCountry("USA");

        // Test with empty list
        when(mockPopulationDAO.getPopulationByCountry("USA")).thenReturn(new ArrayList<>());
        populationReport.printPopulationByCountry("USA");

        // Test with null member
        List<Population> mockPopulationsWithNullMembers = new ArrayList<>();
        mockPopulationsWithNullMembers.add(new Population("USA", 331000000L, 329000000L, 2000000L, (329000000L / 331000000f) * 100, (2000000L / 331000000f) * 100));
        mockPopulationsWithNullMembers.add(null);
        when(mockPopulationDAO.getPopulationByCountry("USA")).thenReturn(mockPopulationsWithNullMembers);
        populationReport.printPopulationByCountry("USA");
    }

    /**
     * Test printing population by district
     */
    @Test
    void testPrintPopulationByDistrict() {
        // Prepare mock data
        List<Population> mockDistrictPopulation = new ArrayList<>();
        mockDistrictPopulation.add(new Population("California", 39500000L, 39000000L, 500000L, (39000000L / 39500000f) * 100, (500000L / 39500000f) * 100));

        // Define behavior for the mock DAO
        when(mockPopulationDAO.getPopulationByDistrict("California")).thenReturn(mockDistrictPopulation);

        // Call the method
        populationReport.printPopulationByDistrict("California");

        // Verify output methods were called
        verify(mockPopulationDAO).getPopulationByDistrict("California");
    }

    /**
     * Test printing population by district with null, empty list, and null members in the list.
     */
    @Test
    void testPrintPopulationByDistrict_NullEmptyAndNullMembers() {
        // Test with null
        when(mockPopulationDAO.getPopulationByDistrict("California")).thenReturn(null);
        populationReport.printPopulationByDistrict("California");

        // Test with empty list
        when(mockPopulationDAO.getPopulationByDistrict("California")).thenReturn(new ArrayList<>());
        populationReport.printPopulationByDistrict("California");

        // Test with null member
        List<Population> mockPopulationsWithNullMembers = new ArrayList<>();
        mockPopulationsWithNullMembers.add(new Population("California", 39500000L, 39000000L, 500000L, (39000000L / 39500000f) * 100, (500000L / 39500000f) * 100));
        mockPopulationsWithNullMembers.add(null);
        when(mockPopulationDAO.getPopulationByDistrict("California")).thenReturn(mockPopulationsWithNullMembers);
        populationReport.printPopulationByDistrict("California");
    }

    /**
     * Test printing population by city
     */
    @Test
    void testPrintPopulationByCity() {
        // Prepare mock data
        List<Population> mockCityPopulation = new ArrayList<>();
        mockCityPopulation.add(new Population("Los Angeles", 4000000L, 3900000L, 100000L, (3900000L / 4000000f) * 100, (100000L / 4000000f) * 100));

        // Define behavior for the mock DAO
        when(mockPopulationDAO.getPopulationByCity("Los Angeles")).thenReturn(mockCityPopulation);

        // Call the method
        populationReport.printPopulationByCity("Los Angeles");

        // Verify output methods were called
        verify(mockPopulationDAO).getPopulationByCity("Los Angeles");
    }

    /**
     * Test printing population by city with null, empty list, and null members in the list.
     */
    @Test
    void testPrintPopulationByCity_NullEmptyAndNullMembers() {
        // Test with null
        when(mockPopulationDAO.getPopulationByCity("Los Angeles")).thenReturn(null);
        populationReport.printPopulationByCity("Los Angeles");

        // Test with empty list
        when(mockPopulationDAO.getPopulationByCity("Los Angeles")).thenReturn(new ArrayList<>());
        populationReport.printPopulationByCity("Los Angeles");

        // Test with null member
        List<Population> mockPopulationsWithNullMembers = new ArrayList<>();
        mockPopulationsWithNullMembers.add(new Population("Los Angeles", 4000000L, 3900000L, 100000L, (3900000L / 4000000f) * 100, (100000L / 4000000f) * 100));
        mockPopulationsWithNullMembers.add(null);
        when(mockPopulationDAO.getPopulationByCity("Los Angeles")).thenReturn(mockPopulationsWithNullMembers);
        populationReport.printPopulationByCity("Los Angeles");
    }
}
