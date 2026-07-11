package com.example.libreria.Servicio;

import com.example.libreria.Model.Libro;

import java.util.List;
import java.util.Optional;

public interface ServicioLibroI {
    List<Libro> obtenerLibros();
    Optional<Libro> obtenerLibroPorId(long id);
    Libro guardar(Libro libro);
    void eliminarPorId(long id);
    String buscarLibroPorTitulo(String titulo);

    String buscaLibro(String titulo);
}
