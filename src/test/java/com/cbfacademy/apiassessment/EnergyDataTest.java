package com.cbfacademy.apiassessment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

@DisplayName("The Energy Data Class should")
public class EnergyDataTest {

    private EnergyData energyData;

    @BeforeEach
    public void setUp() {
        energyData = new EnergyData();
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

    // this test ensures the renewableElectricityProduction2021 HashMap has a list of countries
    @Test
    @DisplayName("check renewableElectricityProduction2021 HashMap for a list of countries")
    public void renewableElectrictyProduction2021HashMapHasListOfCountries() {
        assertNotNull(energyData.getRenewableElectricityProduction2021().keySet());
    }

    // this test ensures the renewableElectricityProduction2021 HashMap has a list of production values
    @Test
    @DisplayName("check renewableElectricityProduction2021 HashMap for a list of electricity production values")
    public void renewableElectricityProduction2021HashMapHasListOfElectricityProductionValues() {
        assertNotNull(energyData.getRenewableElectricityProduction2021().values());
    }

     // this test should check that the number of countries contained in the renewableElectricityProduction2021 HashMap is 10
    @Test
    @DisplayName("check size of renewableElectricityProduction2021 HashMap")
    public void returnsSizeOf2021RenewableElectricityProductionHashMap() {
        assertEquals(10, energyData.getRenewableElectricityProduction2021().size());
    }

    // this test should check that the renewableElectricityProduction2022 HashMap has been ordered
    @Test
    @DisplayName("check that the renewableElectricityProduction2022 HashMap has been ordered")
    public void renewableElectricityProduction2022HashMapHasBeenOrdered() {
        Map<String, Double> sortedMap = new ValueSortedMap<>();
        sortedMap.put(null, null)
    }

    // this test should check that the renewableElectricityProduction2021 HashMap has been ordered

    // this test should check that the EnergyData.java class has been saved to a JSON file

}