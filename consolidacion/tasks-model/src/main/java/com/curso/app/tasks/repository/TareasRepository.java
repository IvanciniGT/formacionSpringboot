package com.curso.app.tasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.app.tasks.models.Tarea;

public interface TareasRepository extends JpaRepository<Tarea, Long>{

}
