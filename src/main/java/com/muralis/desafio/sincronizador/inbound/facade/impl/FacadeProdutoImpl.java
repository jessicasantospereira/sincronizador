package com.muralis.desafio.sincronizador.inbound.facade.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.muralis.desafio.sincronizador.core.domain.dto.ProdutoDTO;
import com.muralis.desafio.sincronizador.core.domain.entity.Produto;
import com.muralis.desafio.sincronizador.core.domain.service.IProdutoService;
import com.muralis.desafio.sincronizador.inbound.facade.IFacadeProduto;
import com.muralis.desafio.sincronizador.inbound.mapper.IProdutoMapper;
@Component
public class FacadeProdutoImpl implements IFacadeProduto {
	@Autowired
	private IProdutoMapper produtoMapper;
	@Autowired
	private IProdutoService<Produto> produtoService;

	@Override
	public ProdutoDTO buscarProduto(int idProd) {
		Optional<Produto> produto = produtoService.buscaPorId(idProd);
		
		ProdutoDTO produtoDTO = produtoMapper.toDto(produto.orElse(null));
		return produtoDTO;
	}

	@Override
	public List<ProdutoDTO> buscarProdutos() {
		
		List<Produto> produtos = produtoService.buscarTodos();		
		List<ProdutoDTO> lista = new ArrayList<>();
		
		for (Produto produto : produtos) {
			ProdutoDTO produtoDTO = produtoMapper.toDto(produto);
			lista.add(produtoDTO);
		}
		
		
		return lista;
	}

}
