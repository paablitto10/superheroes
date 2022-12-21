package com.superheroes.crud.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Hecho por Pablo
 */
public class SuperheroesRequest {
  @JsonProperty("nombre")
  private String nombre;


  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

}
