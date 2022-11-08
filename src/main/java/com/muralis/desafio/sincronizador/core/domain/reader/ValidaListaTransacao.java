package com.muralis.desafio.sincronizador.core.domain.reader;

import java.time.LocalDateTime;

import com.muralis.desafio.sincronizador.core.domain.dto.TransacaoDTO;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class ValidaListaTransacao extends AbstractValidador {
	
	public String validarItens(TransacaoDTO linha) {
		log.info("[Desafio sincronizador - validando itens] - inicio as {}" ,LocalDateTime.now());
		StringBuilder sb = new StringBuilder();
		
		if(ehNulo(linha.getDescricao())){
			sb.append("Faltou a descrição da compra \n");
		}
		if(ehNulo(linha.getIdEmpresa())) {
			sb.append("ID da empresa em branco \n");
		}
		if(ehNulo(linha.getIdPosto())) {
			sb.append("ID do posto em branco \n");
		}
		//validações placa
		if(ehNulo(linha.getPlacaVeiculo())) {
			sb.append("Placa do veículo em branco \n");
		}else if(validaPlaca(linha.getPlacaVeiculo())) {
			sb.append("Placa do veículo em formato inválido \n");
		}
		
		if(ehNulo(linha.getProduto())) {
			sb.append("Descrição do produto em branco \n");
		}
		if(maiorQueZero(linha.getQuantidade())) {
			sb.append("Quantidade deve ser maior que zero \n");
		}
		if(maiorQueZero(linha.getValor())) { 
			sb.append("Valor deve ser maior que zero \n");
		}
		if(maiorQueZero(linha.getValorUnitario())) {
			sb.append("Valor unitário deve ser maior que zero \n");
		}
		
		log.info("[Desafio sincronizador - validando itens] - final as {}" ,LocalDateTime.now());
		return sb.toString();
	}
	
}
