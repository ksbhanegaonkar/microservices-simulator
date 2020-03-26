package com.tokenmagement.services;

import com.tokenmagement.entity.RestEndpoint;
import com.tokenmagement.repository.RestEndpointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {
    @Autowired
    RestEndpointRepository repo;


    public void registerEndpoint(String url,String body){
        repo.save(new RestEndpoint(url,body));
    }

    public void registerEndpoint(RestEndpoint e){
        repo.save(e);
    }

    public List<RestEndpoint> getAllEndpoints(){
        return repo.findAll();
    }
}
