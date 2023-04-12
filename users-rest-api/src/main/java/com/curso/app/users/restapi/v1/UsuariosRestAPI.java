package com.curso.app.users.restapi.v1;

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

import com.curso.app.users.restapi.v1.pojo.DatosUsuarioRest;
import com.curso.app.users.restapi.v1.mappers.UsuariosMappers;
import com.curso.app.users.restapi.v1.pojo.DatosUsuarioModificablesRest;
import com.curso.app.users.restapi.v1.pojo.UsuarioPersistidoRest;
import com.curso.app.users.service.UsuariosService;
import com.curso.app.users.service.pojo.UsuarioPersistido;

@RestController
@RequestMapping("/api/v1")
public class UsuariosRestAPI {
	
	private final UsuariosService usuariosService;
	
	public UsuariosRestAPI(UsuariosService usuariosService) { // Inyección de dependencias
		this.usuariosService=usuariosService;
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<UsuarioPersistidoRest>> recuperarUsuarios(){
		//UsuarioPersistido
		//DatosUsuario
		//DatosUsuarioModificables
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<UsuarioPersistidoRest> recuperarUsuario(@PathVariable long id){
		Optional<UsuarioPersistido> usuario=usuariosService.recuperarUsuario(id);
		if(usuario.isEmpty())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(UsuariosMappers.usuarioPersistido2usuarioPersistidoRest(usuario.get()), HttpStatus.OK);

	}
	
	@PostMapping("/users")
	public ResponseEntity<UsuarioPersistidoRest> nuevoUsuario(@RequestBody DatosUsuarioRest datosUsuario){
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<UsuarioPersistidoRest> modificarUsuario(@PathVariable long id, @RequestBody DatosUsuarioModificablesRest datosUsuarioModificables){
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<UsuarioPersistidoRest> eliminarUsuario(@PathVariable long id){
	}
	
	
}