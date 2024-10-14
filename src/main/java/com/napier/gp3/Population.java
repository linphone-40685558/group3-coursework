package com.napier.gp3;

public class Population {

    private String name;
    private int totalPopulation;
    private int urbanPopulation;
    private int ruralPopulation;

    public Population(String name, int totalPopulation, int urbanPopulation, int ruralPopulation) {
        this.name = name;
        this.totalPopulation = totalPopulation;
        this.urbanPopulation = urbanPopulation;
        this.ruralPopulation = ruralPopulation;
    }

    public String getName() {
        return name;
    }

    public int getTotalPopulation() {
        return totalPopulation;
    }

    public int getUrbanPopulation() {
        return urbanPopulation;
    }

    public int getRuralPopulation() {
        return ruralPopulation;
    }
}
