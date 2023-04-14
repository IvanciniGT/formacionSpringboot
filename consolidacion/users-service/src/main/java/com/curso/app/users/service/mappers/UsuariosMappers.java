package com.curso.app.users.service.mappers;

import com.curso.app.users.models.Usuario;
import com.curso.app.users.service.pojo.DatosUsuario;
import com.curso.app.users.service.pojo.DatosUsuarioModificables;
import com.curso.app.users.service.pojo.UsuarioPersistido;

public interface UsuariosMappers {

	public static UsuarioPersistido usuario2UsuarioPersistido(Usuario usuario) {
		UsuarioPersistido usuarioPersistido = new UsuarioPersistido();
		usuarioPersistido.setId(usuario.getId());
		usuarioPersistido.setNombre(usuario.getNombre());
		usuarioPersistido.setApellidos(usuario.getApellidos());
		usuarioPersistido.setEmail(usuario.getEmail());
		usuarioPersistido.setTelefono(usuario.getTelefono());
		usuarioPersistido.setEdad(usuario.getEdad());
		usuarioPersistido.setFoto(usuario.getFoto());
		usuarioPersistido.setAceptoPoliticas(usuario.isAceptoPoliticas());
		return usuarioPersistido;
	}

	public static Usuario datosUsuario2Usuario(DatosUsuario datosUsuario) {
		Usuario usuario = new Usuario();
		usuario.setNombre(datosUsuario.getNombre());
		usuario.setApellidos(datosUsuario.getApellidos());
		usuario.setEmail(datosUsuario.getEmail());
		usuario.setTelefono(datosUsuario.getTelefono());
		usuario.setEdad(datosUsuario.getEdad());
		usuario.setFoto(datosUsuario.getFoto());
		usuario.setAceptoPoliticas(datosUsuario.isAceptoPoliticas());
		return usuario;
	}

	public static Usuario usuarioActualizarleDatos(Usuario usuario, DatosUsuarioModificables datosUsuarioModificables) {
		usuario.setNombre(datosUsuarioModificables.getNombre());
		usuario.setApellidos(datosUsuarioModificables.getApellidos());
		usuario.setTelefono(datosUsuarioModificables.getTelefono());
		usuario.setEdad(datosUsuarioModificables.getEdad());
		usuario.setFoto(datosUsuarioModificables.getFoto());
		usuario.setAceptoPoliticas(datosUsuarioModificables.isAceptoPoliticas());
		return usuario;
	}
}
