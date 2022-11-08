package com.muralis.desafio.sincronizador.core.domain.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.muralis.desafio.sincronizador.core.domain.entity.Empresa;
import com.muralis.desafio.sincronizador.core.domain.service.IEmpresaService;
import com.muralis.desafio.sincronizador.core.repository.EmpresaRepository;

@Component
public class EmpresaServiceImpl implements IEmpresaService<Empresa>{
	@Autowired
	private EmpresaRepository empresaRepository;
	private Map<String, Empresa> empresa = new HashMap<>();

	public void salvar(Empresa empresa) {
		empresaRepository.save(empresa);
	}

	public Empresa buscarPorIdCliente(String id) {
		List<Empresa> lista = empresaRepository.findByClienteId(id);
		
		if(lista.size() >= 1) {
			return lista.get(0);
		}
		return null;
	}
	@Override
	public Optional<Empresa> buscaPorId(int id) {
		return empresaRepository.findById(id);
	}

	@Override
	public List<Empresa> buscarTodos() {
		return (List<Empresa>) empresaRepository.findAll();

	}



	
}
