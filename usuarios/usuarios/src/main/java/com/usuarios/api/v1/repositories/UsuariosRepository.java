package com.usuarios.api.v1.repositories;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usuarios.api.v1.models.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Long>{
/*
	//getById()
	//getAll()
	//save(usuario)
	//delete(usuario)
	List<Usuario> findByNombre(String nombre);
	List<Usuario> findTop5ByNombre(String nombre);
	List<Usuario> findByNombreIsNull();
	List<Usuario> findByNombreIsNotNull();
	List<Usuario> findByNombreStartingWith(String prefijo);
	List<Usuario> findByNombreEndsWith(String sufijo);
	List<Usuario> findByNombreContaining(String texto);

	List<Usuario> findByEdad(Integer edad);
	List<Usuario> findByEdadLessThan(Integer edad);
	List<Usuario> findByEdadLessThanEqual(Integer edad);
	List<Usuario> findByEdadGreaterThan(Integer edad);
	List<Usuario> findByEdadBetween(Integer edad1,Integer edad2);

	List<Usuario> findByNombreOrderByEdadAsc(String nombre);
	List<Usuario> findByNombreOrderByEdadDesc(String nombre);
	*/

}
