package com.hibernate.ferreteria.controlador;

import com.hibernate.ferreteria.dto.ArticuloDTO;
import com.hibernate.ferreteria.entity.Articulo;
import com.hibernate.ferreteria.mapper.ArticuloMapper;
import com.hibernate.ferreteria.repositorio.RepoArticulo;
import com.hibernate.ferreteria.servicio.ArticuloServicio;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*") // Anotacion para configurar CORS Cross Origin Resource Sharing, mecanismo de seguridad para evitar ajax a un server distinto del que se origino
// Este permite todos
@RestController
@RequestMapping("/api/articulos")
public class ArticuloController {
    private ArticuloServicio articuloServicio;

    public ArticuloController(ArticuloServicio articuloServicio) {this.articuloServicio=articuloServicio;}
    @GetMapping
    public List<ArticuloDTO> listarArticulos(){
        return articuloServicio.getArticulos();
    }
    @GetMapping("/{id}")
    public ArticuloDTO buscarArticuloPorId(@PathVariable Long id){
        return articuloServicio.buscarPorId(id);
    }
    @PostMapping
    public ArticuloDTO insertarArticulo(@RequestBody ArticuloDTO articuloDTO){
        return articuloServicio.insertarArticulo(articuloDTO);
    }

    @PutMapping("/{id}")
    public ArticuloDTO actualizarArticulo(@PathVariable Long id, @RequestBody ArticuloDTO articuloDTO){
        return articuloServicio.actualizarArticulo(id, articuloDTO);
    }
    @DeleteMapping("/{id}")
    public String eliminarArticulo(@PathVariable Long id){
        return articuloServicio.eliminarArticulo(id);
    }
}
