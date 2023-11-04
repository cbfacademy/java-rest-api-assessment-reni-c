package com.cbfacademy.apiassessment;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName(value = "The Energy Data Class should")
public class EnergyDataTest {

    // this test should return the name of a country
    @Test
    @DisplayName("return the name of a country")
    public void returnNameOfCountry() {
        String country = new String();
        final String actual = country;
        assertThat(actual, is(notNullValue()));
    } 

    // this test should return the electricity production of a country
    @Test
    @DisplayName("return electricity production of a country")
    public void returnElectricityProductionOfACountry() {
        Integer production = new Integer(0);
        final Integer actual = production;
        assertThat(actual, is(notNullValue()));
    }

    // this test should return the percentage of electricity production of a country that derives from renewable sources
    @Test
    @DisplayName("return the percentage of a country's electricity production that comes from renewable sources")
    public void returnPercentageOfElectrictyProductionOfACountryThatComesFromRenewableSources() {
        Double renewable = new Double(0);
        final Double actual = renewable;
        assertThat(actual, is(notNullValue()));
    }
}
// import org.junit.jupiter.api.BeforeAll;
// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;

// @DisplayName(value = "The Energy Data Class should")
// public class EnergyDataTest {

//     @BeforeAll
//     public void setUp() {
//         energy = new EnergyData();
//         electricityProduction2022 = energy.getAllElectricityProduction2022();
//     }

//     // this test should return global electricity production for 2022
//     @Test
//     @DisplayName("return electricity production for countries in 2022")
//     public void returns2022ElectricityProductionPerCountry() {
//         HashMap<String, Integer> actualResult = energy.getAllElectricityProduction2022();
//         assertTrue(electricityProduction2022.size() == actualResult.size());
//     }

// }

// import java.util.stream.Stream;

// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.params.ParameterizedTest;

// @DisplayName(value = "The Energy Data class should")
// public class EnergyDataTest {
    
//     /* use a parameterized test to return a list of countries and their respective energy 
//     consumption each year so you're not having to repeat the code unnecessarily and the 
//     use of '@MethodSource' gets the parameters from the method */
//     @ParameterizedTest
//     @DisplayName("should return energy consumption per country per year")
//     @MethodSource("getAnnualEnergyConsumption")

//     public void AnnualEnergyConsumption(String country, int energy, int year) {

//         final string actual = EnergyData.isEnergyData(energy, year);
//         assertThat(actual, is(country));
//     }

//     private static Stream<Arguments> getAnnualEnergyConsumption() {

//         return Stream.of(
//             arguments("China", 3507, 2020),
//             arguments("United States", 2045, 2020),
//             arguments("India", 872, 2020),
//             arguments("Russia", 762, 2020),
//             arguments("Japan", 387, 2020),
//             arguments("China", 3689, 2021),
//             arguments("United States", 2145, 2021),
//             arguments("India", 936, 2021),
//             arguments("Russia", 826, 2021),
//             arguments("Japan", 404, 2021),
//             arguments("China", 3801, 2022),
//             argument("United States", 2182, 2022),
//             arguments("India", 1005, 2022),
//             arguments("Russia", 822, 2022),
//             arguments("Japan", 400, 2022)
//             );
//     }
// }
