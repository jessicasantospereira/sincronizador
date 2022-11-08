package com.muralis.desafio.sincronizador.inbound.mapper.impl;

import org.springframework.stereotype.Component;

import com.muralis.desafio.sincronizador.core.domain.dto.EmpresaDTO;
import com.muralis.desafio.sincronizador.core.domain.entity.Empresa;
import com.muralis.desafio.sincronizador.inbound.mapper.IEmpresaMapper;

@Component
public class EmpresaMapperImpl implements IEmpresaMapper {

	@Override
	public Empresa toEntity(EmpresaDTO empresaDTO) {
		Empresa empresa = new Empresa();
		empresa.setClienteId(empresaDTO.getClienteId());
		
		return empresa;
	}

	@Override
	public EmpresaDTO toDto(Empresa empresa) {
		if(empresa == null) {
			return null;
		}
		EmpresaDTO empresaDTO = new EmpresaDTO();
		empresaDTO.setClienteId(empresa.getClienteId());
		
		return empresaDTO;
	}
	
}
