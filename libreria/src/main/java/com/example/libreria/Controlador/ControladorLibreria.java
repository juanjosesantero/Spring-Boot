package com.example.libreria.Controlador;

import com.example.libreria.Servicio.ServicioLibro;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/libros")
public class ControladorLibreria {
    private final ServicioLibro servicioLibro;

    public ControladorLibreria(ServicioLibro servicioLibro) {
        this.servicioLibro = servicioLibro;
    }

    // Inyeccion de dependencias por constructor, porque se busca un bean que encaje en el constructores

    @GetMapping("/{titulo}")
    public String DameLibro(@PathVariable String titulo) {
        return servicioLibro.buscaLibro(titulo);
    }
}
