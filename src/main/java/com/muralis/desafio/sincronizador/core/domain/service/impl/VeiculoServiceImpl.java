package com.muralis.desafio.sincronizador.core.domain.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.muralis.desafio.sincronizador.core.domain.entity.EntidadeDominio;
import com.muralis.desafio.sincronizador.core.domain.entity.Veiculo;
import com.muralis.desafio.sincronizador.core.domain.service.IVeiculoService;
import com.muralis.desafio.sincronizador.core.repository.VeiculoRepository;

@Component
public class VeiculoServiceImpl implements IVeiculoService<Veiculo> {
	@Autowired
	private VeiculoRepository veiculoRepository;
	private Map<String, Veiculo> veiculo = new HashMap<>();

	@Override
	public void salvar(Veiculo veiculo) {
		veiculoRepository.save(veiculo);
	}

	public Veiculo buscarPorPlaca(String placa) {
		List<Veiculo> lista = veiculoRepository.findByPlaca(placa);
		if(lista.size() >= 1) {
			return lista.get(0);
		}
		return null;
	}
	@Override
	public Optional<Veiculo> buscaPorId(int id) {
		return veiculoRepository.findById(id);
	}

	@Override
	public List<Veiculo> buscarTodos() {
		return (List<Veiculo>) veiculoRepository.findAll();
	}

	
}
