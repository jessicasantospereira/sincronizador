package com.muralis.desafio.sincronizador.inbound.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.muralis.desafio.sincronizador.core.domain.dto.EmpresaDTO;
import com.muralis.desafio.sincronizador.core.domain.dto.PostoDTO;
import com.muralis.desafio.sincronizador.core.domain.entity.Empresa;
import com.muralis.desafio.sincronizador.core.domain.entity.Posto;
import com.muralis.desafio.sincronizador.core.domain.service.IPostoService;
import com.muralis.desafio.sincronizador.inbound.facade.IFacadePosto;
import com.muralis.desafio.sincronizador.inbound.mapper.IPostoMapper;

@Component
public class FacadePostoImpl implements IFacadePosto {
	@Autowired
	IPostoMapper postoMapper;
	@Autowired
	IPostoService<Posto> postoService;

	@Override
	public PostoDTO buscarEstabelecimento(String idPosto) {
		Posto posto = postoService.buscarPorIdPosto(idPosto);

		PostoDTO postoDTO = postoMapper.toDto(posto);

		return postoDTO;
	}

	@Override
	public List<PostoDTO> buscarPostos() {
		List<Posto> postos = postoService.buscarTodos();
		List<PostoDTO> lista = new ArrayList<>();

		for (Posto posto : postos) {
			PostoDTO postoDTO = postoMapper.toDto(posto);
			lista.add(postoDTO);
		}
		return lista;
	}

}
