package com.cbfacademy.apiassessment;

import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class EnergyService implements Energy {
    
    protected LinkedHashMap<Integer, LinkedHashMap<String, Double>> renewableElectricityProduction;

    public EnergyService() {

        // initialize renewable electricity production
        this.renewableElectricityProduction = new LinkedHashMap<>();

        // create a LinkedHashMap within a LinkedHashMap for the years you will be producing renewableElectricityProduction for 
        LinkedHashMap<String, Double> innerMap1 = new LinkedHashMap<>();
        LinkedHashMap<String, Double> innerMap2 = new LinkedHashMap<>();

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

        renewableElectricityProduction.put(2022, convertToOrderedMap(innerMap1));
        renewableElectricityProduction.put(2021, convertToOrderedMap(innerMap2));
    }

    // method to add new data to the LinkedHashMap (this method will be useful for the @PostMapping request in the controller class)
    public void addEnergyData(int year, LinkedHashMap<String, Double> newData) {
        LinkedHashMap<String, Double> existingData = renewableElectricityProduction.get(year);
            if (existingData == null) {
                existingData = new LinkedHashMap<>();
                renewableElectricityProduction.put(year, existingData);
            }

            for (Map.Entry<String, Double> entry : newData.entrySet()) {
                if (existingData.containsKey(entry.getKey())) {
                    existingData.put(entry.getKey(), entry.getValue());
                } else {
                    existingData.put(entry.getKey(), entry.getValue());
                }
            }
    }

    // order the LinkedHashMap based on the innerMap ascending values
    private LinkedHashMap<String, Double> convertToOrderedMap(LinkedHashMap<String, Double> innerMap) {
        List<Map.Entry<String, Double>> entries = new ArrayList<>(innerMap.entrySet());
        entries.sort(Map.Entry.comparingByValue());

        LinkedHashMap<String, Double> orderedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Double> entry : entries) {
            orderedMap.put(entry.getKey(), entry.getValue());
        }

        return orderedMap;
    }

    @Override
    public LinkedHashMap<Integer, LinkedHashMap<String, Double>> getRenewableElectricityProduction() {
        return this.renewableElectricityProduction;
    }

    // public void setRenewableElectricityProduction(LinkedHashMap<Integer, LinkedHashMap<String, Double>> renewableElectricityProduction) {
    //     this.renewableElectricityProduction = renewableElectricityProduction;
    // }

}
