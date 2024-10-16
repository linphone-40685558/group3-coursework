package com.napier.gp3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EachPopulationDAO {

    private Connection con;

    public EachPopulationDAO(Connection connection) { this.con = connection; }

    /**
     * Get population for every continent
     *
     * @return
     */
    public List<Population> getPopulationByEachContinent() {
        List<Population> populations = new ArrayList<>();

        try {
            // first query for total population
            String strSelect1 = "SELECT country.Continent AS continent, SUM(country.Population) AS TotalPopulation " +
                    "FROM country GROUP BY country.Continent";

            PreparedStatement pstmt1 = con.prepareStatement(strSelect1);
            ResultSet rset1 = pstmt1.executeQuery();

            // Iterate over total population each continent's result
            while (rset1.next()) {
                String continent = rset1.getString("Continent");
                long totalPopulation = rset1.getLong("TotalPopulation");

                long urbanPopulation = 0;
                float urbanPercentage = 0;
                float ruralPercentage = 0;

                // second query for urban population
                String strSelect2 = "SELECT SUM(city.Population) AS UrbanPopulation FROM city JOIN country ON city.CountryCode = country.Code WHERE country.Continent = ? ";

                PreparedStatement pstmt2 = con.prepareStatement(strSelect2);
                pstmt2.setString(1, continent);
                ResultSet rset2 = pstmt2.executeQuery();

                if (rset2.next()) {
                    urbanPopulation = rset2.getLong("UrbanPopulation");
                }

                // rural population each continent's result
                long ruralPopulation = totalPopulation - urbanPopulation;

                // Percentage calculation for urban population and rural population
                if (totalPopulation > 0) {
                    urbanPercentage = ((float) urbanPopulation / totalPopulation) * 100;
                    ruralPercentage = ((float) ruralPopulation / totalPopulation) * 100;
                }
                populations.add(new Population(continent, totalPopulation, urbanPopulation, ruralPopulation, urbanPercentage, ruralPercentage));
            }
        } catch (SQLException e) {
            System.out.println("Failed to get population by continent: " + e.getMessage());
        }
        return populations;
    }

    /**
     * get population for every region
     *
     * @return
     */

    public List<Population> getPopulationByEachRegion() {
        List<Population> populations = new ArrayList<>();

        try {
            // first query for total population
            String strSelect1 = "SELECT country.Region AS Region, SUM(country.Population) AS TotalPopulation " +
                    "FROM country GROUP BY country.Region";

            PreparedStatement pstmt1 = con.prepareStatement(strSelect1);
            ResultSet rset1 = pstmt1.executeQuery();

            // Iterate over total population each region's result
            while (rset1.next()) {
                String region = rset1.getString("Region");
                long totalPopulation = rset1.getLong("TotalPopulation");

                long urbanPopulation = 0;
                float urbanPercentage = 0;
                float ruralPercentage = 0;

                // second query for urban population
                String strSelect2 = "SELECT SUM(city.Population) AS UrbanPopulation FROM city JOIN country ON city.CountryCode = country.Code WHERE country.Region = ? ";

                PreparedStatement pstmt2 = con.prepareStatement(strSelect2);
                pstmt2.setString(1, region);
                ResultSet rset2 = pstmt2.executeQuery();

                if (rset2.next()) {
                    urbanPopulation = rset2.getLong("UrbanPopulation");
                }

                // rural population each continent's result
                long ruralPopulation = totalPopulation - urbanPopulation;

                // Percentage calculation for urban population and rural population
                if (totalPopulation > 0) {
                    urbanPercentage = ((float) urbanPopulation / totalPopulation) * 100;
                    ruralPercentage = ((float) ruralPopulation / totalPopulation) * 100;
                }
                populations.add(new Population(region, totalPopulation, urbanPopulation, ruralPopulation, urbanPercentage, ruralPercentage));
            }
        } catch (SQLException e) {
            System.out.println("Failed to get population by region: " + e.getMessage());
        }
        return populations;
    }

}



