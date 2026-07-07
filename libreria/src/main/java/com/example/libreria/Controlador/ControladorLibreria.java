package com.example.libreria.Controlador;

import com.example.libreria.Model.Libro;
import com.example.libreria.RepoLibros.RepoLibros;
import com.example.libreria.Servicio.ServicioLibro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class ControladorLibreria {
    private final ServicioLibro servicioLibro;
    private final RepoLibros repoLibro;
    public ControladorLibreria(ServicioLibro servicioLibro, RepoLibros repoLibro) {
        this.servicioLibro = servicioLibro;
        this.repoLibro = repoLibro;
    }

    // Inyeccion de dependencias por constructor, porque se busca un bean que encaje en el constructores

    @GetMapping("/{titulo}")
    public String DameLibro(@PathVariable String titulo) {
        return servicioLibro.buscaLibro(titulo);
    }
    @GetMapping("/todos")
    public List<Libro> todos(){
        return repoLibro.getLibros();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Libro> buscaLibro(@PathVariable long id){
        return repoLibro.BuscaID(id)
                .map(ResponseEntity::ok)    // Si devuelve un ok el servidor
                .orElse(ResponseEntity.notFound().build()); // Si no devuelve una respuesta con 404, se devuelve un builder, por eso el .build
                //Response Entity
    }

    @GetMapping("/clone")
    public String probarClone(){
        Libro l = new Libro(1L,"Miguel de Cervantes", "El Quijote", LocalDate.of(1605, 1, 16));
        Libro copia= null;
        try {
            copia = l.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        copia.setTitulo("Copia Prueba");
        copia.setIdLibro(8);
        return  "Original: "+ l.toString()+ "\n"+"\ncopia: "+ copia.toString();
    }
}
