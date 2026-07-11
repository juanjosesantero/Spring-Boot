package com.hibernate.ferreteria.mapper;

import com.hibernate.ferreteria.dto.ArticuloDTO;
import com.hibernate.ferreteria.entity.Articulo;

public class ArticuloMapper {
    public static ArticuloDTO toDto(Articulo articulo){
        return new ArticuloDTO(articulo.getId(),articulo.getNombreArticulo(),articulo.getPrecio(),articulo.getExistencia());
    }
    public static Articulo toEntity (ArticuloDTO dto){
        Articulo articulo = new Articulo();
        articulo.setId(dto.getId());
        articulo.setNombreArticulo(dto.getNombreArticulo());
        articulo.setPrecio(dto.getPrecio());
        articulo.setExistencia(dto.getExistencia());
        return  articulo;
    }
}
