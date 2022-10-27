package com.test.ass1;

import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

import com.google.gson.*;
import org.testng.annotations.Test;

public class ex3 {
    @DataProvider
    public Iterator<Object[]> readJsonData() throws FileNotFoundException {
        JsonArray jsonData = JsonParser.parseReader(new FileReader("src/test/resources/json/data.json")).getAsJsonArray();
        System.out.println("jsonData: " + jsonData);

        Collection<Object[]> dp = new ArrayList<>();
        Gson gson = new Gson();

        for(JsonElement jsonElement : jsonData){
            Map<String, String> map = gson.fromJson(jsonElement.getAsJsonObject(), Map.class);
            System.out.println("map: "+map);
            dp.add(new Object[]{map});

        }
        return dp.iterator();
    }

    @DataProvider
    public Iterator<Object[]> getJsonData() throws FileNotFoundException {
        JsonArray jsonArray = JsonParser.parseReader(new FileReader("src/test/resources/json/data.json")).getAsJsonArray();
        System.out.println("Lay tu file Json: " + jsonArray);

        Collection<Object[]> dp = new ArrayList<>();
        Gson gson = new Gson();

        for(JsonElement jsonElement : jsonArray){
            Map<String, String> map = gson.fromJson(jsonElement.getAsJsonObject(), Map.class);
            System.out.println("element: " + jsonElement+"map: " +map);
            dp.add(new Object[]{map});

        }
        return dp.iterator();
    }
    @Test(dataProvider = "getJsonData")
    public void myTest(Map<String, String> data) throws FileNotFoundException {
        System.out.println("color: "+ data.get("color"));
        System.out.println("value: "+ data.get("value"));
    }

}
