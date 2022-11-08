package com.muralis.desafio.sincronizador.inbound.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.muralis.desafio.sincronizador.core.domain.dto.TransacaoDTO;
import com.muralis.desafio.sincronizador.core.domain.entity.Transacao;
import com.muralis.desafio.sincronizador.core.domain.reader.Sincronizacao;
import com.muralis.desafio.sincronizador.core.domain.service.ITransacaoService;
import com.muralis.desafio.sincronizador.inbound.facade.IFacadeTransacao;
import com.muralis.desafio.sincronizador.inbound.mapper.ITransacaoMapper;
@Component
public class FacadeTransacaoImpl implements IFacadeTransacao {
	@Autowired
	private Sincronizacao sinc;
	@Autowired
	private ITransacaoMapper transacaoMapper;
	@Autowired
	private ITransacaoService<Transacao> transacaoService;
	@Override
	public void sincronizar() {
		sinc.sincronizarTransacoes();
		
	}
	@Override
	public List<TransacaoDTO> buscarTransacoes() {
		List<Transacao> transacoes = transacaoService.buscarTodos();
		List<TransacaoDTO> lista = new ArrayList<>();
		for (Transacao transacao : transacoes) {
			TransacaoDTO transacaoDTO = transacaoMapper.toDto(transacao);
			lista.add(transacaoDTO);
		}
	
		return lista;
	}
	@Override
	public List<TransacaoDTO> buscaPlacaProduto(String placa, String produto) {
		List<Transacao> transacoes = transacaoService.buscaFiltro(placa, produto);
		List<TransacaoDTO> lista = new ArrayList<>();
		for (Transacao transacao : transacoes) {
			TransacaoDTO transacaoDTO = transacaoMapper.toDto(transacao);
			lista.add(transacaoDTO);
		}
		return lista;
	}

}
