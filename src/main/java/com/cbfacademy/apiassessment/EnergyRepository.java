package com.cbfacademy.apiassessment;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
// import java.io.FileWriter;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class EnergyRepository {

//     public void saveToJSON() {

//         // create a Gson object
//         Gson gson = new Gson();

//         // create an object to save as JSON
//         EnergyService energyService = new EnergyService();

//         // specify the file path
//         String filePath = "src/main/resources/data/newfile.json";

//         gson.toJson(new EnergyService(), new FileWriter(filePath));

// }





    // method to save data to a JSON file
    public void saveToJSON() {

        String filePath = "src/main/resources/data/newfile.json";
        EnergyService energyService = new EnergyService();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(filePath), energyService.getRenewableElectricityProduction());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // method to read data from a JSON file
    public static EnergyService readFromJSON() {

        String filePath = "src/main/resources/data/newfile.json";
        EnergyService energyService = new EnergyService();

        // the EnergyService Class contains a nested hashmap so read the data as a hashmap or it will throw errors
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            HashMap<Integer, HashMap<String, Double>> data = objectMapper.readValue(new File(filePath), new TypeReference<HashMap<Integer, HashMap<String, Double>>>() {});
            energyService.setRenewableElectricityProduction(data);

            return energyService;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}