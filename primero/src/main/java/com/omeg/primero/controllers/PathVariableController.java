package com.omeg.primero.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omeg.primero.models.Empleado;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/variable") // Prefijo para todas las rutas de este controlador
public class PathVariableController {

    @Value("${config.usuario}")
    private String usuario;
    @Value("${config.mensaje}")
    private String mensaje;
    @Value("${config.codigo}")
    private String codigo;
    @Value("${config.valores}")
    private String[] valores;

    @GetMapping("/pagina1/{mensaje}")
    public ParametroDTO pagina1(@PathVariable String mensaje) { // Parametro a pasar obligatorio
        ParametroDTO parametro = new ParametroDTO();
        parametro.setInformacion(mensaje);
        return parametro;
    }
    // http://localhost:8080/api/variable/pagina1/mensajeria%20movil

    @PostMapping("/solicitud") // Metodo post no tiene metodo get, se usa para enviar informacion al servidor
    public Empleado creaEmpleado(@RequestBody Empleado empleado) {
        return empleado;
    }

    @GetMapping("/valores")
    public Map<String, Object> getValores() {
        Map<String, Object> calor=new HashMap<>();
        calor.put("Usuario", usuario);
        calor.put("Mensaje", mensaje);
        calor.put("Codigo", codigo);
        calor.put("Valores", valores);
        //calor.put("Valores", calor); si se pone asi se genera un bucle infinito y no se puede mostrar en el navegador
       return calor;
    }
}