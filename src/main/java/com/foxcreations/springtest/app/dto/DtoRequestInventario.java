package com.foxcreations.springtest.app.dto;

import java.time.LocalDate;

public class DtoRequestInventario {


	

	private String descripcionMaquina;
	
	private  String marca;
	
	private String  modelo;
	

	private Double precio ;
	
	
	private String  estadoUso;
	

	private  Integer  idEmpleado;
	
	
	private Integer tipoInventario;
	
	private  Integer idSucursalLocalizacion;
	
	private Double valorUnitario;
	
	private LocalDate fechaCompra;

	
	

	public DtoRequestInventario(String descripcionMaquina, String marca, String modelo, Double precio, String estadoUso,
			Integer idEmpleado, Integer tipoInventario, Integer idSucursalLocalizacion, Double valorUnitario, LocalDate fechaCompra) {
		this.descripcionMaquina = descripcionMaquina;
		this.marca = marca;
		this.modelo = modelo;
		this.precio = precio;
		this.estadoUso = estadoUso;
		this.idEmpleado = idEmpleado;
		this.tipoInventario = tipoInventario;
		this.idSucursalLocalizacion=idSucursalLocalizacion; 
		this.valorUnitario = valorUnitario;
		this.fechaCompra= fechaCompra;
	}


	public String getDescripcionMaquina() {
		return descripcionMaquina;
	}


	public void setDescripcionMaquina(String descripcionMaquina) {
		this.descripcionMaquina = descripcionMaquina;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public Double getPrecio() {
		return precio;
	}


	public void setPrecio(Double precio) {
		this.precio = precio;
	}


	public String getEstadoUso() {
		return estadoUso;
	}


	public void setEstadoUso(String estadoUso) {
		this.estadoUso = estadoUso;
	}


	

	public Integer getIdEmpleado() {
		return idEmpleado;
	}


	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}


	public Integer getTipoInventario() {
		return tipoInventario;
	}


	public void setTipoInventario(Integer tipoInventario) {
		this.tipoInventario = tipoInventario;
	}



	public Double getValorUnitario() {
		return valorUnitario;
	}


	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}


	public Integer getIdSucursalLocalizacion() {
		return idSucursalLocalizacion;
	}


	public void setIdSucursalLocalizacion(Integer idSucursalLocalizacion) {
		this.idSucursalLocalizacion = idSucursalLocalizacion;
	}


	public LocalDate getFechaCompra() {
		return fechaCompra;
	}


	public void setFechaCompra(LocalDate fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	
	
	
	
	
	
}
