package com.foxcreations.springtest.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foxcreations.springtest.app.excepciones.ExcepcionTipoInventario;
import com.foxcreations.springtest.app.model.TipoInventario;
import com.foxcreations.springtest.app.repositorio.RepositorioTipoInventario;

@Service
public class ServiceTipoInventario {
	
	private RepositorioTipoInventario  repoTipoInventario;

	
	@Autowired
	public ServiceTipoInventario(RepositorioTipoInventario repoTipoInventario) {
		this.repoTipoInventario = repoTipoInventario;
	}
	
	
	
	public  TipoInventario guardarTipo(TipoInventario tipoInventario) throws Exception{
		
		return repoTipoInventario.save(tipoInventario);
		
	}
	
	public  List<TipoInventario> listarTipo() throws ExcepcionTipoInventario {
		
		List<TipoInventario> listaTipoInventario=repoTipoInventario.listarTipoInventario();
		
		if(listaTipoInventario.isEmpty()) {
			
			throw new ExcepcionTipoInventario("no existen tipos registrados");
			
		}
		return listaTipoInventario;
		
	}
	
	
	public TipoInventario buscarTipoPorId(Integer idTipo) throws ExcepcionTipoInventario

	
	{
		
		Optional<TipoInventario> tipoInventarioEncontrado=repoTipoInventario.findById(idTipo);
		if(!(tipoInventarioEncontrado.isPresent())) {
			
			throw new ExcepcionTipoInventario("el tipo"+ idTipo+ " "+ "registrado en la bd");
		}
		
		
		return tipoInventarioEncontrado.get();
	}	
	
	
	
	
	

}
