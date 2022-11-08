package com.muralis.desafio.sincronizador.inbound.mapper.impl;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.muralis.desafio.sincronizador.core.domain.dto.ProdutoDTO;
import com.muralis.desafio.sincronizador.core.domain.entity.Produto;
import com.muralis.desafio.sincronizador.inbound.mapper.IProdutoMapper;
@Component
public class ProdutoMapperImpl implements IProdutoMapper{

	@Override
	public Produto toEntity(ProdutoDTO produtoDTO) {
		Produto produto = new Produto();
		produto.setDescricao(produtoDTO.getDescricao());
		
		return produto;
	}

	@Override
	public ProdutoDTO toDto(Produto produto) {
		if(produto == null) {
			return null;
		}
		ProdutoDTO produtoDTO = new ProdutoDTO();
		produtoDTO.setDescricao(produto.getDescricao());
		
		return produtoDTO;
	}


}
