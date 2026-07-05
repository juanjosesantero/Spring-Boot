package com.omeg.primero.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController // Informacion formato json
@RequestMapping("/api/parametros")
public class RequestParamController {
    @GetMapping("/detalle")
    public ParametroDTO detalle(@RequestParam String informacion) {
        {
            ParametroDTO parametro1 = new ParametroDTO();
            parametro1.setInformacion(informacion);
            return parametro1;
        }
        //http://localhost:8080/api/parametros/detalle?informacion=saludo

    }
    @GetMapping("/null")
    public ParametroDTO nullValue(@RequestParam (required=false)String informacion) {
        {
            ParametroDTO parametro1 = new ParametroDTO();
            parametro1.setInformacion(informacion);
            return parametro1;
        }
        //http://localhost:8080/api/parametros/otro?informacion=saludo
        //(required=false),indica que el parametro es opcional, por defecto es null 

    }
    @GetMapping("/otro")
    public ParametroDTO otro(@RequestParam (required=false, defaultValue="default")String informacion) {
        {
            ParametroDTO parametro1 = new ParametroDTO();
            parametro1.setInformacion(informacion);
            return parametro1;
        }
        //http://localhost:8080/api/parametros/otro?informacion=saludo
        //(required=false),indica que el parametro es opcional, por defecto es null
        //(defaultValue="default"),indica que el parametro es opcional, por defecto es "default" 

    }
}