// package com.cbfacademy.apiassessment;

// import java.io.File;
// import java.io.IOException;
// import java.util.*;

// import com.fasterxml.jackson.databind.ObjectMapper;

// public class EnergyData {

//     private HashMap<String, Double> renewableElectricityProduction2022;
//     private HashMap<String, Double> renewableElectricityProduction2021;

//     public EnergyData() {

//         // initialise renewable electricity production data
//         this.renewableElectricityProduction2022 = initializeData(2022);
//         this.renewableElectricityProduction2021 = initializeData(2021);
//     }

//     private HashMap<String, Double> initializeData(int year) {
//         HashMap<String, Double> data = (year == 2022) ? get2022Data() : get2021Data();

//         // sort the data by values in ascending order
//         data = sortByValues(data);
//         return data;
//     }

//     /* this should contain a list of countries and the percentage of electricity produced from renewable 
//     sources in 2022 and initialise renewable electricity production data */
//     private HashMap<String, Double> get2022Data() {
//         return new HashMap<String, Double>() {
//             {
//                 put("China", 30.6);
//                 put("United States", 22.2);
//                 put("India", 21.9);
//                 put("Russia", 17.7);
//                 put("Japan", 21.6);
//                 put("Brazil", 89.2);
//                 put("Canada", 68.8);
//                 put("South Korea", 8.1);
//                 put("Germany", 44.4);
//                 put("France", 25.5);
//             }
            
//         };
//     }

//     /* this should contain a list of countries and the percentage of electricity produced from renewable 
//     sources in 2021 and initialise renewable electricity production data */
//     private HashMap<String, Double> get2021Data() {
//         return new HashMap<String, Double>() {
//             {
//                 put("China", 29.1);
//                 put("United States", 20.5);
//                 put("India", 21.4);
//                 put("Russia", 19.2);
//                 put("Japan", 21.0);
//                 put("Brazil", 77.4);
//                 put("Canada", 67.1);
//                 put("South Korea", 7.0);
//                 put("Germany", 40.1);
//                 put("France", 22.8);
//             }
//         };
//     }

//     private HashMap<String, Double> sortByValues(HashMap<String, Double> map) {
//         List<Map.Entry<String, Double>> entryList = new LinkedList<>(map.entrySet());

//         // use Collections.sort to sort the entryList based on values
//         entryList.sort(Comparator.comparingDouble(Map.Entry::getValue));

//         // build a new LinkedHashMap to maintain the order of insertion
//         LinkedHashMap<String, Double> sortedMap = new LinkedHashMap<>();
//         for (Map.Entry<String, Double> entry : entryList) {
//             sortedMap.put(entry.getKey(), entry.getValue());
//         }

//         return sortedMap;
//     }
    

//     public HashMap<String, Double> getRenewableElectricityProduction2022() {
//         return this.renewableElectricityProduction2022;
//     }

//     public HashMap<String, Double> getRenewableElectricityProduction2021() {
//         return this.renewableElectricityProduction2021;
//     }
// }