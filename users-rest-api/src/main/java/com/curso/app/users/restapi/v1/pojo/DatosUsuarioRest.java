package com.curso.app.users.restapi.v1.pojo;

import lombok.Getter;
import lombok.Setter;

public class DatosUsuarioRest extends DatosUsuarioModificablesRest{

	@Getter @Setter
	private String email;
			
}
