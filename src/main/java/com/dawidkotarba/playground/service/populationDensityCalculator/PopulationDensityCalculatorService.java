package com.dawidkotarba.playground.service.populationDensityCalculator;

import com.google.common.base.Preconditions;
import javax.ejb.Stateless;

/**
 * Created by Dawid Kotarba on 19.12.2015.
 */

@Stateless
public class PopulationDensityCalculatorService {

    public int calculate(PopulationDensityCalculationInputData inputData) {
        Preconditions.checkArgument(inputData.getArea() > 0, "Area has to be a positive number");

        return inputData.getPopulation() / inputData.getArea();
    }
}
