package com.curso.app.tasks.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

// JPA
@Entity
@Table(
		name = "Tareas"
)
public class Tarea {

	public enum Estado {
		PENDIENTE, EN_PROGRESO, ACABADA
	}
	
	@Getter @Setter
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(updatable = false)
	private long id;

	@Getter @Setter
	@Column(updatable = true, nullable = false, length = 200)
	private String titulo;

	@Getter @Setter
	@Column(updatable = true, nullable = true, length = 2000)
	private String descripcion;

	@Getter @Setter
	@Column(updatable = true, nullable = false)
	private Estado estado = Estado.PENDIENTE;
	
	@Getter @Setter
	@ManyToOne		// Foreign Key que se dará de alta en la BBDD
	@JoinColumn(updatable = false, nullable = false)
	private ListaTareas listaTareas;
}
