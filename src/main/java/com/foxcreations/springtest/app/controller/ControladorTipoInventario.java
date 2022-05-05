package com.foxcreations.springtest.app.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;



import com.foxcreations.springtest.app.excepciones.ExcepcionTipoInventario;

import com.foxcreations.springtest.app.model.TipoInventario;
import com.foxcreations.springtest.app.service.ServiceTipoInventario;


@RestController
@RequestMapping("/TipoInventario")
public class ControladorTipoInventario {
	@Autowired
	private ServiceTipoInventario servicioTipoInventario;
 
	@PostMapping("/guardar")
	public ResponseEntity<?> guardarTipoInventario(@RequestBody TipoInventario tipoInventario) {
		TipoInventario  tipoInventarioGuardado=null;
		try {
				
			  tipoInventarioGuardado= servicioTipoInventario.guardarTipo(tipoInventario);
			
		} catch (Exception e) {

			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);

		} 

		return new ResponseEntity<TipoInventario>(tipoInventarioGuardado, HttpStatus.CREATED);

	}

	@GetMapping("/listar")
	public ResponseEntity<?> listaTipoInventario() {
		List<TipoInventario> listaInventarioDisponible = null;
		try { 

			listaInventarioDisponible = servicioTipoInventario.listarTipo();
		} catch (ExcepcionTipoInventario e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<TipoInventario>>(listaInventarioDisponible, HttpStatus.OK);
	}

	
		
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarTipoInventarioPorId(@PathVariable("id") Integer tipoInventarioId) {
		TipoInventario  tipoInventarioEncontrado=null;
		try { 

			tipoInventarioEncontrado = servicioTipoInventario.buscarTipoPorId(tipoInventarioId);
		} catch (ExcepcionTipoInventario e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		

		return new ResponseEntity<TipoInventario>(tipoInventarioEncontrado, HttpStatus.OK);
	}
	
}
