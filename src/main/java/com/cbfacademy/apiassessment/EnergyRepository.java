package com.cbfacademy.apiassessment;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

import org.springframework.boot.autoconfigure.SpringBootApplication;

// import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class EnergyRepository {

    public void saveToJSON() {

        // create a Gson object
        Gson gson = new Gson();

        // create an object to save as JSON
        EnergyService energyService = new EnergyService();

        // specify the file path
        String filePath = "src/main/resources/data/newfile.json";

        gson.toJson(new EnergyService(), new FileWriter(filePath));

}





    // // method to save data to a JSON file
    // public void saveToJSON(String filePath) {

    //     ObjectMapper objectMapper = new ObjectMapper();
    //     try {
    //         objectMapper.writeValue(new File(filePath), "src/main/resources/data/newfile.json");
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }

    // // method to read data from a JSON file
    // public static EnergyService readFromJSON(String filePath) {

    //     ObjectMapper objectMapper = new ObjectMapper();
    //     try {
    //         return objectMapper.readValue(new File(filePath), EnergyService.class);
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //         return null;
    //     }
    // }
}