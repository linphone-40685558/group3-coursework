package com.napier.gp3;

import java.sql.Connection;
import java.util.List;

public class Capital_report {
    private CapitalDAO capitalDAO;

    public Capital_report(Connection connection) {
        this.capitalDAO = new CapitalDAO(connection);
    }

    private void printReportHeader() {
        System.out.printf("%-40s %-40s  %-30s%n", "Name", "Country", "Population");
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
    }

    // 17 Get all capital cities by population
    public void printCapitalsByPopulation() {
        System.out.println("**********************************************");
        System.out.println("** 17) ALL CAPITAL CITIES BY POPULATION **");
        System.out.println("**********************************************");
        printReportHeader();
        List<City> allCapitalCities = capitalDAO.getAllCapitalCitiesByPopulation();
        for (City city : allCapitalCities) {
            System.out.printf("%-40s %-40s %-30s%n",
                    city.getName(), city.getCountry(), city.getPopulation());
        }
    }

    // 18 Get capital cities by continent (example: "Asia")
    public void printCapitalsByContinent(String continent) {
        System.out.println("**********************************************");
        System.out.println("** 18) CAPITAL CITIES IN CONTINENT '" + continent.toUpperCase() + "' BY POPULATION **");
        System.out.println("**********************************************");
        printReportHeader();
        List<City> capitalCitiesInContinent = capitalDAO.getCapitalCitiesByContinent(continent);
        for (City city : capitalCitiesInContinent) {
            System.out.printf("%-40s %-40s %-30s%n",
                    city.getName(), city.getCountry(), city.getPopulation());
        }
    }

    // 19 Get capital cities by region (example: "Southeast Asia")
    public void printCapitalsByRegion(String region) {
        System.out.println("**********************************************");
        System.out.println("** 19) CAPITAL CITIES IN REGION '" + region.toUpperCase() + "' BY POPULATION **");
        System.out.println("**********************************************");
        printReportHeader();
        List<City> capitalCitiesInRegion = capitalDAO.getCapitalCitiesByRegion(region);
        for (City city : capitalCitiesInRegion) {
            System.out.printf("%-40s %-40s %-30s%n",
                    city.getName(), city.getCountry(), city.getPopulation());
        }
    }
}
