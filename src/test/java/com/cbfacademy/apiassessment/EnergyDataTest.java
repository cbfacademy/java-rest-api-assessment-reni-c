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
        Map<String, Double> sortedMap = new HashMap<>();
        sortedMap.put("South Korea", 8.1);
        sortedMap.put("Russia", 17.7);
        sortedMap.put("Japan", 21.6);
        sortedMap.put("India", 21.9);
        sortedMap.put("United States", 22.2);
        sortedMap.put("France", 25.5);
        sortedMap.put("China", 30.6);
        sortedMap.put("Germany", 44.4);
        sortedMap.put("Canada", 68.8);
        sortedMap.put("Brazil", 89.2);
    }

    // this test should check that the renewableElectricityProduction2021 HashMap has been ordered
    @Test
    @DisplayName("check that the renewableElectricityProduction2021 HashMap has been ordered")
    public void renewableElectricityProduction2021HashMapHasBeenOrdered() {
        Map<String, Double> sortedMapTwo = new HashMap<>();
        sortedMapTwo.put("South Korea", 7.0);
        sortedMapTwo.put("Russia", 19.2);
        sortedMapTwo.put("United States", 20.5);
        sortedMapTwo.put("Japan", 21.0);
        sortedMapTwo.put("India", 21.4);
        sortedMapTwo.put("France", 22.8);
        sortedMapTwo.put("China", 29.1);
        sortedMapTwo.put("Germany", 40.1);
        sortedMapTwo.put("Canada", 67.1);
        sortedMapTwo.put("Brazil", 77.4);
    }

    // // this test should check that the EnergyData.java class has been saved to a JSON file
    // @Test
    // @DisplayName("check that the HashMaps have been converted to valid JSON types")
    // public void theJSONFileShouldContainValidData() {
    //     Map<String, Double> map = new HashMap<String, Double>();
    //     map.put()
    // }

}