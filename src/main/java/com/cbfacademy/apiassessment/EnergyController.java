package com.cbfacademy.apiassessment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/energy")
public class EnergyController {

    private final EnergyService energyService;

    public EnergyController(EnergyService energyService) {
        this.energyService = energyService;
    }

    // get the whole list of renewable electricity production percentages from the JSON file
    @GetMapping("/allData")
    public LinkedHashMap<Integer, LinkedHashMap<String, Double>> getAllEnergyData() {
        return EnergyApplication.readFromJSON(EnergyApplication.getFilePath());
    }

    // get renewable electricity production percentages for 2021
    @GetMapping("/2021")
    public ResponseEntity<Object> get2021Data() {
        try { 
            LinkedHashMap<Integer, LinkedHashMap<String, Double>> allData = EnergyApplication.readFromJSON(EnergyApplication.getFilePath());
            if (allData.containsKey(2021)) {
                LinkedHashMap<String, Double> dataFor2021 = allData.get(2021);
                LinkedHashMap<Integer, LinkedHashMap<String, Double>> result2021 = new LinkedHashMap<>();
                result2021.put(2021, dataFor2021);
                return new ResponseEntity<>(result2021, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Renewable electricity production percentages for 2021 were not found.", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to retrieve renewable electricity production percentages for 2021.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // get renewable electricity production percentages for 2022
    @GetMapping("/2022")
    public ResponseEntity<Object> get2022Data() {
        try { 
            LinkedHashMap<Integer, LinkedHashMap<String, Double>> allData = EnergyApplication.readFromJSON(EnergyApplication.getFilePath());
            if (allData.containsKey(2022)) {
                LinkedHashMap<String, Double> dataFor2022 = allData.get(2022);
                LinkedHashMap<Integer, LinkedHashMap<String, Double>> result2022 = new LinkedHashMap<>();
                result2022.put(2022, dataFor2022);
                return new ResponseEntity<>(result2022, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Renewable electricity production percentages for 2022 were not found.", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to retrieve renewable electricity production percentages for 2022.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // get renewable electricity percentages for a specific country
    @GetMapping("/countryData")
    public ResponseEntity<Object> getCountryData(@RequestParam String country) {
        try {
            LinkedHashMap<Integer, LinkedHashMap<String, Double>> allData = EnergyApplication.readFromJSON(EnergyApplication.getFilePath());
            LinkedHashMap<String, Double> countryData = new LinkedHashMap<>();

            // get the year and renewable electricity production percentage for said year
            for (Map.Entry<Integer, LinkedHashMap<String, Double>> entry : allData.entrySet()) {
                int year = entry.getKey();
                LinkedHashMap<String, Double> yearData = entry.getValue();

                // if the country exists in the specified year, add it to the result
                if (yearData.containsKey(country)) {
                    countryData.put(Integer.toString(year), yearData.get(country));
                }
            }

            // exception handling in case data for specified country can't be found
            if (!countryData.isEmpty()) {
                return new ResponseEntity<>(countryData, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Renewable electricity production percentages for the specified country cannot be found.", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to retrieve renewable electricity production percentages for the specified country.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // upload new renewable electricity percentages for a new or existing year
    @PostMapping("/newData")
    public ResponseEntity<Object> addEnergyData(@RequestParam int year, @RequestBody LinkedHashMap<String, Double> newData) {
        try { 
            energyService.addEnergyData(year, newData);
            LinkedHashMap<Integer, LinkedHashMap<String, Double>> updatedData = energyService.getRenewableElectricityProduction();
            EnergyApplication.saveToJSON(updatedData, EnergyApplication.getFilePath());
            return new ResponseEntity<>(updatedData, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to add new renewable electricity production percentages.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // upload new renewable electricity percentage(s) for a new country 
    @PostMapping("/newCountryData")
    public ResponseEntity<Object> addCountryData(@RequestParam int year, @RequestBody LinkedHashMap<String, Double> newData) {
        try { 
            energyService.addEnergyData(year, newData);
            LinkedHashMap<Integer, LinkedHashMap<String, Double>> updatedData = energyService.getRenewableElectricityProduction();
            EnergyApplication.saveToJSON(updatedData, EnergyApplication.getFilePath());
            return new ResponseEntity<>(updatedData, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to add new renewable electricity production percentage(s) for specified country.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // update renewable electricity percentage for a new country
    @PutMapping("/updateCanada2021")
    public  ResponseEntity <Object> updateCanada2021Data(@RequestBody LinkedHashMap<String, Double> newData) {
        try {
            int yearToUpdate = 2021;
            LinkedHashMap<String, Double> existingData = EnergyApplication.readFromJSON(EnergyApplication.getFilePath()).get(yearToUpdate);

            // exception handling in case the specified information can't be found/doesn't exist
            if (existingData == null) {
                return new ResponseEntity<>("Renewable electricity production percentage for the country in the specified year cannot be found.", HttpStatus.NOT_FOUND);
            }

            // update the value and save it back to the JSON file with exception handling
            existingData.put("Canada", newData.get("Canada"));
            EnergyApplication.saveToJSON(EnergyApplication.readFromJSON(EnergyApplication.getFilePath()), EnergyApplication.getFilePath());
            return new ResponseEntity<>(existingData, HttpStatus.ACCEPTED);  
        } catch (Exception e) {
            return new ResponseEntity<>("Renewable electricity percentage could not be updated.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // update data for multiple countries in a specific year
    @PutMapping("/updateMultipleCountries2022")
    public  ResponseEntity <Object> updateMultipleCountries(@RequestBody LinkedHashMap<String, Double> newData) {
        try {
            int yearToUpdate = 2022;
            LinkedHashMap<Integer, LinkedHashMap<String, Double>> allData = EnergyApplication.readFromJSON(EnergyApplication.getFilePath());

            // exception handling in case the specified information can't be found/doesn't exist
            if (!allData.containsKey(yearToUpdate)) {
                return new ResponseEntity<>("Renewable electricity percentages for the specified year cannot be found.", HttpStatus.NOT_FOUND);
            }

            LinkedHashMap<String, Double> existingData = allData.get(yearToUpdate);

            // update the values for multiple countries with included exception handling
            for (Map.Entry<String, Double> entry : newData.entrySet()) {
                if (existingData.containsKey(entry.getKey())) {
                    existingData.put(entry.getKey(), entry.getValue());
                } else {
                    return new ResponseEntity<>("Renewable electricity percentages for the specified countries cannot be found.", HttpStatus.NOT_FOUND);
                }
            }

            EnergyApplication.saveToJSON(allData, EnergyApplication.getFilePath());
            return new ResponseEntity<>(allData, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>("Renewable electricity percentages could not be updated.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // delete all data for a specific year
    @DeleteMapping("deleteAllData/{year}")
    public ResponseEntity<Object> deleteDataForAYear(@PathVariable int year) {
        try {
            LinkedHashMap<Integer, LinkedHashMap<String, Double>> allData = EnergyApplication.readFromJSON(EnergyApplication.getFilePath());

            // exception handling in case data for specified year can't be found
            if (!allData.containsKey(year)) {
                return new ResponseEntity<>("Renewable electricity percentages for the specified year cannot be found.", HttpStatus.NOT_FOUND);
            }

            // remove the data for specified year and save it back to JSON file
            allData.remove(year);
            EnergyApplication.saveToJSON(allData, EnergyApplication.getFilePath());
            return new ResponseEntity<>(allData, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete renewable electricity percentages for specified year.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // delete data for a country in a specific year
    @DeleteMapping("deleteAllData/{year}/{country}")
    public ResponseEntity<Object> deleteDataForCountryInYear(@PathVariable int year, @PathVariable String country) {
        try {
            LinkedHashMap<Integer, LinkedHashMap<String, Double>> allData = EnergyApplication.readFromJSON(EnergyApplication.getFilePath());
            
            // exception handling in case data for specified year or country can't be found
            if (!allData.containsKey(year)) {
                return new ResponseEntity<>("Renewable electricity percentages for the specified year cannot be found.", HttpStatus.NOT_FOUND);
            }
            LinkedHashMap<String, Double> countryData = allData.get(year);
            if (!countryData.containsKey(country)) {
                return new ResponseEntity<>("Renewable electricity percentage(s) for the specified country cannot be found.", HttpStatus.NOT_FOUND);
            }

            // remove the data for specified country then save it back to JSON file
            countryData.remove(country);
            EnergyApplication.saveToJSON(allData, EnergyApplication.getFilePath());
            return new ResponseEntity<>(allData, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete renewable electricity percentages for specified country and year.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
