package com.muralis.desafio.sincronizador.outbound.jpa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.muralis.desafio.sincronizador.core.domain.entity.Empresa;


public interface JpaEmpresaRepository extends CrudRepository<Empresa, Integer>{
	
	public List<Empresa> findByClienteId(String id);
}
