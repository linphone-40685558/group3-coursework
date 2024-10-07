package com.napier.gp3;

import java.sql.Connection;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class Capital_report {
    public CapitalDAO capitalDAO;
    private final NumberFormat numberFormat;

    /**
     * Capital report constructor
     *
     * @param connection
     */
    public Capital_report(Connection connection) {
        this.capitalDAO = new CapitalDAO(connection);
        this.numberFormat = NumberFormat.getInstance(Locale.US); // Set number format for US style (comma separated)
    }

    /**
     * Printing headers
     */
    private void printReportHeader() {
        System.out.printf("%-40s %-40s  %-30s%n", "Name", "Country", "Population");
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
    }

    /**
     * 17) Get all capital cities by population
     */
    public void printCapitalsByPopulation() {
        System.out.println("**********************************************");
        System.out.println("** 17) ALL CAPITAL CITIES BY POPULATION **");
        System.out.println("**********************************************");
        printReportHeader();
        List<City> allCapitalCities = capitalDAO.getAllCapitalCitiesByPopulation();
        for (City city : allCapitalCities) {
            System.out.printf("%-40s %-40s %-30s%n",
                    city.getName(), city.getCountry(), numberFormat.format(city.getPopulation())); // Format population with commas
        }
    }

    /**
     * 18) Get capital cities by continent (example: "Asia")
     *
     * @param continent
     */
    public void printCapitalsByContinent(String continent) {
        System.out.println("**********************************************");
        System.out.println("** 18) CAPITAL CITIES IN CONTINENT '" + continent.toUpperCase() + "' BY POPULATION **");
        System.out.println("**********************************************");
        printReportHeader();
        List<City> capitalCitiesInContinent = capitalDAO.getCapitalCitiesByContinent(continent);
        for (City city : capitalCitiesInContinent) {
            System.out.printf("%-40s %-40s %-30s%n",
                    city.getName(), city.getCountry(), numberFormat.format(city.getPopulation())); // Format population with commas
        }
    }

    /**
     * 19) Get capital cities by region (example: "Southeast Asia")
     *
     * @param region
     */
    public void printCapitalsByRegion(String region) {
        System.out.println("**********************************************");
        System.out.println("** 19) CAPITAL CITIES IN REGION '" + region.toUpperCase() + "' BY POPULATION **");
        System.out.println("**********************************************");
        printReportHeader();
        List<City> capitalCitiesInRegion = capitalDAO.getCapitalCitiesByRegion(region);
        for (City city : capitalCitiesInRegion) {
            System.out.printf("%-40s %-40s %-30s%n",
                    city.getName(), city.getCountry(), numberFormat.format(city.getPopulation())); // Format population with commas
        }
    }

    /**
     * 20) Get top N populated capital cities in a world
     *
     * @param N
     */
    public void printTopNPopulatedCapitalCitiesInWorld(int N) {
        System.out.println("\n**********************************************");
        System.out.println("** 20) TOP " + N + " POPULATED CAPITAL CITIES IN THE WORLD **");
        System.out.println("**********************************************");
        printReportHeader();
        List<City> topNCapitals = capitalDAO.getTopNPopulatedCapitalCitiesInWorld(N);
        for (City city : topNCapitals) {
            System.out.printf("%-40s %-40s %-30s%n",
                    city.getName(), city.getCountry(), numberFormat.format(city.getPopulation())); // Format population with commas
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
    }

    /**
     * 21) Get top N populated capital cities in a region
     *
     * @param N
     * @param continent
     */
    public void printTopNPopulatedCapitalCitiesInContinent(int N, String continent) {
        System.out.println("\n**********************************************");
        System.out.println("** 21) TOP " + N + " POPULATED CAPITAL CITIES IN " + continent.toUpperCase() + " **");
        System.out.println("**********************************************");
        printReportHeader();
        List<City> topNCapitalsInContinent = capitalDAO.getTopNPopulatedCapitalCitiesInContinent(continent, N);
        for (City city : topNCapitalsInContinent) {
            System.out.printf("%-40s %-40s %-30s%n",
                    city.getName(), city.getCountry(), numberFormat.format(city.getPopulation())); // Format population with commas
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
    }

    /**
     * 22) Get top N populated capital cities in a region
     *
     * @param N
     * @param region
     */
    public void printTopNPopulatedCapitalCitiesInRegion(int N, String region) {
        System.out.println("\n**********************************************");
        System.out.println("** 22) TOP " + N + " POPULATED CAPITAL CITIES IN " + region.toUpperCase() + " **");
        System.out.println("**********************************************");
        printReportHeader();
        List<City> topNCapitalsInRegion = capitalDAO.getTopNPopulatedCapitalCitiesInRegion(region, N);
        for (City city : topNCapitalsInRegion) {
            System.out.printf("%-40s %-40s %-30s%n",
                    city.getName(), city.getCountry(), numberFormat.format(city.getPopulation())); // Format population with commas
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
    }
}
