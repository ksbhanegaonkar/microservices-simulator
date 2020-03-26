package com.tokenmagement.engine;

import com.tokenmagement.entity.RestEndpoint;
import com.tokenmagement.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SimulatorEngine {

    @Autowired
    ApplicationService service;
    private Map<String, RestEndpoint> simulatorRequestMap = new HashMap<>();

    public SimulatorEngine() {
        //initEngine();
    }

    private void initEngine(){
        List<RestEndpoint> list = service.getAllEndpoints();
        list.stream().forEach(e->simulatorRequestMap.put(e.getUrl(),e));
    }

    public void registerService(String url, String responseBody){
        RestEndpoint e = new RestEndpoint("/simulator"+url,responseBody);
        simulatorRequestMap.put(e.getUrl(),e);
        service.registerEndpoint(e);
    }

    public String getServiceResponse(String url){
        if(simulatorRequestMap.isEmpty()){
            initEngine();
        }
        if(simulatorRequestMap.containsKey(url))
        return simulatorRequestMap.get(url).getResponseBody();
        else return "Url not registered";
    }

    public List<RestEndpoint> getAllRestServices(){
        return service.getAllEndpoints();
    }

}
