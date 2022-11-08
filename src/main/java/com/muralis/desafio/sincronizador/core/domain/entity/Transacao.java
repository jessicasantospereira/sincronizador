package com.muralis.desafio.sincronizador.core.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "transacoes")
public class Transacao extends EntidadeDominio{
	
	private double valor;
	
	@Column(name="valor_calculado")
	private double valorCalculado;
	@Column(name="valor_unitario")
	private double valorUnitario;
	private double quantidade;
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="fk_id_posto")
	private Posto posto;
	
	@ManyToOne
	@JoinColumn(name="fk_id_produto")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name="fk_id_empresa")
	private Empresa empresa;
	
	@ManyToOne
	@JoinColumn(name="fk_id_veiculo")
	private Veiculo veiculo;


	

}
