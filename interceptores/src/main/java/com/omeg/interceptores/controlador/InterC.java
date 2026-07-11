package com.omeg.interceptores.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InterC {
    @GetMapping("/saludar")
    public String saludar(){
        return "Saludos interceptor";
    }
}
