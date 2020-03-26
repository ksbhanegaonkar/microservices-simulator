package com.tokenmagement.controller;

import com.tokenmagement.engine.SimulatorEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tokenmagement.util.JsonUtil;

import javax.servlet.http.HttpServletRequest;

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

}
