package com.napier.gp3;

/**
 * Represents a cities with its attributes such as name, country,
 * countryCode,district, population
 */
public class City {
    /**
     * @id 1
     */
    private final int id;               // Unique identifier for the city
    /**
     * @name Citeyname
     */
    private final String name;          // Name of the city
    /**
     * @country name of country
     */
    private final String country;       // Name of the country the city is located in
    /**
     * @countryCode ISO code of country
     */
    private final String countryCode;   // ISO code of the country
    /**
     * @district name of district
     */
    private final String district;      // Name of the district the city is in
    /**
     * @population population of city
     */
    private final int population;       // Population of the city


    /**
     * Constructs a City object with the specified attributes.
     *
     * @param id
     * @param name
     * @param country
     * @param countryCode
     * @param district
     * @param population
     */
    public City(int id, String name, String country, String countryCode, String district, int population) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.countryCode = countryCode;
        this.district = district;
        this.population = population;
    }

    public String getName() {
        return name;
    }


    public String getCountry() {
        return country;
    }


    public String getDistrict() {
        return district;
    }


    public int getPopulation() {
        return population;
    }

}



