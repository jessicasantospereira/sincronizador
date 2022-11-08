package com.muralis.desafio.sincronizador.inbound.mapper.impl;

import org.springframework.stereotype.Component;

import com.muralis.desafio.sincronizador.core.domain.dto.TransacaoDTO;
import com.muralis.desafio.sincronizador.core.domain.entity.Empresa;
import com.muralis.desafio.sincronizador.core.domain.entity.Posto;
import com.muralis.desafio.sincronizador.core.domain.entity.Produto;
import com.muralis.desafio.sincronizador.core.domain.entity.Transacao;
import com.muralis.desafio.sincronizador.core.domain.entity.Veiculo;
import com.muralis.desafio.sincronizador.inbound.mapper.ITransacaoMapper;
@Component
public class TransacaoMapperImpl implements ITransacaoMapper {

	@Override
	public TransacaoDTO toDto(Transacao transacao) {
		if(transacao == null) {
			return null;
		}
		TransacaoDTO transacaoDTO = new TransacaoDTO();
		transacaoDTO.setDescricao(transacao.getDescricao());
		transacaoDTO.setQuantidade(transacao.getQuantidade());
		transacaoDTO.setValor(transacao.getValor());
		transacaoDTO.setValorCalculado(transacao.getValorCalculado());
		transacaoDTO.setValorUnitario(transacao.getValorUnitario());
		
		transacaoDTO.setProduto(transacao.getProduto().getDescricao());
		transacaoDTO.setIdEmpresa(transacao.getEmpresa().getClienteId());
		transacaoDTO.setIdPosto(transacao.getPosto().getEstabelecimentoId());
		transacaoDTO.setPlacaVeiculo(transacao.getVeiculo().getPlaca());
		
		return transacaoDTO;
	}

	@Override
	public Transacao toEntity(TransacaoDTO transacaoDTO) {
		Transacao transacao = new Transacao();
		transacao.setDescricao(transacaoDTO.getDescricao());
		transacao.setEmpresa(new Empresa(transacaoDTO.getIdEmpresa()));
		transacao.setPosto(new Posto(transacaoDTO.getIdPosto()));
		transacao.setProduto(new Produto(transacaoDTO.getProduto()));
		transacao.setVeiculo(new Veiculo(transacaoDTO.getPlacaVeiculo()));
		transacao.setQuantidade(transacaoDTO.getQuantidade());
		transacao.setValor(transacaoDTO.getValor());
		transacao.setValorCalculado(transacaoDTO.getValorCalculado());
		transacao.setValorUnitario(transacaoDTO.getValorUnitario());
		
		return transacao;
	}
	

}
