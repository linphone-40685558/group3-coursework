package com.napier.gp3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDAO {
    private Connection con;

    public CityDAO(Connection connection) {
        this.con = connection;
    }

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
