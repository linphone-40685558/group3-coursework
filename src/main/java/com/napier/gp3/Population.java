package com.napier.gp3;

/**
 * Population Class
 */
public class Population {

    // Attributes
    /**
     * @name
     */
    private final String name;
    /**
     * @totalPopulation
     */
    private final Long totalPopulation;
    /**
     * @urbanPopulation
     */
    private final Long urbanPopulation;
    /**
     * @ruralPopulation
     */
    private final Long ruralPopulation;
    /**
     * @urbanPopulationPercentage
     */
    private float urbanPopulationPercentage;
    /**
     * @
     */
    private float ruralPopulationPercentage;

    /**
     * Constructor
     * @param name Name will be continent, region, country, etc
     * @param totalPopulation Total Population
     * @param urbanPopulation Urban Population
     * @param ruralPopulation Rural Population
     * @param urbanPopulationPercentage Urban population percentage
     * @param ruralPopulationPercentage Rural population percentage
     */
    public Population(String name, Long totalPopulation, Long urbanPopulation, Long ruralPopulation, float urbanPopulationPercentage, float ruralPopulationPercentage) {
        this.name = name;
        this.totalPopulation = totalPopulation;
        this.urbanPopulation = urbanPopulation;
        this.ruralPopulation = ruralPopulation;
        this.urbanPopulationPercentage = urbanPopulationPercentage;
        this.ruralPopulationPercentage = ruralPopulationPercentage;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public Long getTotalPopulation() {
        return totalPopulation;
    }

    public Long getUrbanPopulation() {
        return urbanPopulation;
    }

    public Long getRuralPopulation() {
        return ruralPopulation;
    }

    public float getUrbanPopulationPercentage() {
        return urbanPopulationPercentage;
    }

    public void setUrbanPopulationPercentage(float urbanPopulationPercentage) {
        this.urbanPopulationPercentage = urbanPopulationPercentage;
    }

    public float getRuralPopulationPercentage() {
        return ruralPopulationPercentage;
    }

    public void setRuralPopulationPercentage(float ruralPopulationPercentage) {
        this.ruralPopulationPercentage = ruralPopulationPercentage;
    }
}
