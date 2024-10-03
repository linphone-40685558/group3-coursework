package com.napier.gp3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * CityDAO has database manipulations to retrieve city-related information.
 * It has methods to fetch cities by population, continent, region, and top N populated countries.
 * tasks
 * All the cities in the world organised by largest population to smallest.
 * All the cities in a continent organised by largest population to smallest.
 * All the cities in a region organised by largest population to smallest.
 * All the cities in a country organised by largest population to smallest.
 * All the cities in a district organised by largest population to smallest.
 */
public class CityDAO {
    private Connection con;

    /**
     * City Data Access Object Constructor
     *
     * @param connection
     */
    public CityDAO(Connection connection) {
        this.con = connection;
    }

    /**
     * 7) Method to get all cities in the world organized by largest population
     *
     * @return
     */
    public List<City> getAllCitiesByPopulation() {
        List<City> cities = new ArrayList<>();
        try {
            // Query to select all cities and order them by population in descending order
            String strSelect = "SELECT city.*, country.Name AS CountryName" +
                    " FROM city" +
                    " JOIN country" +
                    " ON city.CountryCode = country.Code" +
                    " ORDER BY city.Population DESC";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            ResultSet rset = pstmt.executeQuery();

            while (rset.next()) {
                cities.add(new City(
                        rset.getInt("ID"),
                        rset.getString("Name"),
                        rset.getString("CountryName"),
                        rset.getString("CountryCode"),
                        rset.getString("District"),
                        rset.getInt("Population")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Failed to get cities: " + e.getMessage());
        }
        return cities;
    }

    /**
     * 8) Method to get all cities in a continent organized by largest population
     *
     * @param continent
     * @return
     */
    public List<City> getCitiesByContinent(String continent) {
        List<City> cities = new ArrayList<>();
        try {
            String strSelect = "SELECT city.*, country.Name AS CountryName " +
                    "FROM city JOIN country ON city.CountryCode = country.Code " +
                    "WHERE country.Continent = ? ORDER BY city.Population DESC";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            pstmt.setString(1, continent);
            ResultSet rset = pstmt.executeQuery();

            while (rset.next()) {
                cities.add(new City(
                        rset.getInt("ID"),
                        rset.getString("Name"),
                        rset.getString("CountryName"),
                        rset.getString("CountryCode"),
                        rset.getString("District"),
                        rset.getInt("Population")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Failed to get cities by continent: " + e.getMessage());
        }
        return cities;
    }

    /**
     * 9) Method to get all cities in a region organized by largest population
     *
     * @param region
     * @return
     */
    public List<City> getCitiesByRegion(String region) {
        List<City> cities = new ArrayList<>();
        try {
            String strSelect = "SELECT city.*, country.Name AS CountryName " +
                    "FROM city JOIN country ON city.CountryCode = country.Code " +
                    "WHERE country.Region = ? ORDER BY city.Population DESC";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            pstmt.setString(1, region);
            ResultSet rset = pstmt.executeQuery();

            while (rset.next()) {
                cities.add(new City(
                        rset.getInt("ID"),
                        rset.getString("Name"),
                        rset.getString("CountryName"),
                        rset.getString("CountryCode"),
                        rset.getString("District"),
                        rset.getInt("Population")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Failed to get cities by region: " + e.getMessage());
        }
        return cities;
    }

    /**
     * 10) Method to get all cities in a country organized by largest population
     *
     * @param countryCode
     * @return
     */
    public List<City> getCitiesByCountry(String countryCode) {
        List<City> cities = new ArrayList<>();
        try {
            String strSelect = "SELECT city.*, country.Name AS CountryName " +
                    "FROM city JOIN country ON city.CountryCode = country.Code " +
                    "WHERE city.CountryCode = ? " + // Filter by country code
                    "ORDER BY city.Population DESC";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            pstmt.setString(1, countryCode);
            ResultSet rset = pstmt.executeQuery();

            while (rset.next()) {
                cities.add(new City(
                        rset.getInt("ID"),
                        rset.getString("Name"),
                        rset.getString("CountryName"),
                        rset.getString("CountryCode"),
                        rset.getString("District"),
                        rset.getInt("Population")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Failed to get cities by country: " + e.getMessage());
        }
        return cities;
    }

    /**
     * 11) Method to get all cities in a district organized by largest population
     *
     * @param district
     * @return
     */
    public List<City> getCitiesByDistrict(String district) {
        List<City> cities = new ArrayList<>();
        try {
            String strSelect = "SELECT city.*, country.Name AS CountryName " +
                    "FROM city JOIN country ON city.CountryCode = country.Code " +
                    "WHERE District = ? ORDER BY Population DESC";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            pstmt.setString(1, district);
            ResultSet rset = pstmt.executeQuery();

            while (rset.next()) {
                cities.add(new City(
                        rset.getInt("ID"),
                        rset.getString("Name"),
                        rset.getString("CountryName"),
                        rset.getString("CountryCode"),
                        rset.getString("District"),
                        rset.getInt("Population")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Failed to get cities by district: " + e.getMessage());
        }
        return cities;
    }


}
