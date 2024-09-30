package com.napier.gp3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDAO {
    private Connection con;

    public CityDAO(Connection connection) {
        this.con = connection;
    }

    /**
     * All the cities in the world organised by largest population to smallest.
     * All the cities in a continent organised by largest population to smallest.
     * All the cities in a region organised by largest population to smallest.
     * All the cities in a country organised by largest population to smallest.
     * All the cities in a district organised by largest population to smallest.
     */

    // Method to get all cities in the world organized by largest population
    public List<City> getAllCitiesByPopulation() {
        List<City> cities = new ArrayList<>();
        try {
            // Query to select all cities and order them by population in descending order
            String strSelect = "SELECT ID, Name, CountryCode, District, Population FROM city ORDER BY Population DESC";
            PreparedStatement pstmt = con.prepareStatement(strSelect); // Preparing the SQL query
            ResultSet rset = pstmt.executeQuery(); // Executing the query and getting the result set

            // Iterating through the result set
            while (rset.next()) {
                // Creating a new City object and adding it to the list
                cities.add(new City(
                        rset.getInt("ID"),
                        rset.getString("Name"),
                        rset.getString("CountryCode"),
                        rset.getString("District"),
                        rset.getInt("Population")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Failed to get cities: " + e.getMessage()); // Handling SQL exceptions
        }
        return cities; // Returning the list of cities
    }

    // Method to get all cities in a continent organized by largest population
    public List<City> getCitiesByContinent(String continent) {
        List<City> cities = new ArrayList<>();
        try {
            String strSelect = "SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population " +
                    "FROM city JOIN country ON city.CountryCode = country.Code " +
                    "WHERE country.Continent = ? ORDER BY city.Population DESC";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            pstmt.setString(1, continent);
            ResultSet rset = pstmt.executeQuery();

            while (rset.next()) {
                cities.add(new City(
                        rset.getInt("ID"),
                        rset.getString("Name"),
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

    // Method to get all cities in a region organized by largest population
    public List<City> getCitiesByRegion(String region) {
        List<City> cities = new ArrayList<>();
        try {
            String strSelect = "SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population " +
                    "FROM city JOIN country ON city.CountryCode = country.Code " +
                    "WHERE country.Region = ? ORDER BY city.Population DESC";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            pstmt.setString(1, region);
            ResultSet rset = pstmt.executeQuery();

            while (rset.next()) {
                cities.add(new City(
                        rset.getInt("ID"),
                        rset.getString("Name"),
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

    // Method to get all cities in a country organized by largest population
    public List<City> getCitiesByCountry(String countryCode) {
        List<City> cities = new ArrayList<>();
        try {
            String strSelect = "SELECT ID, Name, CountryCode, District, Population " +
                    "FROM city WHERE CountryCode = ? ORDER BY Population DESC";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            pstmt.setString(1, countryCode);
            ResultSet rset = pstmt.executeQuery();

            while (rset.next()) {
                cities.add(new City(
                        rset.getInt("ID"),
                        rset.getString("Name"),
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

    // Method to get all cities in a district organized by largest population
    public List<City> getCitiesByDistrict(String district) {
        List<City> cities = new ArrayList<>();
        try {
            String strSelect = "SELECT ID, Name, CountryCode, District, Population " +
                    "FROM city WHERE District = ? ORDER BY Population DESC";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            pstmt.setString(1, district);
            ResultSet rset = pstmt.executeQuery();

            while (rset.next()) {
                cities.add(new City(
                        rset.getInt("ID"),
                        rset.getString("Name"),
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


    /**
     * All the capital cities in the world organised by largest population to smallest.
     * All the capital cities in a continent organised by largest population to smallest.
     * All the capital cities in a region organised by largest to smallest.
     */

    // Method to get all capital cities in the world organized by largest population to smallest
    public List<City> getAllCapitalCitiesByPopulation() {
        List<City> cities = new ArrayList<>();
        try {
            String strSelect = "SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population " +
                    "FROM city JOIN country ON city.ID = country.Capital " +
                    "ORDER BY city.Population DESC";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            ResultSet rset = pstmt.executeQuery();

            while (rset.next()) {
                cities.add(new City(
                        rset.getInt("ID"),
                        rset.getString("Name"),
                        rset.getString("CountryCode"),
                        rset.getString("District"),
                        rset.getInt("Population")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Failed to get capital cities: " + e.getMessage());
        }
        return cities;
    }

    // Method to get capital cities in a continent organized by largest population to smallest
    public List<City> getCapitalCitiesByContinent(String continent) {
        List<City> cities = new ArrayList<>();
        try {
            String strSelect = "SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population " +
                    "FROM city JOIN country ON city.ID = country.Capital " +
                    "WHERE country.Continent = ? " +
                    "ORDER BY city.Population DESC";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            pstmt.setString(1, continent);
            ResultSet rset = pstmt.executeQuery();

            while (rset.next()) {
                cities.add(new City(
                        rset.getInt("ID"),
                        rset.getString("Name"),
                        rset.getString("CountryCode"),
                        rset.getString("District"),
                        rset.getInt("Population")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Failed to get capital cities in continent: " + e.getMessage());
        }
        return cities;
    }

    // Method to get capital cities in a region organized by largest population to smallest
    public List<City> getCapitalCitiesByRegion(String region) {
        List<City> cities = new ArrayList<>();
        try {
            String strSelect = "SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population " +
                    "FROM city JOIN country ON city.ID = country.Capital " +
                    "WHERE country.Region = ? " +
                    "ORDER BY city.Population DESC";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            pstmt.setString(1, region);
            ResultSet rset = pstmt.executeQuery();

            while (rset.next()) {
                cities.add(new City(
                        rset.getInt("ID"),
                        rset.getString("Name"),
                        rset.getString("CountryCode"),
                        rset.getString("District"),
                        rset.getInt("Population")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Failed to get capital cities in region: " + e.getMessage());
        }
        return cities;
    }
}
