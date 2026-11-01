package com.cia2.devops;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class StatusController {

    @GetMapping("/")
    public Map<String, String> home() {
        return Map.of(
            "application", "CIA2 DevOps CI/CD Application",
            "message", "Hello! Application deployed successfully!",
            "version", "v1",
            "platform", "Azure Kubernetes Service"
        );
    }

    @GetMapping("/api/status")
    public Map<String, String> status() {
        return Map.of(
            "status", "UP",
            "application", "CIA2 DevOps Application",
            "version", "v1"
        );
    }
}
