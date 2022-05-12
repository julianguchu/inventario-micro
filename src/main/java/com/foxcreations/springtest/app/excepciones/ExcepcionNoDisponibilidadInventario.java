package com.foxcreations.springtest.app.excepciones;

public class ExcepcionNoDisponibilidadInventario extends RuntimeException {
	
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public ExcepcionNoDisponibilidadInventario(String mensaje) {
	
	super(mensaje);
	
}

}
