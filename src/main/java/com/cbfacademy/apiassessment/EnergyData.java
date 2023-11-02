package com.cbfacademy.apiassessment;

import java.util.HashMap;

public class EnergyData implements Energy {
    
    /* this method should return/contain a list of countries and their respective 
    electricity production levels (TWh) in 2022 */
    private HashMap<String, Integer> electricityProduction2022;

    public EnergyData() {
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
    }

    public HashMap<String, Integer> getAllElectricityProduction2022() {
        return this.electricityProduction2022;
    }
}
