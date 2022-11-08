package com.muralis.desafio.sincronizador.core.domain.service;

import java.util.List;
import java.util.Optional;

import com.muralis.desafio.sincronizador.core.domain.entity.EntidadeDominio;
import com.muralis.desafio.sincronizador.core.domain.entity.Transacao;

public interface ITransacaoService <T extends EntidadeDominio>{
	
	public void salvarLista(List<T> lista);
	public List<T> buscaFiltro(String placa, String produto);
	public List<T> buscarTodos();
}
