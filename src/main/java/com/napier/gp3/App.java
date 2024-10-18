package com.napier.gp3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class App {
    private static Connection con = null;

    /**
     * Connection object
     *
     * @return Connection object
     */
    public Connection getCon() {
        return con;
    }

    /**
     * Connect function to make a connection
     */
    public static void connect_function(String location, int delay) {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(delay);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location
                                + "/world?allowPublicKeyRetrieval=true&useSSL=false",
                        "root", "group3");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Main class
     */
    public static void main(String[] args) {
        // Connect to database
        if (args.length < 1) {
            connect_function("localhost:33060", 0);
        } else {
            connect_function(args[0], Integer.parseInt(args[1]));
        }

        // Running App
        SpringApplication.run(App.class, args);
    }

    /**
     * Utility
     */
    private long getTotalWorldPopulation() {
        long population = 0;
        try {
            String strSelect = "SELECT SUM(population) AS total_population FROM country";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            ResultSet rset = pstmt.executeQuery();

            if (rset.next()) {
                population = rset.getLong("total_population");
            }
        } catch (SQLException e) {
            System.out.println("Failed to get total world population: " + e.getMessage());
        }
        return population;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World";
    }

    @GetMapping("/countries")
    public List<Country> getCountriesByPopulation() {
        System.out.println("Getting countries by population");
        List<Country> countries = new ArrayList<>();
        try {
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
                        rset.getInt("Capital"),
                        rset.getString("CapitalName")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Failed to get countries: " + e.getMessage());
        }
        return countries;
    }

    @GetMapping("/cities")
    public List<City> getCitiesByPopulation() {
        List<City> cities = new ArrayList<>();
        try {
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

    @GetMapping("/capitals")
    public List<Capital> getCapitalsByPopulation() {
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

    @GetMapping("/languages")
    public List<Language> getLanguagesByPopulation() {
        List<Language> languages = new ArrayList<>();
        try {
            // Query to total number of people who spoke in selected language, ordered by the number of people in descending order
            String strSelect = "SELECT language, SUM(country.population) AS numberOfPeople " +
                    "FROM countrylanguage " +
                    "JOIN country ON countrylanguage.CountryCode = country.Code " +
                    "WHERE language IN ('Chinese', 'English', 'Hindi', 'Spanish', 'Arabic') " +
                    "GROUP BY language " +
                    "ORDER BY numberOfPeople DESC";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            ResultSet rset = pstmt.executeQuery();

            // Get the total world population
            long worldPopulation = getTotalWorldPopulation();
            while (rset.next()) {
                languages.add(new Language(
                        rset.getString("language"),
                        rset.getLong("numberOfPeople"),
                        (rset.getLong("numberOfPeople") / (double) worldPopulation) * 100
                ));
            }
        } catch (SQLException e) {
            System.out.println("Failed to get total number of people who speak in selected languages: " + e.getMessage());
        }
        return languages;
    }

}
