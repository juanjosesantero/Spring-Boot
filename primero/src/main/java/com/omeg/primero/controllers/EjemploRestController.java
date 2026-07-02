package com.omeg.primero.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.omeg.primero.models.Empleado;
import com.omeg.primero.models.dto.ClaseDTO;


@RestController // Handler rest en vez de handler que seria un conttroller normal
@RequestMapping("/api") // Prefijo para todas las rutas de este controlador
public class EjemploRestController {

@GetMapping("/rest")
    public Map<String, Object> rest() {
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("Titulo", "Detalles de la Información");
        respuesta.put("ip", "192.168.1.1");
        return respuesta;
    }
@RequestMapping(path="/resta", method=RequestMethod.GET)
    public Map<String, Object> resta() {
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("Titulo", "Detalles de la Información");
        respuesta.put("ip", "192.168.1.1");
        respuesta.put("Servidor", "online");
        return respuesta;
    }



@RequestMapping(path="/objeto", method=RequestMethod.GET)
public Map<String, Object> objeto(){

        Empleado empleado1= new Empleado(001,"Juan", "Rodriguez", "Desarrollador", 30, 123456789,"Calle 1 Nº 2");
        Map<String, Object> respuesta = new HashMap<>();
        
        
        respuesta.put("Titulo", "Detalles del Empleado");
        respuesta.put("Empleado", empleado1);
        return respuesta;
    }

@RequestMapping(path="/DTO", method=RequestMethod.GET)
public ClaseDTO detalleMap(){

        ClaseDTO usuario1= new ClaseDTO();
        usuario1.setTitulo("administrador");
        usuario1.setUsuario("Informaticconfig");
        return usuario1;
    }

}