package com.curso.app.tasks.models;

import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.curso.app.users.models.Usuario;

import lombok.Getter;
import lombok.Setter;

// JPA
@Entity
@Inheritance(
		strategy = InheritanceType.SINGLE_TABLE // Usa la misma tabla que ya estemos usando para los Usuarios normales
)
public class UsuarioConListasDeTareas extends Usuario {

	@Getter @Setter
	@ManyToMany
	@JoinTable(
			name = "AsignacionesDeListasDeTareas",
			joinColumns = @JoinColumn (name = "usuarioId"),
			inverseJoinColumns = @JoinColumn (name = "listadopTareasId")
	)
	private List<ListaTareas> listasDeTareas;
	
}
