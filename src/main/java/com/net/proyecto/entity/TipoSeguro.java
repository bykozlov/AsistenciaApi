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
@Table(name = "tiposeguro")
public class TipoSeguro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_tipo_seguro;
	
	private String nombre;
	
	private String descripcion;

	public Integer getId_tipo_seguro() {
		return id_tipo_seguro;
	}

	public void setId_tipo_seguro(Integer id_tipo_seguro) {
		this.id_tipo_seguro = id_tipo_seguro;
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
