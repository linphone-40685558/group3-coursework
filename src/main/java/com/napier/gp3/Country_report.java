package com.napier.gp3;

import java.sql.Connection;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

/**
 * The Country_report class provides printing methods to generate country reports.
 */
public class Country_report {
    public CountryDAO countryDAO;
    private final NumberFormat numberFormat;

    /**
     * Constructor to initialize CountryDAO with a connection
     *
     * @param con
     */
    public Country_report(Connection con) {
        this.countryDAO = new CountryDAO(con);
        this.numberFormat = NumberFormat.getInstance(Locale.US); // Set number format for US style (comma separated)
    }

    /**
     * Utility method to print a header for the country report
     */
    private void printReportHeader() {
        System.out.printf("%-5s %-40s %-15s %-30s %-15s %-30s%n", "Code", "Name", "Continent", "Region", "Population", "Capital");
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
    }

    /**
     * 1) Get all countries by population
     */
    public void printAllCountriesByPopulation() {
        System.out.println("**********************************************");
        System.out.println("** 1) ALL COUNTRIES BY POPULATION **");
        System.out.println("**********************************************");
        printReportHeader();

        List<Country> allCountries = countryDAO.getAllCountriesByPopulation();

        if (allCountries == null) {
            System.out.println("No data available (null)");
            return;
        }

        if (allCountries.isEmpty()) {
            System.out.println("No countries found (empty list)");
            return;
        }

        for (Country country : allCountries) {
            if (country == null) {
                System.out.println("Encountered a null country in the list");
                continue;
            }
            System.out.printf("%-5s %-40s %-15s %-30s %-15s %-30s%n",
                    country.getCode(), country.getName(), country.getContinent(),
                    country.getRegion(), numberFormat.format(country.getPopulation()),
                    country.getCapitalName());
        }
    }


    /**
     * 2) Get countries by continent
     *
     * @param continent
     */
    public void printAllCountriesByContinent(String continent) {
        System.out.println("\n**********************************************");
        System.out.println("** 2) ALL COUNTRIES IN " + continent.toUpperCase() + " BY POPULATION **");
        System.out.println("**********************************************");
        printReportHeader();

        List<Country> countriesInContinent = countryDAO.getCountriesByContinent(continent);

        if (countriesInContinent == null) {
            System.out.println("No country data by continent available (null)");
            return;
        }

        if (countriesInContinent.isEmpty()) {
            System.out.println("No countries found in " + continent);
            return;
        }

        for (Country country : countriesInContinent) {
            if (country == null) {
                System.out.println("Encountered a null country in the list");
                continue;
            }
            System.out.printf("%-5s %-40s %-15s %-30s %-15s %-30s%n",
                    country.getCode(), country.getName(), country.getContinent(),
                    country.getRegion(), numberFormat.format(country.getPopulation()),
                    country.getCapitalName());
        }
    }


    /**
     * 3) Get countries by region
     *
     * @param region
     */
    public void printAllCountriesByRegion(String region) {
        System.out.println("\n**********************************************");
        System.out.println("** 3) ALL COUNTRIES IN " + region.toUpperCase() + " BY POPULATION **");
        System.out.println("**********************************************");
        printReportHeader();

        List<Country> countriesInRegion = countryDAO.getCountriesByRegion(region);

        if (countriesInRegion == null) {
            System.out.println("No data available (null)");
            return;
        }

        if (countriesInRegion.isEmpty()) {
            System.out.println("No countries found in " + region);
            return;
        }

        for (Country country : countriesInRegion) {
            if (country == null) {
                System.out.println("Encountered a null country in the list");
                continue;
            }
            System.out.printf("%-5s %-40s %-15s %-30s %-15s %-30s%n",
                    country.getCode(), country.getName(), country.getContinent(),
                    country.getRegion(), numberFormat.format(country.getPopulation()),
                    country.getCapitalName());
        }
    }


    /**
     * 4) Get top N populated countries in the world
     *
     * @param N
     */
    public void printTopNCountries(int N) {
        System.out.println("\n**********************************************");
        System.out.println("** 4) TOP " + N + " POPULATED COUNTRIES **");
        System.out.println("**********************************************");
        printReportHeader();

        List<Country> topNCountries = countryDAO.getTopNPopulatedCountries(N);

        if (topNCountries == null) {
            System.out.println("No data available (null)");
            return;
        }

        if (topNCountries.isEmpty()) {
            System.out.println("No countries found in the top " + N);
            return;
        }

        for (Country country : topNCountries) {
            if (country == null) {
                System.out.println("Encountered a null country in the list");
                continue;
            }
            System.out.printf("%-5s %-40s %-15s %-30s %-15s %-30s%n",
                    country.getCode(), country.getName(), country.getContinent(),
                    country.getRegion(), numberFormat.format(country.getPopulation()),
                    country.getCapitalName());
        }
    }


    /**
     * 5) Get top N populated countries in a continent
     *
     * @param N
     * @param continent
     */
    public void printTopNCountriesByContinent(int N, String continent) {
        System.out.println("\n**********************************************");
        System.out.println("** 5) TOP " + N + " POPULATED COUNTRIES IN " + continent.toUpperCase() + " **");
        System.out.println("**********************************************");
        printReportHeader();

        List<Country> topNInContinent = countryDAO.getTopNPopulatedCountriesInContinent(continent, N);

        if (topNInContinent == null) {
            System.out.println("No data available (null)");
            return;
        }

        if (topNInContinent.isEmpty()) {
            System.out.println("No countries found in the top " + N + " in " + continent);
            return;
        }

        for (Country country : topNInContinent) {
            if (country == null) {
                System.out.println("Encountered a null country in the list");
                continue;
            }
            System.out.printf("%-5s %-40s %-15s %-30s %-15s %-30s%n",
                    country.getCode(), country.getName(), country.getContinent(),
                    country.getRegion(), numberFormat.format(country.getPopulation()),
                    country.getCapitalName());
        }
    }


    /**
     * 6) Get top N populated countries in a region
     *
     * @param N
     * @param region
     */
    public void printTopNCountriesByRegion(int N, String region) {
        System.out.println("\n**********************************************");
        System.out.println("** 6) TOP " + N + " POPULATED COUNTRIES IN " + region.toUpperCase() + " **");
        System.out.println("**********************************************");
        printReportHeader();

        List<Country> topNInRegion = countryDAO.getTopNPopulatedCountriesInRegion(region, N);

        if (topNInRegion == null) {
            System.out.println("No data available (null)");
            return;
        }

        if (topNInRegion.isEmpty()) {
            System.out.println("No countries found in the top " + N + " in " + region);
            return;
        }

        for (Country country : topNInRegion) {
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

}
