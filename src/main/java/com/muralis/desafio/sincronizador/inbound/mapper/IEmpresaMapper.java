package com.muralis.desafio.sincronizador.inbound.mapper;

import com.muralis.desafio.sincronizador.core.domain.dto.EmpresaDTO;
import com.muralis.desafio.sincronizador.core.domain.entity.Empresa;

public interface IEmpresaMapper {
	public Empresa toEntity(EmpresaDTO empresaDTO);
	public EmpresaDTO toDto(Empresa empresa);
	
}
