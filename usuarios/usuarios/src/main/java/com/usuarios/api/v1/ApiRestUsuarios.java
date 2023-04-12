package com.usuarios.api.v1;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usuarios.api.v1.models.Usuario;
import com.usuarios.api.v1.repositories.UsuariosRepository;

@RestController
@RequestMapping("/api/v1")
public class ApiRestUsuarios {

	private final UsuariosRepository usuariosRepository;			// Inversión de dependencias
	
	public ApiRestUsuarios(UsuariosRepository usuariosRepository) { // Inyección de dependencias
		this.usuariosRepository=usuariosRepository;
	}
	
	@GetMapping("/saluda")	//    /api/v1/saluda
	public ResponseEntity<String> saluda(){
		return new ResponseEntity<>("hola", HttpStatus.OK);
	}

	@GetMapping("/users")	//    /api/v1/users
	public ResponseEntity<List<Usuario>> getUsuarios(){
		List<Usuario> usuarios = usuariosRepository.findAll(); 
		return new ResponseEntity<>(usuarios, HttpStatus.OK);
	}
	
	@PostMapping("/users")	//    /api/v1/users
	public ResponseEntity<Usuario> newUsuario(@RequestBody Usuario nuevoUsuario){
		return new ResponseEntity<>(usuariosRepository.save(nuevoUsuario), HttpStatus.OK);
	}
	
}
// Este código lo escribe y ejecuta Spring
// new ApiRestUsuarios();  // Inversion de control!!!

// No quiero montar un servicio REST
// Lo que quiero montar es una interfaz REST para un Servicio que tengo en JAVA

