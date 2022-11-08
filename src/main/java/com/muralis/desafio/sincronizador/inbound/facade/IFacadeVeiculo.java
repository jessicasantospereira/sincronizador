package com.muralis.desafio.sincronizador.inbound.facade;

import java.util.List;

import com.muralis.desafio.sincronizador.core.domain.dto.VeiculoDTO;

public interface IFacadeVeiculo {

	public VeiculoDTO buscarPlaca(String placa);

	public List<VeiculoDTO> buscarVeiculos();
	
}
