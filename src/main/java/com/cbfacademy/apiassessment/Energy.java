package com.cbfacademy.apiassessment;

import java.util.LinkedHashMap;

public interface Energy {
    
    // state the interface method that will be implemented in the EnergyService class
    LinkedHashMap<Integer, LinkedHashMap<String, Double>> getRenewableElectricityProduction();
}
