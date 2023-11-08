package com.cbfacademy.apiassessment;

import java.util.Arrays;
import java.util.HashMap;

public class EnergyInfo implements Energy {
    
    // access the HashMaps in the EnergyData file
    // private HashMap<String, Integer> electricityProduction2022;
    private HashMap<String, Double> renewableElectricityProduction2022;
    private HashMap<String, Double> renewableElectricityProduction2021;
    public EnergyInfo(EnergyData energyData) {
        // this.electricityProduction2022 = energyData.getElectricityProduction2022();
        this.renewableElectricityProduction2022 = energyData.getRenewableElectricityProduction2022();
        this.renewableElectricityProduction2021 = energyData.getRenewableElectricityProduction2021();
    }

    // // implement the getElectricityProductionByCountry method
    // @Override
    // int getElectricityProductionByCountry(String country, int electricityProduction) {

    //     // exception handling for invalid country input
    //     if(!electricityProduction2022.containsKey(country)) {
    //         throw new IllegalArgumentException("2022 electricty production levels are currently unavailable for your selected country.");
    //     }

    // }

    // implement the getRenewableElectricityProdcutionByCountry method
    @Override
    double getRenewableElectricityProdcutionByCountry(String country, double renewableElectricityProduction) {

        // exception handling for invalid country input
        if((!renewableElectricityProduction2022.containsKey(country)) || (!renewableElectricityProduction2021.containsKey(country))) {
            throw new IllegalArgumentException("Renewable electricity production levels are currently unavailable for your selected country.");
        }

        
    }
}
