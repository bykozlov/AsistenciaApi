package com.net.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.net.proyecto.entity.TipoSeguro;
import com.net.proyecto.repository.TipoSeguroRepository;

@Service
public class TipoSeguroServiceImpl implements TipoSeguroService{

	
	@Autowired
	private TipoSeguroRepository repository;
	
	@Override
	public List<TipoSeguro> listaTipoSeguro() {
		return repository.findAll();
	}

}
