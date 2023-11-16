package com.cbfacademy.apiassessment;

import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class EnergyService implements Energy {
    
    protected HashMap<Integer, HashMap<String, Double>> renewableElectricityProduction;

    public EnergyService() {

        // initialize renewable electricity production
        this.renewableElectricityProduction = new HashMap<>();

        // create a HashMap within a HashMap for the years you will be producing data for 
        HashMap<String, Double> innerMap1 = new HashMap<>();
        HashMap<String, Double> innerMap2 = new HashMap<>();

        innerMap1.put("China", 30.6);
        innerMap1.put("United States", 22.2);
        innerMap1.put("India", 21.9);
        innerMap1.put("Russia", 17.7);
        innerMap1.put("Japan", 21.6);
        innerMap1.put("Brazil", 89.2);
        innerMap1.put("Canada", 68.8);
        innerMap1.put("South Korea", 8.1);
        innerMap1.put("Germany", 44.4);
        innerMap1.put("France", 25.5);
        
        innerMap2.put("China", 29.1);
        innerMap2.put("United States", 20.5);
        innerMap2.put("India", 21.4);
        innerMap2.put("Russia", 19.2);
        innerMap2.put("Japan", 21.0);
        innerMap2.put("Brazil", 77.4);
        innerMap2.put("Canada", 67.1);
        innerMap2.put("South Korea", 7.0);
        innerMap2.put("Germany", 40.1);
        innerMap2.put("France", 22.8);

        renewableElectricityProduction.put(2022, innerMap1);
        renewableElectricityProduction.put(2021, innerMap2);
    }

    @Override
    public HashMap<Integer, HashMap<String, Double>> getRenewableElectricityProduction() {
        return this.renewableElectricityProduction;
    }

    public void setRenewableElectricityProduction(HashMap<Integer, HashMap<String, Double>> data) {
        this.renewableElectricityProduction = data;
    }
    
}
