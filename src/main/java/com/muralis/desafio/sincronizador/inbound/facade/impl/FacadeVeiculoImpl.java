package com.muralis.desafio.sincronizador.inbound.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.muralis.desafio.sincronizador.core.domain.dto.VeiculoDTO;
import com.muralis.desafio.sincronizador.core.domain.entity.Veiculo;
import com.muralis.desafio.sincronizador.core.domain.service.IVeiculoService;
import com.muralis.desafio.sincronizador.inbound.facade.IFacadeVeiculo;
import com.muralis.desafio.sincronizador.inbound.mapper.IVeiculoMapper;
@Component
public class FacadeVeiculoImpl implements IFacadeVeiculo {
	@Autowired
	private IVeiculoMapper veiculoMapper;
	@Autowired
	private IVeiculoService<Veiculo> veiculoService;

	@Override
	public VeiculoDTO buscarPlaca(String placa) {
		Veiculo veiculo = veiculoService.buscarPorPlaca(placa);
		VeiculoDTO veiculoDTO = veiculoMapper.toDto(veiculo);
		return veiculoDTO;
	}

	@Override
	public List<VeiculoDTO> buscarVeiculos() {
		List<Veiculo> veiculos = veiculoService.buscarTodos();
		List<VeiculoDTO> lista = new ArrayList<>();
		
		for (Veiculo veiculo : veiculos) {
			VeiculoDTO veiculoDTO = veiculoMapper.toDto(veiculo);
			lista.add(veiculoDTO);
		}
		return lista;
	}

}
