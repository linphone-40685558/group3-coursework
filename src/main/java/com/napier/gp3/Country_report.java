package com.napier.gp3;

import java.sql.Connection;
import java.util.List;

public class Country_report {
    private CountryDAO countryDAO;

    // Constructor to initialize CountryDAO with a connection
    public Country_report(Connection con) {
        this.countryDAO = new CountryDAO(con);
    }

    // Utility method to print a header for the country report
    private void printReportHeader() {
        System.out.printf("%-5s %-40s %-15s %-30s %-15s %-30s%n", "Code", "Name", "Continent", "Region", "Population", "Capital");
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
    }

    // 1. Get all countries by population
    public void printAllCountriesByPopulation() {
        System.out.println("**********************************************");
        System.out.println("** 1) ALL COUNTRIES BY POPULATION **");
        System.out.println("**********************************************");
        printReportHeader();
        List<Country> allCountries = countryDAO.getAllCountriesByPopulation();
        for (Country country : allCountries) {
            System.out.printf("%-5s %-40s %-15s %-30s %-15s %-30s%n",
                    country.getCode(), country.getName(), country.getContinent(),
                    country.getRegion(), country.getPopulation(), country.getCapital());
        }
    }

    // 2. Get countries by continent (example: "Asia")
    public void printAllCountriesByContinent(String continent) {
        System.out.println("\n**********************************************");
        System.out.println("** 2) ALL COUNTRIES IN " + continent.toUpperCase() + " BY POPULATION **");
        System.out.println("**********************************************");
        printReportHeader();
        List<Country> countriesInContinent = countryDAO.getCountriesByContinent(continent);
        for (Country country : countriesInContinent) {
            System.out.printf("%-5s %-40s %-15s %-30s %-15s %-30s%n",
                    country.getCode(), country.getName(), country.getContinent(),
                    country.getRegion(), country.getPopulation(), country.getCapital());
        }
    }

    // 3. Get countries by region (example: "Southeast Asia")
    public void printAllCountriesByRegion(String region) {
        System.out.println("\n**********************************************");
        System.out.println("** 3) ALL COUNTRIES IN " + region.toUpperCase() + " BY POPULATION **");
        System.out.println("**********************************************");
        printReportHeader();
        List<Country> countriesInRegion = countryDAO.getCountriesByRegion(region);
        for (Country country : countriesInRegion) {
            System.out.printf("%-5s %-40s %-15s %-30s %-15s %-30s%n",
                    country.getCode(), country.getName(), country.getContinent(),
                    country.getRegion(), country.getPopulation(), country.getCapital());
        }
    }

    // 4. Get top N populated countries in the world (e.g., top 5)
    public void printTopNCountries(int N) {
        System.out.println("\n**********************************************");
        System.out.println("** 4) TOP " + N + " POPULATED COUNTRIES **");
        System.out.println("**********************************************");
        printReportHeader();
        List<Country> topNCountries = countryDAO.getTopNPopulatedCountries(N);
        for (Country country : topNCountries) {
            System.out.printf("%-5s %-40s %-15s %-30s %-15s %-30s%n",
                    country.getCode(), country.getName(), country.getContinent(),
                    country.getRegion(), country.getPopulation(), country.getCapital());
        }
    }

    // 5. Get top N populated countries in a continent (e.g., Asia, top 5)
    public void printTopNCountriesByContinent(int N, String continent) {
        System.out.println("\n**********************************************");
        System.out.println("** 5) TOP " + N + " POPULATED COUNTRIES IN " + continent.toUpperCase() + " **");
        System.out.println("**********************************************");
        printReportHeader();
        List<Country> topNInContinent = countryDAO.getTopNPopulatedCountriesInContinent(continent, N);
        for (Country country : topNInContinent) {
            System.out.printf("%-5s %-40s %-15s %-30s %-15s %-30s%n",
                    country.getCode(), country.getName(), country.getContinent(),
                    country.getRegion(), country.getPopulation(), country.getCapital());
        }
    }

    // 6. Get top N populated countries in a region (e.g., Southeast Asia, top 5)
    public void printTopNCountriesByRegion(int N, String region) {
        System.out.println("\n**********************************************");
        System.out.println("** 6) TOP " + N + " POPULATED COUNTRIES IN " + region.toUpperCase() + " **");
        System.out.println("**********************************************");
        printReportHeader();
        List<Country> topNInRegion = countryDAO.getTopNPopulatedCountriesInRegion(region, N);
        for (Country country : topNInRegion) {
            System.out.printf("%-5s %-40s %-15s %-30s %-15s %-30s%n",
                    country.getCode(), country.getName(), country.getContinent(),
                    country.getRegion(), country.getPopulation(), country.getCapital());
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
    }
}
