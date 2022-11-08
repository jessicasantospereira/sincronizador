package com.muralis.desafio.sincronizador.core.domain.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.muralis.desafio.sincronizador.core.domain.entity.Posto;
import com.muralis.desafio.sincronizador.core.domain.service.impl.PostoServiceImpl;
import com.muralis.desafio.sincronizador.core.repository.PostoRepository;

public class PostoServiceImplTest {
	@Mock
	PostoRepository postoRepository;

	@InjectMocks
	PostoServiceImpl service;

	@BeforeEach
	public void before() {
		MockitoAnnotations.openMocks(this);
	}

	private List<Posto> getPostos() {
		List<Posto> result = new ArrayList<>();
		result.add(Posto.builder().estabelecimentoId("57233").build());
		result.add(Posto.builder().estabelecimentoId("64500").build());
		result.add(Posto.builder().estabelecimentoId("9653").build());
		result.add(Posto.builder().estabelecimentoId("54537").build());
		return result;
	}

	@Test
	void buscarTodosOsPostos() {
		List<Posto> postos = this.getPostos();

		when(postoRepository.findAll()).thenReturn(postos);

		List<Posto> lista = service.buscarTodos();

		assertNotNull(lista);
		assertEquals(4, lista.size());
		assertNotNull(lista.get(0).getId());
		assertNotNull(lista.get(1).getId());
		assertNotNull(lista.get(2).getId());
		assertNotNull(lista.get(3).getId());
		assertEquals("57233", lista.get(0).getEstabelecimentoId());
		assertEquals("64500", lista.get(1).getEstabelecimentoId());
		assertEquals("9653", lista.get(2).getEstabelecimentoId());
		assertNotEquals("9653", lista.get(3).getEstabelecimentoId());
	}

	@Test
	void buscarPostoPorIdCadastrado() {
		List<Posto> postos = this.getPostos();
		List<Posto> p = new ArrayList<>();
		p.add(postos.get(2));
		
		when(postoRepository.findByEstabelecimentoId("9653")).thenReturn((p));


		Posto posto = service.buscarPorIdPosto("9653");

		assertNotNull(posto);
		assertEquals(posto.getEstabelecimentoId(), postos.get(2).getEstabelecimentoId());
		assertNotEquals("30", posto.getEstabelecimentoId());


		
	}
}
