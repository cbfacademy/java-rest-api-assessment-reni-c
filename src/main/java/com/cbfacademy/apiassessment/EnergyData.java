package com.cbfacademy.apiassessment;

import java.util.HashMap;

public class EnergyData {

    // private HashMap<String, Integer> electricityProduction2022;
    private HashMap<String, Double> renewableElectricityProduction2022;
    private HashMap<String, Double> renewableElectricityProduction2021;

    public EnergyData() {

        // /* this should contain a list of countries and their respective electricity production levels (TWh) 
        // in 2022 and initialise the electricity production data */
        // this.electricityProduction2022 = new HashMap<String, Integer>() {
        //     {
        //         put("China", 8833);
        //         put("United States", 4510);
        //         put("India", 1802);
        //         put("Russia", 1165);
        //         put("Japan", 1063);
        //         put("Brazil", 668);
        //         put("Canada", 657);
        //         put("South Korea", 625);
        //         put("Germany", 578);
        //         put("France", 473);
        //     }
        // };

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
    }

//    public HashMap<String, Integer> getElectricityProduction2022() {
//         return electricityProduction2022;
//     } 

    public HashMap<String, Double> getRenewableElectricityProduction2022() {
        return this.renewableElectricityProduction2022;
    }

    public HashMap<String, Double> getRenewableElectricityProduction2021() {
        return this.renewableElectricityProduction2021;
    }
}