package com.muralis.desafio.sincronizador.core.domain.dto;

public class VeiculoDTO {
	private String placa;

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	@Override
	public String toString() {
		return "Placa: " + this.getPlaca();
	}
	
}
