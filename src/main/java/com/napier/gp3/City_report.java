package com.napier.gp3;

import java.sql.Connection;
import java.util.List;

/**
 * The City_report class provides printing methods to generate city reports.
 */
public class City_report {
    private CityDAO cityDAO;

    // Constructor to initialize CityDAO with a connection
    public City_report(Connection con) {
        this.cityDAO = new CityDAO(con);
    }

    // Utility method to print a header for the city report
    private void printReportHeader() {
        System.out.printf("%-40s %-40s %-30s %-30s%n", "Name", "Country", "District", "Population");
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
    }

    // 7. Get all cities by population
    public void printAllCitiesByPopulation() {
        System.out.println("**********************************************");
        System.out.println("** 7) ALL CITIES BY POPULATION **");
        System.out.println("**********************************************");
        printReportHeader();
        List<City> allCities = cityDAO.getAllCitiesByPopulation();
        for (City city : allCities) {
            System.out.printf("%-40s %-40s %-30s %-30s%n",
                    city.getName(), city.getCountry(),
                    city.getDistrict(), city.getPopulation());
        }
    }

    // 8. Get cities by continent
    public void printCitiesByContinent(String continent) {
        System.out.println("**********************************************");
        System.out.println("** 8) CITIES IN " + continent.toUpperCase() + " BY POPULATION **");
        System.out.println("**********************************************");
        printReportHeader();
        List<City> cities = cityDAO.getCitiesByContinent(continent);
        for (City city : cities) {
            System.out.printf("%-40s %-40s %-30s %-30s%n",
                    city.getName(), city.getCountry(),
                    city.getDistrict(), city.getPopulation());
        }
    }

    // 9. Get cities by region
    public void printCitiesByRegion(String region) {
        System.out.println("**********************************************");
        System.out.println("** 9) CITIES IN " + region.toUpperCase() + " BY POPULATION **");
        System.out.println("**********************************************");
        printReportHeader();
        List<City> cities = cityDAO.getCitiesByRegion(region);
        for (City city : cities) {
            System.out.printf("%-40s %-40s %-30s %-30s%n",
                    city.getName(), city.getCountry(),
                    city.getDistrict(), city.getPopulation());
        }
    }

    // 10. Get cities by country
    public void printCitiesByCountry(String countryCode) {
        System.out.println("**********************************************");
        System.out.println("** 10) CITIES IN COUNTRY CODE '" + countryCode.toUpperCase() + "' BY POPULATION **");
        System.out.println("**********************************************");
        printReportHeader();
        List<City> cities = cityDAO.getCitiesByCountry(countryCode);
        for (City city : cities) {
            System.out.printf("%-40s %-40s %-30s %-30s%n",
                    city.getName(), city.getCountry(),
                    city.getDistrict(), city.getPopulation());
        }
    }

    // 11. Get cities by district
    public void printCitiesByDistrict(String district) {
        System.out.println("**********************************************");
        System.out.println("** 11) CITIES IN DISTRICT '" + district.toUpperCase() + "' BY POPULATION **");
        System.out.println("**********************************************");
        printReportHeader();
        List<City> cities = cityDAO.getCitiesByDistrict(district);
        for (City city : cities) {
            System.out.printf("%-40s %-40s %-30s %-30s%n",
                    city.getName(), city.getCountry(),
                    city.getDistrict(), city.getPopulation());
        }
    }

}
