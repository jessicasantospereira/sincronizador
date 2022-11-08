package com.muralis.desafio.sincronizador.inbound.mapper;

import java.util.Optional;

import com.muralis.desafio.sincronizador.core.domain.dto.ProdutoDTO;
import com.muralis.desafio.sincronizador.core.domain.entity.Produto;

public interface IProdutoMapper {
	public Produto toEntity(ProdutoDTO produtoDTO);
	public ProdutoDTO toDto(Produto produto);
}
