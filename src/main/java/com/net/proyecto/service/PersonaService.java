package com.net.proyecto.service;

import java.util.List;
import java.util.Optional;

import com.net.proyecto.entity.Persona;

public interface PersonaService {
	
	
	public abstract List<Persona> listaPersonas();
	
	public abstract Persona insertaPersona(Persona persona);
	
	public abstract Persona actualizaPersona(Persona persona);
	
	public abstract void eliminarPersona(int id);
	
	public abstract Optional<Persona> buscarPersona(int id);

	public abstract Persona buscarPorDni(String dni);
	
}
