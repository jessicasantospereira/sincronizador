package com.muralis.desafio.sincronizador.inbound.facade;

import java.util.List;

import com.muralis.desafio.sincronizador.core.domain.dto.TransacaoDTO;

public interface IFacadeTransacao {

	public void sincronizar();

	public List<TransacaoDTO> buscarTransacoes();
	
	public List<TransacaoDTO> buscaPlacaProduto(String placa, String produto);

}
