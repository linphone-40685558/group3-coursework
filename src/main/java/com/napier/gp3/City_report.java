package com.napier.gp3;

import java.sql.Connection;
import java.util.List;

public class City_report {
    private CityDAO cityDAO;

    // Constructor to initialize CityDAO with a connection
    public City_report(Connection con) {
        this.cityDAO = new CityDAO(con);
    }

    // 7. Get all cities by population
    public void printAllCitiesByPopulation() {
        System.out.println("\n\nAll cities by population:");
        List<City> allCities = cityDAO.getAllCitiesByPopulation();
        for (City city : allCities) {
            System.out.println(city.getName() + ": " + city.getPopulation());
        }
    }

    // 8. Get cities by continent
    public void printCitiesByContinent(String continent) {
        System.out.println("\n\nCities in " + continent + " by population:");
        List<City> cities = cityDAO.getCitiesByContinent(continent);
        for (City city : cities) {
            System.out.println(city.getName() + ": " + city.getPopulation());
        }
    }

    // 9. Get cities by region
    public void printCitiesByRegion(String region) {
        System.out.println("\n\nCities in " + region + " by population:");
        List<City> cities = cityDAO.getCitiesByRegion(region);
        for (City city : cities) {
            System.out.println(city.getName() + ": " + city.getPopulation());
        }
    }

    // 10. Get cities by country
    public void printCitiesByCountry(String countryCode) {
        System.out.println("\n\nCities in country code '" + countryCode + "' by population:");
        List<City> cities = cityDAO.getCitiesByCountry(countryCode);
        for (City city : cities) {
            System.out.println(city.getName() + ": " + city.getPopulation());
        }
    }

    // 11. Get cities by district
    public void printCitiesByDistrict(String district) {
        System.out.println("\n\nCities in district '" + district + "' by population:");
        List<City> cities = cityDAO.getCitiesByDistrict(district);
        for (City city : cities) {
            System.out.println(city.getName() + ": " + city.getPopulation());
        }
    }

    // 17. Get all capital cities by population
    public void printCapitalsByPopulation() {
        System.out.println("\n\nAll capital cities by population:");
        List<City> allCapitalCities = cityDAO.getAllCapitalCitiesByPopulation();
        for (City city : allCapitalCities) {
            System.out.println(city.getName() + ": " + city.getPopulation());
        }
    }

    // 18. Get capital cities by continent (example: "Asia")
    public void printCapitalsByContinent(String continent) {
        String continentForCapital = "Asia";
        System.out.println("\nAll capital cities in " + continent + " by population:");
        List<City> capitalCitiesInContinent = cityDAO.getCapitalCitiesByContinent(continent);
        for (
                City city : capitalCitiesInContinent) {
            System.out.println(city.getName() + ": " + city.getPopulation());
        }
    }

    // 19. Get capital cities by region (example: "Southeast Asia")
    public void printCapitalsByRegion(String region) {
        String regionForCapital = "Southeast Asia";
        System.out.println("\nAll capital cities in " + region + " by population:");
        List<City> capitalCitiesInRegion = cityDAO.getCapitalCitiesByRegion(region);
        for (
                City city : capitalCitiesInRegion) {
            System.out.println(city.getName() + ": " + city.getPopulation());
        }
    }
}
