package com.net.proyecto.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.net.proyecto.entity.Rol;
import com.net.proyecto.service.RolService;

@RestController
@RequestMapping("/api/v1")
public class RolController {

	
	@Autowired
	private RolService service;
	
	
	@GetMapping("/rol")
	@ResponseBody
	public List<Rol> listar(){
		List<Rol> lista = service.listarRoles();
		
		return lista;
		
	}
	
	
	@PostMapping("/registrarRol")
	@ResponseBody
	public ResponseEntity<?> insertaUsuario(@RequestBody Rol obj){
		HashMap<String, String> mensaje = new HashMap<>();
		Rol objSalida = service.insertarRol(obj);
		if (objSalida == null) {
			mensaje.put("mensaje", "Error en el registro");
		}else {
			mensaje.put("mensaje", "Se ha registrado el rol de ID " + objSalida.getId_rol());
		}
		return ResponseEntity.ok(mensaje);
	}
}
