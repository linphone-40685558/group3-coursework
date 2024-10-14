package com.napier.gp3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * PopulationDAO has database manipulations to retrieve related information.
 * It has methods to fetch population by world, continent, region, country, and district
 */
public class PopulationDAO {
    private Connection con;

    public PopulationDAO(Connection connection) {
        this.con = connection;
    }

    /** Method to get the total population in world
     *
     * @return
     */
    public long getTotalWorldPopulation() {
        long totalPopulation = 0;
        try {
            String strSelect = "SELECT SUM(Population) AS TotalPopulation FROM country";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            ResultSet rset = pstmt.executeQuery();

            if (rset.next()) {
                totalPopulation = rset.getLong("TotalPopulation");
            }
        } catch (SQLException e) {
            System.out.println("Failed to get total world population: " + e.getMessage());
        }
        return totalPopulation;
    }


    /** Method to get the population in the world
     *
     * @return
     */
    public List<Population> getWorldPopulation() {
        List<Population> populations = new ArrayList<>();
        long worldPopulation = getTotalWorldPopulation();
        try {
            String strSelect = "SELECT SUM(Population) AS TotalPopulation, " +
                    "(SELECT SUM(city.Population) FROM city) AS UrbanPopulation " +
                    "FROM country";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            ResultSet rset = pstmt.executeQuery();

            if (rset.next()) {
                long totalPopulation = rset.getLong("TotalPopulation");
                long urbanPopulation = rset.getLong("UrbanPopulation");
                long ruralPopulation = totalPopulation - urbanPopulation;
                populations.add(new Population("World", totalPopulation, urbanPopulation, ruralPopulation));
            }
        } catch (SQLException e) {
            System.out.println("Failed to get world population: " + e.getMessage());
        }
        return populations;
    }

    /** Method to get total population of continent
     *
     * @param continent
     * @return
     */
    public List<Population> getPopulationByContinent(String continent) {
        List<Population> populations = new ArrayList<>();
        long worldPopulation = getTotalWorldPopulation();
        try {
            String strSelect = "SELECT SUM(country.Population) AS TotalPopulation, " +
                    "(SELECT SUM(city.Population) FROM city JOIN country ON city.CountryCode = country.Code WHERE country.Continent = ?) AS UrbanPopulation " +
                    "FROM country WHERE country.Continent = ?";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            pstmt.setString(1, continent);
            pstmt.setString(2, continent);
            ResultSet rset = pstmt.executeQuery();

            if (rset.next()) {
                long totalPopulation = rset.getLong("TotalPopulation");
                long urbanPopulation = rset.getLong("UrbanPopulation");
                long ruralPopulation = totalPopulation - urbanPopulation;
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


    /** Method to get total population of region
     *
     * @param region
     * @return
     */
    public List<Population> getPopulationByRegion(String region) {
        List<Population> populations = new ArrayList<>();
        long worldPopulation = getTotalWorldPopulation();
        try {
            String strSelect = "SELECT SUM(country.Population) AS TotalPopulation, " +
                    "(SELECT SUM(city.Population) FROM city JOIN country ON city.CountryCode = country.Code WHERE country.Region = ?) AS UrbanPopulation " +
                    "FROM country WHERE country.Region = ?";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            pstmt.setString(1, region);
            pstmt.setString(2, region);
            ResultSet rset = pstmt.executeQuery();

            if (rset.next()) {
                long totalPopulation = rset.getLong("TotalPopulation");
                long urbanPopulation = rset.getLong("UrbanPopulation");
                long ruralPopulation = totalPopulation - urbanPopulation;
                populations.add(new Population(
                        region,
                        totalPopulation,
                        urbanPopulation,
                        ruralPopulation
                ));
            }
        } catch (SQLException e) {
            System.out.println("Failed to get population by region: " + e.getMessage());
        }
        return populations;
    }


    /** Method to get total population of country
     *
     * @param countryCode
     * @return
     */
    public List<Population> getPopulationByCountry(String countryCode) {
        List<Population> populations = new ArrayList<>();
        long worldPopulation = getTotalWorldPopulation();
        try {
            // Updated SQL query to filter by country code instead of country name
            String strSelect = "SELECT country.Name AS CountryName, " +
                    "SUM(country.Population) AS TotalPopulation, " +
                    "(SELECT SUM(city.Population) FROM city WHERE city.CountryCode = country.Code) AS UrbanPopulation " +
                    "FROM country WHERE country.Code = ? GROUP BY country.Code";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            pstmt.setString(1, countryCode);
            ResultSet rset = pstmt.executeQuery();

            if (rset.next()) {
                long totalPopulation = rset.getLong("TotalPopulation");
                long urbanPopulation = rset.getLong("UrbanPopulation");
                long ruralPopulation = totalPopulation - urbanPopulation;

                populations.add(new Population(
                        rset.getString("CountryName"),
                        totalPopulation,
                        urbanPopulation,
                        ruralPopulation
                ));
            }
        } catch (SQLException e) {
            System.out.println("Failed to get population by country: " + e.getMessage());
        }
        return populations;
    }
    /** Method to get total population of a district
     *
     * @param district
     * @return
     */
    public List<Population> getPopulationByDistrict(String district) {
        List<Population> populations = new ArrayList<>();
        long worldPopulation = getTotalWorldPopulation();
        try {
            String strSelect = "SELECT SUM(city.Population) AS UrbanPopulation " +
                    "FROM city WHERE city.District = ?";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            pstmt.setString(1, district);
            ResultSet rset = pstmt.executeQuery();

            if (rset.next()) {
                long urbanPopulation = rset.getLong("UrbanPopulation");
                long totalPopulation = urbanPopulation;
                long ruralPopulation = 0;
                populations.add(new Population(
                        district,
                        totalPopulation,
                        urbanPopulation,
                        ruralPopulation
                ));
            }
        } catch (SQLException e) {
            System.out.println("Failed to get population by district: " + e.getMessage());
        }
        return populations;
    }


    /** Method to get total population of a city
     *
     * @param cityName
     * @return
     */
    public List<Population> getPopulationByCity(String cityName) {
        List<Population> populations = new ArrayList<>();
        long worldPopulation = getTotalWorldPopulation();
        try {
            String strSelect = "SELECT Population FROM city WHERE city.Name = ?";
            PreparedStatement pstmt = con.prepareStatement(strSelect);
            pstmt.setString(1, cityName);
            ResultSet rset = pstmt.executeQuery();

            if (rset.next()) {
                long urbanPopulation = rset.getLong("Population");
                long totalPopulation = urbanPopulation;
                long ruralPopulation = 0;
                populations.add(new Population(
                        cityName,
                        totalPopulation,
                        urbanPopulation,
                        ruralPopulation
                ));
            }
        } catch (SQLException e) {
            System.out.println("Failed to get population by city: " + e.getMessage());
        }
        return populations;
    }
}
