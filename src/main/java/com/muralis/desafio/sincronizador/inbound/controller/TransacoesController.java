package com.muralis.desafio.sincronizador.inbound.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muralis.desafio.sincronizador.core.domain.dto.TransacaoDTO;
import com.muralis.desafio.sincronizador.core.domain.service.impl.TransacaoServiceImpl;
import com.muralis.desafio.sincronizador.inbound.facade.IFacadeTransacao;

@RestController
public class TransacoesController {
	@Autowired
	TransacaoServiceImpl tDao;
	@Autowired
	IFacadeTransacao facadeTransacao;
	
	@RequestMapping("/transacoes")
	public List<TransacaoDTO> lista(String placa, String produto){
		if(placa == null && produto == null) {
			return facadeTransacao.buscarTransacoes();
		}else{
			
			return facadeTransacao.buscaPlacaProduto(placa, produto);
//			return null;
		}
		
	}

}
