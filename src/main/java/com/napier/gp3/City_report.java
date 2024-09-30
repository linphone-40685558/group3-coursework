package com.napier.gp3;

import java.sql.Connection;
import java.util.List;

public class City_report {
    private CityDAO cityDAO;

    // Constructor to initialize CityDAO with a connection
    public City_report(Connection con) {
        this.cityDAO = new CityDAO(con);
    }

    // Method to print all cities by population
    public void printAllCitiesByPopulation() {
        System.out.println("\n\nAll cities by population:");
        List<City> allCities = cityDAO.getAllCitiesByPopulation();
        for (City city : allCities) {
            System.out.println(city.getName() + ": " + city.getPopulation());
        }
    }

    // Method to print cities by continent
    public void printCitiesByContinent(String continent) {
        System.out.println("\n\nCities in " + continent + " by population:");
        List<City> cities = cityDAO.getCitiesByContinent(continent);
        for (City city : cities) {
            System.out.println(city.getName() + ": " + city.getPopulation());
        }
    }

    // Method to print cities by region
    public void printCitiesByRegion(String region) {
        System.out.println("\n\nCities in " + region + " by population:");
        List<City> cities = cityDAO.getCitiesByRegion(region);
        for (City city : cities) {
            System.out.println(city.getName() + ": " + city.getPopulation());
        }
    }

    // Method to print cities by country
    public void printCitiesByCountry(String countryCode) {
        System.out.println("\n\nCities in country code '" + countryCode + "' by population:");
        List<City> cities = cityDAO.getCitiesByCountry(countryCode);
        for (City city : cities) {
            System.out.println(city.getName() + ": " + city.getPopulation());
        }
    }

    // Method to print cities by district
    public void printCitiesByDistrict(String district) {
        System.out.println("\n\nCities in district '" + district + "' by population:");
        List<City> cities = cityDAO.getCitiesByDistrict(district);
        for (City city : cities) {
            System.out.println(city.getName() + ": " + city.getPopulation());
        }
    }
}
