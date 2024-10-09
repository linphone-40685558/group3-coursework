package com.napier.gp3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class CountryReportUnitTest {

    private Country_report countryReport;
    private CountryDAO mockCountryDAO;
    private Connection mockConnection;

    /**
     * Set up for testing
     */
    @BeforeEach
    void setUp() {
        // Mocking the Connection and CountryDAO
        mockConnection = mock(Connection.class);
        mockCountryDAO = mock(CountryDAO.class);

        // Initializing Country_report with the mocked DAO
        countryReport = new Country_report(mockConnection);
        countryReport.countryDAO = mockCountryDAO; // Inject the mock DAO into Country_report
    }

    /**
     * Test printing all countries by population
     */
    @Test
    void testPrintAllCountriesByPopulation() {
        // Prepare mock data
        List<Country> mockCountries = new ArrayList<>();
        mockCountries.add(new Country("USA", "United States", "North America", "Northern America", 331000000, 3426, "Washington D.C."));
        mockCountries.add(new Country("CHN", "China", "Asia", "Eastern Asia", 1400000000, 1891, "Beijing"));

        // Define behavior for the mock DAO
        when(mockCountryDAO.getAllCountriesByPopulation()).thenReturn(mockCountries);

        // Call the method
        countryReport.printAllCountriesByPopulation();

        // Verify that the DAO method was called
        verify(mockCountryDAO).getAllCountriesByPopulation();
    }

    /**
     * Test printing all countries by continent
     */
    @Test
    void testPrintAllCountriesByContinent() {
        // Prepare mock data
        List<Country> mockCountries = new ArrayList<>();
        mockCountries.add(new Country("USA", "United States", "North America", "Northern America", 331000000, 3426, "Washington D.C."));

        // Define behavior for the mock DAO
        when(mockCountryDAO.getCountriesByContinent("North America")).thenReturn(mockCountries);

        // Call the method
        countryReport.printAllCountriesByContinent("North America");

        // Verify that the DAO method was called
        verify(mockCountryDAO).getCountriesByContinent("North America");
    }

    /**
     * Test printing all countries by region
     */
    @Test
    void testPrintAllCountriesByRegion() {
        // Prepare mock data
        List<Country> mockCountries = new ArrayList<>();
        mockCountries.add(new Country("USA", "United States", "North America", "Northern America", 331000000, 3426, "Washington D.C."));

        // Define behavior for the mock DAO
        when(mockCountryDAO.getCountriesByRegion("Northern America")).thenReturn(mockCountries);

        // Call the method
        countryReport.printAllCountriesByRegion("Northern America");

        // Verify that the DAO method was called
        verify(mockCountryDAO).getCountriesByRegion("Northern America");
    }

    /**
     * Test printing top n populated countries
     */
    @Test
    void testPrintTopNCountries() {
        // Prepare mock data
        List<Country> mockCountries = new ArrayList<>();
        mockCountries.add(new Country("CHN", "China", "Asia", "Eastern Asia", 1400000000, 1891, "Beijing"));
        mockCountries.add(new Country("USA", "United States", "North America", "Northern America", 331000000, 3426, "Washington D.C."));

        // Define behavior for the mock DAO
        when(mockCountryDAO.getTopNPopulatedCountries(2)).thenReturn(mockCountries);

        // Call the method
        countryReport.printTopNCountries(2);

        // Verify that the DAO method was called
        verify(mockCountryDAO).getTopNPopulatedCountries(2);
    }

    /**
     * Test printing top n populated countries by continent
     */
    @Test
    void testPrintTopNCountriesByContinent() {
        // Prepare mock data
        List<Country> mockCountries = new ArrayList<>();
        mockCountries.add(new Country("USA", "United States", "North America", "Northern America", 331000000, 3426, "Washington D.C."));

        // Define behavior for the mock DAO
        when(mockCountryDAO.getTopNPopulatedCountriesInContinent("North America", 1)).thenReturn(mockCountries);

        // Call the method
        countryReport.printTopNCountriesByContinent(1, "North America");

        // Verify that the DAO method was called
        verify(mockCountryDAO).getTopNPopulatedCountriesInContinent("North America", 1);
    }

    /**
     * Test printing top n populated countries by region
     */
    @Test
    void testPrintTopNCountriesByRegion() {
        // Prepare mock data
        List<Country> mockCountries = new ArrayList<>();
        mockCountries.add(new Country("USA", "United States", "North America", "Northern America", 331000000, 3426, "Washington D.C."));

        // Define behavior for the mock DAO
        when(mockCountryDAO.getTopNPopulatedCountriesInRegion("Northern America", 1)).thenReturn(mockCountries);

        // Call the method
        countryReport.printTopNCountriesByRegion(1, "Northern America");

        // Verify that the DAO method was called
        verify(mockCountryDAO).getTopNPopulatedCountriesInRegion("Northern America", 1);
    }
}
