package com.muralis.desafio.sincronizador.core.domain.service;

import java.util.List;
import java.util.Optional;

import com.muralis.desafio.sincronizador.core.domain.entity.EntidadeDominio;

public interface IProdutoService <T extends EntidadeDominio>{
	public void salvarLista(List<T> lista);
	public Optional<T> buscaPorId(int id);
	public List<T> buscarTodos();
	public void salvar(T produto);
	
}
