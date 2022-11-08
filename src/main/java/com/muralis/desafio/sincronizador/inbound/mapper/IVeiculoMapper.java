package com.muralis.desafio.sincronizador.inbound.mapper;

import com.muralis.desafio.sincronizador.core.domain.dto.VeiculoDTO;
import com.muralis.desafio.sincronizador.core.domain.entity.Veiculo;

public interface IVeiculoMapper {
	
	public Veiculo toEntity(VeiculoDTO veiculoDTO);
	public VeiculoDTO toDto(Veiculo veiculo);
	
}
