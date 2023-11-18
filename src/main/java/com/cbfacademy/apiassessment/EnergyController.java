package com.cbfacademy.apiassessment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/energy")
public class EnergyController {

    // private final EnergyApplication energyApplication;
    
    // public EnergyController(EnergyApplication energyApplication) {
    //     this.energyApplication = energyApplication;
    // }

    
    // private final EnergyApplication energyAEnergyApplication;
    // public EnergyController(EnergyApplication energyAEnergyApplication) {
    //     this.energyAEnergyApplication = energyAEnergyApplication;
    // }

    // get the whole list of electricity production percentages from renewable sources from the JSON file
    @GetMapping("/energy")
    public LinkedHashMap<Integer, LinkedHashMap<String, Double>> getAllEnergyData() {
        return EnergyApplication.readFromJSON(EnergyApplication.getFilePath());
    }

    // get electricity production percentages for 2021
    @GetMapping("/2021")
    public LinkedHashMap<Integer, LinkedHashMap<String, Double>> get2021Data() {
        LinkedHashMap<Integer, LinkedHashMap<String, Double>> allData = EnergyApplication.readFromJSON(EnergyApplication.getFilePath());
        LinkedHashMap<String, Double> dataFor2021 = allData.get(2021);
        LinkedHashMap<Integer, LinkedHashMap<String, Double>> result2021 = new LinkedHashMap<>();
        result2021.put(2021, dataFor2021);
        return result2021;
    }

    // get electricity percentages for 2022
    @GetMapping("/2022")
    public LinkedHashMap<Integer, LinkedHashMap<String, Double>> get2022Data() {
        LinkedHashMap<Integer, LinkedHashMap<String, Double>> allData = EnergyApplication.readFromJSON(EnergyApplication.getFilePath());
        LinkedHashMap<String, Double> dataFor2022 = allData.get(2022);
        LinkedHashMap<Integer, LinkedHashMap<String, Double>> result2022 = new LinkedHashMap<>();
        result2022.put(2021, dataFor2022);
        return result2022;
    }

    // get electricity percentages for a specific country
    @GetMapping("/china")
    public LinkedHashMap<Integer, LinkedHashMap<String, Double>> getChinaData() {
        LinkedHashMap<Integer, LinkedHashMap<String, Double>> allData = EnergyApplication.readFromJSON(EnergyApplication.getFilePath());
        String requiredCountry = "China";
        LinkedHashMap<Integer, LinkedHashMap<String, Double>> resultChina = new LinkedHashMap<>();
        allData.forEach((year, countryData) -> {
            if (countryData.containsKey(requiredCountry)) {
                resultChina.put(year, new LinkedHashMap<>(Map.of(requiredCountry, countryData.get(requiredCountry))));
            }
        });

        return resultChina;
    }

    // upload new data set for a year
    @PostMapping("/2020")
    public LinkedHashMap<Integer, LinkedHashMap<String, Double>> new2020Data() {
        
    }


//     // add data for a new country
//     @PutMapping("/energy/2022")


//     // delete data for a country
//     @DeleteMapping("/energy")
//     public
}
