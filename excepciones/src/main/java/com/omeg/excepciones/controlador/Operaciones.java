package com.omeg.excepciones.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Operaciones {
    //http://localhost:8080/api/division
    @GetMapping("/division")
    public String Divide() {
        long valor = 200 / 10;
        return "resultado: " + valor;
    }

    //http://localhost:8080/api/dividir?num=3
    @GetMapping("/dividir")
    public String dividir(@RequestParam (required = false) String num) {
        int valor = Integer.parseInt(num);
        int resultado = 20 / valor;
        return "resultado: " + resultado;
            /*
            *  catch (NumberFormatException e) {
            return "Error: valor invalido";
        }
        catch (ArithmeticException e) {
            return "Error: No se puede dividir por cero";
        }
            * */
    }
}

@RestController
class ObjetoNulo {
    @GetMapping("/objetoNulo")
    public String nulo() {
        String valorNulo = null;
        valorNulo.length();
        return "Valor nulo en variable";
    }
}
