package com.napier.gp3;

import java.sql.Connection;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

/**
 * The City_report class provides printing methods to generate city reports.
 */
public class City_report {
    public CityDAO cityDAO;
    private final NumberFormat numberFormat;

    /**
     * Constructor to initialize CityDAO with a connection
     *
     * @param con
     */
    public City_report(Connection con) {
        this.cityDAO = new CityDAO(con);
        this.numberFormat = NumberFormat.getInstance(Locale.US); // (comma separated)
    }

    /**
     * Utility method to print a header for the city report
     */
    private void printReportHeader() {
        System.out.printf("%-40s %-40s %-30s %-30s%n", "Name", "Country", "District", "Population");
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
    }

    /**
     * 7) Get all cities by population
     */
    public void printAllCitiesByPopulation() {
        System.out.println("**********************************************");
        System.out.println("** 7) ALL CITIES BY POPULATION **");
        System.out.println("**********************************************");
        printReportHeader();
        List<City> allCities = cityDAO.getAllCitiesByPopulation();
        for (City city : allCities) {
            System.out.printf("%-40s %-40s %-30s %-30s%n",
                    city.getName(), city.getCountry(),
                    city.getDistrict(), numberFormat.format(city.getPopulation())); // Format population with commas
        }
    }

    /**
     * 8) Get cities by continent
     *
     * @param continent
     */
    public void printCitiesByContinent(String continent) {
        System.out.println("**********************************************");
        System.out.println("** 8) CITIES IN " + continent.toUpperCase() + " BY POPULATION **");
        System.out.println("**********************************************");
        printReportHeader();
        List<City> cities = cityDAO.getCitiesByContinent(continent);
        for (City city : cities) {
            System.out.printf("%-40s %-40s %-30s %-30s%n",
                    city.getName(), city.getCountry(),
                    city.getDistrict(), numberFormat.format(city.getPopulation())); // Format population with commas
        }
    }

    /**
     * 9) Get cities by region
     *
     * @param region
     */
    public void printCitiesByRegion(String region) {
        System.out.println("**********************************************");
        System.out.println("** 9) CITIES IN " + region.toUpperCase() + " BY POPULATION **");
        System.out.println("**********************************************");
        printReportHeader();
        List<City> cities = cityDAO.getCitiesByRegion(region);
        for (City city : cities) {
            System.out.printf("%-40s %-40s %-30s %-30s%n",
                    city.getName(), city.getCountry(),
                    city.getDistrict(), numberFormat.format(city.getPopulation())); // Format population with commas
        }
    }

    /**
     * 10) Get cities by country
     *
     * @param countryCode
     */
    public void printCitiesByCountry(String countryCode) {
        System.out.println("**********************************************");
        System.out.println("** 10) CITIES IN COUNTRY CODE '" + countryCode.toUpperCase() + "' BY POPULATION **");
        System.out.println("**********************************************");
        printReportHeader();
        List<City> cities = cityDAO.getCitiesByCountry(countryCode);
        for (City city : cities) {
            System.out.printf("%-40s %-40s %-30s %-30s%n",
                    city.getName(), city.getCountry(),
                    city.getDistrict(), numberFormat.format(city.getPopulation())); // Format population with commas
        }
    }

    /**
     * 11) Get cities by district
     *
     * @param district
     */
    public void printCitiesByDistrict(String district) {
        System.out.println("**********************************************");
        System.out.println("** 11) CITIES IN DISTRICT '" + district.toUpperCase() + "' BY POPULATION **");
        System.out.println("**********************************************");
        printReportHeader();
        List<City> cities = cityDAO.getCitiesByDistrict(district);
        for (City city : cities) {
            System.out.printf("%-40s %-40s %-30s %-30s%n",
                    city.getName(), city.getCountry(),
                    city.getDistrict(), numberFormat.format(city.getPopulation())); // Format population with commas
        }
    }

    /**
     * 12) Get Top N cities around the world
     *
     * @param N
     */
    public void printTopNPopulatedCitiesInWorld(int N) {
        System.out.println("**********************************************");
        System.out.println("** 12) TOP "+ N + " POPULATED CITIES IN THE WORLD **");
        System.out.println("**********************************************");
        printReportHeader();
        List<City> cities = cityDAO.getTopNPopulatedCitiesInWorld(N);
        for (City city : cities) {
            System.out.printf("%-40s %-40s %-30s %-30s%n",
                    city.getName(), city.getCountry(),
                    city.getDistrict(), numberFormat.format(city.getPopulation())); // Format population with commas
        }
    }


    /**
     * 13) Get Top N cities in a Continent
     *
     * @param N
     */
    public void printTopNPopulatedCitiesInContinent(String continent, int N) {
        System.out.println("**********************************************");
        System.out.println("** 13) TOP "+ N + " POPULATED CITIES IN " + continent + " **");
        System.out.println("**********************************************");
        printReportHeader();
        List<City> cities = cityDAO.getTopNPopulatedCitiesInContinent(continent, N);
        for (City city : cities) {
            System.out.printf("%-40s %-40s %-30s %-30s%n",
                    city.getName(), city.getCountry(),
                    city.getDistrict(), numberFormat.format(city.getPopulation())); // Format population with commas
        }
    }

}
