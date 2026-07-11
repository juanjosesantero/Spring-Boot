package com.omeg.excepciones.servicio;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileContent {
    public String LecturaArchivo(String ruta){
        try {
            Path Vruta = Paths.get(ruta);
            return Files.readString(Vruta);
        } catch (IOException e) {
            throw new RuntimeException("Error: lectura no encontrada"+e.getMessage(),e);
        }
    }
}
// Endpoints de este estilo mejor no poner en produccion por posibles hackeos