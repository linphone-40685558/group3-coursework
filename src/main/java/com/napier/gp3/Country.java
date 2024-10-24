package com.napier.gp3;

/**
 * Represents a country with its attributes such as code, name, continent,
 * region, population, capital ID, and capital name.
 */

public class Country {
    /**
     * @code
     */
    private final String code;        // Unique code for the country (e.g., "MMR" for Myanmar)
    /**
     * @name
     */
    private final String name;        // Name of the country (e.g., "Myanmar")
    /**
     * @continent
     */
    private final String continent;   // Continent the country belongs to (e.g., "Asia")
    /**
     * @region
     */
    private final String region;      // Specific region within the continent (e.g., "Southeast Asia")
    /**
     * @population
     */
    private final long population;     // Population of the country
    /**
     * @capital
     */
    private final int capital;        // Capital ID from the Country table
    /**
     * @capitalName
     */
    private final String capitalName; // Name of the capital city from the City table

    /**
     * Constructs a Country object with the specified attributes.
     *
     * @param code Country Code
     * @param name Country Name
     * @param continent Continent
     * @param region Region
     * @param population Population
     * @param capital Capital
     * @param capitalName Capital Name
     */
    public Country(String code, String name, String continent, String region, long population, int capital, String capitalName) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.population = population;
        this.capital = capital;
        this.capitalName = capitalName;
    }

    /**
     * Getter and Setter code of Country
     */
    public String getCode() {
        return code;
    }


    public String getName() {
        return name;
    }


    public String getContinent() {
        return continent;
    }


    public String getRegion() {
        return region;
    }


    public long getPopulation() {
        return population;
    }


    public int getCapital() {
        return capital;
    }


    public String getCapitalName() {
        return capitalName;
    }

}
