package com.api.test.repository;

//import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
//import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.api.test.model.Cliente;


@RepositoryRestResource(collectionResourceRel = "cliente", path="cliente")
public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Long>{
    //List<Cliente> findByNombre(@Param("Nombre") String Nombre);
}

