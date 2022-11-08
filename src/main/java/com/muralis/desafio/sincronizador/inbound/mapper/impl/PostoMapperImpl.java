package com.muralis.desafio.sincronizador.inbound.mapper.impl;

import org.springframework.stereotype.Component;

import com.muralis.desafio.sincronizador.core.domain.dto.PostoDTO;
import com.muralis.desafio.sincronizador.core.domain.entity.Posto;
import com.muralis.desafio.sincronizador.inbound.mapper.IPostoMapper;
@Component
public class PostoMapperImpl implements IPostoMapper{

	@Override
	public Posto toEntity(PostoDTO postoDTO) {
		Posto posto = new Posto();
		posto.setEstabelecimentoId(postoDTO.getIdPosto());
		
		return posto;
	}

	@Override
	public PostoDTO toDto(Posto posto) {
		if(posto == null) {
			return null;
		}
		PostoDTO postoDTO = new PostoDTO();
		postoDTO.setIdPosto(posto.getEstabelecimentoId());
		
		return postoDTO;
	}

}
