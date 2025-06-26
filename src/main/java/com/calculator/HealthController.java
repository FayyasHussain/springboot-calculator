package com.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/")
    public String home() {
        return "Spring Boot Calculator is live!";
    }

    @GetMapping("/healthz")
    public String healthCheck() {
        return "OK";
    }


}
