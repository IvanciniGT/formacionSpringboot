package com.curso.app.users.restapi.v1.mappers;

import com.curso.app.users.restapi.v1.pojo.DatosUsuarioModificablesRest;
import com.curso.app.users.restapi.v1.pojo.DatosUsuarioRest;
import com.curso.app.users.restapi.v1.pojo.UsuarioPersistidoRest;
import com.curso.app.users.service.pojo.DatosUsuario;
import com.curso.app.users.service.pojo.DatosUsuarioModificables;
import com.curso.app.users.service.pojo.UsuarioPersistido;

public interface UsuariosMappers {

	static UsuarioPersistidoRest usuarioPersistido2usuarioPersistidoRest(UsuarioPersistido usuarioPersistido) {
		UsuarioPersistidoRest usuarioPersistidoRest = new UsuarioPersistidoRest();
		usuarioPersistidoRest.setId(usuarioPersistido.getId());
		usuarioPersistidoRest.setNombre(usuarioPersistido.getNombre());
		usuarioPersistidoRest.setApellidos(usuarioPersistido.getApellidos());
		usuarioPersistidoRest.setEdad(usuarioPersistido.getEdad());
		usuarioPersistidoRest.setEmail(usuarioPersistido.getEmail());
		usuarioPersistidoRest.setTelefono(usuarioPersistido.getTelefono());
		return usuarioPersistidoRest;
	}

	static DatosUsuario datosUsuarioRest2datosUsuario(DatosUsuarioRest datosUsuarioRest) {
		DatosUsuario datosUsuario = new DatosUsuario();
		datosUsuario.setNombre(datosUsuarioRest.getNombre());
		datosUsuario.setApellidos(datosUsuarioRest.getApellidos());
		datosUsuario.setEdad(datosUsuarioRest.getEdad());
		datosUsuario.setEmail(datosUsuarioRest.getEmail());
		datosUsuario.setTelefono(datosUsuarioRest.getTelefono());
		return datosUsuario;
	}
	static DatosUsuarioModificables datosUsuarioModificablesRest2datosUsuarioModificables(
				DatosUsuarioModificablesRest datosUsuarioModificablesRest) {
		DatosUsuarioModificables datosUsuario = new DatosUsuarioModificables();
		datosUsuario.setNombre(datosUsuarioModificablesRest.getNombre());
		datosUsuario.setApellidos(datosUsuarioModificablesRest.getApellidos());
		datosUsuario.setEdad(datosUsuarioModificablesRest.getEdad());
		datosUsuario.setTelefono(datosUsuarioModificablesRest.getTelefono());
		return datosUsuario;
	}
	
}

