package com.curso.app.users.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

// JPA
@Entity
@Table(
		name = "Usuarios"
)
public class Usuario {

	@Getter @Setter
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(updatable = false)
	private long id;

	@Getter @Setter
	@Column(updatable = true, nullable = false, length = 50)
	private String nombre;

	@Getter @Setter
	@Column(updatable = true, nullable = false, length = 50)
	private String apellidos;

	@Getter @Setter
	@Column(updatable = false, nullable = false, length = 100)
	private String email;

	@Getter @Setter
	@Column(updatable = true, nullable = true, length = 12)
	private String telefono;

	@Getter @Setter
	@Column(updatable = true, nullable = true)
	private int edad;
	
	@Getter @Setter
	@Column(updatable = true, nullable = true, length = 300)
	private String foto;

	@Getter @Setter
	@Column(updatable = true, nullable = false)
	private boolean aceptoPoliticas = false;
		
}
