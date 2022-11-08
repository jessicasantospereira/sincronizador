package com.muralis.desafio.sincronizador.core.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransacaoDTO {

	private Double valor;
	private Double valorCalculado;
	private Double valorUnitario;
	private Double quantidade;
	private String descricao;
	private String idPosto;
	private String produto;
	private String idEmpresa;
	private String placaVeiculo;
	private String idTabela;

	

}
