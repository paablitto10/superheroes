package com.superheroes.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.superheroes.crud.model.Superheroes;

/**
 * Hecho por Pablo Lozano
 */
@Repository
public interface SuperheroesRepository extends JpaRepository<Superheroes, Long> {

	
	  List<Superheroes> findByNombreIgnoreCaseContaining(String name);

}
