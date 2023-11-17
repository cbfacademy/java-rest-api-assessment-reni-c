package com.cbfacademy.apiassessment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.LinkedHashMap;

@RestController
@RequestMapping("/energy")
public class EnergyController {

    private final EnergyService energyService;
    
    public EnergyController(EnergyService energyService) {
        this.energyService = energyService;
    }

    String filePath = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "data" + File.separator + "newfile.json";
    // private final EnergyApplication energyAEnergyApplication;
    // public EnergyController(EnergyApplication energyAEnergyApplication) {
    //     this.energyAEnergyApplication = energyAEnergyApplication;
    // }

    // get the whole list of electricity production percentages from renewable sources from the JSON file
    @GetMapping("/allData")
    public LinkedHashMap<Integer, LinkedHashMap<String, Double>> getAllEnergyData() {
        return EnergyApplication.readFromJSON(filePath);
    }

    // get electricity production percentages for 2021


    // get electricity percentages for 2022


    // get electricity percentages for a specific country

//     // upload new data set for a year
//     @PostMapping("/energy")


//     // add data for a new country
//     @PutMapping("/energy/2022")


//     // delete data for a country
//     @DeleteMapping("/energy")
//     public
}
