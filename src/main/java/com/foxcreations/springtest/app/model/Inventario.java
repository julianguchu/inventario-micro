package com.foxcreations.springtest.app.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table
public class Inventario {
 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nombre_maquina")
	private String descripcionMaquina;
	
	private  String marca;
	
	private String  modelo;
	
	@Column (name="precio_compra")
	private Double precio ;
	
	@Column(name="estado_uso")
	private String  estadoUso;
	
	@Column(name="valor_unitario")
	private Double  valorUnitario;
	
	@Column(name="fecha_compra")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaCompra;
	
	@Column(name="fecha_venta")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private  LocalDate fechaVenta;
	
	@JoinColumn(name="ubicacion")
	@ManyToOne
	private Sucursal sucursal;
	
	
	@Lob
	@Column(name="recibo_compra")
	private byte[] imagenReciboCompra;
	
	@JoinColumn(name="empleado")
	@ManyToOne
	private  Empleado  empleado;
	
	@JoinColumn(name="tipo_inventario")
	@ManyToOne
	private TipoInventario tipoInventario;

	

	public Inventario() {

	}

	

	public Inventario(Integer id, String descripcionMaquina, String marca, String modelo, Double precio,
			String estadoUso, Double valorUnitario, LocalDate fechaCompra, LocalDate fechaVenta,
			byte[] imagenReciboCompra, Empleado empleado, TipoInventario tipoInventario, Sucursal sucursal) {
	
		this.id = id;
		this.descripcionMaquina = descripcionMaquina;
		this.marca = marca;
		this.modelo = modelo;
		this.precio = precio;
		this.estadoUso = estadoUso;
		this.valorUnitario = valorUnitario;
		this.fechaCompra = fechaCompra;
		this.fechaVenta = fechaVenta;
		this.imagenReciboCompra = imagenReciboCompra;
		this.empleado = empleado;
		this.tipoInventario = tipoInventario;
		this.sucursal= sucursal;
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


	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public TipoInventario getTipoInventario() {
		return tipoInventario;
	}

	public void setTipoInventario(TipoInventario tipoInventario) {
		this.tipoInventario = tipoInventario;
	}

	public LocalDate getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(LocalDate fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public LocalDate getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public byte[] getImagenReciboCompra() {
		return imagenReciboCompra;
	}

	public void setImagenReciboCompra(byte[] imagenReciboCompra) {
		this.imagenReciboCompra = imagenReciboCompra;
	}



	public Double getValorUnitario() {
		return valorUnitario;
	}



	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}



	public Sucursal getSucursal() {
		return sucursal;
	}



	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}
	

	
	
}
