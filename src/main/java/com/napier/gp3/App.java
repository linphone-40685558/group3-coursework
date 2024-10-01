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

        // Create an instance of City_report
        City_report cityReport = new City_report(conn.con);
        // Create an instance of Country_report
        Country_report countryReport = new Country_report(conn.con);
        // Create an instance of Capital_report
        Capital_report capitalReport = new Capital_report(conn.con);

        // Call each function and display results
        // Country Report
        countryReport.printAllCountriesByPopulation();
        countryReport.printAllCountriesByContinent("Asia");
        countryReport.printAllCountriesByRegion("Southeast Asia");
        countryReport.printTopNCountries(5);
        countryReport.printTopNCountriesByContinent(5, "Asia");
        countryReport.printTopNCountriesByRegion(5, "Southeast Asia");

        // Call each function and display results
        // City Report
        cityReport.printAllCitiesByPopulation();
        cityReport.printCitiesByContinent("Asia");
        cityReport.printCitiesByRegion("Southern Europe");
        cityReport.printCitiesByCountry("GBR");
        cityReport.printCitiesByDistrict("England");

        // Call each function and display results
        // Capital City Report
        capitalReport.printCapitalsByPopulation();
        capitalReport.printCapitalsByContinent("Asia");
        capitalReport.printCapitalsByRegion("Southeast Asia");


        // Disconnect from the database
        conn.disconnect_function();
    }

}