package com.hibernate.ferreteria.seguridad;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Repo_Usuario extends JpaRepository<Usuario,Long> {
    Optional<Usuario> findByUserName(String userName);
}
