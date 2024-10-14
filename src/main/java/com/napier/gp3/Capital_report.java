package com.napier.gp3;

import java.sql.Connection;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

/**
 * The class has printing methods for capital city reports.
 */
public class Capital_report {
    public CapitalDAO capitalDAO;
    private final NumberFormat numberFormat;

    /**
     * Constructor
     *
     * @param connection Connection object
     */
    public Capital_report(Connection connection) {
        this.capitalDAO = new CapitalDAO(connection);
        this.numberFormat = NumberFormat.getInstance(Locale.US); // Set number format for US style (comma separated)
    }

    /**
     * Printing header
     */
    private void printReportHeader() {
        System.out.printf("%-40s %-40s  %-30s%n", "Name", "Country", "Population");
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
    }

    /**
     * Printing capital city data
     *
     * @param capitals List of capital cities
     * @param title    Title
     */
    private void printCapitalReport(List<Capital> capitals, String title) {
        System.out.println("\n**********************************************");
        System.out.println("** " + title.toUpperCase() + " **");
        System.out.println("**********************************************");
        printReportHeader();

        if (capitals == null || capitals.isEmpty()) {
            System.out.println("No data available.");
            return;
        }

        for (Capital capital : capitals) {
            if (capital == null) {
                System.out.println("Encountered a null capital in the list");
                continue;
            }
            System.out.printf("%-40s %-40s %-30s%n",
                    capital.getName(), capital.getCountry(),
                    numberFormat.format(capital.getPopulation()));
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
    }

    /**
     * Get all capital cities by population
     */
    public void printCapitalsByPopulation() {
        List<Capital> allCapitals = capitalDAO.getAllCapitalCitiesByPopulation();
        printCapitalReport(allCapitals, "17) All capital cities by population");
    }

    /**
     * Get capital cities by continent
     *
     * @param continent The name of the continent
     */
    public void printCapitalsByContinent(String continent) {
        List<Capital> capitals = capitalDAO.getCapitalCitiesByContinent(continent);
        printCapitalReport(capitals, "18) Capitals in " + continent + " by population");
    }

    /**
     * Get capital cities by region
     *
     * @param region The name of the region
     */
    public void printCapitalsByRegion(String region) {
        List<Capital> capitals = capitalDAO.getCapitalCitiesByRegion(region);
        printCapitalReport(capitals, "19) Capitals in " + region + " by population");
    }

    /**
     * Get top N populated capital cities in the world
     *
     * @param N Number of top populated capitals
     */
    public void printTopNPopulatedCapitalCitiesInWorld(int N) {
        List<Capital> capitals = capitalDAO.getTopNPopulatedCapitalCitiesInWorld(N);
        printCapitalReport(capitals, "20) Top " + N + " populated capital cities in the world");
    }

    /**
     * Get top N populated capital cities in a continent
     *
     * @param continent The name of the continent
     * @param N         Number of top populated capitals
     */
    public void printTopNPopulatedCapitalCitiesInContinent(int N, String continent) {
        List<Capital> capitals = capitalDAO.getTopNPopulatedCapitalCitiesInContinent(continent, N);
        printCapitalReport(capitals, "21) Top " + N + " populated capital cities in " + continent);
    }

    /**
     * Get top N populated capital cities in a region
     *
     * @param region The name of the region
     * @param N      Number of top populated capitals
     */
    public void printTopNPopulatedCapitalCitiesInRegion(int N, String region) {
        List<Capital> capitals = capitalDAO.getTopNPopulatedCapitalCitiesInRegion(region, N);
        printCapitalReport(capitals, "22) Top " + N + " populated capital cities in " + region);
    }
}
