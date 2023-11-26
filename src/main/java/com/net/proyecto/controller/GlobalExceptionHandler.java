package com.net.proyecto.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Object> handleException(Exception ex) {
		Map<String, String> response = new HashMap<>();
		response.put("mensaje", "Ruta no encontrada o incorrecta.");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}
}
