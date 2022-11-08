package com.muralis.desafio.sincronizador.core.domain.service;

import java.util.List;
import java.util.Optional;

import com.muralis.desafio.sincronizador.core.domain.entity.EntidadeDominio;
import com.muralis.desafio.sincronizador.core.domain.entity.Veiculo;

public interface IVeiculoService<T extends EntidadeDominio>{
	
	public Optional<T> buscaPorId(int id);
	public List<T> buscarTodos();
	public void salvar(T veiculo);
	public T buscarPorPlaca(String placa);

}
