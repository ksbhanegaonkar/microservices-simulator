package com.tokenmagement;

import com.tokenmagement.entity.RestEndpoint;
import com.tokenmagement.repository.RestEndpointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = "com.tokenmagement")
public class MavenreactjsspringbootApplication implements CommandLineRunner {
	@Autowired
    RestEndpointRepository repo;

    public static void main(String[] args) {
        SpringApplication.run(MavenreactjsspringbootApplication.class, args);
    }



/*
    @Bean
    public SimulatorEngine createSimulatorEngine() {
        SimulatorEngine engine = new SimulatorEngine();
        return engine;
    }
*/

    
	  @Override public void run(String... args) {

//          RestEndpoint p = new RestEndpoint("/test123","test12response");
//		  repo.save(p);

//          RestEndpoint r = repo.getByUrl("/test12");
//          System.out.println(r);


//          List<RestEndpoint> e = repo.findAll();
//          System.out.println(e);
	  
	  }
	  

}
