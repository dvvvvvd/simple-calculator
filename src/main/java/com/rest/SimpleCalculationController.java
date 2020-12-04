package com.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("calculate")
public class SimpleCalculationController {

    @GetMapping
    @ResponseBody
    public String getHello() {
        return "hello";
    }
}
