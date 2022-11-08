package com.muralis.desafio.sincronizador.outbound.jpa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.muralis.desafio.sincronizador.core.domain.entity.Produto;

public interface JpaProdutoRepository extends CrudRepository<Produto, Integer>{
	
	public List<Produto> findByDescricao(String descricao);
}
