package com.tokenmagement.controller;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.tokenmagement.engine.SimulatorEngine;
import com.tokenmagement.entity.RestEndpoint;
import com.tokenmagement.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/services")
public class ActionController {


	@Autowired
	SimulatorEngine simulatorEngine;
	

    @PostMapping("/registerservice")
    public RestEndpoint registerservice(@RequestBody String body, HttpServletRequest req) {
        String name = JsonUtil.getJsonValue(body, "name");
        String description = JsonUtil.getJsonValue(body, "description");
        String url = JsonUtil.getJsonValue(body, "url");
        String responseBody = JsonUtil.getJsonValue(body, "responseBody");
        return simulatorEngine.registerService(name,description,url,responseBody);

    }

    @GetMapping("/getallrestservices")
    public List<RestEndpoint> getAllRestServices() {
        return simulatorEngine.getAllRestServices();
    }

}
