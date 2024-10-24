package com.napier.gp3;

/**
 * Represents a capital cities with its attributes such as name, country,
 * countryCode,district, population
 */
public class Capital {
    /**
     * @id
     */
    private final int id;
    /**
     * @name
     */
    private final String name;
    /**
     * @country
     */
    private final String country;
    /**
     * @countryCode
     */
    private final String countryCode;
    /**
     * @district
     */
    private final String district;
    /**
     * @population
     */
    private final int population;

    /**
     * Constructs a City object with the specified attributes.
     */
    public Capital(int id, String name, String country, String countryCode, String district, int population) {
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
