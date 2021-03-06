package com.tokenmagement.controller;

import com.tokenmagement.engine.SimulatorEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/simulator")
public class SimulatorController {

    @Autowired
    SimulatorEngine simulatorEngine;

    @GetMapping("/**")
    public String simulateGetResponse(HttpServletRequest req){
        String [] s = req.getRequestURI().split("/");
        return simulatorEngine.getServiceResponse(req.getRequestURI());
    }
}
