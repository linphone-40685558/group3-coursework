package com.napier.gp3;

import java.sql.*;
import java.util.List;

/**
 * The App class is to connect the MySQL database server from world.sql
 * And to produce reports
 * Implement the error handling method
 */

public class App {
    /**
     * Make a connection to the database
     */
    public Connection con = null;

    /**
     * Connect function to make a connection
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
     * Main class to call connect function, discount function
     * and reports producing
     *
     * @param args
     */
    public void main(String[] args) {
        // Create a new App instance
        App conn = new App();

        // Connect to the world.sql database
        conn.connect_function();

        // Create reports instances
        City_report cityReport = new City_report(conn.con);
        Country_report countryReport = new Country_report(conn.con);
        Capital_report capitalReport = new Capital_report(conn.con);

        // Parameter values for easy changes
        String continent = "Asia";
        String region = "Southeast Asia";
        String countryCode = "MMR";
        String country = "Myanmar";
        String district = "Mandalay";
        int number = 5;

        /**
         * Generate reports with parameters
         */
        conn.generateCountryReport(countryReport, continent, region, number);
        conn.generateCityReport(cityReport, continent, region, countryCode, district);


        // Disconnect from the database
        conn.disconnect_function();
    }

    /**
     * Generates the country report
     *
     * @param countryReport
     * @param continent
     * @param region
     * @param number
     */
    public void generateCountryReport(Country_report countryReport, String continent, String region, int number) {
        // Call each function and display results (1 - 6)
        countryReport.printAllCountriesByPopulation();
        countryReport.printAllCountriesByContinent(continent);
        countryReport.printAllCountriesByRegion(region);
        countryReport.printTopNCountries(number);
        countryReport.printTopNCountriesByContinent(number, continent);
        countryReport.printTopNCountriesByRegion(number, region);
    }

    /**
     * Generates the city report
     *
     * @param cityReport
     * @param continent
     * @param region
     * @param countryCode
     * @param district
     */
    public void generateCityReport(City_report cityReport, String continent, String region, String countryCode, String district) {
        // Call each function and display results (7 - 11)
        cityReport.printAllCitiesByPopulation();
        cityReport.printCitiesByContinent(continent);
        cityReport.printCitiesByRegion(region);
        cityReport.printCitiesByCountry(countryCode);
        cityReport.printCitiesByDistrict(district);
    }

}