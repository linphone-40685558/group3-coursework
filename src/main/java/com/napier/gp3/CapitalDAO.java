package com.napier.gp3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CapitalDAO {
    private Connection con;

    public CapitalDAO(Connection connection) {
        this.con = connection;
    }

    /**
     * All the capital cities in the world organised by largest population to smallest.
     * All the capital cities in a continent organised by largest population to smallest.
     * All the capital cities in a region organised by largest to smallest.
     */

    // 17 Method to get all capital cities in the world organized by largest population to smallest
    public List<Capital> getAllCapitalCitiesByPopulation() {
        List<Capital> cities = new ArrayList<>();
        try {
            String strSelect = "SELECT city.*, country.Name AS CountryName " +
                    "FROM city " +
                    "JOIN country ON city.ID = country.Capital " +
                    "ORDER BY city.Population DESC";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            ResultSet rset = pstmt.executeQuery();

            while (rset.next()) {
                cities.add(new Capital(
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
    public List<Capital> getCapitalCitiesByContinent(String continent) {
        List<Capital> cities = new ArrayList<>();
        try {
            String strSelect = "SELECT city.*, country.Name AS CountryName " +
                    "FROM city JOIN country ON city.ID = country.Capital " +
                    "WHERE country.Continent = ? ORDER BY city.Population DESC";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            pstmt.setString(1, continent);
            ResultSet rset = pstmt.executeQuery();

            while (rset.next()) {
                cities.add(new Capital(
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
    public List<Capital> getCapitalCitiesByRegion(String region) {
        List<Capital> cities = new ArrayList<>();
        try {
            String strSelect = "SELECT city.*, country.Name AS CountryName, country.Code AS CountryCode  " +
                    "FROM city JOIN country ON city.ID = country.Capital " +
                    "WHERE country.Region = ? ORDER BY city.Population DESC";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            pstmt.setString(1, region);
            ResultSet rset = pstmt.executeQuery();

            while (rset.next()) {
                cities.add(new Capital(
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

    // 20 Method to get top N populated capital cities in the world
    public List<Capital> getTopNPopulatedCapitalCitiesInWorld(int N) {
        List<Capital> cities = new ArrayList<>();
        try {
            // SQL query to get top N populated capital cities in the world
            String strSelect = "SELECT city.*, country.Name AS CountryName, country.Code AS CountryCode " +
                    "FROM city JOIN country ON city.ID = country.Capital " +
                    "ORDER BY city.Population DESC LIMIT ?";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            pstmt.setInt(1, N);
            ResultSet rset = pstmt.executeQuery();

            while (rset.next()) {
                cities.add(new Capital(
                        rset.getInt("ID"),
                        rset.getString("Name"),
                        rset.getString("CountryName"),  // Country name from the country table
                        rset.getString("CountryCode"),   // ISO country code
                        rset.getString("District"),
                        rset.getInt("Population")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Failed to get top N populated capital cities in the world: " + e.getMessage());
        }
        return cities;
    }

    // 21 Method to get top N populated capital cities in the continent
    public List<Capital> getTopNPopulatedCapitalCitiesInContinent(String continent, int N) {
        List<Capital> cities = new ArrayList<>();
        try {
            String strSelect = "SELECT city.*, country.Name AS CountryName, country.Code AS CountryCode " +
                    "FROM city JOIN country ON city.ID = country.Capital " +
                    "WHERE country.Continent = ? " +
                    "ORDER BY city.Population DESC LIMIT ?";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            pstmt.setString(1, continent);
            pstmt.setInt(2, N);
            ResultSet rset = pstmt.executeQuery();

            while (rset.next()) {
                cities.add(new Capital(
                        rset.getInt("ID"),
                        rset.getString("Name"),
                        rset.getString("CountryName"),
                        rset.getString("CountryCode"),
                        rset.getString("District"),
                        rset.getInt("Population")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Failed to get top N populated capital cities in continent: " + e.getMessage());
        }
        return cities;
    }


    // 22 Method to get top N populated capital cities in the region
    public List<Capital> getTopNPopulatedCapitalCitiesInRegion(String region, int N) {
        List<Capital> cities = new ArrayList<>();
        try {
            String strSelect = "SELECT city.*, country.Name AS CountryName, country.Code AS CountryCode " +
                    "FROM city JOIN country ON city.ID = country.Capital " +
                    "WHERE country.Region = ? " +
                    "ORDER BY city.Population DESC LIMIT ?";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            pstmt.setString(1, region);
            pstmt.setInt(2, N);
            ResultSet rset = pstmt.executeQuery();

            while (rset.next()) {
                cities.add(new Capital(
                        rset.getInt("ID"),
                        rset.getString("Name"),
                        rset.getString("CountryName"),
                        rset.getString("CountryCode"),
                        rset.getString("District"),
                        rset.getInt("Population")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Failed to get top N populated capital cities in region: " + e.getMessage());
        }
        return cities;
    }







}
