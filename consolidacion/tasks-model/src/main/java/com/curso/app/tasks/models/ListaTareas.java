package com.curso.app.tasks.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

// JPA
@Entity
@Table(
		name = "ListaDeTareas"
)
public class ListaTareas {

	@Getter @Setter
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(updatable = false)
	private long id;

	@Getter @Setter
	@Column(updatable = true, nullable = false, length = 200)
	private String titulo;

	@Getter @Setter
	@ManyToMany (mappedBy = "listasDeTareas") // Campo dentro de UsuarioConListasDeTareas que define la relación
	private List<UsuarioConListasDeTareas> usuariosAsignados;
	
	@Getter @Setter
	@OneToMany (mappedBy = "listaTareas") 
	private List<Tarea> tareas;
}
