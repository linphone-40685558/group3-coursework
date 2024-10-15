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
    }

    /**
     * Test printing all countries by population with null, empty list, and null members in the list.
     */
    @Test
    void testPrintAllCountriesByPopulation_NullEmptyAndNullMembers() {
        // Test with null
        when(mockCountryDAO.getAllCountriesByPopulation()).thenReturn(null);
        countryReport.printAllCountriesByPopulation();

        // Test with empty list
        when(mockCountryDAO.getAllCountriesByPopulation()).thenReturn(new ArrayList<>());
        countryReport.printAllCountriesByPopulation();
        ArrayList<Country> EmptyCountries = new ArrayList<>();

        // Test with null member
        List<Country> mockCountriesWithNullMembers = new ArrayList<>();
        mockCountriesWithNullMembers.add(new Country("USA", "United States", "North America", "Northern America", 331000000, 3426, "Washington D.C."));
        mockCountriesWithNullMembers.add(null);
        when(mockCountryDAO.getAllCountriesByPopulation()).thenReturn(mockCountriesWithNullMembers);
        countryReport.printAllCountriesByPopulation();
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
    }

    /**
     * Test printing all countries by continent with null, empty list, and null members in the list.
     */
    @Test
    void testPrintAllCountriesByContinent_NullEmptyAndNullMembers() {
        // Test with null
        when(mockCountryDAO.getCountriesByContinent("North America")).thenReturn(null);
        countryReport.printAllCountriesByContinent("North America");

        // Test with empty list
        when(mockCountryDAO.getCountriesByContinent("North America")).thenReturn(new ArrayList<>());
        countryReport.printAllCountriesByContinent("North America");

        // Test with null member
        List<Country> mockCountriesWithNullMembers = new ArrayList<>();
        mockCountriesWithNullMembers.add(new Country("USA", "United States", "North America", "Northern America", 331000000, 3426, "Washington D.C."));
        mockCountriesWithNullMembers.add(null);
        when(mockCountryDAO.getCountriesByContinent("North America")).thenReturn(mockCountriesWithNullMembers);
        countryReport.printAllCountriesByContinent("North America");
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
    }

    /**
     * Test printing all countries by region with null, empty list, and null members in the list.
     */
    @Test
    void testPrintAllCountriesByRegion_NullEmptyAndNullMembers() {
        // Test with null
        when(mockCountryDAO.getCountriesByRegion("Northern America")).thenReturn(null);
        countryReport.printAllCountriesByRegion("Northern America");

        // Test with empty list
        when(mockCountryDAO.getCountriesByRegion("Northern America")).thenReturn(new ArrayList<>());
        countryReport.printAllCountriesByRegion("Northern America");

        // Test with null member
        List<Country> mockCountriesWithNullMembers = new ArrayList<>();
        mockCountriesWithNullMembers.add(new Country("USA", "United States", "North America", "Northern America", 331000000, 3426, "Washington D.C."));
        mockCountriesWithNullMembers.add(null);
        when(mockCountryDAO.getCountriesByRegion("Northern America")).thenReturn(mockCountriesWithNullMembers);
        countryReport.printAllCountriesByRegion("Northern America");
    }


    /**
     * Test printing top n populated countries around the world
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
    }

    /**
     * Test printing top n populated countries with null, empty list, and null members in the list.
     */
    @Test
    void testPrintTopNCountries_NullEmptyAndNullMembers() {
        // Test with null
        when(mockCountryDAO.getTopNPopulatedCountries(2)).thenReturn(null);
        countryReport.printTopNCountries(2);

        // Test with empty list
        when(mockCountryDAO.getTopNPopulatedCountries(2)).thenReturn(new ArrayList<>());
        countryReport.printTopNCountries(2);

        // Test with null member
        List<Country> mockCountriesWithNullMembers = new ArrayList<>();
        mockCountriesWithNullMembers.add(new Country("CHN", "China", "Asia", "Eastern Asia", 1400000000, 1891, "Beijing"));
        mockCountriesWithNullMembers.add(null);
        when(mockCountryDAO.getTopNPopulatedCountries(2)).thenReturn(mockCountriesWithNullMembers);
        countryReport.printTopNCountries(2);
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
    }

    /**
     * Test printing top n populated countries by continent with null, empty list, and null members in the list.
     */
    @Test
    void testPrintTopNCountriesByContinent_NullEmptyAndNullMembers() {
        // Test with null
        when(mockCountryDAO.getTopNPopulatedCountriesInContinent("North America", 1)).thenReturn(null);
        countryReport.printTopNCountriesByContinent(1, "North America");

        // Test with empty list
        when(mockCountryDAO.getTopNPopulatedCountriesInContinent("North America", 1)).thenReturn(new ArrayList<>());
        countryReport.printTopNCountriesByContinent(1, "North America");

        // Test with null member
        List<Country> mockCountriesWithNullMembers = new ArrayList<>();
        mockCountriesWithNullMembers.add(new Country("USA", "United States", "North America", "Northern America", 331000000, 3426, "Washington D.C."));
        mockCountriesWithNullMembers.add(null);
        when(mockCountryDAO.getTopNPopulatedCountriesInContinent("North America", 1)).thenReturn(mockCountriesWithNullMembers);
        countryReport.printTopNCountriesByContinent(1, "North America");
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
    }

    /**
     * Test printing top n populated countries by region with null, empty list, and null members in the list.
     */
    @Test
    void testPrintTopNCountriesByRegion_NullEmptyAndNullMembers() {
        // Test with null
        when(mockCountryDAO.getTopNPopulatedCountriesInRegion("Northern America", 1)).thenReturn(null);
        countryReport.printTopNCountriesByRegion(1, "Northern America");

        // Test with empty list
        when(mockCountryDAO.getTopNPopulatedCountriesInRegion("Northern America", 1)).thenReturn(new ArrayList<>());
        countryReport.printTopNCountriesByRegion(1, "Northern America");

        // Test with null member
        List<Country> mockCountriesWithNullMembers = new ArrayList<>();
        mockCountriesWithNullMembers.add(new Country("USA", "United States", "North America", "Northern America", 331000000, 3426, "Washington D.C."));
        mockCountriesWithNullMembers.add(null);
        when(mockCountryDAO.getTopNPopulatedCountriesInRegion("Northern America", 1)).thenReturn(mockCountriesWithNullMembers);
        countryReport.printTopNCountriesByRegion(1, "Northern America");
    }

}
