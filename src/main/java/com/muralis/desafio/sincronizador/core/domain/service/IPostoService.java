package com.muralis.desafio.sincronizador.core.domain.service;

import java.util.List;
import java.util.Optional;

import com.muralis.desafio.sincronizador.core.domain.entity.EntidadeDominio;
import com.muralis.desafio.sincronizador.core.domain.entity.Posto;

public interface IPostoService <T extends EntidadeDominio>{
	public T buscarPorIdPosto(String idPosto);
	public Optional<T> buscaPorId(int id);
	public List<T> buscarTodos();
	public void salvar(T posto);
}
