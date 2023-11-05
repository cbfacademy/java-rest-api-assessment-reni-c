package com.cbfacademy.apiassessment;

import java.util.HashMap;

public class EnergyData {

    private HashMap<String, Integer> electricityProduction2022;
    private HashMap<String, Double> renewableElectricityProduction2022;

    public EnergyData() {

        /* this should contain a list of countries and their respective electricity production levels (TWh) 
        in 2022 and initialise the electricity production data */
        this.electricityProduction2022 = new HashMap<String, Integer>() {
            {
                put("China", 8833);
                put("United States", 4510);
                put("India", 1802);
                put("Russia", 1165);
                put("Japan", 1063);
                put("Brazil", 668);
                put("Canada", 657);
                put("South Korea", 625);
                put("Germany", 578);
                put("France", 473);
            }
        };

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
    }

   public HashMap<String, Integer> getElectricityProduction2022() {
        return electricityProduction2022;
    } 

    public HashMap<String, Double> getRenewableElectricityProduction2022() {
        return this.renewableElectricityProduction2022;
    }
}