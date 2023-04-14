package com.curso.app.users.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.curso.app.users.models.Usuario;
import com.curso.app.users.repository.UsuariosRepository;
import com.curso.app.users.service.mappers.UsuariosMappers;
import com.curso.app.users.service.pojo.DatosUsuario;
import com.curso.app.users.service.pojo.DatosUsuarioModificables;
import com.curso.app.users.service.pojo.UsuarioPersistido;

@Service // Es la que mermite que Spring inyecte una instancia de esta clase cuando se solicite
public class UsuariosService {

	private final UsuariosRepository usuariosRepository;

	private UsuariosService(UsuariosRepository usuariosRepository) { // Inyeccion de dependencias
		this.usuariosRepository=usuariosRepository; 
	}

	public List<UsuarioPersistido> recuperarUsuarios(){
		// Usuario AQUI GUAY !
		List<Usuario> usuarios = usuariosRepository.findAll();
		
		return usuarios.stream()
					   .map( UsuariosMappers::usuario2UsuarioPersistido )
					   .collect(Collectors.toList());
		/*
		List<UsuariosPersistidos> usuariosPersistidos= new ArraList<>();
		for(Usuario usuario : usuarios) {
			usuariosPersistidos.append(UsuariosMappers.usuario2UsuarioPersistido(usuario));
		}
		return usuariosPersistidos;
		*/
	}
	
	public Optional<UsuarioPersistido> recuperarUsuario(long id){
		Optional<Usuario> usuario = usuariosRepository.findById(id);
		if(!usuario.isPresent())
			return Optional.empty();
		return Optional.of(UsuariosMappers.usuario2UsuarioPersistido(usuario.get()));
	}
	
	public Optional<UsuarioPersistido> nuevoUsuario(DatosUsuario datosUsuario){
		Usuario usuario = usuariosRepository.save(UsuariosMappers.datosUsuario2Usuario(datosUsuario));
		// Nuevo email que mandamos
		// Comprobación de politicas!
		return Optional.of(UsuariosMappers.usuario2UsuarioPersistido(usuario));
	}
	
	public Optional<UsuarioPersistido> modificarUsuario(long id, DatosUsuarioModificables datosUsuarioModificables){
		Optional<Usuario> usuario = usuariosRepository.findById(id);
		if(!usuario.isPresent())
			return Optional.empty();
		Usuario modificado = UsuariosMappers.usuarioActualizarleDatos(usuario.get(), datosUsuarioModificables);
		return Optional.of(UsuariosMappers.usuario2UsuarioPersistido(usuariosRepository.save(modificado)));
	}
	
	public Optional<UsuarioPersistido> eliminarUsuario(long id){
		Optional<UsuarioPersistido> usuario = recuperarUsuario(id);
		if(usuario.isPresent())
			usuariosRepository.deleteById(id);
		return usuario;
		
		/*
		Optional<Usuario> usuario = usuariosRepository.findById(id);
		if(!usuario.isPresent())
			return Optional.empty();
		usuariosRepository.delete(usuario.get());
		return Optional.of(UsuariosMappers.usuario2UsuarioPersistido(usuario.get()));
		*/
	}
	
}

