package com.muralis.desafio.sincronizador.core.domain.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.muralis.desafio.sincronizador.core.domain.entity.Produto;
import com.muralis.desafio.sincronizador.core.domain.service.IProdutoService;
import com.muralis.desafio.sincronizador.core.repository.ProdutoRepository;

@Component
public class ProdutoServiceImpl implements IProdutoService<Produto> {
	@Autowired
	private ProdutoRepository produtoRepository;
	
	private Map<String, Produto> produto = new HashMap<>();


	public void salvarLista(List produto) {
		produtoRepository.saveAll(produto);
	}

	public Produto buscarPorDescricao(String descricao) {
		List<Produto> lista = produtoRepository.findByDescricao(descricao);
		if(lista.size() >= 1) {
			return lista.get(0);
//			for (Produto produto : lista) {
//				if(produto.getDescricao() == descricao) {
//					return produto;
//				}
//			}
			
		}
		return null;
	}

	@Override
	public Optional<Produto> buscaPorId(int id) {
		return produtoRepository.findById(id);

	}

	@Override
	public List<Produto> buscarTodos() {
		return (List<Produto>) produtoRepository.findAll();
	}

	@Override
	public void salvar(Produto produto) {
		produtoRepository.save(produto);

	}

}
