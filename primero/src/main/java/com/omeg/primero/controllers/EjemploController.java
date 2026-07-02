package com.omeg.primero.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

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

        //Empleado empleado1 = new Empleado(001, "Juan", "Rodriguez", "Desarrollador", 30, 987654231,"Calle 1 Nº 2");
        Empleado empleado1 = new Empleado(001, "Juan", "Rodriguez", "Desarrollador", 30, 987654231,null);
        modelo.addAttribute("Empleado", empleado1);
        modelo.addAttribute("Titulo", "Detalles del Empleado");
        return "modelo";
    }

    @ModelAttribute("Empleados")    //Nombre de la vista a cargar datos
    // Model atriobute para agregar atributos al modelo que se utilizarán en la vista. En este caso, se está agregando una lista de empleados con el nombre "Empleados".
    public List<Empleado> ListaEmpleados(){
        return Arrays.asList(
            new Empleado(002, "Maria", "Gonzalez", "Analista", 28, 123456789,"Calle 2 Nº 3"),
            new Empleado(003, "Pedro", "Martinez", "Diseñador", 35, 987654321,"Calle 3 Nº 4"),
            new Empleado(004, "Laura", "Lopez", "Gerente", 40, 456789123,"Calle 4 Nº 5"),
            new Empleado(005, "Carlos", "Sanchez", "Programador", 25, 789123456,"Calle 5 Nº 6")
        );
        
    }
}
