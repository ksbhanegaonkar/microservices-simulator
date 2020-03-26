package com.tokenmagement.engine;

import java.util.HashMap;
import java.util.Map;

public class SimulatorEngine {

    private Map<String,String> simulatorRequestMap = new HashMap<>();

    public void registerService(String url, String responseBody){
        simulatorRequestMap.put("/simulator"+url,responseBody);
    }

    public String getServiceResponse(String url){
        return simulatorRequestMap.get(url);
    }

}
