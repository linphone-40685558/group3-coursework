package com.napier.gp3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
        this.numberFormat = NumberFormat.getInstance(Locale.US);
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
     * Outputs the country list to a Markdown file, with an option to append.
     *
     * @param countries Countries list
     * @param filename  Markdown file name
     * @param title     Table title
     * @param append    To be appended to md or not
     */
    public void outputCountriesByPopulationMarkdown(List<Country> countries, String filename, String title, boolean append) {
        if (countries == null || countries.isEmpty()) {
            System.out.println("No countries available.");
            return;
        }

        StringBuilder sb = new StringBuilder(200);
        sb.append("\r\n# ").append(title).append("\r\n\r\n")
                .append("| Country Code | Country Name | Continent | Region | Population | Capital |\r\n| --- | --- | --- | --- | --- | --- |\r\n");

        // Loop
        for (Country country : countries) {
            if (country == null) continue;
            sb.append("| ")
                    .append(country.getCode()).append(" | ")
                    .append(country.getName()).append(" | ")
                    .append(country.getContinent()).append(" | ")
                    .append(country.getRegion()).append(" | ")
                    .append(numberFormat.format(country.getPopulation())).append(" | ")
                    .append(country.getCapitalName()).append(" |\r\n");
        }

        // Write the content to md file
        try {
            new File("./reports/").mkdir();
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("./reports/" + filename), append));
            writer.write(sb.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Get all countries by population
     */
    public void printAllCountriesByPopulation() {
        List<Country> allCountries = countryDAO.getAllCountriesByPopulation();
        printCountryReport(allCountries, "1) All countries by population");
        outputCountriesByPopulationMarkdown(allCountries, "Country_Report.md", "1) All countries by population", false);
    }

    /**
     * Get countries by continent
     *
     * @param continent The name of the continent
     */
    public void printAllCountriesByContinent(String continent) {
        List<Country> countriesInContinent = countryDAO.getCountriesByContinent(continent);
        printCountryReport(countriesInContinent, "2) All countries in " + continent + " by population");
        outputCountriesByPopulationMarkdown(countriesInContinent, "Country_Report.md", "2) All countries in " + continent + " by population", true);
    }

    /**
     * Get countries by region
     *
     * @param region The name of the region
     */
    public void printAllCountriesByRegion(String region) {
        List<Country> countriesInRegion = countryDAO.getCountriesByRegion(region);
        printCountryReport(countriesInRegion, "3) All countries in " + region + " by population");
        outputCountriesByPopulationMarkdown(countriesInRegion, "Country_Report.md", "3) All countries in " + region + " by popularion", true);
    }

    /**
     * Get top N populated countries
     *
     * @param N Number of top populated countries to retrieve
     */
    public void printTopNCountries(int N) {
        List<Country> topNCountries = countryDAO.getTopNPopulatedCountries(N);
        printCountryReport(topNCountries, "4) Top " + N + " populated countries");
        outputCountriesByPopulationMarkdown(topNCountries, "Country_Report.md", "4) Top " + N + " populated countries", true);
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
        outputCountriesByPopulationMarkdown(topNInContinent, "Country_Report.md", "5) Top " + N + " populated countries in " + continent + " by population", true);
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
        outputCountriesByPopulationMarkdown(topNInRegion, "Country_Report.md", "6) Top " + N + " populated countries in " + region + " by population", true);
    }
}
