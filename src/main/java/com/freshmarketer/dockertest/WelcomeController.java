package com.freshmarketer.dockertest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/docker")
public class WelcomeController {

    @GetMapping
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hi, First docker image!!");
    }

    @GetMapping("/env")
    public ResponseEntity<String> env() {
        Map<String, String> env = System.getenv();
        return ResponseEntity.ok(env.keySet().stream().map(k -> k + '=' + env.get(k)).collect(Collectors.joining("\n")));
    }
}
