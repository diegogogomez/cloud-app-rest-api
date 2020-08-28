package com.cloud.cloudapprestapi.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {

    @GetMapping("/")
    public String sayHello(){
        return "Hello World! Time on server " + LocalDateTime.now() + "<h1><font face='verdana'>Spring Boot Rocks!</font></h1>";
    }

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Corre 5 kilometros.";
    }

    @GetMapping("/fortuna")
    public String getDailyFortune(){
        return "este es tu dia de fortuna.";
    }
}
