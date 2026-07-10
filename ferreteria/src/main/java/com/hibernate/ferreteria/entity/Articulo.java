package com.hibernate.ferreteria.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Articulo {

    @Id // Marca campo como PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreArticulo;
    private Double precio;
    private Integer existencia;

    // Con Lombok, no es necesario ni getters ni setters ni el contructor salvo alguno personalizado, porque da prioridad
}
