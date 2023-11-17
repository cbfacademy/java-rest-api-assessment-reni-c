package com.cbfacademy.apiassessment;

import java.io.*;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@SpringBootApplication
public class EnergyApplication {

    private static final String filePath = "src\\main\\resources\\data\\newfile.json";
    static EnergyService energyService = new EnergyService();

    	public static void main(String[] args) {
		SpringApplication.run(EnergyApplication.class, args);
	}
    
    // method to save to JSON file
    static void saveToJSON() {
        try (FileWriter writer = new FileWriter(filePath)) {
          Gson gson = new Gson(); 
          gson.toJson(energyService.getRenewableElectricityProduction(), writer); 
          writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // method to read from JSON file
    static LinkedHashMap<Integer, LinkedHashMap<String, Double>> readFromJSON() {
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
