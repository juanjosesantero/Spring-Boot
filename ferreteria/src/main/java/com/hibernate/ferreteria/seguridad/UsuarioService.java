package com.hibernate.ferreteria.seguridad;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements UserDetailsService {

    private Repo_Usuario repoUsuario;

    public UsuarioService(Repo_Usuario repoUsuario) {
        this.repoUsuario = repoUsuario;
    }

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException{
        var usuario= repoUsuario.findByUserName(nombreUsuario).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: "+nombreUsuario));

        return new User(usuario.getUserName(), usuario.getPassword(), List.of(new SimpleGrantedAuthority("ROLE_"+usuario.getRol())));
        // Cuidado con el ROLE_, porque internamente se busca ROLE_ADMIN,ROLE_USER...
    }
}
