package com.napier.gp3;

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
     * @param con
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
     * 32) Get all total number of people who speak in select language
     */
    public void printLanguagesByNumberOfPeople() {
        System.out.println("**********************************************");
        System.out.println("** 32) LANGUAGES BY NUMBER OF PEOPLE WHO SPEAK IN SELECTED LANGUAGES **");
        System.out.println("**********************************************");
        printReportHeader();
        List<Language> languages = languageDAO.getLanguagesByNumberOfPeople();
        for (Language language : languages) {
            System.out.printf("%-20s %-30s %-6.2f%%%n",
                    language.getLanguage(),
                    numberFormat.format(language.getNumberOfPeople()), // Format number of speakers with commas
                    language.getPopulation_percentage());
        }
    }

}
