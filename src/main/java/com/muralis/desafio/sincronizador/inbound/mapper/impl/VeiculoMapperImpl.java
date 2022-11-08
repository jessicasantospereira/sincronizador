package com.muralis.desafio.sincronizador.inbound.mapper.impl;

import org.springframework.stereotype.Component;

import com.muralis.desafio.sincronizador.core.domain.dto.VeiculoDTO;
import com.muralis.desafio.sincronizador.core.domain.entity.Veiculo;
import com.muralis.desafio.sincronizador.inbound.mapper.IVeiculoMapper;
@Component
public class VeiculoMapperImpl implements IVeiculoMapper{

	@Override
	public Veiculo toEntity(VeiculoDTO veiculoDTO) {
		
		Veiculo veiculo = new Veiculo();
		veiculo.setPlaca(veiculoDTO.getPlaca());
		
		return veiculo;
	}

	@Override
	public VeiculoDTO toDto(Veiculo veiculo) {
		if(veiculo == null) {
			return null;
		}
		VeiculoDTO veiculoDTO = new VeiculoDTO();
		veiculoDTO.setPlaca(veiculo.getPlaca());
		
		return veiculoDTO;
	}

}
