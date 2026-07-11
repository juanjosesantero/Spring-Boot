package com.omeg.excepciones.manejador;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // Aplica logica global a los controladores
public class ManejoErrores {
    @ExceptionHandler(ArithmeticException.class) // Maneja excepciones especificas de manera personalizada
    public ResponseEntity<String> handlerArithmeticException(ArithmeticException ERROR){
        return new ResponseEntity<>("Error: division entre 0 no permitida", HttpStatus.BAD_REQUEST);
        // El ResponseEntity es para dar mensajes personalizados
    }
    @ExceptionHandler(NullPointerException.class) // Maneja excepciones especificas de manera personalizada
    public ResponseEntity<String> handlerNullPointerException(NullPointerException ERROR){
        return new ResponseEntity<>("Error: parametro nulo", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NumberFormatException.class) // Maneja excepciones especificas de manera personalizada
    public ResponseEntity<String> handlerNumberFormatException(NumberFormatException ERROR){
        return new ResponseEntity<>("Error: formato de valor incorrecto", HttpStatus.BAD_REQUEST);
    }
}
