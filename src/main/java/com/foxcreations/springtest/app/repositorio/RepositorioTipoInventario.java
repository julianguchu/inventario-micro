package com.foxcreations.springtest.app.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.foxcreations.springtest.app.dto.DtoResponseInventarioDisponible;
import com.foxcreations.springtest.app.model.TipoInventario;


@Repository
public interface RepositorioTipoInventario extends CrudRepository<TipoInventario, Integer> {

	@Query("SELECT t  from TipoInventario t ")
	public List<TipoInventario> listarTipoInventario();
	
	
}
