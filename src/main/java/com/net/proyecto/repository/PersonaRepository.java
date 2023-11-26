package com.net.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.net.proyecto.entity.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {

	
	@Query("SELECT p FROM Persona p WHERE p.dni = ?1")
    public Persona findByDNI(String dni);
}
