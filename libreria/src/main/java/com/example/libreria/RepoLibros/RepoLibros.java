package com.example.libreria.RepoLibros;

import com.example.libreria.Model.Libro;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository // Anotacion para que el sistema verifique que este será el repositorio
public class RepoLibros {
    private final List<Libro> libros= new ArrayList<>();    // Final para referencia inmutable

    public RepoLibros() {
        libros.add(new Libro(1L,"Miguel de Cervantes", "El Quijote", LocalDate.of(1605, 1, 16)));
        libros.add(new Libro(2L, "Gabriel García Márquez", "Cien Años de Soledad", LocalDate.of(1967, 5, 30)));
        libros.add(new Libro(3L, "J.K. Rowling", "Harry Potter y la Piedra Filosofal", LocalDate.of(1997, 6, 26)));
        libros.add(new Libro(4L, "George Orwell", "1984", LocalDate.of(1949, 6, 8)));
        libros.add(new Libro(5L, "F. Scott Fitzgerald", "El Gran Gatsby", LocalDate.of(1925, 4, 10)));
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public Optional<Libro> BuscaID(long idLibro) {
        return libros.stream()
                .filter(libros1->libros1.getIdLibro()==idLibro)
                .findFirst();
    }
}
