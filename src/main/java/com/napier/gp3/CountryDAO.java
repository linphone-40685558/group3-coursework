package com.napier.gp3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * CountryDAO has database manipulations to retrieve country-related information.
 * It has methods to fetch countries by population, continent, region, and top N populated countries.
 */
public class CountryDAO {
    private Connection con;

    public CountryDAO(Connection connection) {
        this.con = connection;
    }

    // 1) Method to get all countries by population with capital name
    public List<Country> getAllCountriesByPopulation() {
        List<Country> countries = new ArrayList<>();
        try {
            // Query to get country info and the corresponding capital name from city table
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital, city.Name AS CapitalName " +
                            "FROM country " +
                            "LEFT JOIN city ON country.Capital = city.ID " +
                            "ORDER BY country.Population DESC";

            PreparedStatement pstmt = con.prepareStatement(strSelect);
            ResultSet rset = pstmt.executeQuery();

            while (rset.next()) {
                countries.add(new Country(
                        rset.getString("Code"),
                        rset.getString("Name"),
                        rset.getString("Continent"),
                        rset.getString("Region"),
                        rset.getLong("Population"),
                        rset.getInt("Capital"),  // Capital ID
                        rset.getString("CapitalName")  // Capital Name from city table
                ));
            }
        } catch (SQLException e) {
            System.out.println("Failed to get countries: " + e.getMessage());
        }
        return countries;
    }

    // 2) Method to get all countries by continent with capital name
    public List<Country> getCountriesByContinent(String continent) {
        List<Country> countries = new ArrayList<>();
        try {
            // Query to get countries in a specific continent with capital name
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital, city.Name AS CapitalName " +
                            "FROM country " +
                            "LEFT JOIN city ON country.Capital = city.ID " +
                            "WHERE country.Continent = ? " +
                            "ORDER BY country.Population DESC";

            PreparedStatement pstmt = con.prepareStatement(strSelect);
            pstmt.setString(1, continent);
            ResultSet rset = pstmt.executeQuery();

            while (rset.next()) {
                countries.add(new Country(
                        rset.getString("Code"),
                        rset.getString("Name"),
                        rset.getString("Continent"),
                        rset.getString("Region"),
                        rset.getLong("Population"),
                        rset.getInt("Capital"),  // Capital ID
                        rset.getString("CapitalName")  // Capital Name from city table
                ));
            }
        } catch (SQLException e) {
            System.out.println("Failed to get countries in continent: " + e.getMessage());
        }
        return countries;
    }

    // 3) Method to get all countries by region with capital name
    public List<Country> getCountriesByRegion(String region) {
        List<Country> countries = new ArrayList<>();
        try {
            // Query to get countries in a specific region with capital name
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital, city.Name AS CapitalName " +
                            "FROM country " +
                            "LEFT JOIN city ON country.Capital = city.ID " +
                            "WHERE country.Region = ? " +
                            "ORDER BY country.Population DESC";

            PreparedStatement pstmt = con.prepareStatement(strSelect);
            pstmt.setString(1, region);
            ResultSet rset = pstmt.executeQuery();

            while (rset.next()) {
                countries.add(new Country(
                        rset.getString("Code"),
                        rset.getString("Name"),
                        rset.getString("Continent"),
                        rset.getString("Region"),
                        rset.getLong("Population"),
                        rset.getInt("Capital"),  // Capital ID
                        rset.getString("CapitalName")  // Capital Name from city table
                ));
            }
        } catch (SQLException e) {
            System.out.println("Failed to get countries in region: " + e.getMessage());
        }
        return countries;
    }

    // 4) Method to get top N populated countries in the world
    public List<Country> getTopNPopulatedCountries(int N) {
        List<Country> countries = new ArrayList<>();
        try {
            // Query to get top N populated countries with capital name
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital, city.Name AS CapitalName " +
                            "FROM country " +
                            "LEFT JOIN city ON country.Capital = city.ID " +
                            "ORDER BY country.Population DESC LIMIT ?";

            PreparedStatement pstmt = con.prepareStatement(strSelect);
            pstmt.setInt(1, N);
            ResultSet rset = pstmt.executeQuery();

            while (rset.next()) {
                countries.add(new Country(
                        rset.getString("Code"),
                        rset.getString("Name"),
                        rset.getString("Continent"),
                        rset.getString("Region"),
                        rset.getLong("Population"),
                        rset.getInt("Capital"),  // Capital ID
                        rset.getString("CapitalName")  // Capital Name from city table
                ));
            }
        } catch (SQLException e) {
            System.out.println("Failed to get top N populated countries: " + e.getMessage());
        }
        return countries;
    }

    // 5) Method to get top N populated countries in a continent
    public List<Country> getTopNPopulatedCountriesInContinent(String continent, int N) {
        List<Country> countries = new ArrayList<>();
        try {
            // Query to get top N populated countries in a continent with capital name
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital, city.Name AS CapitalName " +
                            "FROM country " +
                            "LEFT JOIN city ON country.Capital = city.ID " +
                            "WHERE country.Continent = ? " +
                            "ORDER BY country.Population DESC LIMIT ?";

            PreparedStatement pstmt = con.prepareStatement(strSelect);
            pstmt.setString(1, continent);
            pstmt.setInt(2, N);
            ResultSet rset = pstmt.executeQuery();

            while (rset.next()) {
                countries.add(new Country(
                        rset.getString("Code"),
                        rset.getString("Name"),
                        rset.getString("Continent"),
                        rset.getString("Region"),
                        rset.getLong("Population"),
                        rset.getInt("Capital"),  // Capital ID
                        rset.getString("CapitalName")  // Capital Name from city table
                ));
            }
        } catch (SQLException e) {
            System.out.println("Failed to get top N populated countries in continent: " + e.getMessage());
        }
        return countries;
    }

    // 6) Method to get top N populated countries in a region
    public List<Country> getTopNPopulatedCountriesInRegion(String region, int N) {
        List<Country> countries = new ArrayList<>();
        try {
            // Query to get top N populated countries in a region with capital name
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital, city.Name AS CapitalName " +
                            "FROM country " +
                            "LEFT JOIN city ON country.Capital = city.ID " +
                            "WHERE country.Region = ? " +
                            "ORDER BY country.Population DESC LIMIT ?";

            PreparedStatement pstmt = con.prepareStatement(strSelect);
            pstmt.setString(1, region);
            pstmt.setInt(2, N);
            ResultSet rset = pstmt.executeQuery();

            while (rset.next()) {
                countries.add(new Country(
                        rset.getString("Code"),
                        rset.getString("Name"),
                        rset.getString("Continent"),
                        rset.getString("Region"),
                        rset.getLong("Population"),
                        rset.getInt("Capital"),  // Capital ID
                        rset.getString("CapitalName")  // Capital Name from city table
                ));
            }
        } catch (SQLException e) {
            System.out.println("Failed to get top N populated countries in region: " + e.getMessage());
        }
        return countries;
    }
}
