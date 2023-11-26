package com.net.proyecto.service;

import java.util.List;

import com.net.proyecto.entity.Usuario;

public interface UsuarioService {
	
	
	public List<Usuario> listarUsuarios();
	
	public Usuario insertarUsuario (Usuario obj);
	
	public abstract Usuario login(String usuario, String contrasena);

}
