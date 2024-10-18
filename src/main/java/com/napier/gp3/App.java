package com.napier.gp3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The App class is to connect the MySQL database server from world.sql
 * And to produce reports
 * Implement the error handling method
 */

public class App {
    /**
     * Make a connection to the database
     */
    private Connection con = null;

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
     *
     * @param location Local/Docker
     * @param delay    Before connecting to database
     */
    public void connect_function(String location, int delay) {
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
     * @param args Arguments
     */
    public static void main(String[] args) {
        // Create a new App instance
        App conn = new App();

        // Connect to the world.sql database
        if (args.length < 1) {
            conn.connect_function("localhost:33060", 2000);
        } else {
            conn.connect_function(args[0], Integer.parseInt(args[1]));
        }

        // Create reports instances
        Country_report countryReport = new Country_report(conn.con);
        City_report cityReport = new City_report(conn.con);
        Capital_report capitalReport = new Capital_report(conn.con);
        Language_report languageReport = new Language_report(conn.con);
        EachPopulation_report eachPopulationReport = new EachPopulation_report(conn.con);
        Population_report populationReport = new Population_report(conn.con);

        // Parameter values for easy changes
        String continent = "Asia";
        String region = "Southeast Asia";
        String countryCode = "MMR";
        String district = "Mandalay";
        String cityName = "Myingyan";
        int number = 5;

        // Generate Reports
        generateCountryReport(countryReport, continent, region, number);
        generateCityReport(cityReport, continent, region, countryCode, district, number);
        generateCapitalCityReport(capitalReport, continent, region, countryCode, district, number);
        generateEachPopulationReport(eachPopulationReport);
        generatePopulationReport(populationReport, continent, region, countryCode, district, cityName);
        generateLanguageReport(languageReport);


        // Disconnect from the database
        conn.disconnect_function();
    }

    /**
     * Generates the country report
     *
     * @param countryReport Country Report Instance
     * @param continent     Continent
     * @param region        Region
     * @param number        Top N
     */
    private static void generateCountryReport(Country_report countryReport, String continent, String region, int number) {
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
     * @param cityReport  City Report Instance
     * @param continent   Continent
     * @param region      Region
     * @param countryCode Country Code
     * @param district    Districe
     */
    private static void generateCityReport(City_report cityReport, String continent, String region, String countryCode, String district, int number) {
        // Call each function and display results (7 - 16)
        cityReport.printAllCitiesByPopulation();
        cityReport.printCitiesByContinent(continent);
        cityReport.printCitiesByRegion(region);
        cityReport.printCitiesByCountry(countryCode);
        cityReport.printCitiesByDistrict(district);
        cityReport.printTopNPopulatedCitiesInWorld(number);
        cityReport.printTopNPopulatedCitiesInContinent(continent, number);
        cityReport.printTopNPopulatedCitiesInRegion(region, number);
        cityReport.printTopNPopulatedCitiesInCountry(countryCode, number);
        cityReport.printTopNPopulatedCitiesInDistrict(district, number);
    }

    /**
     * Generates the capital city report
     *
     * @param capitalReport Capital Report Instance
     * @param continent     Continent
     * @param region        Region
     * @param countryCode   Country Code
     * @param district      Districe
     */
    private static void generateCapitalCityReport(Capital_report capitalReport, String continent, String region, String countryCode, String district, int number) {
        // Call each function and display results (17 - 22)
        capitalReport.printCapitalsByPopulation();
        capitalReport.printCapitalsByContinent(continent);
        capitalReport.printCapitalsByRegion(region);
        capitalReport.printTopNPopulatedCapitalCitiesInWorld(number);
        capitalReport.printTopNPopulatedCapitalCitiesInContinent(number, continent);
        capitalReport.printTopNPopulatedCapitalCitiesInRegion(number, region);
    }

    /**
     * Generates the population report
     *
     * @param populationReport Object
     * @param continent Continent name
     * @param region Region name
     * @param countryCode Country code
     * @param district District name
     */
    private static void generatePopulationReport(Population_report populationReport, String continent, String region, String countryCode, String district, String cityName) {
        // Call each function and display results for population (26 - 31)
        populationReport.printWorldPopulation();
        populationReport.printPopulationByContinent(continent);
        populationReport.printPopulationByRegion(region);
        populationReport.printPopulationByCountry(countryCode);
        populationReport.printPopulationByDistrict(district);
        populationReport.printPopulationByCity(cityName);
    }

    private static void generateEachPopulationReport(EachPopulation_report eachpopulationReport) {
        // Call each function and display results for each population (23 - 25)
        eachpopulationReport.printPopulationByEachContinent();
        eachpopulationReport.printPopulationByEachRegion();
        eachpopulationReport.printPopulationByEachCountry();
    }

    /**
     * Generates the language report.
     *
     * @param languageReport Language Report Instance
     */
    private static void generateLanguageReport(Language_report languageReport) {
        languageReport.printLanguagesByNumberOfPeople();
    }
}
