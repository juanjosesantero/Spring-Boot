package com.omeg.interceptores.Interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LogInterceptor implements HandlerInterceptor // Necesaria la interfaz
{
    // Metodo previo al controlador
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception{
        System.out.println("PretHandle:Interceptando peticion ..." + request.getRequestURI());
        return true; // En caso contrario no prosigue la peticion
    }

    // HttpServletRequest contiene la solicitud
    // HttpServletResponse, permite modificar la respuesta
    // Object, controlador que maneja la solicitud

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception{
        System.out.println("PostHandle: Interceptando peticion ..." + request.getRequestURI());
    }
    // ModelAndView, representa un modelo de datos para mostrar los datos y la plantilla
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,Object handler,Exception error) throws Exception{
        System.out.println("AfterCompletion: Ejecuccion completada para la peticion ..." + request.getRequestURI());
    }
    // Exception, en caso de una excepcion se guardan en el 4 parametro
}
