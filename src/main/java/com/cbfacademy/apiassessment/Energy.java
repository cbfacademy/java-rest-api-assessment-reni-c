package com.cbfacademy.apiassessment;

import java.util.HashMap;

public interface Energy {
    
    // state the interface method that will be implemented in the EnergyInfo class
    HashMap<Integer, HashMap<String, Double>> getRenewableElectricityProduction();
}
