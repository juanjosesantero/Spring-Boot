package com.omeg.primero.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController // Handler rest en vez de handler que seria un conttroller normal
public class EjemploRestController {

@GetMapping("/rest")
    public Map<String, Object> rest() {
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("Titulo", "Detalles de la Información");
        respuesta.put("ip", "192.168.1.1");
        return respuesta;
    }
}
