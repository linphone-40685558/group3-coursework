package com.napier.gp3;

import java.sql.*;
import java.util.List;

/**
 * The App class is to connect the MySQL database server from world.sql
 * Implement the error handling method
 */

public class App {
    /**
     * Make a connection to the database
     */
    private Connection con = null;

    /**
     * connect function to make a connection
     */
    public void connect_function() {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("SQL drive Loading Fail!");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to world database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "group3");
                System.out.println("Successfully,Connected with database");
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
     * Disconnect function to disconnect from the MySQL database.
     */
    public void disconnect_function() {
        if (con != null) {
            try {
                // Close connection
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }

    /**
     * Main class to call connect function and discount function
     */
    public static void main(String[] args) {
        // Create a new App instance
        App conn = new App();

        // Connect to the world.sql database
        conn.connect_function();

        // Create an instance of CountryDAO
        CountryDAO countryDAO = new CountryDAO(conn.con);

        // Call each function and display results

        // 1. Get all countries by population
        System.out.println("All countries by population:");
        List<Country> allCountries = countryDAO.getAllCountriesByPopulation();
        for (Country country : allCountries) {
            System.out.println(country.getName() + ": " + country.getPopulation());
        }

        // 2. Get countries by continent (example: "Asia")
        String continent = "Asia";
        System.out.println("\nAll countries in " + continent + " by population:");
        List<Country> countriesInContinent = countryDAO.getCountriesByContinent(continent);
        for (Country country : countriesInContinent) {
            System.out.println(country.getName() + ": " + country.getPopulation());
        }

        // 3. Get countries by region (example: "Southeast Asia")
        String region = "Southeast Asia";
        System.out.println("\nAll countries in " + region + " by population:");
        List<Country> countriesInRegion = countryDAO.getCountriesByRegion(region);
        for (Country country : countriesInRegion) {
            System.out.println(country.getName() + ": " + country.getPopulation());
        }

        // 4. Get top N populated countries in the world (e.g., top 5)
        int N = 5; // You can change this number as needed
        List<Country> topNCountries = countryDAO.getTopNPopulatedCountries(N);
        System.out.println("\nTop " + N + " populated countries:");
        for (Country country : topNCountries) {
            System.out.println(country.getName() + ": " + country.getPopulation());
        }

        // 5. Get top N populated countries in a continent (e.g., Asia, top 5)
        System.out.println("\nTop " + N + " populated countries in " + continent + ":");
        List<Country> topNInContinent = countryDAO.getTopNPopulatedCountriesInContinent(continent, N);
        for (Country country : topNInContinent) {
            System.out.println(country.getName() + ": " + country.getPopulation());
        }

        // 6. Get top N populated countries in a region (e.g., Southeast Asia, top 5)
        System.out.println("\nTop " + N + " populated countries in " + region + ":");
        List<Country> topNInRegion = countryDAO.getTopNPopulatedCountriesInRegion(region, N);
        for (Country country : topNInRegion) {
            System.out.println(country.getName() + ": " + country.getPopulation());
        }

        // Disconnect from the database
        conn.disconnect_function();
    }

}