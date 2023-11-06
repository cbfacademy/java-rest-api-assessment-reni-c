package com.cbfacademy.apiassessment;

import java.util.HashMap;

public class EnergyInfo implements Energy {
    
    // access the HashMaps in the EnergyData file
    private HashMap<String, Integer> electricityProduction2022;
    private HashMap<String, Double> renewableElectricityProduction2022;
    public EnergyInfo(EnergyData energyData) {
        this.electricityProduction2022 = energyData.getElectricityProduction2022();
        this.renewableElectricityProduction2022 = energyData.getRenewableElectricityProduction2022();
    }

    // implement the getElectricityProductionByCountryMethod
    @Override
    int getElectricityProductionByCountry(String country, int electricityProduction) {

        // exception handling for invalid country input
        if(!electricityProduction2022.containsKey(country)) {
            return toString("2022 electricty production levels are currently unavailable for your selected country.");
        }
    }
}
