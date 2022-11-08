package com.muralis.desafio.sincronizador.inbound.mapper;

import com.muralis.desafio.sincronizador.core.domain.dto.TransacaoDTO;
import com.muralis.desafio.sincronizador.core.domain.entity.Transacao;

public interface ITransacaoMapper {

	public TransacaoDTO toDto(Transacao transacao);
	public Transacao toEntity(TransacaoDTO transacaoDTO);

}
