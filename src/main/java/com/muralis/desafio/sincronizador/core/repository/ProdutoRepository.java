package com.muralis.desafio.sincronizador.core.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.muralis.desafio.sincronizador.core.domain.entity.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Integer>{
	
	public List<Produto> findByDescricao(String descricao);
}
