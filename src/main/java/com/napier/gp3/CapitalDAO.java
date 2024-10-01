package com.napier.gp3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CapitalDAO {
    private Connection con;

    public CapitalDAO(Connection connection) {
        this.con = connection;
    }

    // 17 Method to get all capital cities in the world organized by largest population to smallest
    public List<City> getAllCapitalCitiesByPopulation() {
        List<City> cities = new ArrayList<>();
        try {
            String strSelect = "SELECT city.*, country.Name AS CountryName " +
                    "FROM city " +
                    "JOIN country ON city.ID = country.Capital " +
                    "ORDER BY city.Population DESC";
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
            System.out.println("Failed to get capital cities: " + e.getMessage());
        }
        return cities;
    }

    // 18 Method to get capital cities in a continent organized by largest population to smallest
    public List<City> getCapitalCitiesByContinent(String continent) {
        List<City> cities = new ArrayList<>();
        try {
            String strSelect = "SELECT city.*, country.Name AS CountryName " +
                    "FROM city JOIN country ON city.ID = country.Capital " +
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
            System.out.println("Failed to get capital cities in continent: " + e.getMessage());
        }
        return cities;
    }

    // 19 Method to get capital cities in a region organized by largest population to smallest
    public List<City> getCapitalCitiesByRegion(String region) {
        List<City> cities = new ArrayList<>();
        try {
            String strSelect = "SELECT city.*, country.Name AS CountryName " +
                    "FROM city JOIN country ON city.ID = country.Capital " +
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
            System.out.println("Failed to get capital cities in region: " + e.getMessage());
        }
        return cities;
    }
}
