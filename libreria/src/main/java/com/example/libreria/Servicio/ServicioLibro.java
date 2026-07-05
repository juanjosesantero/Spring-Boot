package com.example.libreria.Servicio;

import org.springframework.stereotype.Service;

@Service // Marcar clase como componente de servicio, sin este no hay inyeccion de dependencias
public class ServicioLibro {

    public String buscaLibro(String titulo){
        if("El quijote".equalsIgnoreCase(titulo)){
            return "Libro encontrado";
        }
        else
            return "Libro no encontrado";
    }
}
