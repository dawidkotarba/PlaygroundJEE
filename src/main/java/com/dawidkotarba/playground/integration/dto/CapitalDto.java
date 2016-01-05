package com.dawidkotarba.playground.integration.dto;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

/**
 * Created by Dawid Kotarba on 30.11.2015.
 */
public class CapitalDto implements Serializable {

    @NotNull
    private String name;

    private int population;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
