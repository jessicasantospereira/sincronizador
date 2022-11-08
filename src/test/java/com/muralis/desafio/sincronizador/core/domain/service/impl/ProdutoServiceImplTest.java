package com.muralis.desafio.sincronizador.core.domain.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.muralis.desafio.sincronizador.core.domain.entity.Produto;
import com.muralis.desafio.sincronizador.core.domain.service.impl.ProdutoServiceImpl;
import com.muralis.desafio.sincronizador.core.repository.ProdutoRepository;

public class ProdutoServiceImplTest {
	@Mock
	ProdutoRepository produtoRepository;

	@InjectMocks
	ProdutoServiceImpl service;

	@BeforeEach
	public void before() {
		MockitoAnnotations.openMocks(this);
	}
	private static String[] produtos = { "Gasolina Aditivada", "Gasolina Comum", "Gasolina Premium", "Diesel", "Diesel S10",
	"Diesel S50", "Arla 32", "Etanol", "Etanol Aditivado", "GNV", "Não Informado" };
	
	private List<Produto>getProdutos(){
		List<Produto> lista_prod = new ArrayList<>();
		for (int i = 0; i < produtos.length; i++) {
			lista_prod.add(Produto.builder().descricao(produtos[i]).build());
		}
		return lista_prod;
	}
	@Test
	void buscarTodosOsProdutos() {
		List<Produto> produtos = this.getProdutos();
		
		when(produtoRepository.findAll()).thenReturn(produtos);

		List<Produto> lista = service.buscarTodos();
		
		assertNotNull(lista);
		assertEquals(11, lista.size());
		assertNotNull(lista.get(5).getId());
		assertNotNull(lista.get(8).getId());
		assertNotNull(lista.get(10).getId());
		assertEquals("Gasolina Aditivada", lista.get(0).getDescricao());
		assertEquals("Diesel", lista.get(3).getDescricao());
		assertEquals("Arla 32", lista.get(6).getDescricao());
		assertNotEquals("GNV", lista.get(2).getDescricao());
	}
	
	@Test
	void buscarPorDescricaoDoProduto() {
		List<Produto> produtos = this.getProdutos();
		List<Produto> busca = new ArrayList<>();
		busca.add(produtos.get(8));

		when(produtoRepository.findByDescricao(any(String.class))).thenReturn(busca);
		
		Produto produto = service.buscarPorDescricao("Etanol Aditivado");
		
		assertNotNull(produto);
		assertEquals(produto.getDescricao(), produtos.get(8).getDescricao());
		assertNotEquals(produto, produtos.get(0));
	}
	
}
