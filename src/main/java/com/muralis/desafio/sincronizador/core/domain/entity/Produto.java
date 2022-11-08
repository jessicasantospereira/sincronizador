package com.muralis.desafio.sincronizador.core.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "produtos")
public class Produto extends EntidadeDominio{
	
//	private static String[] id_prod = {"1", "2", "3", "10", "11", "12", "20", "30", "31", "50", "100"};
//	@Transient
//	private static String[] produtos = { "Gasolina Aditivada", "Gasolina Comum", "Gasolina Premium", "Diesel", "Diesel S10",
//			"Diesel S50", "Arla 32", "Etanol", "Etanol Aditivado", "GNV", "Não Informado" };

	private String descricao;
	
	
}
