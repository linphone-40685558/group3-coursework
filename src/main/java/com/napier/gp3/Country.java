package com.napier.gp3;

/**
 * Represents a country with its attributes such as code, name, continent,
 * region, population, capital ID, and capital name.
 */
public class Country {
    private String code;        // Unique code for the country (e.g., "MM" for Myanmar)
    private String name;        // Name of the country (e.g., "Myanmar")
    private String continent;   // Continent the country belongs to (e.g., "Asia")
    private String region;      // Specific region within the continent (e.g., "Southeast Asia")
    private long population;     // Population of the country
    private int capital;        // Capital ID from the Country table
    private String capitalName; // Name of the capital city from the City table

    /**
     * Constructs a Country object with the specified attributes.
     */
    public Country(String code, String name, String continent, String region, long population, int capital, String capitalName) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.population = population;
        this.capital = capital;       // Capital ID from Country Table
        this.capitalName = capitalName; // Capital name from City Table
    }

    // Getters and Setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public String getCapitalName() {
        return capitalName;
    }

    public void setCapitalName(String capitalName) {
        this.capitalName = capitalName;
    }
}
