package com.muralis.desafio.sincronizador.outbound.jpa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.muralis.desafio.sincronizador.core.domain.entity.Posto;

public interface JpaPostoRepository extends CrudRepository<Posto, Integer>{
	
	public List<Posto> findByEstabelecimentoId(String id);
}
