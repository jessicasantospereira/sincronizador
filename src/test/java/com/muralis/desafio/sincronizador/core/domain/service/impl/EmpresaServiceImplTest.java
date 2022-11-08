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

import com.muralis.desafio.sincronizador.core.domain.entity.Empresa;
import com.muralis.desafio.sincronizador.core.domain.service.impl.EmpresaServiceImpl;
import com.muralis.desafio.sincronizador.core.repository.EmpresaRepository;

public class EmpresaServiceImplTest {
	@Mock
	EmpresaRepository empresaRepository;
	
	@InjectMocks
	EmpresaServiceImpl service;
	
    @BeforeEach
    public void before() {
        MockitoAnnotations.openMocks(this);
    }
    
    private List<Empresa> getEmpresas() {
    	List<Empresa> result = new ArrayList<>();
    	result.add(Empresa.builder().clienteId("15").build());
    	result.add(Empresa.builder().clienteId("25").build());
    	result.add(Empresa.builder().clienteId("35").build());
    	return result;
    }
    @Test
    void buscarTodasAsEmpresas() {
    	List<Empresa> empresas = this.getEmpresas();
    
    	when(empresaRepository.findAll()).thenReturn(empresas);
    	
    	List<Empresa> lista = service.buscarTodos();
    	
    	assertNotNull(lista);
    	assertEquals(3, lista.size());
    	assertNotNull(lista.get(0).getId());
        assertNotNull(lista.get(1).getId());
        assertNotNull(lista.get(2).getId());
        assertEquals("15", lista.get(0).getClienteId());
        assertEquals("25", lista.get(1).getClienteId());
        assertEquals("35", lista.get(2).getClienteId());
        assertNotEquals(4, lista.size());

    	
    }
    @Test
    void buscarPorIdClienteCadastrado() {
    	List<Empresa> empresas = this.getEmpresas();
    	
    	when(empresaRepository.findByClienteId("15")).thenReturn((empresas));
    	
    	Empresa empresa = service.buscarPorIdCliente("15");
    	
    	assertNotNull(empresa);
    	assertEquals("15", empresas.get(0).getClienteId());
    	assertNotEquals("30", empresas.get(1).getClienteId());
    }
}
