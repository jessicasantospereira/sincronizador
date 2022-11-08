package com.muralis.desafio.sincronizador.core.domain.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.muralis.desafio.sincronizador.core.domain.entity.Empresa;
import com.muralis.desafio.sincronizador.core.domain.entity.Posto;
import com.muralis.desafio.sincronizador.core.domain.entity.Produto;
import com.muralis.desafio.sincronizador.core.domain.entity.Transacao;
import com.muralis.desafio.sincronizador.core.domain.entity.Veiculo;
import com.muralis.desafio.sincronizador.core.repository.TransacaoRepository;
import com.opencsv.CSVReader;

public class TransacaoServiceImplTest {
	@Mock
	TransacaoRepository transacaoRepository;

	@InjectMocks
	TransacaoServiceImpl service;

	@BeforeEach
	public void before() {
		MockitoAnnotations.openMocks(this);
	}

	private static String[] produtos = { "Gasolina Aditivada", "Gasolina Comum", "Gasolina Premium", "Diesel",
			"Diesel S10", "Diesel S50", "Arla 32", "Etanol", "Etanol Aditivado", "GNV", "Não Informado" };

	private List<Produto> getProdutos() {
		List<Produto> lista_prod = new ArrayList<>();
		for (int i = 0; i < produtos.length; i++) {
			lista_prod.add(Produto.builder().descricao(produtos[i]).build());
		}
		return lista_prod;
	}

	private List<Empresa> getEmpresas() {
		List<Empresa> result = new ArrayList<>();
		result.add(Empresa.builder().clienteId("15").build());
		result.add(Empresa.builder().clienteId("25").build());
		result.add(Empresa.builder().clienteId("35").build());
		return result;
	}

	private List<Posto> getPostos() {
		List<Posto> result = new ArrayList<>();
		result.add(Posto.builder().estabelecimentoId("57233").build());
		result.add(Posto.builder().estabelecimentoId("64500").build());
		result.add(Posto.builder().estabelecimentoId("9653").build());
		result.add(Posto.builder().estabelecimentoId("54537").build());
		return result;
	}

	private List<Veiculo> getVeiculos() {
		List<Veiculo> result = new ArrayList<>();
		result.add(Veiculo.builder().placa("FHX8F42").build());
		result.add(Veiculo.builder().placa("QGS0559").build());
		result.add(Veiculo.builder().placa("QGV5113").build());
		return result;
	}

	private List<Transacao> getTransacoes() {
		List<Transacao> result = new ArrayList<>();
		List<Veiculo> veiculos = this.getVeiculos();
		List<Posto> postos = this.getPostos();
		List<Empresa> empresas = this.getEmpresas();
		List<Produto> produtos = this.getProdutos();

		result.add(Transacao.builder().descricao("Combustível").valor(281.32).valorCalculado(277.13).valorUnitario(7.49)
				.quantidade(37).posto(postos.get(0)).empresa(empresas.get(0)).produto(produtos.get(0))
				.veiculo(veiculos.get(0)).build());
		result.add(Transacao.builder().descricao("Aditivos e Lubrificantes").valor(46.76).valorCalculado(43.89)
				.valorUnitario(3.99).quantidade(11).posto(postos.get(1)).empresa(empresas.get(1))
				.produto(produtos.get(6)).veiculo(veiculos.get(1)).build());
		result.add(Transacao.builder().descricao("Combustível").valor(723.85).valorCalculado(716.68).valorUnitario(7.79)
				.quantidade(92).posto(postos.get(2)).empresa(empresas.get(2)).produto(produtos.get(4))
				.veiculo(veiculos.get(2)).build());

		return result;
	}

	@Test
	void buscarTransacoesCadastradas() {
		List<Transacao> transacoes = this.getTransacoes();

		when(transacaoRepository.findAll()).thenReturn(transacoes);

		List<Transacao> lista = service.buscarTodos();

		assertNotNull(lista);
		assertEquals(3, lista.size());
		assertNotNull(lista.get(0).getId());
		assertNotNull(lista.get(1).getId());
		assertNotNull(lista.get(2).getId());
		assertEquals("Combustível", lista.get(0).getDescricao());
		assertEquals("Aditivos e Lubrificantes", lista.get(1).getDescricao());
		assertEquals("QGV5113", lista.get(2).getVeiculo().getPlaca());
		assertEquals("Gasolina Aditivada", lista.get(0).getProduto().getDescricao());
		assertEquals("64500", lista.get(1).getPosto().getEstabelecimentoId());
		assertEquals("35", lista.get(2).getEmpresa().getClienteId());
		assertNotEquals(4, lista.size());
		assertNotEquals("QGV5113", lista.get(0).getVeiculo().getPlaca());
		assertNotEquals(32.15, lista.get(0).getValor());
	}

	@Test
	void buscarTransacaoPorPlacaEProduto() {
		List<Transacao> transacoes = this.getTransacoes();
		List<Transacao> transacoes2 = new ArrayList<>();
		transacoes2.add(transacoes.get(2));

		when(transacaoRepository.findByVeiculoPlacaAndProdutoDescricao("QGV5113", "Diesel S10"))
				.thenReturn(transacoes2);

		List<Transacao> lista = service.buscaFiltro("QGV5113", "Diesel S10");

		assertNotNull(lista);

		assertEquals(lista.get(0).getVeiculo().getPlaca(), transacoes.get(2).getVeiculo().getPlaca());
		assertEquals(lista.get(0).getProduto().getDescricao(), transacoes.get(2).getProduto().getDescricao());
		assertEquals(lista.get(0), transacoes.get(2));
		assertNotEquals(4, lista.size());
		assertNotEquals(lista.get(0).getVeiculo().getPlaca(), transacoes.get(0).getVeiculo().getPlaca());
		assertNotEquals(lista.get(0).getProduto().getDescricao(), transacoes.get(1).getProduto().getDescricao());

	}


}
