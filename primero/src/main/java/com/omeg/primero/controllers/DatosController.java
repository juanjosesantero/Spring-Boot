package com.omeg.primero.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DatosController {
    @GetMapping("/detalles_info_datos")
    public String info(Model model) {
        model.addAttribute("Titulo", "Detalles de la Información");
        model.addAttribute("ip", "192.168.1.1");
        return "detalles_info_datos";

    }
    /*
    Con Model, podemos pasar datos desde el controlador a la vista. 
    En este caso, estamos agregando un atributo llamado "Titulo" con el valor "Detalles de la Información". 
    Esto permitirá que la vista "detalles_info" acceda a este dato y lo muestre en la página web.

    Model es un controlador de tipo MVC 

    Aunque se podria hacer con map<string,object> o pasar int string, ... 

    Añadir al html:
        <html lang="es" xmlns:th="https://www.thymeleaf.org"> 
        <title th:text="${Titulo}">Detalles de la Información</title>
        <h1 th:text="${Titulo}"></h1th:text>></h1>
    */
}
