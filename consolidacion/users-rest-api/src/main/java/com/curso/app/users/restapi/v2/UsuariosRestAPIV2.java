
package com.curso.app.users.restapi.v2;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.app.users.restapi.v2.pojo.DatosUsuarioRest;
import com.curso.app.users.restapi.v2.mappers.UsuariosMappers;
import com.curso.app.users.restapi.v2.pojo.DatosUsuarioModificablesRest;
import com.curso.app.users.restapi.v2.pojo.UsuarioPersistidoRest;
import com.curso.app.users.service.UsuariosService;
import com.curso.app.users.service.pojo.DatosUsuario;
import com.curso.app.users.service.pojo.DatosUsuarioModificables;
import com.curso.app.users.service.pojo.UsuarioPersistido;

@RestController
@RequestMapping("/api/v2")
public class UsuariosRestAPIV2 {
	
	private final UsuariosService usuariosService;
	
	public UsuariosRestAPIV2(UsuariosService usuariosService) { // Inyección de dependencias
		this.usuariosService=usuariosService;
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<UsuarioPersistidoRest>> recuperarUsuarios(){
		List<UsuarioPersistido> usuarios = usuariosService.recuperarUsuarios();
		
		return new ResponseEntity<>(usuarios.stream()
					   .map( UsuariosMappers::usuarioPersistido2usuarioPersistidoRest )
					   .collect(Collectors.toList()), HttpStatus.OK);
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<UsuarioPersistidoRest> recuperarUsuario(@PathVariable long id){
		Optional<UsuarioPersistido> usuario=usuariosService.recuperarUsuario(id);
		if(usuario.isEmpty())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(UsuariosMappers.usuarioPersistido2usuarioPersistidoRest(usuario.get()), HttpStatus.OK);

	}
	
	@PostMapping("/users")
	public ResponseEntity<UsuarioPersistidoRest> nuevoUsuario(@RequestBody DatosUsuarioRest datosUsuarioRest){
		DatosUsuario datosUsuario = UsuariosMappers.datosUsuarioRest2datosUsuario(datosUsuarioRest);
		Optional<UsuarioPersistido> usuario=usuariosService.nuevoUsuario(datosUsuario);
		if(usuario.isEmpty())
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(UsuariosMappers.usuarioPersistido2usuarioPersistidoRest(usuario.get()), HttpStatus.OK);
	}
	
	
	@PutMapping("/users/{id}")
	public ResponseEntity<UsuarioPersistidoRest> modificarUsuario(@PathVariable long id, @RequestBody DatosUsuarioModificablesRest datosUsuarioModificablesRest){
		DatosUsuarioModificables datosUsuarioModificables = UsuariosMappers.datosUsuarioModificablesRest2datosUsuarioModificables(datosUsuarioModificablesRest);
		Optional<UsuarioPersistido> usuario=usuariosService.modificarUsuario(id, datosUsuarioModificables);
		if(usuario.isEmpty())
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(UsuariosMappers.usuarioPersistido2usuarioPersistidoRest(usuario.get()), HttpStatus.OK);
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<UsuarioPersistidoRest> eliminarUsuario(@PathVariable long id){
		Optional<UsuarioPersistido> usuario=usuariosService.eliminarUsuario(id);
		if(usuario.isEmpty())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(UsuariosMappers.usuarioPersistido2usuarioPersistidoRest(usuario.get()), HttpStatus.ACCEPTED);
	}
	
	
}