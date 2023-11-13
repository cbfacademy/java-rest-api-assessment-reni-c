package com.cbfacademy.apiassessment;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class EnergyInfo implements Energy {
    
    // access the HashMaps in the EnergyData file
    private HashMap<String, Double> renewableElectricityProduction2022;
    private HashMap<String, Double> renewableElectricityProduction2021;

    public EnergyInfo(EnergyData energyData) {
        this.renewableElectricityProduction2022 = energyData.getRenewableElectricityProduction2022();
        this.renewableElectricityProduction2021 = energyData.getRenewableElectricityProduction2021();
    }


    // implement the getRenewableElectricityProdcutionByCountry method
    @Override
    public String getRenewableElectricityProdcutionByCountry() {
        EnergyData energyData;
        Set<String> country1 = energyData.getRenewableElectricityProduction2022().keySet();
        Set<String> country2 = energyData.getRenewableElectricityProduction2021().keySet();
        Collection<Double> renewableElectricityProduction1 = energyData.getRenewableElectricityProduction2022().values();
        Collection<Double> renewableElectricityProduction2 = energyData.getRenewableElectricityProduction2021().values();

        // exception handling for invalid country input
        if((!renewableElectricityProduction2022.containsKey(country1)) || (!renewableElectricityProduction2021.containsKey(country2))) {
            throw new IllegalArgumentException("Renewable electricity production levels are currently unavailable for your selected country.");
        }

        return "In 2022, " + renewableElectricityProduction2022.get(country1) + " had a renewable electricity production percentage of " + renewableElectricityProduction2022.get(renewableElectricityProduction1) + "." + 
        " In 2021, " + renewableElectricityProduction2021.get(country2) + " had a renewable electricity production percentage of " + renewableElectricityProduction2021.get(renewableElectricityProduction2) + ".";
    }
}