package com.napier.gp3;

import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class CountryReportTest {
    private Connection connection;
    private Country_report countryReport;

    @BeforeEach
    public void setUp() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database (updated connection string)
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:33060/world?allowPublicKeyRetrieval=true&useSSL=false",
                    "root",
                    "group3"
            );

            // Initialize the DAO with the connected database
            countryReport = new Country_report(connection);

        } catch (ClassNotFoundException e) {
            fail("SQL Driver Loading Failed: " + e.getMessage());
        } catch (SQLException e) {
            fail("Database connection failed: " + e.getMessage());
        }
    }

    @Test
    public void testPrintAllCountriesByPopulation() {
        // Ensure no exceptions are thrown during the execution of the report
        assertDoesNotThrow(() -> countryReport.printAllCountriesByPopulation(),
                "printAllCountriesByPopulation should run without throwing exceptions");
    }

    @Test
    public void testPrintAllCountriesByContinent() {
        // Ensure no exceptions are thrown for the 'Europe' continent
        assertDoesNotThrow(() -> countryReport.printAllCountriesByContinent("Europe"),
                "printAllCountriesByContinent should run without throwing exceptions");
    }

    @Test
    public void testPrintAllCountriesByRegion() {
        String region = "Southern Europe";

        // Ensure no exceptions are thrown during the execution of the report
        assertDoesNotThrow(() -> countryReport.printAllCountriesByRegion(region),
                "printAllCountriesByRegion should run without throwing exceptions");
    }


    @Test
    public void testPrintTopNCountries() {
        int N = 5;
        // Ensure no exceptions are thrown when printing the top N countries
        assertDoesNotThrow(() -> countryReport.printTopNCountries(N),
                "printTopNCountries should run without throwing exceptions");
    }

    @Test
    public void testPrintTopNCountriesByContinent() {
        int N = 5;
        String continent = "Asia";

        // Ensure no exceptions are thrown during the execution of the report
        assertDoesNotThrow(() -> countryReport.printTopNCountriesByContinent(N, continent),
                "printTopNCountriesByContinent should run without throwing exceptions");
    }

    @Test
    public void testPrintTopNCountriesByRegion() {
        int N = 5;
        String region = "Southern Europe";

        // Ensure no exceptions are thrown during the execution of the report
        assertDoesNotThrow(() -> countryReport.printTopNCountriesByRegion(N, region),
                "printTopNCountriesByRegion should run without throwing exceptions");
    }


    @AfterEach
    public void tearDown() {
        if (connection != null) {
            try {
                // Safely close the connection after each test
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}
