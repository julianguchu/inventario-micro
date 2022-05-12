package com.foxcreations.springtest.app.repositorio;



import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.foxcreations.springtest.app.dto.DtoResponseInventarioDisponible;
import com.foxcreations.springtest.app.model.Inventario;

@Repository
public interface RepositorioInventario extends CrudRepository<Inventario, Integer> {
	
	
	@Query(" SELECT new com.foxcreations.springtest.app.dto.DtoResponseInventarioDisponible(i.id, i.descripcionMaquina ,i.marca, i.modelo , i.valorUnitario, i.estadoUso ,i.tipoInventario.descripcionTipo ,i.sucursal.id,  i.sucursal.nombreSucursal)  "
			+ " FROM  "
			+ "Inventario  i  WHERE    i.fechaCompra BETWEEN :inicio AND :finalmes "
			+ " AND " +"("
			+ "i.fechaVenta IS NULL OR i.fechaVenta > :finalmes" +") AND   i.sucursal.id = :idSucursalRequerida")
			
	public List<DtoResponseInventarioDisponible> getInventarioPorMesComprado(@Param("inicio") LocalDate inicio, @Param("finalmes") LocalDate finalmes, @Param("idSucursalRequerida") Integer idSucursal);
	
	
	@Query("SELECT new com.foxcreations.springtest.app.dto.DtoResponseInventarioDisponible(i.id, i.descripcionMaquina ,i.marca, i.modelo , i.valorUnitario, i.estadoUso ,i.tipoInventario.descripcionTipo , i.sucursal.id, i.sucursal.nombreSucursal) FROM  "
			+ "Inventario  i  WHERE  i.fechaVenta IS NULL")
	public List<DtoResponseInventarioDisponible> getInventarioDisponibleActualmente();
	
	@Query("SELECT new com.foxcreations.springtest.app.dto.DtoResponseInventarioDisponible(i.id, i.descripcionMaquina ,i.marca, i.modelo , i.valorUnitario, i.estadoUso ,i.tipoInventario.descripcionTipo ,i.sucursal.id,  i.sucursal.nombreSucursal) FROM  "
			+ "Inventario  i  WHERE  i.fechaVenta IS NULL AND  i.sucursal.id = :idSucursalRequerida")
	public List<DtoResponseInventarioDisponible> getInventarioParaUnaSucursal(@Param("idSucursalRequerida") Integer sucursalId); 

}
