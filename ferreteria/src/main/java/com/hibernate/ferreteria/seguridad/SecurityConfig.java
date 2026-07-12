package com.hibernate.ferreteria.seguridad;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UsuarioService usuarioService;
    public SecurityConfig(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Bean
    public PasswordEncoder codificaPass() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager autenticacion(AuthenticationConfiguration authConfig)
            throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityChain(HttpSecurity http,AuthenticationManager authManager) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/**").permitAll()
                        .requestMatchers("/api/**").hasAnyRole("ADMIN","USER")
                        .anyRequest().authenticated()
                )
                .authenticationManager(authManager) //Inyecta autenticacion, procesa intento, valida usuario y clave
                .userDetailsService(usuarioService) //Permite que la autenticacion pueda ver detalles de la bd
                .formLogin(form -> form.permitAll())    // Pagina de formulario por defecto que permite que todos puedan entrar a esa pero sin autenticacion
                .httpBasic(basic->{});
        return http.build();    // Construir desde httpSecurity
    }
}
    //Deshabilita una proteccion de seguridad que puede bloquearnos
    // Todas las rutas requieren autenticacion
