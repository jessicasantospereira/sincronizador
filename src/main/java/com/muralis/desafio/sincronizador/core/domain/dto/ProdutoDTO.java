package com.muralis.desafio.sincronizador.core.domain.dto;

public class ProdutoDTO {
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Produto: " + this.getDescricao();
	}
	
}
