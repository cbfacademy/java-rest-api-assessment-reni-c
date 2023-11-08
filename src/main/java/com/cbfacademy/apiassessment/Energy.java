package com.cbfacademy.apiassessment;

public interface Energy {
    
    // state the interface method that will be implemented in the EnergyInfo class
    // int getElectricityProductionByCountry(String country, int electricityProduction);
    double getRenewableElectricityProductionByCountry(String country, double renewableElectricityProduction);
}
