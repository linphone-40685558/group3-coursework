package com.napier.gp3;

public class Population {

    private String name;
    private Long totalPopulation;  // Change this to Long
    private Long urbanPopulation;   // Change this to Long
    private Long ruralPopulation;    // Change this to Long

    public Population(String name, Long totalPopulation, Long urbanPopulation, Long ruralPopulation) {
        this.name = name;
        this.totalPopulation = totalPopulation;
        this.urbanPopulation = urbanPopulation;
        this.ruralPopulation = ruralPopulation;
    }

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
}
