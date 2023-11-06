package com.cbfacademy.apiassessment;

public interface Energy {
    
    // state the interface methods that will be implemented in the 
    int getElectricityProductionByCountry(String country, int electricityProduction);
    double getRenewableElectricityProductionByCountry(String country, double renewableElectricityProduction);
}
