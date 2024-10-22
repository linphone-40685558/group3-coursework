package com.napier.gp3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @LanguageDAO which will make generate query from world
 */
public class LanguageDAO {
    /**
     * @con connection for LanguageDAO
     */
    private final Connection con;

    /**
     * Language Data Access Object Constructor
     *
     * @param connection
     */
    public LanguageDAO(Connection connection) {
        this.con = connection;
    }
    /**
     * 32 Method to get the number of people who can speak desire languages
     * (Chinese, English, Hindi, Spanish, Arabic) and their percentage of the world population.
     *
     * @return
     */
    public List<Language> getLanguagesByNumberOfPeople() {
        List<Language> languages = new ArrayList<>();
        try {
            // Query to total number of people who spoke in selected language, ordered by the number of people in descending order
            String strSelect = "SELECT language, SUM(country.population) AS numberOfPeople " +
                    "FROM countrylanguage " +
                    "JOIN country ON countrylanguage.CountryCode = country.Code " +
                    "WHERE language IN ('Chinese', 'English', 'Hindi', 'Spanish', 'Arabic') " +
                    "GROUP BY language " +
                    "ORDER BY numberOfPeople DESC";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            ResultSet rset = pstmt.executeQuery();

            // Get the total world population
            long worldPopulation = getTotalWorldPopulation();
            while (rset.next()) {
                languages.add(new Language(
                        rset.getString("language"),
                        rset.getLong("numberOfPeople"),
                        (rset.getLong("numberOfPeople") / (double) worldPopulation) * 100
                ));
            }
        } catch (SQLException e) {
            System.out.println("Failed to get total number of people who speak in selected languages: " + e.getMessage());
        }
        return languages;
    }

    /**
     * Method to get the total world population.
     *
     * @return the total population of the world
     */
    private long getTotalWorldPopulation() {
        long population = 0;
        try {
            String strSelect = "SELECT SUM(population) AS total_population FROM country";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            ResultSet rset = pstmt.executeQuery();

            if (rset.next()) {
                population = rset.getLong("total_population");
            }
        } catch (SQLException e) {
            System.out.println("Failed to get total world population: " + e.getMessage());
        }
        return population;
    }
}
