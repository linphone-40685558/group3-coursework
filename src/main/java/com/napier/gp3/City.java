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
     * @param id          Unique identifier for the city
     * @param name        Name of the city
     * @param country     Name of the country the city is located in
     * @param countryCode ISO code of the country
     * @param district    Name of the district the city is in
     * @param population  Population of the city
     */
    public City(int id, String name, String country, String countryCode, String district, int population) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.countryCode = countryCode;
        this.district = district;
        this.population = population;
    }

    /**
     * Getter and Setter code of City table
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}



