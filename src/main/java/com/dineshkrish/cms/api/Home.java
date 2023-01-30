package com.dineshkrish.cms.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class Home {

    @GetMapping
    public String home() {

        System.out.println("Andy at least home got called");
        return "Application is works!!! " + new Date();

    }


}
