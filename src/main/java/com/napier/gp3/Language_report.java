package com.napier.gp3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;


public class Language_report {
    public LanguageDAO languageDAO;
    private final NumberFormat numberFormat;

    /**
     * Constructor to initialize LanguageDAO with a connection.
     *
     * @param con Connection object
     */
    public Language_report(Connection con) {
        this.languageDAO = new LanguageDAO(con);
        this.numberFormat = NumberFormat.getInstance(Locale.US); // Format numbers with commas
    }

    /**
     * Utility method to print a header for the language report
     */
    private void printReportHeader() {
        System.out.printf("%-20s %-30s %-30s%n", "Language", "Number of People", "Percentage of World Population");
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
    }

    /**
     * @param languages Languages list
     * @param filename  Markdown file name
     * @param title     Table title
     * @param append    To be appended to md or not
     */
    public void outputLanguagesByNumberOfPeopleMarkdown(List<Language> languages, String filename, String title, boolean append) {
        if (languages == null || languages.isEmpty()) {
            System.out.println("No languages available.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("\r\n# ").append(title).append("\r\n\r\n");
        sb.append("| Language | Number of People | Population Percentage |\r\n");
        sb.append("| --- | --- | --- |\r\n");

        // Loop
        for (Language language : languages) {
            if (language == null) continue;
            sb.append("| ")
                    .append(language.getLanguage()).append(" | ")
                    .append(numberFormat.format(language.getNumberOfPeople())).append(" | ")
                    .append(String.format("%.2f%%", language.getPopulation_percentage())).append(" |\r\n");
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
     * 32) Get all total number of people who speak in select language
     */
    public void printLanguageReport(List<Language> languages, String title) {
        System.out.println("**********************************************");
        System.out.println("** " + title.toUpperCase() + " **");
        System.out.println("**********************************************");
        printReportHeader();

        if (languages == null || languages.isEmpty()) {
            System.out.println("No data available.");
            return;
        }

        for (Language language : languages) {

            if (language == null) {
                System.out.println("Encountered a null language in the list");
                continue;
            }

            System.out.printf("%-20s %-30s %-6.2f%%%n",
                    language.getLanguage(),
                    numberFormat.format(language.getNumberOfPeople()),
                    language.getPopulation_percentage());
        }
    }

    public void printLanguagesByNumberOfPeople() {
        List<Language> languages = languageDAO.getLanguagesByNumberOfPeople();
        printLanguageReport(languages, "32) NUMBER OF PEOPLE WHO SPEAK IN SELECTED LANGUAGE");
        outputLanguagesByNumberOfPeopleMarkdown(languages, "Language_Report.md", "32) NUMBER OF PEOPLE WHO SPEAK IN SELECTED LANGUAGE", true);
    }

}
