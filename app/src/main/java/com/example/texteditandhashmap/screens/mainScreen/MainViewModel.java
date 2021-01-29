package com.example.texteditandhashmap.screens.mainScreen;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.util.HashMap;
import java.util.Map;

public class MainViewModel extends AndroidViewModel {
    private static Map<String,String> countries;
    public MainViewModel(@NonNull Application application) {
        super(application);
        countries = new HashMap<>();
    }

    public Map<String, String> getCountries() {
        return countries;
    }

    public void addCountry(String key,String val){
        countries.put(key, val);
    }

    public void clearCountries() {
        if (!countries.isEmpty())
            countries.clear();
    }
    public String fromMapToString(Map<String,String> map){

        StringBuilder stringBuilder = new StringBuilder();
        for(String city:map.keySet()){
            stringBuilder.append(city).append("  -  ").append(map.get(city)).append("\n");
        }
        return stringBuilder.toString();

    }

    public String findCapitalByCity(String city){
        return countries.get(city);
    }


}
