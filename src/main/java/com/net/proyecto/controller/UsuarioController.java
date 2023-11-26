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

import com.net.proyecto.entity.Usuario;
import com.net.proyecto.service.UsuarioService;

@RestController
@RequestMapping("/api/v1")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@GetMapping("/usuario")
	@ResponseBody
	public List<Usuario> listar() {
		List<Usuario> lista = service.listarUsuarios();

		return lista;

	}

	@PostMapping("/registrarUsuario")
	@ResponseBody
	public ResponseEntity<?> insertaUsuario(@RequestBody Usuario obj) {
		HashMap<String, String> mensaje = new HashMap<>();
		Usuario objSalida = service.insertarUsuario(obj);
		if (objSalida == null) {
			mensaje.put("mensaje", "Error en el registro");
		} else {
			mensaje.put("mensaje", "Se ha registrado el usuario de ID " + objSalida.getPersona().getId_persona());
		}
		return ResponseEntity.ok(mensaje);
	}

	@GetMapping("/login")
	@ResponseBody
	public ResponseEntity<Usuario> login(@RequestBody Usuario obj) {
		obj = service.login(obj.getUsuario(), obj.getContrasena());
		return ResponseEntity.ok(obj);
	}

}
