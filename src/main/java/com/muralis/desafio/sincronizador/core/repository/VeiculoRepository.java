package com.muralis.desafio.sincronizador.core.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.muralis.desafio.sincronizador.core.domain.entity.Veiculo;

public interface VeiculoRepository extends CrudRepository<Veiculo, Integer>{
	
	public List<Veiculo> findByPlaca(String placa);
}
