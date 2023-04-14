package com.curso.app.tasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.app.tasks.models.ListaTareas;

public interface ListasDeTareasRepository extends JpaRepository<ListaTareas, Long>{

}
