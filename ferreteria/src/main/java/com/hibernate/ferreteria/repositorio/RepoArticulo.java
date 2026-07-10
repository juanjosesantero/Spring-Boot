package com.hibernate.ferreteria.repositorio;

import com.hibernate.ferreteria.entity.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoArticulo extends JpaRepository<Articulo, Long> {
    
}
