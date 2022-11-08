package com.muralis.desafio.sincronizador.core.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.muralis.desafio.sincronizador.core.domain.entity.Transacao;

public interface TransacaoRepository extends CrudRepository<Transacao, Integer>{
	
	public List<Transacao> findByVeiculoPlacaAndProdutoDescricao(String placa, String produto);
}
