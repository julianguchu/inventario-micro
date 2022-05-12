package com.foxcreations.springtest.app.service;


import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.foxcreations.springtest.app.dto.DtoRequestInventario;
import com.foxcreations.springtest.app.dto.DtoResponseInventarioDisponible;
import com.foxcreations.springtest.app.excepciones.ExcepcionNoDisponibilidadInventario;
import com.foxcreations.springtest.app.excepciones.ExcepcionNoSucursalFound;
import com.foxcreations.springtest.app.excepciones.ExcepcionNotFound;
import com.foxcreations.springtest.app.excepciones.ExcepcionTipoInventario;
import com.foxcreations.springtest.app.model.Empleado;
import com.foxcreations.springtest.app.model.Inventario;
import com.foxcreations.springtest.app.model.Sucursal;
import com.foxcreations.springtest.app.model.TipoInventario;
import com.foxcreations.springtest.app.repositorio.RepositorioEmpleado;
import com.foxcreations.springtest.app.repositorio.RepositorioInventario;
import com.foxcreations.springtest.app.repositorio.RepositorioSucursal;
import com.foxcreations.springtest.app.repositorio.RepositorioTipoInventario;

@Service
public class ServicioInventario {
	
	private RepositorioInventario repositorioInventario;

	private RepositorioEmpleado repoEmpleado;
	
	private RepositorioTipoInventario repoTipoInventario;
	private RepositorioSucursal repoSucursal;
	
	@Autowired
	public ServicioInventario(RepositorioInventario repositorioInventario, RepositorioEmpleado repoEmpleado, RepositorioTipoInventario repoTipoInventario,RepositorioSucursal repoSucursal) {
		this.repositorioInventario = repositorioInventario;
		this.repoEmpleado = repoEmpleado;
		this.repoTipoInventario = repoTipoInventario;
		this.repoSucursal= repoSucursal;
		
	}
	
	@Transactional
	public  Inventario guardarInventario(DtoRequestInventario inventarioDto ) throws ExcepcionNoSucursalFound, ExcepcionNotFound, ExcepcionTipoInventario {
		

		Inventario inventario= new Inventario();
	
			inventario.setDescripcionMaquina(inventarioDto.getDescripcionMaquina());
			inventario.setEstadoUso(inventarioDto.getEstadoUso());
			inventario.setValorUnitario(inventarioDto.getValorUnitario());
			//se deberia asumir que existe ya que desde el front ya se ha cargado desde bd la sucursal en una lista
			
			Optional<Sucursal> sucursalLocalizacionInventario=repoSucursal.findById(inventarioDto.getIdSucursalLocalizacion());
		if (!(sucursalLocalizacionInventario.isPresent())) {
			
			throw new ExcepcionNoSucursalFound("No existe en bd  la sucursal");
			
			
		}
		inventario.setSucursal(sucursalLocalizacionInventario.get());
			inventario.setModelo(inventarioDto.getModelo());
			inventario.setPrecio(inventarioDto.getPrecio());
			inventario.setMarca(inventarioDto.getMarca());
			inventario.setFechaCompra(inventarioDto.getFechaCompra());
			
			
			Optional<Empleado> empleadoComprador=repoEmpleado.findById(inventarioDto.getIdEmpleado());
			
			if(!(empleadoComprador.isPresent())) {
				
			throw new ExcepcionNotFound("usuario no enecontrado en la base de datos");
				
			}
			
			Optional<TipoInventario> tipoInventarioConsultado=repoTipoInventario.findById(inventarioDto.getTipoInventario());
			if(!(tipoInventarioConsultado.isPresent())) {
				
				throw new ExcepcionTipoInventario("No se encuentra el tipo de inventario registrado");
				
			}
			inventario.setEmpleado(empleadoComprador.get());
			inventario.setTipoInventario(tipoInventarioConsultado.get());
			
			/*
			 aca va la parte para consultar el id del empleado que registra
			 aca va la parte donde se consulta el tipo de maquinaria
			 */
			
			
			return repositorioInventario.save(inventario);
		} 
		
	
	
		public List<DtoResponseInventarioDisponible> consultarInventarioDisponible() throws ExcepcionNoDisponibilidadInventario {
			List<DtoResponseInventarioDisponible>  listaDisponibilidadInventario=repositorioInventario.getInventarioDisponibleActualmente();
			
					if(listaDisponibilidadInventario.isEmpty()) {
						
						throw new ExcepcionNoDisponibilidadInventario("no hay disponibilidad de maquinaria en el inventario a nivel total de sucursales");
						
						
					}
			return listaDisponibilidadInventario ;
			
		}
		
		
		public Inventario consultarInventarioPorId(Integer id )throws ExcepcionNotFound {
			Optional<Inventario> inventarioPorId=repositorioInventario.findById(id);
			
					if(!(inventarioPorId.isPresent())) {
						
						throw new ExcepcionNotFound("no existe  el producto-inventario");
						
						
					}
			return inventarioPorId.get() ;
			
		}
		
		@Transactional
		@Modifying(clearAutomatically = true)
		public void  actualizarCualquierCampoInventario(Inventario  inventario) {
			
			repositorioInventario.save(inventario);
			
			
		}
		

		public List<DtoResponseInventarioDisponible> consultarInventarioDisponibleSucursalUnica(Integer sucursalid) throws ExcepcionNoDisponibilidadInventario, ExcepcionNoSucursalFound {
			
			Optional<Sucursal>sucursalBuscada= repoSucursal.findById(sucursalid);
			
			if(!(sucursalBuscada.isPresent())) {
				
				throw new ExcepcionNoSucursalFound("sucursal inexistente");
			}
			List<DtoResponseInventarioDisponible>  listaDisponibilidadInventario=repositorioInventario.getInventarioParaUnaSucursal(sucursalid);
			
					if(listaDisponibilidadInventario.isEmpty()) {
						
						throw new ExcepcionNoDisponibilidadInventario("no hay disponibilidad de maquinaria en el inventario para esta sucursal");
						
						
					}
			return listaDisponibilidadInventario ;
			
		}
		
	
		
public List<DtoResponseInventarioDisponible> ReporteDisponibilidadMesEspecificoSucursal(LocalDate inicio , LocalDate finalmes, Integer sucursalid) throws ExcepcionNoDisponibilidadInventario, ExcepcionNoSucursalFound {
			
			Optional<Sucursal>sucursalBuscada= repoSucursal.findById(sucursalid);
			
			if(!(sucursalBuscada.isPresent())) {
				
				throw new ExcepcionNoSucursalFound("sucursal inexistente");
			}
			List<DtoResponseInventarioDisponible>  listaDisponibilidadInventario=repositorioInventario.getInventarioPorMesComprado(inicio, finalmes,sucursalid);
			
					if(listaDisponibilidadInventario.isEmpty()) {
						
						throw new ExcepcionNoDisponibilidadInventario("no hay disponibilidad de maquinaria en el inventario para esta sucursal en el mes "+ inicio.getMonthValue());
						
						
					}
			return listaDisponibilidadInventario ;
			
		}
		
	
	
	

}
