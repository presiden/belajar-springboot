package com.nostratech.belajar_springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nostratech.belajar_springboot.config.ApplicationProperties;

@RestController
@RequestMapping("/v1/hello")
public class HelloResource {
    
    private ApplicationProperties applicationProperties;

    public HelloResource(ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }

    @GetMapping
    public String hello() {
        return "Hello World! " + applicationProperties.getName();
    }
}
