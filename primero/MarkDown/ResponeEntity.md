Entidad de respuesta para retornar un mensaje

Ej: 
```
 return ResponseEntity.status(HttpStatus.CREATED).body("Mensaje");
```

Las ResponseEntity no sirven únicamente para enviar mensajes personalizados, sino para controlar completamente la respuesta HTTP.
Con ellas se define codigo HTTP, cuerpo de la respuesta(retorno como objeto,string,json) y cabeceras()

Cabeceras, informacion adicional o metadatos que van con la informacion
```java
return ResponseEntity.ok()
        .header("Autor", "Juan")
        .body(libro);
```


En el cuerpo se pueden devolver string como texto plano
                                objetos o colecciones convertidos a json
                                json
                                html 

Devolver html
```java
// Poco habitual
@RestController
public class MiControlador {

    @GetMapping("/html")
    public String pagina() {
        return "<h1>Hola</h1>";
    }
}
// Usando una plantilla y Thymelead
@Controller
public class MiControlador {

    @GetMapping("/inicio")
    public String inicio() {
        return "inicio";
    }
}

```
Se pueden devolver archivos tipo pdf, imagen...
```java
@GetMapping("/imagen")
public ResponseEntity<byte[]> imagen() {
    byte[] datos = ...;

    return ResponseEntity.ok()
            .header("Content-Type", "image/png")
            .body(datos);
}
```

O no devolver nada
```java
@DeleteMapping("/{id}")
public ResponseEntity<Void> eliminar(@PathVariable int id) {
    servicio.eliminar(id);
    return ResponseEntity.noContent().build();
}
```
------------------
## ResponseEntity

Entidad de respuesta que permite controlar completamente la respuesta HTTP que envía el servidor.

Ejemplo:

```java
return ResponseEntity.status(HttpStatus.CREATED)
        .body("Mensaje");
```

Con `ResponseEntity` se puede definir:

- Código de estado HTTP (`200 OK`, `201 Created`, `404 Not Found`, `400 Bad Request`...)
- Cuerpo de la respuesta (body)
- Cabeceras HTTP (headers)

### Cabeceras (Headers)

Son información adicional o metadatos que acompañan a la respuesta.

Ejemplo:

```java
return ResponseEntity.ok()
        .header("Autor", "Juan")
        .body(libro);
```

### Cuerpo de la respuesta (Body)

Puede contener distintos tipos de datos:

- `String` → texto plano.
- Objetos → Spring los convierte automáticamente a JSON.
- Colecciones (`List`, `Set`, etc.) → se convierten a un array JSON.
- JSON (si se devuelve como texto o un objeto).
- HTML.
- Archivos (PDF, imágenes, Excel, etc.).
- Ningún contenido (`204 No Content`).

### Devolver HTML

Como texto (poco habitual):

```java
@RestController
public class MiControlador {

    @GetMapping("/html")
    public String pagina() {
        return "<h1>Hola</h1>";
    }
}
```

Usando una plantilla (Thymeleaf):

```java
@Controller
public class MiControlador {

    @GetMapping("/inicio")
    public String inicio() {
        return "inicio"; // Busca templates/inicio.html
    }
}
```

### Devolver un archivo

```java
@GetMapping("/imagen")
public ResponseEntity<byte[]> imagen() {

    byte[] datos = ...;

    return ResponseEntity.ok()
            .header("Content-Type", "image/png")
            .body(datos);
}
```

También se pueden devolver PDF, Excel, audio, vídeo, etc.

### No devolver contenido

```java
@DeleteMapping("/{id}")
public ResponseEntity<Void> eliminar(@PathVariable int id) {

    servicio.eliminar(id);

    return ResponseEntity.noContent().build();
}
```

Devuelve el código HTTP `204 No Content`, indicando que la operación se realizó correctamente pero no hay contenido que enviar en el cuerpo de la respuesta.

Si no tiene cuerpo, se utiliza .build (200,404,204), sino .body 