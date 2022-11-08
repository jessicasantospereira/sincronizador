package com.muralis.desafio.sincronizador.core.domain.service;

import java.util.List;
import java.util.Optional;

import com.muralis.desafio.sincronizador.core.domain.entity.EntidadeDominio;

public interface IEmpresaService <T extends EntidadeDominio> {
	public T buscarPorIdCliente(String id);
	public Optional<T> buscaPorId(int id);
	public List<T> buscarTodos();
	public void salvar(T empresa);
}
