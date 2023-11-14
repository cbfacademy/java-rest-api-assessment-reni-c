package com.cbfacademy.apiassessment;

import java.io.File;
import java.io.IOException;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;

public class EnergyData {

    private HashMap<String, Double> renewableElectricityProduction2022;
    private HashMap<String, Double> renewableElectricityProduction2021;

    public EnergyData() {

        /* this should contain a list of countries and the percentage of electricity produced from renewable 
        sources in 2022 and initialise renewable electricity production data */
        this.renewableElectricityProduction2022 = new HashMap<String, Double>() {
            {
                put("China", 30.6);
                put("United States", 22.2);
                put("India", 21.9);
                put("Russia", 17.7);
                put("Japan", 21.6);
                put("Brazil", 89.2);
                put("Canada", 68.8);
                put("South Korea", 8.1);
                put("Germany", 44.4);
                put("France", 25.5);
            }
            
        };

        /* this should contain a list of countries and the percentage of electricity produced from renewable 
        sources in 2021 and initialise renewable electricity production data */
        this.renewableElectricityProduction2021 = new HashMap<String, Double>() {
            {
                put("China", 29.1);
                put("United States", 20.5);
                put("India", 21.4);
                put("Russia", 19.2);
                put("Japan", 21.0);
                put("Brazil", 77.4);
                put("Canada", 67.1);
                put("South Korea", 7.0);
                put("Germany", 40.1);
                put("France", 22.8);
            }
        };
   
    
        // sort the data in the HashMaps by the values
        // final EnergyData sort = new EnergyData();
        final Set<Map.Entry<String, Double>> entry = renewableElectricityProduction2022.entrySet();
        final Set<Map.Entry<String, Double>> entryTwo = renewableElectricityProduction2021.entrySet();

        final Comparator<Map.Entry<String, Double>> comparator = new Comparator<Map.Entry<String, Double>>() {
            @Override
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                Double value1 = o1.getValue();
                Double value2 = o2.getValue();
                return value1.compareTo(value2);
            }
        };

        final SortedSet<Map.Entry<String, Double>> sortedSet = new TreeSet<>(comparator);
        sortedSet.addAll(entry);
        final  Map<String, Double> sortedMap = new LinkedHashMap<String, Double>();
        for(Map.Entry<String, Double> entry1 : sortedSet) {
            sortedMap.put(entry1.getKey(), entry1.getValue());
        }
        
        final Comparator<Map.Entry<String, Double>> comparatorTwo = new Comparator<Map.Entry<String, Double>>() {
            @Override
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                Double value1 = o1.getValue();
                Double value2 = o2.getValue();
                return value1.compareTo(value2);
            }
        };

        final SortedSet<Map.Entry<String, Double>> sortedSetTwo = new TreeSet<>(comparatorTwo);
        sortedSetTwo.addAll(entryTwo);
        final  Map<String, Double> sortedMapTwo = new LinkedHashMap<String, Double>();
        for(Map.Entry<String, Double> entry1 : sortedSetTwo) {
            sortedMapTwo.put(entry1.getKey(), entry1.getValue());
        }
    }

    public HashMap<String, Double> getRenewableElectricityProduction2022() {
        return this.renewableElectricityProduction2022;
    }

    public HashMap<String, Double> getRenewableElectricityProduction2021() {
        return this.renewableElectricityProduction2021;
    }

    // method to save data to a JSON file
    public void saveToJSON(String filePath) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(filePath), "src/main/java/com/cbfacademy/apiassessment/EnergyData.java");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // method to read data from a JSON file
    public static EnergyData readFromJSON(String filePath) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(filePath), EnergyData.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}