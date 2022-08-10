package com.platzi.market.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/saludar")
public class SaludarController {

    @GetMapping(value = "/hola")
    public String saludar() {
        return "Hola Haminton!!";
    }
}
