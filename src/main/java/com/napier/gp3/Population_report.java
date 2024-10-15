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
 * This class handles printing and outputting population reports.
 */
public class Population_report {
    public PopulationDAO populationDAO;
    private final NumberFormat numberFormat;

    /**
     * Constructor
     *
     * @param con Connection object
     */
    public Population_report(Connection con) {
        this.populationDAO = new PopulationDAO(con);
        this.numberFormat = NumberFormat.getInstance(Locale.US); // Set number format for US style (comma separated)
    }

    /**
     * Printing report header.
     */
    private void printReportHeader() {
        System.out.printf("%-15s %-20s %-20s %-15s%n", "Location", "Total Population", "Urban Population", "Rural Population");
        System.out.println("--------------------------------------------------------------------------");
    }

    /**
     * Printing population data.
     *
     * @param populations List of population data
     * @param title       Title of the report
     */
    private void printPopulationReport(List<Population> populations, String title) {
        System.out.println("\n**********************************************");
        System.out.println("** " + title.toUpperCase() + " **");
        System.out.println("**********************************************");
        printReportHeader();

        if (populations == null || populations.isEmpty()) {
            System.out.println("No data available.");
            return;
        }

        for (Population population : populations) {
            if (population == null) {
                System.out.println("Encountered a null population in the list");
                continue;
            }

            System.out.printf("%-15s %-20s %-20s %-15s%n",
                    population.getName(),
                    numberFormat.format(population.getTotalPopulation()),
                    numberFormat.format(population.getUrbanPopulation()),
                    numberFormat.format(population.getRuralPopulation()));
        }
        System.out.println("--------------------------------------------------------------------------");
    }

    /**
     * Outputs the population data to a Markdown file, with an option to append.
     *
     * @param populations List of population data to output.
     * @param filename    Name of the file to save the output.
     * @param title       Title to be included in the markdown report.
     * @param append      Whether to append to the existing file.
     */
    public void outputPopulationMarkdown(List<Population> populations, String filename, String title, boolean append) {
        if (populations == null || populations.isEmpty()) {
            System.out.println("No population data available.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("\r\n# ").append(title.toUpperCase()).append("\r\n\r\n");
        sb.append("| Location | Total Population | Urban Population | Rural Population |\r\n");
        sb.append("| --- | --- | --- | --- |\r\n");

        // Loop through the list of populations
        for (Population population : populations) {
            if (population == null) continue;

            sb.append("| ")
                    .append(population.getName()).append(" | ")
                    .append(numberFormat.format(population.getTotalPopulation())).append(" | ")
                    .append(numberFormat.format(population.getUrbanPopulation())).append(" | ")
                    .append(numberFormat.format(population.getRuralPopulation())).append(" |\r\n");
        }

        // Write the content to the file
        try {
            new File("./reports/").mkdirs(); // Ensure directory exists
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("./reports/" + filename), append))) {
                writer.write(sb.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get total world population report.
     */
    public void printWorldPopulation() {
        List<Population> worldPopulation = populationDAO.getWorldPopulation();
        printPopulationReport(worldPopulation, "26) Total World Population");
        outputPopulationMarkdown(worldPopulation, "Population_Report.md", "1) Total World Population", false);
    }

    /**
     * Get population by continent.
     *
     * @param continent The name of the continent
     */
    public void printPopulationByContinent(String continent) {
        List<Population> continentPopulation = populationDAO.getPopulationByContinent(continent);
        printPopulationReport(continentPopulation, "27) Total Population in " + continent);
        outputPopulationMarkdown(continentPopulation, "Population_Report.md", "27) Total Population in " + continent, true);
    }

    /**
     * Get population by region.
     *
     * @param region The name of the region
     */
    public void printPopulationByRegion(String region) {
        List<Population> regionPopulation = populationDAO.getPopulationByRegion(region);
        printPopulationReport(regionPopulation, "28) Total Population in " + region);
        outputPopulationMarkdown(regionPopulation, "Population_Report.md", "28) Total Population in " + region, true);
    }

    /**
     * Get population by country.
     *
     * @param countryCode The name of the country
     */
    public void printPopulationByCountry(String countryCode) {
        List<Population> countryPopulation = populationDAO.getPopulationByCountry(countryCode);
        printPopulationReport(countryPopulation, "29) Total Population in " + countryCode);
        outputPopulationMarkdown(countryPopulation, "Population_Report.md", "29) Total Population in " + countryCode, true);
    }

    /**
     * Get population by district.
     *
     * @param district The name of the district
     */
    public void printPopulationByDistrict(String district) {
        List<Population> districtPopulation = populationDAO.getPopulationByDistrict(district);
        printPopulationReport(districtPopulation, "30) Total Population in " + district);
        outputPopulationMarkdown(districtPopulation, "Population_Report.md", "30) Total Population in " + district, true);
    }

    /**
     * Get population by city.
     *
     * @param cityName The name of the city
     */
    public void printPopulationByCity(String cityName) {
        List<Population> cityPopulation = populationDAO.getPopulationByCity(cityName);
        printPopulationReport(cityPopulation, "31) Total Population in " + cityName);
        outputPopulationMarkdown(cityPopulation, "Population_Report.md", "31) Total Population in " + cityName, true);
    }
}
