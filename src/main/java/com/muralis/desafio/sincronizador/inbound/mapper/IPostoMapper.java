package com.muralis.desafio.sincronizador.inbound.mapper;

import com.muralis.desafio.sincronizador.core.domain.dto.PostoDTO;
import com.muralis.desafio.sincronizador.core.domain.entity.Posto;

public interface IPostoMapper {
	public Posto toEntity(PostoDTO postoDTO);
	public PostoDTO toDto(Posto posto);
}
