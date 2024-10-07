package com.napier.gp3;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.verify;

public class CountryReportTest {

    @Test
    public void testPrintAllCountriesByPopulation() {
        // Mocking the DAO
        CountryDAO mockCountryDAO = Mockito.mock(CountryDAO.class);

        // Mock data for countries
        List<Country> mockCountries = List.of(
                new Country("USA", "United States", "North America", "Northern America", 331002651L, 1, "Washington D.C.")
        );
        Mockito.when(mockCountryDAO.getAllCountriesByPopulation()).thenReturn(mockCountries);

        // Create an instance of Country_report with a mock DAO
        Country_report report = new Country_report(null);  // Connection is not needed for this test
        report.countryDAO = mockCountryDAO;  // Injecting mock DAO

        // Test print method
        report.printAllCountriesByPopulation();

        // Verify that the DAO method was called
        verify(mockCountryDAO).getAllCountriesByPopulation();
    }
}

