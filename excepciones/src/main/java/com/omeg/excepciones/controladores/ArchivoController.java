package com.omeg.excepciones.controladores;

import com.omeg.excepciones.servicio.FileContent;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/archivo")
public class ArchivoController {
    private final FileContent contenido;

    public ArchivoController(FileContent contenido) {
        this.contenido = contenido;
    }

    @GetMapping("/lectura")
    public ResponseEntity<String> lectura(@RequestParam String ruta) {
        try {
            String archivo = contenido.LecturaArchivo(ruta);
            //return ResponseEntity.ok(archivo);
            return ResponseEntity.ok().header("Content-Type", "text/plain; charset=UTF-8").body(archivo); // respeta los saltos de linea
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: lectura de arhivo incorrecta | " + e);//'status' has private access in 'org.springframework.http.ResponseEntity'
        }
    }

    // gpt
    @GetMapping("/pdf")
    public ResponseEntity<byte[]> verPdf() throws IOException {

        Path ruta = Paths.get("C:/Users/juanj_s0rvmd3/Downloads/2025_26_INSO1_Conv1.pdf");
        byte[] datos = Files.readAllBytes(ruta);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .body(datos);
    }

    @GetMapping("/imagen")
    public ResponseEntity<byte[]> verImagen() throws IOException {

        Path ruta = Paths.get("C:/Users/juanj_s0rvmd3/Pictures/Screenshots/Captura de pantalla 2026-01-05 200101.png");
        byte[] datos = Files.readAllBytes(ruta);

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(datos);
    }
}
/*
| Archivo  | MediaType                    |
| -------- | ---------------------------- |
| Texto    | `MediaType.TEXT_PLAIN`       |
| HTML     | `MediaType.TEXT_HTML`        |
| JSON     | `MediaType.APPLICATION_JSON` |
| PDF      | `MediaType.APPLICATION_PDF`  |
| PNG      | `MediaType.IMAGE_PNG`        |
| JPG/JPEG | `MediaType.IMAGE_JPEG`       |
| GIF      | `MediaType.IMAGE_GIF`        |

Esto

return ResponseEntity.ok()
        .contentType(MediaType.APPLICATION_PDF)
        .body(datos);

Equivalente a

return ResponseEntity.ok()
        .header("Content-Type", "application/pdf")
        .body(datos);

Texto → String
Objeto Java → JSON (automáticamente)
HTML → String con text/html o una plantilla (Thymeleaf)
Imagen → byte[] + MediaType.IMAGE_PNG / IMAGE_JPEG
PDF → byte[] + MediaType.APPLICATION_PDF
 */
