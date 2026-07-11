package com.omeg.interceptores.Interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // Marca como fuente de configuracion, para definir beans y configurar componentes de spring
public class InterceptorConfig implements WebMvcConfigurer { // Permite personalizar el comportamiento del framework sin deshabilitar la configuración automatica y poner los interceptores

    private final LogInterceptor logInterceptor;

    public InterceptorConfig(LogInterceptor logInterceptor) {
        this.logInterceptor = logInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(logInterceptor).addPathPatterns("/**"); //  Lo ultimo son los patrones de la ruta, una ER donde diga las rutas donde se aplica
    }
}
