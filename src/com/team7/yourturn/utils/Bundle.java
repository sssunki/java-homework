package com.team7.yourturn.utils;

import java.util.HashMap;
import java.util.List;

public class Bundle {

    private HashMap<String, Integer> intPackage;

    public Bundle() {
        intPackage = new HashMap<>();
    }

    public void addInteger(String key, Integer value) {
        intPackage.put(key,value);
    }

    

}
