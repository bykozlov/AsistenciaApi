package com.net.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.net.proyecto.entity.Rol;
import com.net.proyecto.repository.RolRepository;

@Service
public class RolServiceImpl implements RolService{
	
	@Autowired
	private RolRepository repository;

	@Override
	public List<Rol> listarRoles() {
	return repository.findAll();
	}

	@Override
	public Rol insertarRol(Rol obj) {
		return repository.save(obj);
	}

}
