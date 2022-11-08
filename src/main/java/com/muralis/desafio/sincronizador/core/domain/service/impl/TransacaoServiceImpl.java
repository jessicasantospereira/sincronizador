package com.muralis.desafio.sincronizador.core.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.muralis.desafio.sincronizador.core.domain.entity.Transacao;
import com.muralis.desafio.sincronizador.core.domain.service.ITransacaoService;
import com.muralis.desafio.sincronizador.core.repository.TransacaoRepository;
@Component
public class TransacaoServiceImpl implements ITransacaoService {
	@Autowired
	private TransacaoRepository transacaoRepository;
	
	public void salvarLista(List lista) {
		transacaoRepository.saveAll(lista);
	}

	public List<Transacao> buscarTodos() {
		return (List<Transacao>) transacaoRepository.findAll();

	}

	public List<Transacao> buscaFiltro(String placa, String produto) {

		return transacaoRepository.findByVeiculoPlacaAndProdutoDescricao(placa, produto);
	}





}
