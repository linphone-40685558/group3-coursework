package com.napier.gp3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class EachPopulation_report {

    public EachPopulationDAO eachPopulationDAO;
    private final NumberFormat numberFormat;

    public EachPopulation_report(Connection con) {
        this.eachPopulationDAO = new EachPopulationDAO(con);
        this.numberFormat = NumberFormat.getNumberInstance();
    }

    /**
     * Printing report header.
     */
    private void printReportHeader() {
        System.out.printf("%-40s %-15s %-30s %-15s%n", "Location", "Total Population", "Urban Population", "Rural Population");
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
    }


    /**
     * Printing population data.
     *
     * @param populations List of population data
     * @param title      Title of the report
     */
    private void printEachPopulationReport(List<Population> populations, String title) {
        System.out.println("\n**********************************************");
        System.out.println("** Population " + title + " **");
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

            System.out.printf("%-40s %-15s %-30s %-15s%n",
                    population.getName(),
                    numberFormat.format(population.getTotalPopulation()),
                    numberFormat.format(population.getUrbanPopulation()),
                    numberFormat.format(population.getRuralPopulation()));
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
    }

    /**
     * Outputs the population data to a Markdown file, with an option to append.
     *
     * @param populations List of population data to output.
     * @param filename    Name of the file to save the output.
     * @param title       Title to be included in the markdown report.
     * @param append      Whether to append to the existing file.
     */
    public void outputEachPopulationMarkdown(List<Population> populations, String filename, String title, boolean append) {
        if (populations == null || populations.isEmpty()) {
            System.out.println("No population data available.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("\r\n# ").append("Population of " + title).append("\r\n\r\n");
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
     *
     * Get population for every continent
     *
     * there is no param
     */
    public void printPopulationByEachContinent() {
        List<Population> eachContinentPopulation = eachPopulationDAO.getPopulationByEachContinent();
        printEachPopulationReport(eachContinentPopulation, "1) Population For Each Continent");
        outputEachPopulationMarkdown(eachContinentPopulation, "Population_Report.md", "1) Population For Each Continent ", true);
    }
}
