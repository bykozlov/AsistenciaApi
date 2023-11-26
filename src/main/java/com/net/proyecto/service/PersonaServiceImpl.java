package com.net.proyecto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.net.proyecto.entity.Persona;
import com.net.proyecto.repository.PersonaRepository;

@Service
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private PersonaRepository repository;
	
	@Override
	public List<Persona> listaPersonas() {
		return repository.findAll();
	}

	@Override
	public Persona insertaPersona(Persona persona) {
		return repository.save(persona);
	}

	@Override
	public Persona actualizaPersona(Persona persona) {
		return repository.save(persona);
	}

	@Override
	public void eliminarPersona(int id) {
		repository.deleteById(id);
	}

	@Override
	public Optional<Persona> buscarPersona(int id) {
		return repository.findById(id);
	}

	@Override
	public Persona buscarPorDni(String dni) {
		return repository.findByDNI(dni);
	}




}
