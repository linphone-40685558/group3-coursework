package com.napier.gp3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Test class to test printing city reports
 */
class CityReportUnitTest {

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
        cityReport.cityDAO = mockCityDAO;
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
    }

    /**
     * Test printing all cities by population with null, empty list, and null members in the list.
     */
    @Test
    void testPrintCitiesByPopulation_NullEmptyAndNullMembers() {
        // Test with null
        when(mockCityDAO.getAllCitiesByPopulation()).thenReturn(null);
        cityReport.printAllCitiesByPopulation();

        // Test with empty list
        when(mockCityDAO.getAllCitiesByPopulation()).thenReturn(new ArrayList<>());
        cityReport.printAllCitiesByPopulation();

        // Test with null member
        List<City> mockCitiesWithNullMembers = new ArrayList<>();
        mockCitiesWithNullMembers.add(new City(1, "Washington D.C.", "United States", "USA", "District of Columbia", 705749));
        mockCitiesWithNullMembers.add(null);
        when(mockCityDAO.getAllCitiesByPopulation()).thenReturn(mockCitiesWithNullMembers);
        cityReport.printAllCitiesByPopulation();
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
    }

    /**
     * Test printing cities by continent with null, empty list, and null members in the list.
     */
    @Test
    void testPrintCitiesByContinent_NullEmptyAndNullMembers() {
        // Test with null
        when(mockCityDAO.getCitiesByContinent("North America")).thenReturn(null);
        cityReport.printCitiesByContinent("North America");

        // Test with empty list
        when(mockCityDAO.getCitiesByContinent("North America")).thenReturn(new ArrayList<>());
        cityReport.printCitiesByContinent("North America");

        // Test with null member
        List<City> mockCitiesWithNullMembers = new ArrayList<>();
        mockCitiesWithNullMembers.add(new City(1, "Washington D.C.", "United States", "USA", "District of Columbia", 705749));
        mockCitiesWithNullMembers.add(null);
        when(mockCityDAO.getCitiesByContinent("North America")).thenReturn(mockCitiesWithNullMembers);
        cityReport.printCitiesByContinent("North America");
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
    }

    /**
     * Test printing cities by region with null, empty list, and null members in the list.
     */
    @Test
    void testPrintCitiesByRegion_NullEmptyAndNullMembers() {
        // Test with null
        when(mockCityDAO.getCitiesByRegion("Eastern Asia")).thenReturn(null);
        cityReport.printCitiesByRegion("Eastern Asia");

        // Test with empty list
        when(mockCityDAO.getCitiesByRegion("Eastern Asia")).thenReturn(new ArrayList<>());
        cityReport.printCitiesByRegion("Eastern Asia");

        // Test with null member
        List<City> mockCitiesWithNullMembers = new ArrayList<>();
        mockCitiesWithNullMembers.add(new City(2, "Beijing", "China", "CHN", "Beijing", 21540000));
        mockCitiesWithNullMembers.add(null);
        when(mockCityDAO.getCitiesByRegion("Eastern Asia")).thenReturn(mockCitiesWithNullMembers);
        cityReport.printCitiesByRegion("Eastern Asia");
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
    }

    /**
     * Test printing cities by country with null, empty list, and null members in the list.
     */
    @Test
    void testPrintCitiesByCountry_NullEmptyAndNullMembers() {
        // Test with null
        when(mockCityDAO.getCitiesByCountry("Korea")).thenReturn(null);
        cityReport.printCitiesByCountry("Korea");

        // Test with empty list
        when(mockCityDAO.getCitiesByCountry("Korea")).thenReturn(new ArrayList<>());
        cityReport.printCitiesByCountry("Korea");

        // Test with null member
        List<City> mockCitiesWithNullMembers = new ArrayList<>();
        mockCitiesWithNullMembers.add(new City(3, "Seoul", "Korea", "KOR", "Dobong-gu", 51704562));
        mockCitiesWithNullMembers.add(null);
        when(mockCityDAO.getCitiesByCountry("Korea")).thenReturn(mockCitiesWithNullMembers);
        cityReport.printCitiesByCountry("Korea");
    }


    /**
     * Test printing cities by district
     */
    @Test
    void testPrintCitiesByDistrict() {
        // Prepare mock data
        List<City> mockCities = new ArrayList<>();
        mockCities.add(new City(4, "Rangoon", "Myanmar", "MMR", "Rangoon", 54500091));

        // Define behavior for the mock DAO
        when(mockCityDAO.getCitiesByDistrict("Rangoon")).thenReturn(mockCities);

        // Call the method
        cityReport.printCitiesByDistrict("Rangoon");
    }

    /**
     * Test printing cities by district with null, empty list, and null members in the list.
     */
    @Test
    void testPrintCitiesByDistrict_NullEmptyAndNullMembers() {
        // Test with null
        when(mockCityDAO.getCitiesByDistrict("Rangoon")).thenReturn(null);
        cityReport.printCitiesByDistrict("Rangoon");

        // Test with empty list
        when(mockCityDAO.getCitiesByDistrict("Rangoon")).thenReturn(new ArrayList<>());
        cityReport.printCitiesByDistrict("Rangoon");

        // Test with null member
        List<City> mockCitiesWithNullMembers = new ArrayList<>();
        mockCitiesWithNullMembers.add(new City(4, "Rangoon", "Myanmar", "MMR", "Rangoon", 54500091));
        mockCitiesWithNullMembers.add(null);
        when(mockCityDAO.getCitiesByDistrict("Rangoon")).thenReturn(mockCitiesWithNullMembers);
        cityReport.printCitiesByDistrict("Rangoon");
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
    }

    /**
     * Test printing top n populated cities in the world with null, empty list, and null members in the list.
     */
    @Test
    void testPrintTopNPopulatedCitiesInWorld_NullEmptyAndNullMembers() {
        // Test with null
        when(mockCityDAO.getTopNPopulatedCitiesInWorld(2)).thenReturn(null);
        cityReport.printTopNPopulatedCitiesInWorld(2);

        // Test with empty list
        when(mockCityDAO.getTopNPopulatedCitiesInWorld(2)).thenReturn(new ArrayList<>());
        cityReport.printTopNPopulatedCitiesInWorld(2);

        // Test with null member
        List<City> mockCitiesWithNullMembers = new ArrayList<>();
        mockCitiesWithNullMembers.add(new City(2, "Beijing", "China", "CHN", "Beijing", 21540000));
        mockCitiesWithNullMembers.add(null);
        when(mockCityDAO.getTopNPopulatedCitiesInWorld(2)).thenReturn(mockCitiesWithNullMembers);
        cityReport.printTopNPopulatedCitiesInWorld(2);
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
    }

    /**
     * Test printing top n populated cities by continent with null, empty list, and null members in the list.
     */
    @Test
    void testPrintTopNPopulatedCitiesInContinent_NullEmptyAndNullMembers() {
        // Test with null
        when(mockCityDAO.getTopNPopulatedCitiesInContinent("North America", 1)).thenReturn(null);
        cityReport.printTopNPopulatedCitiesInContinent("North America", 1);

        // Test with empty list
        when(mockCityDAO.getTopNPopulatedCitiesInContinent("North America", 1)).thenReturn(new ArrayList<>());
        cityReport.printTopNPopulatedCitiesInContinent("North America", 1);

        // Test with null member
        List<City> mockCitiesWithNullMembers = new ArrayList<>();
        mockCitiesWithNullMembers.add(new City(1, "Washington D.C.", "United States", "USA", "District of Columbia", 705749));
        mockCitiesWithNullMembers.add(null);
        when(mockCityDAO.getTopNPopulatedCitiesInContinent("North America", 1)).thenReturn(mockCitiesWithNullMembers);
        cityReport.printTopNPopulatedCitiesInContinent("North America", 1);
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
    }

    /**
     * Test printing top n populated cities by region with null, empty list, and null members in the list.
     */
    @Test
    void testPrintTopNPopulatedCitiesInRegion_NullEmptyAndNullMembers() {
        // Test with null
        when(mockCityDAO.getTopNPopulatedCitiesInRegion("Eastern Asia", 1)).thenReturn(null);
        cityReport.printTopNPopulatedCitiesInRegion("Eastern Asia", 1);

        // Test with empty list
        when(mockCityDAO.getTopNPopulatedCitiesInRegion("Eastern Asia", 1)).thenReturn(new ArrayList<>());
        cityReport.printTopNPopulatedCitiesInRegion("Eastern Asia", 1);

        // Test with null member
        List<City> mockCitiesWithNullMembers = new ArrayList<>();
        mockCitiesWithNullMembers.add(new City(2, "Beijing", "China", "CHN", "Beijing", 21540000));
        mockCitiesWithNullMembers.add(null);
        when(mockCityDAO.getTopNPopulatedCitiesInRegion("Eastern Asia", 1)).thenReturn(mockCitiesWithNullMembers);
        cityReport.printTopNPopulatedCitiesInRegion("Eastern Asia", 1);
    }


    /**
     * Test printing top n populated cities by Country
     */
    @Test
    void testPrintTopNPopulatedCitiesInCountry() {
        // Prepare mock data
        List<City> mockCities = new ArrayList<>();
        mockCities.add(new City(3, "Seoul", "Korea", "KOR", "Dobong-gu", 51704562));

        // Define behavior for the mock DAO
        when(mockCityDAO.getTopNPopulatedCitiesInCountry("Korea", 1)).thenReturn(mockCities);

        // Call the method
        cityReport.printTopNPopulatedCitiesInCountry("Korea", 1);
    }

    /**
     * Test printing top n populated cities by country with null, empty list, and null members in the list.
     */
    @Test
    void testPrintTopNPopulatedCitiesInCountry_NullEmptyAndNullMembers() {
        // Test with null
        when(mockCityDAO.getTopNPopulatedCitiesInCountry("Korea", 1)).thenReturn(null);
        cityReport.printTopNPopulatedCitiesInCountry("Korea", 1);

        // Test with empty list
        when(mockCityDAO.getTopNPopulatedCitiesInCountry("Korea", 1)).thenReturn(new ArrayList<>());
        cityReport.printTopNPopulatedCitiesInCountry("Korea", 1);

        // Test with null member
        List<City> mockCitiesWithNullMembers = new ArrayList<>();
        mockCitiesWithNullMembers.add(new City(3, "Seoul", "Korea", "KOR", "Dobong-gu", 51704562));
        mockCitiesWithNullMembers.add(null);
        when(mockCityDAO.getTopNPopulatedCitiesInCountry("Korea", 1)).thenReturn(mockCitiesWithNullMembers);
        cityReport.printTopNPopulatedCitiesInCountry("Korea", 1);
    }


    /**
     * Test printing top n populated cities by district
     */
    @Test
    void testPrintTopNPopulatedCitiesInDistrict() {
        // Prepare mock data
        List<City> mockCities = new ArrayList<>();
        mockCities.add(new City(4, "Rangoon", "Myanmar", "MMR", "Rangoon", 54500091));

        // Define behavior for the mock DAO
        when(mockCityDAO.getTopNPopulatedCitiesInDistrict("Rangoon", 1)).thenReturn(mockCities);

        // Call the method
        cityReport.printTopNPopulatedCitiesInDistrict("Rangoon", 1);

        // Verify that the DAO method was called
        verify(mockCityDAO).getTopNPopulatedCitiesInDistrict("Rangoon", 1);
    }

    /**
     * Test printing top n populated cities by district with null, empty list, and null members in the list.
     */
    @Test
    void testPrintTopNPopulatedCitiesInDistrict_NullEmptyAndNullMembers() {
        // Test with null
        when(mockCityDAO.getTopNPopulatedCitiesInDistrict("Rangoon", 1)).thenReturn(null);
        cityReport.printTopNPopulatedCitiesInDistrict("Rangoon", 1);

        // Test with empty list
        when(mockCityDAO.getTopNPopulatedCitiesInDistrict("Rangoon", 1)).thenReturn(new ArrayList<>());
        cityReport.printTopNPopulatedCitiesInDistrict("Rangoon", 1);

        // Test with null member
        List<City> mockCitiesWithNullMembers = new ArrayList<>();
        mockCitiesWithNullMembers.add(new City(4, "Rangoon", "Myanmar", "MMR", "Rangoon", 54500091));
        mockCitiesWithNullMembers.add(null);
        when(mockCityDAO.getTopNPopulatedCitiesInDistrict("Rangoon", 1)).thenReturn(mockCitiesWithNullMembers);
        cityReport.printTopNPopulatedCitiesInDistrict("Rangoon", 1);
    }

}




