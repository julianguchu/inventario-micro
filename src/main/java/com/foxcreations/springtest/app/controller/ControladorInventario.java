package com.foxcreations.springtest.app.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.foxcreations.springtest.app.dto.DtoRequestInventario;
import com.foxcreations.springtest.app.dto.DtoResponseInventarioDisponible;
import com.foxcreations.springtest.app.excepciones.ExcepcionNoDisponibilidadInventario;
import com.foxcreations.springtest.app.excepciones.ExcepcionNoSucursalFound;
import com.foxcreations.springtest.app.excepciones.ExcepcionNotFound;
import com.foxcreations.springtest.app.excepciones.ExcepcionTipoInventario;
import com.foxcreations.springtest.app.model.Inventario;

import com.foxcreations.springtest.app.service.ServicioInventario;

@RestController
@RequestMapping("/inventario")
public class ControladorInventario {
	@Autowired
	private ServicioInventario servicioInventario;
 
	@PostMapping("/guardar")
	public ResponseEntity<?> guardarInventario(@RequestBody DtoRequestInventario peticion) {
		Inventario inventarioGuardado = null;
		try {

			
			inventarioGuardado = servicioInventario.guardarInventario(peticion);
		} catch (ExcepcionNotFound e) {

			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);

		} catch (ExcepcionTipoInventario e) {

			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);

		} catch (Exception e) {

			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);

		}

		return new ResponseEntity<Inventario>(inventarioGuardado, HttpStatus.CREATED);

	}

	@GetMapping("/disponibilidadGeneral")
	public ResponseEntity<?> obtenerlistProductosDisponibles() {
		List<DtoResponseInventarioDisponible> listaInventarioDisponible = null;
		try { 

			listaInventarioDisponible = servicioInventario.consultarInventarioDisponible();
		} catch (ExcepcionNoDisponibilidadInventario e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<DtoResponseInventarioDisponible>>(listaInventarioDisponible, HttpStatus.OK);
	}

	@PutMapping("/{id}/guardarFactura")
	public ResponseEntity<?> añadirFacturInventario(@PathVariable("id") Integer idInventario, @RequestParam("imagen") MultipartFile imagen) {
		byte[] imagenBite= null;
		Inventario inventario=null;
		try {
			 imagenBite=imagen.getBytes();
			 inventario=servicioInventario.consultarInventarioPorId(idInventario);
			 
			 inventario.setImagenReciboCompra(imagenBite);
			 servicioInventario.actualizarCualquierCampoInventario(inventario);
		} catch (IOException e) {
			return new ResponseEntity<String>("error en generar bites en la  imagen", HttpStatus.BAD_REQUEST);
		}
		catch (ExcepcionNotFound e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<String>("guardado",HttpStatus.NO_CONTENT);
		}
	
	
	@PutMapping("/{id}/actualizaFechaAVendido")
	public ResponseEntity<?> actualizafechaAvendido(@PathVariable("id") Integer idInventario) {
		
		Inventario inventario=null;
		try {
		
			 inventario=servicioInventario.consultarInventarioPorId(idInventario);
			 
			 inventario.setFechaVenta(LocalDate.now());
			 servicioInventario.actualizarCualquierCampoInventario(inventario);
		} 
		catch (ExcepcionNotFound e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<String>("Imagen cargada correctamente para el producto: "+" "+ inventario.getDescripcionMaquina(), HttpStatus.NO_CONTENT);
		}
		
		
	
	@GetMapping("/disponibilidadGeneral/sucursal/{id}")
	public ResponseEntity<?> disponibilidadGeneralEnSucursal(@PathVariable("id") Integer sucursalid) {
		List<DtoResponseInventarioDisponible> listaInventarioDisponibleSucursal = null;
		try { 

			listaInventarioDisponibleSucursal = servicioInventario.consultarInventarioDisponibleSucursalUnica(sucursalid);
		} catch (ExcepcionNoDisponibilidadInventario e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		catch (ExcepcionNoSucursalFound e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<DtoResponseInventarioDisponible>>(listaInventarioDisponibleSucursal, HttpStatus.OK);
	}
	
}
