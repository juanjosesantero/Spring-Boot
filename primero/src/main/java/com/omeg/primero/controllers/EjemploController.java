package com.omeg.primero.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class EjemploController {

    @GetMapping("/detalles_info")
    public String  info(){
        return "detalles_info";
    }
    public String ejemplo() {
        return "¡Hola desde EjemploController!";
    } 
}
