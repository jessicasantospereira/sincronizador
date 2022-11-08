package com.muralis.desafio.sincronizador.inbound.facade;

import java.util.List;
import java.util.Optional;

import com.muralis.desafio.sincronizador.core.domain.dto.ProdutoDTO;

public interface IFacadeProduto {

	public ProdutoDTO buscarProduto(int idProd);

	public List<ProdutoDTO> buscarProdutos();

}
