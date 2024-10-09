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
        cityReport = new City_report(mockConnection);
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

        // Define behavior for the mock DAO
        when(mockCityDAO.getAllCitiesByPopulation()).thenReturn(mockCities);

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
        verify(mockCityDAO).getCitiesByRegion("Eastern Asia");
    }

    /**
     * Test printing cities by country
     */
    @Test
    void testPrintCitiesByCountry() {
        // Prepare mock data
        List<City> mockCities = new ArrayList<>();
        mockCities.add(new City(3, "Seoul", "Korea", "KOR", "Dobong-gu", 51704562));

        // Define behavior for the mock DAO
        when(mockCityDAO.getCitiesByCountry("Korea")).thenReturn(mockCities);

        // Call the method
        cityReport.printCitiesByCountry("Korea");

        // Verify that the DAO method was called
        verify(mockCityDAO).getCitiesByCountry("Korea");
    }

    /**
     *
     * Test printing cities by district
     */

    @Test
    void testPrintCitiesByDistrict() {
        // Prepare mock data
        List<City> mockCities = new ArrayList<>();
        mockCities.add(new City(4, "Rangoo", "Myanmar", "MMR", "Rangoo", 54500091));

        // Define behavior for the mock DAO
        when(mockCityDAO.getCitiesByCountry("Rangoo")).thenReturn(mockCities);

        // Call the method
        cityReport.printCitiesByCountry("Rangoo");

        // Verify that the DAO method was called
        verify(mockCityDAO).getCitiesByCountry("Rangoo");
    }

    /**
     * Test printing top n populated cities in the world
     */
    @Test
    void testPrintTopNPopulatedCitiesInWorld() {
        // Prepare mock data
        List<City> mockCities = new ArrayList<>();
        mockCities.add(new City(2, "Beijing", "China", "CHN", "Beijing", 21540000));
        mockCities.add(new City(1, "Washington D.C.", "United States", "USA", "District of Columbia", 705749));

        // Define behavior for the mock DAO
        when(mockCityDAO.getTopNPopulatedCitiesInWorld(2)).thenReturn(mockCities);

        // Call the method
        cityReport.printTopNPopulatedCitiesInWorld(2);

        // Verify that the DAO method was called
        verify(mockCityDAO).getTopNPopulatedCitiesInWorld(2);
    }

    /**
     * Test printing top n populated cities by continent
     */
    @Test
    void testPrintTopNPopulatedCitiesInContinent() {
        // Prepare mock data
        List<City> mockCities = new ArrayList<>();
        mockCities.add(new City(1, "Washington D.C.", "United States", "USA", "District of Columbia", 705749));

        // Define behavior for the mock DAO
        when(mockCityDAO.getTopNPopulatedCitiesInContinent("North America", 1)).thenReturn(mockCities);

        // Call the method
        cityReport.printTopNPopulatedCitiesInContinent("North America", 1);

        // Verify that the DAO method was called
        verify(mockCityDAO).getTopNPopulatedCitiesInContinent("North America", 1);
    }

    /**
     * Test printing top n populated cities by region
     */
    @Test
    void testPrintTopNPopulatedCitiesInRegion() {
        // Prepare mock data
        List<City> mockCities = new ArrayList<>();
        mockCities.add(new City(2, "Beijing", "China", "CHN", "Beijing", 21540000));

        // Define behavior for the mock DAO
        when(mockCityDAO.getTopNPopulatedCitiesInRegion("Eastern Asia", 1)).thenReturn(mockCities);

        // Call the method
        cityReport.printTopNPopulatedCitiesInRegion("Eastern Asia", 1);

        // Verify that the DAO method was called
        verify(mockCityDAO).getTopNPopulatedCitiesInRegion("Eastern Asia", 1);
    }


    @Test
    void testPrintTopNPopulatedCitiesInCountry() {
        // Prepare mock data
        List<City> mockCities = new ArrayList<>();
        mockCities.add(new City(3, "Seoul", "Korea", "KOR", "Dobong-gu", 51704562));

        // Define behavior for the mock DAO
        when(mockCityDAO.getTopNPopulatedCitiesInCountry("Korea", 1)).thenReturn(mockCities);

        // Call the method
        cityReport.printTopNPopulatedCitiesInCountry("Korea", 1);

        // Verify that the DAO method was called
        verify(mockCityDAO).getTopNPopulatedCitiesInCountry("Korea", 1);
    }
}
