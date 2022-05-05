package com.foxcreations.springtest.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Table
@Entity
public class Cargo {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	

	@Column(name="nombre_cargo")
	private String descripcionCargo;


	
	
	public Cargo() {
		
	}


	public Cargo(Integer id, String descripcionCargo) {
	
		this.id = id;
		this.descripcionCargo = descripcionCargo;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDescripcionCargo() {
		return descripcionCargo;
	}


	public void setDescripcionCargo(String descripcionCargo) {
		this.descripcionCargo = descripcionCargo;
	}
	
	
	
}
