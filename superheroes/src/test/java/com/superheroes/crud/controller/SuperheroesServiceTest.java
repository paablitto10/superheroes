package com.superheroes.crud.controller;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.superheroes.crud.model.Superheroes;
import com.superheroes.crud.payload.SuperheroesRequest;
import com.superheroes.crud.service.SuperheroesService;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
@Transactional
public class SuperheroesServiceTest {

	@Autowired
	private SuperheroesService superheroesService;

	@Test
	public void getSuperheroes() {
		assertEquals(true, superheroesService.getSuperheroes() instanceof List);
	}

	@Test
	public void getSuperheroe() {
		assertEquals(true, superheroesService.getSuperheroe(1L) instanceof Superheroes);
	}

	@Test
	public void getSuperheroesByName() {
		assertEquals(true, superheroesService.getSuperheroesByName("man") instanceof List);
	}

	@Test
	public void createSuperheroes() {
		Boolean proceso = true;
		try {
			SuperheroesRequest superheroe = new SuperheroesRequest();
			superheroe.setNombre("Superheroe prueba");
			superheroesService.createSuperheroes(superheroe);
		} catch (Exception e) {
			proceso = false;
		}
		assertEquals(true, proceso);
	}

	@Test
	public void updateSuperheroes() {
		SuperheroesRequest superheroe = new SuperheroesRequest();
		superheroe.setNombre("Superheroe prueba");
		assertEquals(true, superheroesService.updateSuperheroes(superheroe, 1L) instanceof Superheroes);
	}

	@Test
	public void deleteSuperheroes() {
		Boolean proceso = true;
		try {
			superheroesService.deleteSuperheroes(1L);
		} catch (Exception e) {
			proceso = false;
		}
		assertEquals(true, proceso);
	}
}