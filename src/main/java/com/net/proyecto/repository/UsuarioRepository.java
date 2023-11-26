package com.net.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.net.proyecto.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	 @Query("SELECT u FROM Usuario u WHERE u.usuario = :usuario AND u.contrasena = :contrasena")
	    public Usuario login(@Param("usuario") String usuario, @Param("contrasena") String contrasena);
    
}
