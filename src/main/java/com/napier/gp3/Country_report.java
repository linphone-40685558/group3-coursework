package com.napier.gp3;

import java.sql.Connection;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

/**
 * This class has printing methods for country reports
 */
public class Country_report {
    public CountryDAO countryDAO;
    private final NumberFormat numberFormat;

    /**
     * Constructor
     *
     * @param con Connection object
     */
    public Country_report(Connection con) {
        this.countryDAO = new CountryDAO(con);
        this.numberFormat = NumberFormat.getInstance(Locale.US); // Set number format for US style (comma separated)
    }

    /**
     * Printing header
     */
    private void printReportHeader() {
        System.out.printf("%-5s %-40s %-15s %-30s %-15s %-30s%n", "Code", "Name", "Continent", "Region", "Population", "Capital");
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
    }

    /**
     * Printing country data
     *
     * @param countries List of countries
     * @param title     Title
     */
    private void printCountryReport(List<Country> countries, String title) {
        System.out.println("\n**********************************************");
        System.out.println("** " + title.toUpperCase() + " **");
        System.out.println("**********************************************");
        printReportHeader();

        if (countries == null || countries.isEmpty()) {
            System.out.println("No data available.");
            return;
        }

        for (Country country : countries) {
            if (country == null) {
                System.out.println("Encountered a null country in the list");
                continue;
            }
            System.out.printf("%-5s %-40s %-15s %-30s %-15s %-30s%n",
                    country.getCode(), country.getName(), country.getContinent(),
                    country.getRegion(), numberFormat.format(country.getPopulation()),
                    country.getCapitalName());
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
    }

    /**
     * Get all countries by population
     */
    public void printAllCountriesByPopulation() {
        List<Country> allCountries = countryDAO.getAllCountriesByPopulation();
        printCountryReport(allCountries, "1) All countries by population");
    }

    /**
     * Get countries by continent
     *
     * @param continent The name of the continent
     */
    public void printAllCountriesByContinent(String continent) {
        List<Country> countriesInContinent = countryDAO.getCountriesByContinent(continent);
        printCountryReport(countriesInContinent, "2) All countries in " + continent + " by population");
    }

    /**
     * Get countries by region
     *
     * @param region The name of the region
     */
    public void printAllCountriesByRegion(String region) {
        List<Country> countriesInRegion = countryDAO.getCountriesByRegion(region);
        printCountryReport(countriesInRegion, "3) All countries in " + region + " by population");
    }

    /**
     * Get top N populated countries
     *
     * @param N Number of top populated countries to retrieve
     */
    public void printTopNCountries(int N) {
        List<Country> topNCountries = countryDAO.getTopNPopulatedCountries(N);
        printCountryReport(topNCountries, "4) Top " + N + " populated countries");
    }

    /**
     * Get top N populated countries in a continent
     *
     * @param N         Number of top populated countries
     * @param continent The continent name
     */
    public void printTopNCountriesByContinent(int N, String continent) {
        List<Country> topNInContinent = countryDAO.getTopNPopulatedCountriesInContinent(continent, N);
        printCountryReport(topNInContinent, "5) Top " + N + " populated countries in " + continent);
    }

    /**
     * Get top N populated countries in a region
     *
     * @param N      Number of top populated countries
     * @param region The region name
     */
    public void printTopNCountriesByRegion(int N, String region) {
        List<Country> topNInRegion = countryDAO.getTopNPopulatedCountriesInRegion(region, N);
        printCountryReport(topNInRegion, "6) Top " + N + " populated countries in " + region);
    }
}
