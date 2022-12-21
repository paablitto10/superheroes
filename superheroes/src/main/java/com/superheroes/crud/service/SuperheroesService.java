package com.superheroes.crud.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.superheroes.crud.model.Superheroes;
import com.superheroes.crud.payload.SuperheroesRequest;

/**
 * Hecho por Pablo Lozano
 */
public interface SuperheroesService {

	public List<Superheroes> getSuperheroes();
	
	public Superheroes getSuperheroe(Long id);
	
	public List<Superheroes> getSuperheroesByName(String nombre);
	
	public Boolean createSuperheroes(SuperheroesRequest request);

	public Superheroes updateSuperheroes(@RequestBody SuperheroesRequest request, @PathVariable Long id);

	public Boolean deleteSuperheroes(Long id);

}
