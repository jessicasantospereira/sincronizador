package com.muralis.desafio.sincronizador.inbound.facade;

import java.util.List;

import com.muralis.desafio.sincronizador.core.domain.dto.EmpresaDTO;

public interface IFacadeEmpresa {

	public EmpresaDTO buscarCliente(String id_empresa);

	public List<EmpresaDTO> buscarEmpresas();

}
