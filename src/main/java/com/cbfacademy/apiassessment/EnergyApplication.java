package com.cbfacademy.apiassessment;

import java.io.*;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;
import org.springframework.boot.SpringApplication;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

@SpringBootApplication
public class EnergyApplication {

    	public static void main(String[] args) {
		SpringApplication.run(EnergyApplication.class, args);

        // access the LinkedHashMap in EnergyService
        EnergyService energyService = new EnergyService();
        LinkedHashMap<Integer, LinkedHashMap<String, Double>> data = energyService.getRenewableElectricityProduction();

        String filePath = getFilePath();
        saveToJSON(data, filePath);
        readFromJSON(filePath);
	}

    // method to create the JSON file
    protected static String getFilePath() {
            try {
            return ResourceUtils.getFile("classpath:newfile.json").getAbsolutePath();   
        } catch (FileNotFoundException e) {
            return "newfile.json";
        }
    }

    // method to save the LinkedHashMap in EnergyService to JSON file keeping the same formatting
    static void saveToJSON(LinkedHashMap<Integer, LinkedHashMap<String, Double>> data, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(data, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // method to read the data from the JSON file
    static LinkedHashMap<Integer, LinkedHashMap<String, Double>> readFromJSON(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            Gson gson = new Gson();
            Type type = new TypeToken<LinkedHashMap<Integer, LinkedHashMap<String, Double>>>() {}.getType();
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            e.printStackTrace();
            return new LinkedHashMap<>();
        } 
    }
}
