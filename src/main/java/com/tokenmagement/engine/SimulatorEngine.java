package com.tokenmagement.engine;

import com.tokenmagement.entity.RestEndpoint;
import com.tokenmagement.entity.UrlNode;
import com.tokenmagement.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SimulatorEngine {

    UrlNode baseNode = new UrlNode("simulator");

    @Autowired
    ApplicationService service;
    private Map<String, RestEndpoint> simulatorRequestMap = new ConcurrentHashMap<>();

    public SimulatorEngine() {
        //initEngine();
    }

    private void initEngine(){
        List<RestEndpoint> list = service.getAllEndpoints();
        list.stream().forEach(e->simulatorRequestMap.put("/simulator"+e.getUrl(),e));
    }

    private void initEngineNew(){
        List<RestEndpoint> list = service.getAllEndpoints();
        list.stream().forEach(e->{
            StringTokenizer st = new StringTokenizer(e.getUrl(),"/");
            Set<UrlNode> tmpSet = baseNode.getNextNodes();
            while (st.hasMoreTokens()){
                String token = st.nextToken();

                UrlNode tmpNode = new UrlNode(token);
                if(tmpSet.contains(tmpNode)){
                    tmpSet = getNextNodeSet(tmpSet,tmpNode);
                }else{
                    tmpSet.add(tmpNode);
                    tmpSet = tmpNode.getNextNodes();
                }

            }
        });

        System.out.println("hi");
    }

    private Set<UrlNode> getNextNodeSet(Set<UrlNode> tmpSet, UrlNode tmpNode) {
        for(UrlNode n : tmpSet){
            if(n.equals(tmpNode)){
                return n.getNextNodes();
            }
        }
        return new HashSet<>();
    }


    public RestEndpoint registerService(String name, String description,String url, String responseBody){
        RestEndpoint e = new RestEndpoint(name,description,url,responseBody);
        simulatorRequestMap.put("/simulator"+e.getUrl(),e);
        service.registerEndpoint(e);
        return e;
    }

    public String getServiceResponse(String url){
        if(simulatorRequestMap.isEmpty()){
            initEngine();
            initEngineNew();
        }
        if(simulatorRequestMap.containsKey(url))
        return simulatorRequestMap.get(url).getResponseBody();
        else return "Url not registered";
    }

    public List<RestEndpoint> getAllRestServices(){
        return service.getAllEndpoints();
    }

}
