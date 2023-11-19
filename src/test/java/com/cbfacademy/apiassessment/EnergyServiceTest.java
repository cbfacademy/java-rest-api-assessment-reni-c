package com.cbfacademy.apiassessment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;
import java.util.stream.Collectors;

@DisplayName("The Energy Data Class should")
public class EnergyServiceTest {

    private EnergyService energyService;

    @BeforeEach
    public void setUp() {
        energyService = new EnergyService();
    }

    // this test checks that the HashMap has data for 2022
    @Test
    @DisplayName("check renewableElectricityProduction HashMap for 2022 data")
    public void renewableElectricityProductionHashMapHasDataFor2022() {
        assertTrue(energyService.getRenewableElectricityProduction().containsKey(2022));
    }

    // this test checks that the HashMap has data for 2021
    @Test
    @DisplayName("check renewableElectricityProduction HashMap for 2021 data")
    public void renewableElectricityProductionHashMapHasDataFor2021() {
        assertTrue(energyService.getRenewableElectricityProduction().containsKey(2021));
    }

    // this test checks that the HashMap has 10 countries for 2022
    @Test
    @DisplayName("check renewableElectricityProduction HashMap has 10 countries for 2022")
    public void renewableElectricityProductionHashMapHas10CountriesFor2022() {
        assertEquals(10, energyService.getRenewableElectricityProduction().get(2022).size());
    }

    // this test checks that the HashMap has 10 countries for 2021
    @Test
    @DisplayName("check renewableElectricityProduction HashMap has 10 countries for 2021")
    public void renewableElectricityProductionHashMapHas10CountriesFor2021() {
        assertEquals(10, energyService.getRenewableElectricityProduction().get(2021).size());
    }

    // this test checks that the HashMap contains the correct list of countries
    @Test
    @DisplayName("check renewableElectricityProduction HashMap for correct list of countries")
    public void renewableElectricityProductionHashMapHasCorrectListOfCountries() {
        Set<String> expectedCountries = new HashSet<>(Arrays.asList("China", "United States", "India", "Russia", "Japan", "Brazil", "Canada", "South Korea", "Germany", "France"));
        Set<String> actualCountries = energyService.getRenewableElectricityProduction().values().stream().flatMap(innerMap -> innerMap.keySet().stream()).collect(Collectors.toSet());
        assertEquals(expectedCountries, actualCountries);
    }

    // this test checks that the HashMap has been ordered
    @Test
    @DisplayName("check renewableElectricityProduction HashMap has been ordered by ascending values for each year")
    public void renewableElectricityProductionHashMapHasBeenOrderedByAscendingValuesForEachYear() {
        LinkedHashMap<Integer, LinkedHashMap<String, Double>> renewableElectricityProduction = energyService.getRenewableElectricityProduction();
        int[] years = {2022, 2021};
        for (int year : years) {
            LinkedHashMap<String, Double> innerMap = renewableElectricityProduction.get(year);
            Double previousValue = Double.MIN_VALUE;
            for (Double value : innerMap.values()) {
                assertTrue(value >= previousValue);
                previousValue = value;
            }
        }
    }
}
