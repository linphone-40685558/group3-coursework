package com.napier.gp3;

/**
 * Represents a cities with its attributes such as name, country,
 * countryCode,district, population
 */
public class City {
    private int id;               // Unique identifier for the city
    private String name;          // Name of the city
    private String country;       // Name of the country the city is located in
    private String countryCode;   // ISO code of the country
    private String district;      // Name of the district the city is in
    private int population;       // Population of the city


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



