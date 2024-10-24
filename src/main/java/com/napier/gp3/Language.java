package com.napier.gp3;

/**
 * Represents a language with its attributes such as language, numberOfPeople
 * and popular_percentage
 */

public class Language {
    /**
     * @language
     */
    private final String language;
    /**
     * @numberOfPeople
     */
    private final long numberOfPeople;
    /**
     * @population_percentage
     */
    private final double population_percentage;

    /**
     * Constructs a Language object with the specified attributes.
     */
    public Language(String language, long numberOfPeople, double population_percentage) {
        this.language = language;
        this.numberOfPeople = numberOfPeople;
        this.population_percentage = population_percentage;
    }

    /**
     * Getter and Setter code of Language
     */
    public String getLanguage() {
        return language;
    }


    public long getNumberOfPeople() {
        return numberOfPeople;
    }


    public double getPopulation_percentage() {
        return population_percentage;
    }


}


