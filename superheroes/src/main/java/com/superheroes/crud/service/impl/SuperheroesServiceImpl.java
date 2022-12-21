package com.superheroes.crud.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.superheroes.crud.exception.AppException;
import com.superheroes.crud.model.Superheroes;
import com.superheroes.crud.payload.SuperheroesRequest;
import com.superheroes.crud.repository.SuperheroesRepository;
import com.superheroes.crud.service.SuperheroesService;

/**
 * Hecho por Pablo Lozano
 */
@Service
public class SuperheroesServiceImpl implements SuperheroesService {

	@Autowired
	private SuperheroesRepository superheroesRepository;

	@Override
	public List<Superheroes> getSuperheroes() {
		return superheroesRepository.findAll();

	}
	@Override
	public Superheroes getSuperheroe(Long id) {
		Optional<Superheroes> superheroe = superheroesRepository.findById(id);
		if (!superheroe.isPresent()) {
			throw new AppException("Superheroe no encontrado.");
		}

		return superheroe.get();
	}
	@Override
	public List<Superheroes> getSuperheroesByName(String nombre) {

		List<Superheroes> superheroes = superheroesRepository.findByNombreIgnoreCaseContaining(nombre);
		if (superheroes.size() == 0) {
			throw new AppException("Superheroe no encontrado.");
		}
		return superheroes;

	}
	@Override
	public Boolean createSuperheroes(SuperheroesRequest request) {

		Superheroes superheroe = new Superheroes();
		superheroe.setNombre(request.getNombre());
		Superheroes result = superheroesRepository.save(superheroe);

		if (result == null)
			throw new AppException("Superheroe no encontrado.");

		return true;

	}
	@Override
	public Superheroes updateSuperheroes(@RequestBody SuperheroesRequest request, @PathVariable Long id) {

		Optional<Superheroes> superheroeOptional = superheroesRepository.findById(id);
		if (!superheroeOptional.isPresent()) {
			throw new AppException("Superheroe no encontrado.");
		}
		Superheroes superheroe = superheroeOptional.get();
		superheroe.setNombre(request.getNombre());
		superheroesRepository.save(superheroe);

		return superheroe;
	}
	@Override
	public Boolean deleteSuperheroes(Long id) {

		Optional<Superheroes> superheroe = superheroesRepository.findById(id);
		if (!superheroe.isPresent()) {
			throw new AppException("Superheroe no encontrado.");
		}
		superheroesRepository.delete(superheroe.get());

		return true;

	}

}
