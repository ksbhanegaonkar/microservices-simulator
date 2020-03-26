package com.tokenmagement;

import com.tokenmagement.engine.SimulatorEngine;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MavenreactjsspringbootApplication implements CommandLineRunner {
	//@Autowired
	//ServiceCounterRepository serviceCounterRepository;
    public static void main(String[] args) {
        SpringApplication.run(MavenreactjsspringbootApplication.class, args);
    }



    @Bean
    public SimulatorEngine createSimulatorEngine(
            @Value("${tokencounter.count}") int tokenCounters,
            @Value("${normal.servicecounter}") int normalServiceCounters,
            @Value("${premium.servicecounter}") int premiumServiceCounters) {
        SimulatorEngine engine = new SimulatorEngine();
        return engine;
    }

    
	  @Override public void run(String... args) {
		  //ServiceCounter counter = new ServiceCounter();
		  

	  
	  }
	  

}
