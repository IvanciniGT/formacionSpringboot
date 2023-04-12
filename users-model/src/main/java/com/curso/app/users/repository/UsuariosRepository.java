package com.curso.app.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.app.users.models.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Long>{

}
