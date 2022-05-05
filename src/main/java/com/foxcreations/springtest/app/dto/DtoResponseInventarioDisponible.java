package com.foxcreations.springtest.app.dto;



public class DtoResponseInventarioDisponible {


	

	private Integer id;
	
	private String descripcionMaquina;
	
	private  String marca;
	
	private String  modelo;
	

	private Double valorUnitario;
	
	
	private String  estadoUso;
	
	
	private String descripcionTipo;
	
	private Integer idSucursalLocalizacionProducto;
	private  String  sucursalLocalizacionProducto;
	
	

	
	
	
	
	
	
	public DtoResponseInventarioDisponible() {
	
	}

	public DtoResponseInventarioDisponible(Integer id, String descripcionMaquina, String marca, String modelo,
			Double valorUnitario, String estadoUso, String descripcionTipo,Integer idSucursalLocalizacionProducto, String sucursalLocalizacionProducto) {

		this.id = id;
		this.descripcionMaquina = descripcionMaquina;
		this.marca = marca;
		this.modelo = modelo;
		this.valorUnitario = valorUnitario;
		this.estadoUso = estadoUso;
		this.descripcionTipo = descripcionTipo;
		this.idSucursalLocalizacionProducto=idSucursalLocalizacionProducto;
		this.sucursalLocalizacionProducto = sucursalLocalizacionProducto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public String getEstadoUso() {
		return estadoUso;
	}

	public void setEstadoUso(String estadoUso) {
		this.estadoUso = estadoUso;
	}

	public String getDescripcionTipo() {
		return descripcionTipo;
	}

	public void setDescripcionTipo(String descripcionTipo) {
		this.descripcionTipo = descripcionTipo;
	}

	public String getSucursalLocalizacionProducto() {
		return sucursalLocalizacionProducto;
	}

	public void setSucursalLocalizacionProducto(String sucursalLocalizacionProducto) {
		this.sucursalLocalizacionProducto = sucursalLocalizacionProducto;
	}

	public Integer getIdSucursalLocalizacionProducto() {
		return idSucursalLocalizacionProducto;
	}

	public void setIdSucursalLocalizacionProducto(Integer idSucursalLocalizacionProducto) {
		this.idSucursalLocalizacionProducto = idSucursalLocalizacionProducto;
	}

	
	


	

	
	
	
}
