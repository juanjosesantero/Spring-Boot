package com.hibernate.ferreteria.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Se encarga de to string , getters,setters
@Entity
@Table(name="articulos") //Indica la tabla, mapea esta y no el nombre de clase que seria la opcion por defecto
@NoArgsConstructor // Constructor obligatorio vacio
@AllArgsConstructor
public class Articulo {

    @Id // Marca campo como PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombreArticulo")
    private String nombreArticulo;
    private Double precio;
    private Integer existencia;

    // Con Lombok, no es necesario ni getters ni setters ni el contructor salvo alguno personalizado, porque da prioridad
}
