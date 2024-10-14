package com.napier.gp3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PopulationDAO {
    private Connection con;

    public PopulationDAO(Connection connection) {
        this.con = connection;
    }

    // Method to get the total population of the world
    public Population getWorldPopulation() {
        Population population = null;
        try {
            String strSelect = "SELECT SUM(Population) AS TotalPopulation, " +
                    "(SELECT SUM(Population) FROM city) AS UrbanPopulation " +
                    "FROM country";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            ResultSet rset = pstmt.executeQuery();

            if (rset.next()) {
                int totalPopulation = rset.getInt("TotalPopulation");
                int urbanPopulation = rset.getInt("UrbanPopulation");
                int ruralPopulation = totalPopulation - urbanPopulation;
                population = new Population("World", totalPopulation, urbanPopulation, ruralPopulation);
            }
        } catch (SQLException e) {
            System.out.println("Failed to get world population: " + e.getMessage());
        }
        return population;
    }

    // Method to get the total population of a continent
    public Population getPopulationByContinent(String continent) {
        Population population = null;
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
                population = new Population(continent, totalPopulation, urbanPopulation, ruralPopulation);
            }
        } catch (SQLException e) {
            System.out.println("Failed to get population by continent: " + e.getMessage());
        }
        return population;
    }

    // Method to get the total population of a region
    public Population getPopulationByRegion(String region) {
        Population population = null;
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
                population = new Population(region, totalPopulation, urbanPopulation, ruralPopulation);
            }
        } catch (SQLException e) {
            System.out.println("Failed to get population by region: " + e.getMessage());
        }
        return population;
    }

    // Method to get the total population of a country
    public Population getPopulationByCountry(String countryCode) {
        Population population = null;
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
                population = new Population(countryCode, totalPopulation, urbanPopulation, ruralPopulation);
            }
        } catch (SQLException e) {
            System.out.println("Failed to get population by country: " + e.getMessage());
        }
        return population;
    }

    // Method to get the total population of a district
    public Population getPopulationByDistrict(String district) {
        Population population = null;
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
                population = new Population(district, totalPopulation, urbanPopulation, ruralPopulation);
            }
        } catch (SQLException e) {
            System.out.println("Failed to get population by district: " + e.getMessage());
        }
        return population;
    }

    // Method to get the total population of a city
    public Population getPopulationByCity(String cityName) {
        Population population = null;
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
                population = new Population(cityName, totalPopulation, urbanPopulation, ruralPopulation);
            }
        } catch (SQLException e) {
            System.out.println("Failed to get population by city: " + e.getMessage());
        }
        return population;
    }
}
