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
    public String registerservice(@RequestBody String body, HttpServletRequest req) {
        String url = JsonUtil.getJsonValue(body, "url");
        String responseBody = JsonUtil.getJsonValue(body, "responsebody");
        simulatorEngine.registerService(url,responseBody);
        return req.getRequestURL().toString().replace("services/registerservice","simulator"+url);
    }

    @GetMapping("/getallrestservices")
    public List<RestEndpoint> getAllRestServices() {
        return simulatorEngine.getAllRestServices();
    }

}
