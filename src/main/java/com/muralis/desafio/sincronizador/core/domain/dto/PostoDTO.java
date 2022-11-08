package com.muralis.desafio.sincronizador.core.domain.dto;

public class PostoDTO {
	private String idPosto;

	public String getIdPosto() {
		return idPosto;
	}

	public void setIdPosto(String idPosto) {
		this.idPosto = idPosto;
	}
	
	@Override
	public String toString() {
		return "Estabelecimento id: " + this.getIdPosto();
	}
}
