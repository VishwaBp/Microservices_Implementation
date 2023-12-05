package com.vishwanath.pservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication

//@EnableEurekaClient // This annotation is optional as it is automatically enabled by Spring Boot when Eureka Client is added to the classpath.
public class PServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PServiceApplication.class, args);
    }

}
