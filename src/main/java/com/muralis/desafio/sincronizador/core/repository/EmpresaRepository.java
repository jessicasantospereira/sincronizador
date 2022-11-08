package com.muralis.desafio.sincronizador.core.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.muralis.desafio.sincronizador.core.domain.entity.Empresa;


public interface EmpresaRepository extends CrudRepository<Empresa, Integer>{
	
	public List<Empresa> findByClienteId(String id);
}
