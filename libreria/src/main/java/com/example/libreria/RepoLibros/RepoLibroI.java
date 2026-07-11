package com.example.libreria.RepoLibros;

import com.example.libreria.Model.Libro;

import java.util.List;
import java.util.Optional;

public interface RepoLibroI {
    List<Libro> findAll();
    Optional<Libro> findById(long id);
    Libro save(Libro libro);
    void deleteById(long id);

    List<Libro> getLibros();
}
