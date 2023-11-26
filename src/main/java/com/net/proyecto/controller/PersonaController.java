package com.net.proyecto.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.net.proyecto.entity.EstadoCivil;
import com.net.proyecto.entity.Persona;
import com.net.proyecto.entity.TipoSeguro;
import com.net.proyecto.service.EstadoCivilService;
import com.net.proyecto.service.PersonaService;
import com.net.proyecto.service.TipoSeguroService;

@RestController
@RequestMapping("/api/v1")
public class PersonaController {
	
	@Autowired
	private PersonaService service;
	
	
	@Autowired
	private TipoSeguroService serviceSeguro;
	
	
	@Autowired
	private EstadoCivilService serviceEstado;
	
	
	@GetMapping
	@ResponseBody
	public List<Persona> listaPersonas(){
		List<Persona> listaSalida = service.listaPersonas();
		return listaSalida;
	}
	
	
	@PostMapping("/registrar")
	@ResponseBody
	public ResponseEntity<?> insertaPersona(@RequestBody Persona obj){
		HashMap<String, String> mensaje = new HashMap<>();
		Persona objSalida = service.insertaPersona(obj);
		if (objSalida == null) {
			mensaje.put("mensaje", "Error en el registro");
		}else {
			mensaje.put("mensaje", "Se ha registrado el Alumno de ID " + objSalida.getId_persona());
		}
		return ResponseEntity.ok(mensaje);
	}
	
	@PutMapping("/actualizar")
	@ResponseBody
	public ResponseEntity<?> actualizaPersona(@RequestBody Persona obj){
		HashMap<String, String> mensaje = new HashMap<>();
		
		Optional<Persona> optPersona = service.buscarPersona(obj.getId_persona());
		if (optPersona.isPresent()) {
			Persona objSalida = service.actualizaPersona(obj);
			if (objSalida == null) {
				mensaje.put("mensaje", "Error en el registro");
			}else {
				mensaje.put("mensaje", "Se ha actualizado el Alumno de ID " + objSalida.getId_persona());
			}
		}else {
			mensaje.put("mensaje", "No existe alumno de ID " + obj.getId_persona());
		}
		return ResponseEntity.ok(mensaje);
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<?> eliminaPersona(@PathVariable("id") int idPersona){
		HashMap<String, String> mensaje = new HashMap<>();
		Optional<Persona> optPersona = service.buscarPersona(idPersona);
		if (optPersona.isPresent()) {
			service.eliminarPersona(idPersona);
			mensaje.put("mensaje", "Se ha eliminado el Alumno de ID " + idPersona);
		}else {
			mensaje.put("mensaje", "No existe alumno de ID " + idPersona);
		}
		return ResponseEntity.ok(mensaje);
	}
	
	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Object> listaPorId(@PathVariable("id") int idPersona) {
	    Optional<Persona> listaSalida = service.buscarPersona(idPersona);

	    if (listaSalida.isPresent()) {
	        return ResponseEntity.ok(listaSalida.get());
	    } else {
	        Map<String, String> response = new HashMap<>();
	        response.put("mensaje", "No se encontró ninguna persona con el ID proporcionado.");
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	    }
	}
	
	
	@GetMapping("/seguros")
	@ResponseBody
	public List<TipoSeguro> listaSeguros(){
		List<TipoSeguro> listaSalida = serviceSeguro.listaTipoSeguro();
		return listaSalida;
	}
	
	
	@GetMapping("/estado")
	@ResponseBody
	public List<EstadoCivil> listaEstados(){
		List<EstadoCivil> listaSalida = serviceEstado.listaEstadoCivil();
		return listaSalida;
	}
	
	
	@GetMapping("/buscarPorDni/{dni}")
	@ResponseBody
	public ResponseEntity<Object> buscarPorDni(@PathVariable("dni") String dni) {
	    Persona personaEncontrada = service.buscarPorDni(dni);

	    if (personaEncontrada != null) {
	        return ResponseEntity.ok(personaEncontrada);
	    } else {
	        Map<String, String> response = new HashMap<>();
	        response.put("mensaje", "No se encontró ninguna persona con el DNI proporcionado.");
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	    }
	}


}
