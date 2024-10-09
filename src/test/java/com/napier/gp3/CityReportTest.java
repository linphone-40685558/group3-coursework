package com.napier.gp3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class CityReportTest {

    private City_report cityReport;
    private CityDAO mockCityDAO;
    private Connection mockConnection;

    /**
     * Set up for testing
     */
    @BeforeEach
    void setUp() {
        // Mocking the Connection and CityDAO
        mockConnection = mock(Connection.class);
        mockCityDAO = mock(CityDAO.class);

        // Initializing City_report with the mocked DAO
        ciyReport = new City_report(mockConnection);
        cityReport.cityDAO = mockCityDAO; // Inject the mock DAO into City_report
    }

    /**
     * Test printing all cities by population
     */
    @Test
    void testPrintCitiesByPopulation() {
        // Prepare mock data
        List<City> mockCities = new ArrayList<>();
        mockCities.add(new City(1, "Washington D.C.", "United States", "USA", "District of Columbia", 705749));
        mockCities.add(new City(2, "Beijing", "China", "CHN", "Beijing", 21540000));
        mockCities.add(new City(3, "Seoul", "Korea", "KOR", "Seoul", 51704562));
        mockCities.add(new City(4, "Rangoo", "Myanmar", "MMR", "Naypyitaw", 54500091))

        // Define behavior for the mock DAO
        when(mockCitiesDAO.getAllCitiesByPopulation()).thenReturn(mockCities);

        // Call print method from city report
        cityReport.printAllCitiesByPopulation();

        // Verify that the DAO method was called
        verify(mockCityDAO).getAllCitiesByPopulation();
    }

    /**
     * Test printing cities by continent
     */
    @Test
    void testPrintCitiesByContinent() {
        // Prepare mock data
        List<City> mockCities = new ArrayList<>();
        mockCities.add(new City(1, "Washington D.C.", "United States", "USA", "District of Columbia", 705749));

        // Define behavior for the mock DAO
        when(mockCityDAO.getCitiesByContinent("North America")).thenReturn(mockCities);

        // Call the method
        cityReport.printCitiesByContinent("North America");

        // Verify that the DAO method was called
        verify(mockCityDAO).getCitiesByContinent("North America");
    }

    /**
     * Test printing cities by region
     */
    @Test
    void testPrintCitiesByRegion() {
        // Prepare mock data
        List<City> mockCities = new ArrayList<>();
        mockCities.add(new City(2, "Beijing", "China", "CHN", "Beijing", 21540000));

        // Define behavior for the mock DAO
        when(mockCityDAO.getCitiesByRegion("Eastern Asia")).thenReturn(mockCities);

        // Call the method
        cityReport.printCitiesByRegion("Eastern Asia");

        // Verify that the DAO method was called
        verify(mockCityDAO).getgetCitiesByRegion("Eastern Asia");
    }

    /**
     * Test printing cities by country
     */
    @Test
    void testPrintCitiesByCountry() {
        // Prepare mock data
        List<City> mockCities = new ArrayList<>();
        mockCities.add(new City(3, "Seoul", "Korea", "KOR", "Seoul", 51704562));

        // Define behavior for the mock DAO
        when(mockCityDAO.getCitiesByRegion("Eastern Asia")).thenReturn(mockCities);

        // Call the method
        cityReport.printCitiesByRegion("Eastern Asia");

        // Verify that the DAO method was called
        verify(mockCityDAO).getgetCitiesByRegion("Eastern Asia");
    }


    /**
     * Test printing top n populated cities in the world
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
