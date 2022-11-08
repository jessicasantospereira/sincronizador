package com.muralis.desafio.sincronizador.core.domain.dto;

public class EmpresaDTO {
	private String clienteId;

	
	public String getClienteId() {
		return clienteId;
	}

	public void setClienteId(String clienteId) {
		this.clienteId = clienteId;
	}
	
	@Override
	public String toString() {
		
		return "Cliente id: " + this.getClienteId();
	}
	
}
