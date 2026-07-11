package com.example.libreria.Servicio;

import com.example.libreria.Model.Libro;
import com.example.libreria.RepoLibros.RepoLibroI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Marcar clase como componente de servicio, sin este no hay inyeccion de dependencias
public class ServicioLibro implements ServicioLibroI{

    private final RepoLibroI repo;

    @Autowired
    public ServicioLibro(RepoLibroI repo) {
        this.repo = repo;
    }

    public String buscaLibro(String titulo){
        if("El quijote".equalsIgnoreCase(titulo)){
            return "Libro encontrado";
        }
        else
            return "Libro no encontrado";
    }

    @Override
    public List<Libro> obtenerLibros() {
        return repo.findAll();
    }

    @Override
    public Optional<Libro> obtenerLibroPorId(long id) {
        return repo.findById(id);
    }

    @Override
    public Libro guardar(Libro libro) {
        return repo.save(libro);
    }

    @Override
    public void eliminarPorId(long id) {
        repo.deleteById(id);
    }

    @Override
    public String buscarLibroPorTitulo(String titulo) {
        boolean encontrado = repo.findAll().stream().anyMatch(libro -> libro.getTitulo()!=null&&libro.getTitulo().equalsIgnoreCase(titulo));

        return encontrado ? "Libro encontrado" : "Libro no encontrado";
    }
}
