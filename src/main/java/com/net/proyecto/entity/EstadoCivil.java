package com.net.proyecto.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "estadocivil")
public class EstadoCivil {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_estado_civil;
	
	private String nombre;
	
	private String descripcion;

	public Integer getId_estado_civil() {
		return id_estado_civil;
	}

	public void setId_estado_civil(Integer id_estado_civil) {
		this.id_estado_civil = id_estado_civil;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
}
