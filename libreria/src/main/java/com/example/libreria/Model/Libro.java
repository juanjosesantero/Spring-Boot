package com.example.libreria.Model;

import java.time.LocalDate;

public class Libro {

    private long idLibro;
    private String titulo;
    private String autor;
    private LocalDate fechaPublicacion;

    public long getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(long idLibro) {
        this.idLibro = idLibro;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Libro( long idLibro,String titulo, String autor, LocalDate fechaPublicacion) {
        this.titulo = titulo;
        this.idLibro = idLibro;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
    }
}
