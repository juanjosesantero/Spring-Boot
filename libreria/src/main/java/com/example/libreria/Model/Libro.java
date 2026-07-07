package com.example.libreria.Model;

import java.time.LocalDate;

public class Libro implements  Cloneable{

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

    @Override
    public String toString() {
        return "Libro{" +
                "idLibro=" + idLibro +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", fechaPublicacion=" + fechaPublicacion +
                '}';
    }

    public Libro(long idLibro, String titulo, String autor, LocalDate fechaPublicacion) {
        this.titulo = titulo;
        this.idLibro = idLibro;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
    }
    // implements clone
    @Override
    public Libro clone() throws CloneNotSupportedException {
        return (Libro) super.clone();
    }
}
