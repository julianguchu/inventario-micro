package com.foxcreations.springtest.app.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.foxcreations.springtest.app.model.Empleado;

@Repository
public interface RepositorioEmpleado extends CrudRepository<Empleado, Integer> {

}
