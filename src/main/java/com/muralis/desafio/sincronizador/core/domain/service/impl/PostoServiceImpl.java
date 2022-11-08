package com.muralis.desafio.sincronizador.core.domain.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.muralis.desafio.sincronizador.core.domain.entity.Posto;
import com.muralis.desafio.sincronizador.core.domain.service.IPostoService;
import com.muralis.desafio.sincronizador.core.repository.PostoRepository;

@Component
public class PostoServiceImpl implements IPostoService<Posto> {
	@Autowired
	private PostoRepository postoRepository;
	private Map<String, Posto> posto = new HashMap<>();

	public void salvar(Posto posto) {
		postoRepository.save(posto);
	}
	public Posto buscarPorIdPosto(String idPosto) {
		List<Posto> lista = postoRepository.findByEstabelecimentoId(idPosto);
		if(lista.size() >= 1) {
			return lista.get(0);
		}
		return null;
	}
	@Override
	public Optional<Posto> buscaPorId(int id) {
		return postoRepository.findById(id);
	}
	
	@Override
	public List<Posto> buscarTodos() {
		
		return (List<Posto>) postoRepository.findAll();

	}



}
