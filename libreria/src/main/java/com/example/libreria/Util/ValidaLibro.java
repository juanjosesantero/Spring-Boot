package com.example.libreria.Util;

import com.example.libreria.Model.Libro;
import org.springframework.stereotype.Component;

@Component  // Bean generico de Spring
public class ValidaLibro {
    public Libro libro;
    public boolean tituloValido(String titulo) {

        return libro.getTitulo()!=null&&!libro.getTitulo().isBlank();
    }
}
