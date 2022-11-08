package com.muralis.desafio.sincronizador.inbound.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.muralis.desafio.sincronizador.core.domain.dto.EmpresaDTO;
import com.muralis.desafio.sincronizador.core.domain.entity.Empresa;
import com.muralis.desafio.sincronizador.core.domain.service.IEmpresaService;
import com.muralis.desafio.sincronizador.inbound.facade.IFacadeEmpresa;
import com.muralis.desafio.sincronizador.inbound.mapper.IEmpresaMapper;

@Component
public class FacadeEmpresaImpl implements IFacadeEmpresa {
	@Autowired
	private IEmpresaMapper empresaMapper;
	@Autowired
	private IEmpresaService<Empresa> empresaService;
	@Override
	public EmpresaDTO buscarCliente(String id_empresa) {
		
		Empresa empresa = empresaService.buscarPorIdCliente(id_empresa);
		EmpresaDTO empresaDTO = empresaMapper.toDto(empresa);
		
		return empresaDTO;
	}
	@Override
	public List<EmpresaDTO> buscarEmpresas() {
		List<Empresa> empresas = empresaService.buscarTodos();		
		List<EmpresaDTO> lista = new ArrayList<>();
		
		for (Empresa empresa : empresas) {
			EmpresaDTO empresaDTO = empresaMapper.toDto(empresa);
			lista.add(empresaDTO);
		}
		
		
		return lista;
	}

}
