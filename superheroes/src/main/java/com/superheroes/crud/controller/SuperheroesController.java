package com.superheroes.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.superheroes.crud.exception.AppException;
import com.superheroes.crud.payload.SuperheroesRequest;
import com.superheroes.crud.service.SuperheroesService;

/**
 * Hecho por Pablo Lozano
 */
@RestController
@RequestMapping("/api")
public class SuperheroesController {

	@Autowired
	private SuperheroesService superheroesService;

	/**
	 * Busca todos los superheroes
	 * 
	 * @return List de Superheroes
	 */
	@GetMapping("/superheroes")
	public ResponseEntity<Object> getSuperheroes() {
		try {
			return new ResponseEntity<Object>(superheroesService.getSuperheroes(), HttpStatus.OK);
		} catch (Exception e) {
			throw new AppException("Superheroes no encontrados.");
		}

	}

	/**
	 * Busca superheroe por id
	 * 
	 * @param id
	 * @return Superheroes
	 */
	@GetMapping("/superheroes/{id}")
	public ResponseEntity<Object> getSuperheroe(@PathVariable Long id) {

		try {
			return new ResponseEntity<Object>(superheroesService.getSuperheroe(id), HttpStatus.OK);
		} catch (Exception e) {
			throw new AppException("Superheroes no encontrados.");
		}

	}

	/**
	 * Busca superheroes que contengan nombre
	 * 
	 * @param nombre
	 * @return List de Superheroes
	 */
	@GetMapping("/superheroes/nombre/{nombre}")
	public ResponseEntity<Object> getSuperheroesByName(@PathVariable String nombre) {

		try {
			return new ResponseEntity<Object>(superheroesService.getSuperheroesByName(nombre), HttpStatus.OK);
		} catch (Exception e) {
			throw new AppException("Superheroes no encontrados.");
		}
	}

	/**
	 * Crea un nuevo superheroe
	 * 
	 * @param request
	 * @return Message
	 */
	@PostMapping("/superheroes")
	public ResponseEntity<Object> createSuperheroes(@RequestBody SuperheroesRequest request) {

		try {
			return new ResponseEntity<Object>(superheroesService.createSuperheroes(request), HttpStatus.OK);
		} catch (Exception e) {
			throw new AppException("Superheroe no guardado.");
		}
	}

	/**
	 * Actualiza un superheroe existente
	 * 
	 * @param request
	 * @return ResponseEntity
	 */
	@PutMapping("/superheroes/{id}")
	public ResponseEntity<Object> updateSuperheroes(@RequestBody SuperheroesRequest request, @PathVariable Long id) {

		try {
			return new ResponseEntity<Object>(superheroesService.updateSuperheroes(request, id), HttpStatus.OK);
		} catch (Exception e) {
			throw new AppException("Superheroe no actualizado.");
		}

	}

	/**
	 * Borra un superheroe
	 * 
	 * @param id
	 * @return ResponseEntity
	 */
	@DeleteMapping("/superheroes/{id}")
	public ResponseEntity<Object> deleteSuperheroes(@PathVariable Long id) {

		try {
			return new ResponseEntity<Object>(superheroesService.deleteSuperheroes(id), HttpStatus.OK);
		} catch (Exception e) {
			throw new AppException("Superheroe no actualizado.");
		}

	}
}
