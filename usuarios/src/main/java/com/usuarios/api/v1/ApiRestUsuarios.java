package com.usuarios.api.v1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ApiRestUsuarios {

	@GetMapping("/saluda")	//    /api/v1/saluda
	public ResponseEntity<String> saluda(){
		return new ResponseEntity<>("hola", HttpStatus.OK);
	}
	
}
