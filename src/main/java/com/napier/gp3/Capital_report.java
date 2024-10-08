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
        List<Capital> allCapitalCities = capitalDAO.getAllCapitalCitiesByPopulation();
        for (Capital city : allCapitalCities) {
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
        List<Capital> capitalCitiesInContinent = capitalDAO.getCapitalCitiesByContinent(continent);
        for (Capital city : capitalCitiesInContinent) {
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
        List<Capital> capitalCitiesInRegion = capitalDAO.getCapitalCitiesByRegion(region);
        for (Capital city : capitalCitiesInRegion) {
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
        List<Capital> topNCapitals = capitalDAO.getTopNPopulatedCapitalCitiesInWorld(N);
        for (Capital city : topNCapitals) {
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
        List<Capital> topNCapitalsInContinent = capitalDAO.getTopNPopulatedCapitalCitiesInContinent(continent, N);
        for (Capital city : topNCapitalsInContinent) {
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
        List<Capital> topNCapitalsInRegion = capitalDAO.getTopNPopulatedCapitalCitiesInRegion(region, N);
        for (Capital city : topNCapitalsInRegion) {
            System.out.printf("%-40s %-40s %-30s%n",
                    city.getName(), city.getCountry(), numberFormat.format(city.getPopulation())); // Format population with commas
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
    }
}
