package com.cbfacademy.apiassessment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/energy")
public class EnergyController {

    private final EnergyService energyService;
    
    @Autowired
    public EnergyController(EnergyService energyService) {
        this.energyService = energyService;
    }

    // get the whole list of electricity production percentages from renewable sources
    @GetMapping("/allData")
    public HashMap<Integer, HashMap<String, Double>> getAllEnergyData() {
        return energyService.getRenewableElectricityProduction();
    }

//     // upload new data set for a year
//     @PostMapping("/energy")


//     // add data for a new country
//     @PutMapping("/energy/2022")


//     // delete data for a country
//     @DeleteMapping("/energy")
//     public
}