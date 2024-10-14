package com.napier.gp3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PopulationDAO {
    private Connection con;

    public PopulationDAO(Connection connection) {
        this.con = connection;
    }

    /**
     * Methods to get population data organized by various categories.
     */

    //  Method to get the total population of the world
    public long getTotalWorldPopulation() {
        long totalPopulation = 0;
        try {
            String strSelect = "SELECT SUM(Population) AS TotalPopulation FROM country";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            ResultSet rset = pstmt.executeQuery();

            if (rset.next()) {
                totalPopulation = rset.getLong("TotalPopulation");
            }
        } catch (SQLException e) {
            System.out.println("Failed to get total world population: " + e.getMessage());
        }
        return totalPopulation;
    }

    //  26 Method to get the population of the world
    public List<Population> getWorldPopulation() {
        List<Population> populations = new ArrayList<>();
        long worldPopulation = getTotalWorldPopulation();
        try {
            String strSelect = "SELECT SUM(Population) AS TotalPopulation, " +
                    "(SELECT SUM(city.Population) FROM city) AS UrbanPopulation " +
                    "FROM country";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            ResultSet rset = pstmt.executeQuery();

            if (rset.next()) {
                int totalPopulation = rset.getInt("TotalPopulation");
                int urbanPopulation = rset.getInt("UrbanPopulation");
                int ruralPopulation = totalPopulation - urbanPopulation;
                populations.add(new Population("World", totalPopulation, urbanPopulation, ruralPopulation));
            }
        } catch (SQLException e) {
            System.out.println("Failed to get world population: " + e.getMessage());
        }
        return populations;
    }

    // 27 Method to get the total population of a continent
    public List<Population> getPopulationByContinent(String continent) {
        List<Population> populations = new ArrayList<>();
        long worldPopulation = getTotalWorldPopulation();
        try {
            String strSelect = "SELECT SUM(country.Population) AS TotalPopulation, " +
                    "(SELECT SUM(city.Population) FROM city JOIN country ON city.CountryCode = country.Code WHERE country.Continent = ?) AS UrbanPopulation " +
                    "FROM country WHERE country.Continent = ?";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            pstmt.setString(1, continent);
            pstmt.setString(2, continent);
            ResultSet rset = pstmt.executeQuery();

            if (rset.next()) {
                int totalPopulation = rset.getInt("TotalPopulation");
                int urbanPopulation = rset.getInt("UrbanPopulation");
                int ruralPopulation = totalPopulation - urbanPopulation;
                populations.add(new Population(
                        continent,
                        totalPopulation,
                        urbanPopulation,
                        ruralPopulation
                ));
            }
        } catch (SQLException e) {
            System.out.println("Failed to get population by continent: " + e.getMessage());
        }
        return populations;
    }

    // 28 Method to get the total population of a region
    public List<Population> getPopulationByRegion(String region) {
        List<Population> populations = new ArrayList<>();
        long worldPopulation = getTotalWorldPopulation();
        try {
            String strSelect = "SELECT SUM(country.Population) AS TotalPopulation, " +
                    "(SELECT SUM(city.Population) FROM city JOIN country ON city.CountryCode = country.Code WHERE country.Region = ?) AS UrbanPopulation " +
                    "FROM country WHERE country.Region = ?";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            pstmt.setString(1, region);
            pstmt.setString(2, region);
            ResultSet rset = pstmt.executeQuery();

            if (rset.next()) {
                int totalPopulation = rset.getInt("TotalPopulation");
                int urbanPopulation = rset.getInt("UrbanPopulation");
                int ruralPopulation = totalPopulation - urbanPopulation;
                populations.add(new Population(
                        region,
                        totalPopulation,
                        urbanPopulation,
                        ruralPopulation
                ));
            }
        } catch (SQLException e) {
            System.out.println("Failed to get population by region: " + e.getMessage());
        }
        return populations;
    }

    // 29 Method to get the total population of a country
    public List<Population> getPopulationByCountry(String countryCode) {
        List<Population> populations = new ArrayList<>();
        long worldPopulation = getTotalWorldPopulation();
        try {
            String strSelect = "SELECT SUM(Population) AS TotalPopulation, " +
                    "(SELECT SUM(city.Population) FROM city WHERE city.CountryCode = ?) AS UrbanPopulation " +
                    "FROM country WHERE country.Code = ?";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            pstmt.setString(1, countryCode);
            pstmt.setString(2, countryCode);
            ResultSet rset = pstmt.executeQuery();

            if (rset.next()) {
                int totalPopulation = rset.getInt("TotalPopulation");
                int urbanPopulation = rset.getInt("UrbanPopulation");
                int ruralPopulation = totalPopulation - urbanPopulation;
                populations.add(new Population(
                        countryCode,
                        totalPopulation,
                        urbanPopulation,
                        ruralPopulation
                ));
            }
        } catch (SQLException e) {
            System.out.println("Failed to get population by country: " + e.getMessage());
        }
        return populations;
    }

    // 30 Method to get the total population of a district
    public List<Population> getPopulationByDistrict(String district) {
        List<Population> populations = new ArrayList<>();
        long worldPopulation = getTotalWorldPopulation();
        try {
            String strSelect = "SELECT SUM(city.Population) AS UrbanPopulation " +
                    "FROM city WHERE city.District = ?";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            pstmt.setString(1, district);
            ResultSet rset = pstmt.executeQuery();

            if (rset.next()) {
                int urbanPopulation = rset.getInt("UrbanPopulation");
                // Assuming total population includes only urban; adjust as necessary
                int totalPopulation = urbanPopulation; // Adjust this based on actual logic needed
                int ruralPopulation = 0; // Assuming no rural population data for districts
                populations.add(new Population(
                        district,
                        totalPopulation,
                        urbanPopulation,
                        ruralPopulation
                ));
            }
        } catch (SQLException e) {
            System.out.println("Failed to get population by district: " + e.getMessage());
        }
        return populations;
    }

    // 7 Method to get the total population of a city
    public List<Population> getPopulationByCity(String cityName) {
        List<Population> populations = new ArrayList<>();
        long worldPopulation = getTotalWorldPopulation();
        try {
            String strSelect = "SELECT Population FROM city WHERE city.Name = ?";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            pstmt.setString(1, cityName);
            ResultSet rset = pstmt.executeQuery();

            if (rset.next()) {
                int urbanPopulation = rset.getInt("Population");
                // Assuming total population includes only urban; adjust as necessary
                int totalPopulation = urbanPopulation; // Adjust this based on actual logic needed
                int ruralPopulation = 0; // Assuming no rural population data for cities
                populations.add(new Population(
                        cityName,
                        totalPopulation,
                        urbanPopulation,
                        ruralPopulation
                ));
            }
        } catch (SQLException e) {
            System.out.println("Failed to get population by city: " + e.getMessage());
        }
        return populations;
    }
}
