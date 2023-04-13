package com.curso.app.users.service.pojo;

import lombok.Getter;
import lombok.Setter;

public class DatosUsuarioModificables {

	@Getter @Setter
	private String nombre;

	@Getter @Setter
	private String apellidos;

	@Getter @Setter
	private String telefono;

	@Getter @Setter
	private int edad;
			
}
