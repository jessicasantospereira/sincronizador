package com.muralis.desafio.sincronizador.core.domain.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.muralis.desafio.sincronizador.core.domain.entity.Veiculo;
import com.muralis.desafio.sincronizador.core.domain.service.impl.VeiculoServiceImpl;
import com.muralis.desafio.sincronizador.core.repository.VeiculoRepository;

public class VeiculoServiceImplTest {
	@Mock
	VeiculoRepository veiculoRepository;

	@InjectMocks
	VeiculoServiceImpl service;

	@BeforeEach
	public void before() {
		MockitoAnnotations.openMocks(this);
	}

	private List<Veiculo> getVeiculos() {
		List<Veiculo> result = new ArrayList<>();
		result.add(Veiculo.builder().placa("FHX8F42").build());
		result.add(Veiculo.builder().placa("QGS0559").build());
		result.add(Veiculo.builder().placa("QGV5113").build());
		return result;
	}

	@Test
	void buscarVeiculosCadastrados() {
		List<Veiculo> veiculos = this.getVeiculos();

		when(veiculoRepository.findAll()).thenReturn(veiculos);

		List<Veiculo> lista = service.buscarTodos();

		assertNotNull(lista);
		assertEquals(3, lista.size());
		assertNotNull(lista.get(0).getId());
		assertNotNull(lista.get(1).getId());
		assertNotNull(lista.get(2).getId());
		assertEquals("FHX8F42", lista.get(0).getPlaca());
		assertEquals("QGS0559", lista.get(1).getPlaca());
		assertEquals("QGV5113", lista.get(2).getPlaca());
		assertNotEquals(4, lista.size());
		assertNotEquals("QGV5113", lista.get(0).getPlaca());
	}

	@Test
	void buscarVeiculoPorPlaca() {
		List<Veiculo> veiculos = this.getVeiculos();

		when(veiculoRepository.findByPlaca("FHX8F42")).thenReturn(veiculos);
		
		Veiculo veiculo = service.buscarPorPlaca("FHX8F42");
		Veiculo veiculo2 = service.buscarPorPlaca("IYP4440");
		
		
		assertNotNull(veiculo);
		assertNull(veiculo2);
		
		assertEquals(veiculo.getPlaca(), veiculos.get(0).getPlaca());
		assertNotEquals(veiculo, veiculos.get(1));
		assertNotEquals("IYP4440", veiculos.get(2).getPlaca());
	}
}
