package com.net.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.net.proyecto.entity.EstadoCivil;
import com.net.proyecto.repository.EstadoCivilRepository;

@Service
public class EstadoCivilServiceImpl implements EstadoCivilService {

	
	@Autowired 
	private EstadoCivilRepository repository;

	@Override
	public List<EstadoCivil> listaEstadoCivil() {
		return repository.findAll();
	}
	
	
	
}
