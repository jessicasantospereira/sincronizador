package com.muralis.desafio.sincronizador.core.domain.entity;

import javax.persistence.Column;
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
@Table(name = "postos")
public class Posto extends EntidadeDominio{
	
	@Column(name="id_posto")
	private String estabelecimentoId;
	
	
}
