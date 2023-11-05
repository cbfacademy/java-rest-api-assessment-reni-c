package com.cbfacademy.apiassessment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("The Energy Data Class should")
public class EnergyDataTest {

    private EnergyData energyData;

    @BeforeEach
    public void setUp() {
        energyData = new EnergyData();
    }

    // this test ensures the electricityProduction2022 HashMap has a list of countries
    @Test
    @DisplayName("check electricityProduction2022 HashMap for a list of countries")
    public void electrictyProduction2022HashMapHasListOfCountries() {
        assertNotNull(energyData.getElectricityProduction2022().keySet());
    } 

    // this test ensures the electricityProduction2022 HashMap has a list of production values
    @Test
    @DisplayName("check electricityProduction2022 HashMap for a list of electricity production values")
    public void electricityProduction2022HashMapHasListOfElectricityProductionValues() {
        assertNotNull(energyData.getElectricityProduction2022().values());
    }

    // this test should check that the number of countries contained in the electricityProduction2022 HashMap is 10
    @Test
    @DisplayName("check size of electricityProduction2022 HashMap")
    public void returnsSizeOf2022ElectricityProductionHashMap() {
        assertEquals(10, energyData.getElectricityProduction2022().size());
    }

    // this test ensures the renewableElectricityProduction2022 HashMap has a list of countries
    @Test
    @DisplayName("check renewableElectricityProduction2022 HashMap for a list of countries")
    public void renewableElectrictyProduction2022HashMapHasListOfCountries() {
        assertNotNull(energyData.getRenewableElectricityProduction2022().keySet());
    }

    // this test ensures the renewableElectricityProduction2022 HashMap has a list of production values
    @Test
    @DisplayName("check renewableElectricityProduction2022 HashMap for a list of electricity production values")
    public void renewableElectricityProduction2022HashMapHasListOfElectricityProductionValues() {
        assertNotNull(energyData.getRenewableElectricityProduction2022().values());
    }

     // this test should check that the number of countries contained in the renewableElectricityProduction2022 HashMap is 10
    @Test
    @DisplayName("check size of renewableElectricityProduction2022 HashMap")
    public void returnsSizeOf2022RenewableElectricityProductionHashMap() {
        assertEquals(10, energyData.getRenewableElectricityProduction2022().size());
    }

}