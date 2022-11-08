package com.muralis.desafio.sincronizador.inbound.facade;

import java.util.List;

import com.muralis.desafio.sincronizador.core.domain.dto.PostoDTO;

public interface IFacadePosto {

	public PostoDTO buscarEstabelecimento(String idPosto);

	public List<PostoDTO> buscarPostos();
	
}
