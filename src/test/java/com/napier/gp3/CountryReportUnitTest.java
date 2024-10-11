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
     * Test printing all countries with null list
     */
    @Test
    void testPrintAllCountriesByPopulation_NullList() {
        // Define behavior for the mock DAO
        when(mockCountryDAO.getAllCountriesByPopulation()).thenReturn(null);

        // Call the method
        countryReport.printAllCountriesByPopulation();
    }

    /**
     * Test printing all countries with empty list
     */
    @Test
    void testPrintAllCountriesByPopulation_EmptyList() {
        // Define behavior for the mock DAO to return an empty list
        when(mockCountryDAO.getAllCountriesByPopulation()).thenReturn(new ArrayList<>());

        // Call the method
        countryReport.printAllCountriesByPopulation();
    }

    /**
     * Test printing all countries with null member in list
     */
    @Test
    void testPrintAllCountriesByPopulation_ListWithNullMember() {
        // Create arraylist
        List<Country> mockCountries = new ArrayList<>();

        // add example data and null member
        mockCountries.add(new Country("USA", "United States", "North America", "Northern America", 331000000, 3426, "Washington D.C."));
        mockCountries.add(null);

        // Define behavior for the mock DAO
        when(mockCountryDAO.getAllCountriesByPopulation()).thenReturn(mockCountries);

        // Call the method
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
     * Test printing countries in continent with null list
     */
    @Test
    void testPrintAllCountriesByContinent_NullList() {
        // Define behavior for the mock DAO
        when(mockCountryDAO.getCountriesByContinent("North America")).thenReturn(null);

        // Call the method
        countryReport.printAllCountriesByContinent("North America");
    }

    /**
     * Test print countries in continent with empty list
     */
    @Test
    void testPrintAllCountriesByContinent_EmptyList() {
        // Define behavior for the mock DAO
        when(mockCountryDAO.getCountriesByContinent("North America")).thenReturn(new ArrayList<>());

        // Call the method
        countryReport.printAllCountriesByContinent("North America");
    }

    /**
     * Test print countries in continent with null member in list
     */
    @Test
    void testPrintAllCountriesByContinent_ListWithNullMember() {
        // Create arraylist
        List<Country> mockCountries = new ArrayList<>();

        // add example data and null member
        mockCountries.add(new Country("USA", "United States", "North America", "Northern America", 331000000, 3426, "Washington D.C."));
        mockCountries.add(null);

        // Define behavior for the mock DAO
        when(mockCountryDAO.getCountriesByContinent("North America")).thenReturn(mockCountries);

        // Call the method
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
     * Test printing all countries by region with null list
     */
    @Test
    void testPrintAllCountriesByRegion_NullList() {
        // Define behavior for the mock DAO
        when(mockCountryDAO.getCountriesByRegion("Southeast Asia")).thenReturn(null);

        // Call the method
        countryReport.printAllCountriesByRegion("Southeast Asia");
    }

    /**
     * Test printing all countries by region with empty list
     */
    @Test
    void testPrintAllCountriesByRegion_EmptyList() {
        // Define behavior for the mock DAO
        when(mockCountryDAO.getCountriesByRegion("Southeast Asia")).thenReturn(new ArrayList<>());

        // Call the method
        countryReport.printAllCountriesByRegion("Southeast Asia");
    }

    /**
     * Test printing all countries by region with null member in list
     */
    @Test
    void testPrintAllCountriesByRegion_ListWithNullMember() {
        // Create arraylist
        List<Country> mockCountries = new ArrayList<>();

        // add example data and null member
        mockCountries.add(new Country("USA", "United States", "North America", "Northern America", 331000000, 3426, "Washington D.C."));
        mockCountries.add(null);

        // Define behavior for the mock DAO
        when(mockCountryDAO.getCountriesByRegion("Southeast Asia")).thenReturn(mockCountries);

        // Call the method
        countryReport.printAllCountriesByRegion("Southeast Asia");
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
     * Test printing top n populated countries around the world with null list
     */
    @Test
    void testPrintTopNCountries_NullList() {
        // Define behavior for the mock DAO
        when(mockCountryDAO.getTopNPopulatedCountries(2)).thenReturn(null);

        // Call the method
        countryReport.printTopNCountries(2);
    }

    /**
     * Test printing top n populated countries around the world with empty list
     */
    @Test
    void testPrintTopNCountries_EmptyList() {
        // Define behavior for the mock DAO
        when(mockCountryDAO.getTopNPopulatedCountries(2)).thenReturn(new ArrayList<>());

        // Call the method
        countryReport.printTopNCountries(2);
    }

    /**
     * Test printing top n populated countries around the world with null member in list
     */
    @Test
    void testPrintTopNCountries_ListWithNullMember() {
        // Create arraylist
        List<Country> mockCountries = new ArrayList<>();

        // add example data and null member
        mockCountries.add(new Country("USA", "United States", "North America", "Northern America", 331000000, 3426, "Washington D.C."));
        mockCountries.add(null);

        // Define behavior for the mock DAO
        when(mockCountryDAO.getTopNPopulatedCountries(2)).thenReturn(mockCountries);

        // Call the method
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
     * Test printing top n populated countries by continent with null list
     */
    @Test
    void testPrintTopNCountriesByContinent_NullList() {
        // Define behavior for the mock DAO
        when(mockCountryDAO.getTopNPopulatedCountriesInContinent("North America", 2)).thenReturn(null);

        // Call the method
        countryReport.printTopNCountriesByContinent(2, "North America");
    }

    /**
     * Test printing top n populated countries by continent with empty list
     */
    @Test
    void testPrintTopNCountriesByContinent_EmptyList() {

        // Define behavior for the mock DAO
        when(mockCountryDAO.getTopNPopulatedCountriesInContinent("North America", 2)).thenReturn(null);

        // Call the method
        countryReport.printTopNCountriesByContinent(2, "North America");
    }

    /**
     * Test printing top n populated countries by continent with null member in list
     */
    @Test
    void testPrintTopNCountriesByContinent_ListWithNullMember() {

        // Create array list
        List<Country> mockCountries = new ArrayList<>();

        // add example object and null
        mockCountries.add(new Country("USA", "United States", "North America", "Northern America", 331000000, 3426, "Washington D.C."));
        mockCountries.add(null);
        when(mockCountryDAO.getTopNPopulatedCountriesInContinent("North America", 2)).thenReturn(mockCountries);
        countryReport.printTopNCountriesByContinent(2, "North America");
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
     * Test printing top n populated countries by region with null list
     */
    @Test
    void testPrintTopNCountriesByRegion_NullList() {

        // Define behavior for the mock DAO
        when(mockCountryDAO.getTopNPopulatedCountriesInRegion("Southeast Asia", 2)).thenReturn(null);

        // Call the method
        countryReport.printTopNCountriesByRegion(2, "Southeast Asia");
    }

    /**
     * Test printing top n populated countries by region with empty list
     */
    @Test
    void testPrintTopNCountriesByRegion_EmptyList() {

        // Define behavior for the mock DAO
        when(mockCountryDAO.getTopNPopulatedCountriesInRegion("Southeast Asia", 2)).thenReturn(null);

        // Call the method
        countryReport.printTopNCountriesByRegion(2, "Southeast Asia");
    }

    /**
     * Test printing top n populated countries by region with null member in list
     */
    @Test
    void testPrintTopNCountriesByRegion_ListWithNullMember() {

        // Create array list
        List<Country> mockCountries = new ArrayList<>();

        // add example member and null member
        mockCountries.add(new Country("USA", "United States", "North America", "Northern America", 331000000, 3426, "Washington D.C."));
        mockCountries.add(null);

        // Define behavior for the mock DAO
        when(mockCountryDAO.getTopNPopulatedCountriesInRegion("Southeast Asia", 2)).thenReturn(mockCountries);

        // Call the method
        countryReport.printTopNCountriesByRegion(2, "Southeast Asia");
    }
}
