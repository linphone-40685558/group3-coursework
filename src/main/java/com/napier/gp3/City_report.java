package com.napier.gp3;

import java.sql.Connection;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

/**
 * The class has printing methods for city reports.
 */
public class City_report {
    public CityDAO cityDAO;
    private final NumberFormat numberFormat;

    /**
     * Constructor
     *
     * @param con Connection object
     */
    public City_report(Connection con) {
        this.cityDAO = new CityDAO(con);
        this.numberFormat = NumberFormat.getInstance(Locale.US); // Set number format for US style (comma separated)
    }

    /**
     * Printing header
     */
    private void printReportHeader() {
        System.out.printf("%-40s %-40s %-30s %-30s%n", "Name", "Country", "District", "Population");
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
    }

    /**
     * Printing city data
     *
     * @param cities List of cities
     * @param title  Title
     */
    private void printCityReport(List<City> cities, String title) {
        System.out.println("\n**********************************************");
        System.out.println("** " + title.toUpperCase() + " **");
        System.out.println("**********************************************");
        printReportHeader();

        if (cities == null || cities.isEmpty()) {
            System.out.println("No data available.");
            return;
        }

        for (City city : cities) {
            if (city == null) {
                System.out.println("Encountered a null city in the list");
                continue;
            }
            System.out.printf("%-40s %-40s %-30s %-30s%n",
                    city.getName(), city.getCountry(),
                    city.getDistrict(), numberFormat.format(city.getPopulation()));
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
    }

    /**
     * Get all cities by population
     */
    public void printAllCitiesByPopulation() {
        List<City> allCities = cityDAO.getAllCitiesByPopulation();
        printCityReport(allCities, "7) All cities by population");
    }

    /**
     * Get cities by continent
     *
     * @param continent The name of the continent
     */
    public void printCitiesByContinent(String continent) {
        List<City> cities = cityDAO.getCitiesByContinent(continent);
        printCityReport(cities, "8) Cities in " + continent + " by population");
    }

    /**
     * Get cities by region
     *
     * @param region The name of the region
     */
    public void printCitiesByRegion(String region) {
        List<City> cities = cityDAO.getCitiesByRegion(region);
        printCityReport(cities, "9) Cities in " + region + " by population");
    }

    /**
     * Get cities by country
     *
     * @param countryCode The country code
     */
    public void printCitiesByCountry(String countryCode) {
        List<City> cities = cityDAO.getCitiesByCountry(countryCode);
        printCityReport(cities, "10) Cities in country code '" + countryCode.toUpperCase() + "' by population");
    }

    /**
     * Get cities by district
     *
     * @param district The name of the district
     */
    public void printCitiesByDistrict(String district) {
        List<City> cities = cityDAO.getCitiesByDistrict(district);
        printCityReport(cities, "11) Cities in district '" + district.toUpperCase() + "' by population");
    }

    /**
     * Get Top N populated cities around the world
     *
     * @param N Number of top populated cities
     */
    public void printTopNPopulatedCitiesInWorld(int N) {
        List<City> cities = cityDAO.getTopNPopulatedCitiesInWorld(N);
        printCityReport(cities, "12) Top " + N + " populated cities in the world");
    }

    /**
     * Get Top N populated cities in a continent
     *
     * @param continent The name of the continent
     * @param N         Number of top populated cities
     */
    public void printTopNPopulatedCitiesInContinent(String continent, int N) {
        List<City> cities = cityDAO.getTopNPopulatedCitiesInContinent(continent, N);
        printCityReport(cities, "13) Top " + N + " populated cities in " + continent);
    }

    /**
     * Get Top N populated cities in a region
     *
     * @param region The name of the region
     * @param N      Number of top populated cities
     */
    public void printTopNPopulatedCitiesInRegion(String region, int N) {
        List<City> cities = cityDAO.getTopNPopulatedCitiesInRegion(region, N);
        printCityReport(cities, "14) Top " + N + " populated cities in " + region);
    }

    /**
     * Get Top N populated cities in a country
     *
     * @param countryCode The country code
     * @param N           Number of top populated cities
     */
    public void printTopNPopulatedCitiesInCountry(String countryCode, int N) {
        List<City> cities = cityDAO.getTopNPopulatedCitiesInCountry(countryCode, N);
        printCityReport(cities, "15) Top " + N + " populated cities in " + countryCode);
    }

    /**
     * Get Top N populated cities in a district
     *
     * @param district The name of the district
     * @param N        Number of top populated cities
     */
    public void printTopNPopulatedCitiesInDistrict(String district, int N) {
        List<City> cities = cityDAO.getTopNPopulatedCitiesInDistrict(district, N);
        printCityReport(cities, "16) Top " + N + " populated cities in " + district);
    }
}
