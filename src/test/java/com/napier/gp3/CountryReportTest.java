package com.napier.gp3;

import org.junit.jupiter.api.*;
import org.mockito.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CountryReportTest {
    @Mock
    private Connection connection;

    @Mock
    private PreparedStatement preparedStatement;

    @Mock
    private ResultSet resultSet;

    private Country_report countryReport;

    @BeforeEach
    public void setUp() throws SQLException {
        // Initialize the mocks
        MockitoAnnotations.openMocks(this);

        // Set up the mock behavior for connection and statements
        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);

        // Initialize Country_report with the mocked connection
        countryReport = new Country_report(connection);
    }

    @Test
    public void testPrintAllCountriesByPopulation() {
        // Mock the behavior for fetching results
        // You can customize this mock based on how your print method interacts with the database.
        // For example, you might want to return a specific ResultSet with expected data.

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
        // Clear mocks after each test
        Mockito.framework().clearInlineMocks();
    }
}
