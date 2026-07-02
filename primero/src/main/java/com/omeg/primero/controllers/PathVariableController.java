package com.omeg.primero.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping ("/api/variable") // Prefijo para todas las rutas de este controlador
public class PathVariableController {
    @GetMapping("/pagina1/{mensaje}")
    public ParametroDTO pagina1(@PathVariable String mensaje) { //Parametro a pasar obligatorio
        ParametroDTO parametro = new ParametroDTO();
        parametro.setInformacion(mensaje);
        return parametro;
    }
//http://localhost:8080/api/variable/pagina1/mensajeria%20movil
}

