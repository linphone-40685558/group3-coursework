package com.napier.gp3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EachPopulationDAO {

    private Connection con;

    public EachPopulationDAO(Connection connection) { this.con = connection; }

    /**
     * Get population for every continent
     * @return
     */
    public List<Population> getPopulationByEachContinent() {
        List<Population> populations = new ArrayList<>();

        try {
            String strSelect = "SELECT country.Continent AS Continent, " +
                    "SUM(country.Population) AS TotalPopulation, " +
                    "(SELECT SUM(city.Population) FROM city JOIN country ON city.CountryCode = country.Code WHERE country.Continent = Continent) AS UrbanPopulation " +
                    "FROM country GROUP BY country.Continent";

            PreparedStatement pstmt = con.prepareStatement(strSelect);
            ResultSet rset = pstmt.executeQuery();

            // Iterate over each continent's result
            while (rset.next()) {
                String continent = rset.getString("Continent");
                long totalPopulation = rset.getLong("TotalPopulation");
                long urbanPopulation = rset.getLong("UrbanPopulation");
                long ruralPopulation = totalPopulation - urbanPopulation;

                // Add to your list of populations
                populations.add(new Population(
                        continent,
                        totalPopulation,
                        urbanPopulation,
                        ruralPopulation
                ));
            }
        } catch (SQLException e) {
            System.out.println("Failed to get population by continent: " + e.getMessage());
        }
        return populations;
    }


}
