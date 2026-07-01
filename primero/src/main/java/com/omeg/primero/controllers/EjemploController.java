package com.omeg.primero.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.omeg.primero.models.Empleado;

@Controller
public class EjemploController {

    @GetMapping("/detalles_info")
    public String info() {
        return "detalles_info";
    }

    public String ejemplo() {
        return "¡Hola desde EjemploController!";
    }

    @GetMapping("/modelo")
    public String modelo(Model modelo) {

        Empleado empleado1 = new Empleado(001, "Juan", "Rodriguez", "Desarrollador", 30, 987654231);
        modelo.addAttribute("Empleado", empleado1);
        modelo.addAttribute("Titulo", "Detalles del Empleado");
        return "modelo";
    }
}
