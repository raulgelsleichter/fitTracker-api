package com.fittracker.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/saude")
    public ResponseEntity<String> healthCheck() {
        return new ResponseEntity<>("A aplicação está rodando", HttpStatus.OK);
    }
}