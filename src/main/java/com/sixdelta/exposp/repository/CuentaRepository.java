package com.sixdelta.exposp.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
//import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sixdelta.exposp.model.Cuenta;


@RepositoryRestResource(collectionResourceRel = "cuenta", path="cuenta")
public interface CuentaRepository extends PagingAndSortingRepository<Cuenta, Long>{ 
	//List<Cuenta> findByNombre(@Param("Nombre") String Nombre);
}