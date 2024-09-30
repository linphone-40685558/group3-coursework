package com.napier.gp3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO {
    private Connection con;

    public CountryDAO(Connection connection) {
        this.con = connection;
    }

    // Method to get all countries organized by largest population to smallest
    public List<Country> getAllCountriesByPopulation() {
        List<Country> countries = new ArrayList<>();
        try {
            String strSelect = "SELECT Code, Name, Continent, Region, SurfaceArea, IndepYear, Population, LifeExpectancy, GNP, GNPOld, LocalName, GovernmentForm, HeadOfState, Capital, Code2 FROM country ORDER BY Population DESC";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            ResultSet rset = pstmt.executeQuery();

            while (rset.next()) {
                countries.add(new Country(
                        rset.getString("Code"),
                        rset.getString("Name"),
                        rset.getString("Continent"),
                        rset.getString("Region"),
                        rset.getDouble("SurfaceArea"),
                        rset.getInt("IndepYear"),
                        rset.getLong("Population"),
                        rset.getDouble("LifeExpectancy"),
                        rset.getDouble("GNP"),
                        rset.getDouble("GNPOld"),
                        rset.getString("LocalName"),
                        rset.getString("GovernmentForm"),
                        rset.getString("HeadOfState"),
                        rset.getInt("Capital"),
                        rset.getString("Code2")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Failed to get countries: " + e.getMessage());
        }
        return countries;
    }

    // Method to get all countries in a continent organized by largest population to smallest
    public List<Country> getCountriesByContinent(String continent) {
        List<Country> countries = new ArrayList<>();
        try {
            String strSelect = "SELECT Code, Name, Continent, Region, SurfaceArea, IndepYear, Population, LifeExpectancy, GNP, GNPOld, LocalName, GovernmentForm, HeadOfState, Capital, Code2 FROM country WHERE Continent = ? ORDER BY Population DESC";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            pstmt.setString(1, continent);
            ResultSet rset = pstmt.executeQuery();

            while (rset.next()) {
                countries.add(new Country(
                        rset.getString("Code"),
                        rset.getString("Name"),
                        rset.getString("Continent"),
                        rset.getString("Region"),
                        rset.getDouble("SurfaceArea"),
                        rset.getInt("IndepYear"),
                        rset.getLong("Population"),
                        rset.getDouble("LifeExpectancy"),
                        rset.getDouble("GNP"),
                        rset.getDouble("GNPOld"),
                        rset.getString("LocalName"),
                        rset.getString("GovernmentForm"),
                        rset.getString("HeadOfState"),
                        rset.getInt("Capital"),
                        rset.getString("Code2")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Failed to get countries in continent: " + e.getMessage());
        }
        return countries;
    }

    // Method to get all countries in a region organized by largest population to smallest
    public List<Country> getCountriesByRegion(String region) {
        List<Country> countries = new ArrayList<>();
        try {
            String strSelect = "SELECT Code, Name, Continent, Region, SurfaceArea, IndepYear, Population, LifeExpectancy, GNP, GNPOld, LocalName, GovernmentForm, HeadOfState, Capital, Code2 FROM country WHERE Region = ? ORDER BY Population DESC";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            pstmt.setString(1, region);
            ResultSet rset = pstmt.executeQuery();

            while (rset.next()) {
                countries.add(new Country(
                        rset.getString("Code"),
                        rset.getString("Name"),
                        rset.getString("Continent"),
                        rset.getString("Region"),
                        rset.getDouble("SurfaceArea"),
                        rset.getInt("IndepYear"),
                        rset.getLong("Population"),
                        rset.getDouble("LifeExpectancy"),
                        rset.getDouble("GNP"),
                        rset.getDouble("GNPOld"),
                        rset.getString("LocalName"),
                        rset.getString("GovernmentForm"),
                        rset.getString("HeadOfState"),
                        rset.getInt("Capital"),
                        rset.getString("Code2")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Failed to get countries in region: " + e.getMessage());
        }
        return countries;
    }

    // Method to get the top N populated countries in the world
    public List<Country> getTopNPopulatedCountries(int N) {
        List<Country> countries = new ArrayList<>();
        try {
            String strSelect = "SELECT Code, Name, Continent, Region, SurfaceArea, IndepYear, Population, LifeExpectancy, GNP, GNPOld, LocalName, GovernmentForm, HeadOfState, Capital, Code2 FROM country ORDER BY Population DESC LIMIT ?";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            pstmt.setInt(1, N);
            ResultSet rset = pstmt.executeQuery();

            while (rset.next()) {
                countries.add(new Country(
                        rset.getString("Code"),
                        rset.getString("Name"),
                        rset.getString("Continent"),
                        rset.getString("Region"),
                        rset.getDouble("SurfaceArea"),
                        rset.getInt("IndepYear"),
                        rset.getLong("Population"),
                        rset.getDouble("LifeExpectancy"),
                        rset.getDouble("GNP"),
                        rset.getDouble("GNPOld"),
                        rset.getString("LocalName"),
                        rset.getString("GovernmentForm"),
                        rset.getString("HeadOfState"),
                        rset.getInt("Capital"),
                        rset.getString("Code2")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Failed to get top N populated countries: " + e.getMessage());
        }
        return countries;
    }

    // Method to get the top N populated countries in a continent
    public List<Country> getTopNPopulatedCountriesInContinent(String continent, int N) {
        List<Country> countries = new ArrayList<>();
        try {
            String strSelect = "SELECT Code, Name, Continent, Region, SurfaceArea, IndepYear, Population, LifeExpectancy, GNP, GNPOld, LocalName, GovernmentForm, HeadOfState, Capital, Code2 FROM country WHERE Continent = ? ORDER BY Population DESC LIMIT ?";
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
                        rset.getDouble("SurfaceArea"),
                        rset.getInt("IndepYear"),
                        rset.getLong("Population"),
                        rset.getDouble("LifeExpectancy"),
                        rset.getDouble("GNP"),
                        rset.getDouble("GNPOld"),
                        rset.getString("LocalName"),
                        rset.getString("GovernmentForm"),
                        rset.getString("HeadOfState"),
                        rset.getInt("Capital"),
                        rset.getString("Code2")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Failed to get top N populated countries in continent: " + e.getMessage());
        }
        return countries;
    }

    // Method to get the top N populated countries in a region
    public List<Country> getTopNPopulatedCountriesInRegion(String region, int N) {
        List<Country> countries = new ArrayList<>();
        try {
            String strSelect = "SELECT Code, Name, Continent, Region, SurfaceArea, IndepYear, Population, LifeExpectancy, GNP, GNPOld, LocalName, GovernmentForm, HeadOfState, Capital, Code2 FROM country WHERE Region = ? ORDER BY Population DESC LIMIT ?";
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
                        rset.getDouble("SurfaceArea"),
                        rset.getInt("IndepYear"),
                        rset.getLong("Population"),
                        rset.getDouble("LifeExpectancy"),
                        rset.getDouble("GNP"),
                        rset.getDouble("GNPOld"),
                        rset.getString("LocalName"),
                        rset.getString("GovernmentForm"),
                        rset.getString("HeadOfState"),
                        rset.getInt("Capital"),
                        rset.getString("Code2")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Failed to get top N populated countries in region: " + e.getMessage());
        }
        return countries;
    }
}
