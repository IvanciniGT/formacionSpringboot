package com.curso.app.users.restapi.v1.pojo;

import lombok.Getter;
import lombok.Setter;

public class DatosUsuarioModificablesRest {

	@Getter @Setter
	private String nombre;

	@Getter @Setter
	private String apellidos;

	@Getter @Setter
	private String telefono;

	@Getter @Setter
	private int edad;
			
}