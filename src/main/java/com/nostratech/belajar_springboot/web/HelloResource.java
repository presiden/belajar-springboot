package com.nostratech.belajar_springboot.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/hello")
public class HelloResource {
    @Value("${tes.name}")
    private String name;
    @GetMapping
    public String hello() {
        return "Hello World " + name;
    }
}
