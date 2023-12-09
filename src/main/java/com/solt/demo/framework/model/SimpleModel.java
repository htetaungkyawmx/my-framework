package com.solt.demo.framework.model;

import java.util.HashMap;
import java.util.Map;

public class SimpleModel implements Model{

    private Map<String,String> model=new HashMap<>();

    @Override
    public void set(String name, String value) {

    }

    @Override
    public String get(String name) {
        return null;
    }
}
