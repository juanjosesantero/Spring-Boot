package com.hibernate.ferreteria.servicio;

import com.hibernate.ferreteria.dto.ArticuloDTO;
import com.hibernate.ferreteria.entity.Articulo;
import com.hibernate.ferreteria.mapper.ArticuloMapper;
import com.hibernate.ferreteria.repositorio.RepoArticulo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArticuloServicio {
    private final RepoArticulo repoArticulo;

    public ArticuloServicio(RepoArticulo repoArticulo){this.repoArticulo = repoArticulo;}

    public List<ArticuloDTO> getArticulos(){
        return (List<ArticuloDTO>) repoArticulo.findAll().stream().map(ArticuloMapper::toDto).collect(Collectors.toList());
    }
    public ArticuloDTO insertarArticulo(ArticuloDTO articuloDTO){
        Articulo articulo= ArticuloMapper.toEntity(articuloDTO);
        Articulo insertado= repoArticulo.save(articulo);
        return  ArticuloMapper.toDto(insertado);
    }

    public ArticuloDTO actualizarArticulo(Long id,ArticuloDTO dto){
        Optional<Articulo> art=repoArticulo.findById(id);

        if(art.isPresent()){
            Articulo articulo=art.get();
            articulo.setId(dto.getId());
            articulo.setNombreArticulo(dto.getNombreArticulo());
            articulo.setExistencia(dto.getExistencia());
            articulo.setPrecio(dto.getPrecio());

            Articulo actual= repoArticulo.save(articulo);
            return ArticuloMapper.toDto(actual);
        }
        else
            throw new RuntimeException("No existe el articulo con el id: " + id);
    }

    public String eliminarArticulo(Long id) {
        if(repoArticulo.existsById(id)){
            repoArticulo.deleteById(id);
            return "Articulo eliminado con exito";
        }
        else
            throw new RuntimeException("No existe el articulo con el id: " + id);
    }
}
