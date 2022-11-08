package com.muralis.desafio.sincronizador.core.domain.reader;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.muralis.desafio.sincronizador.core.domain.dto.TransacaoDTO;
import com.muralis.desafio.sincronizador.core.domain.entity.Empresa;
import com.muralis.desafio.sincronizador.core.domain.entity.Posto;
import com.muralis.desafio.sincronizador.core.domain.entity.Produto;
import com.muralis.desafio.sincronizador.core.domain.entity.Transacao;
import com.muralis.desafio.sincronizador.core.domain.entity.Veiculo;
import com.muralis.desafio.sincronizador.core.domain.service.impl.EmpresaServiceImpl;
import com.muralis.desafio.sincronizador.core.domain.service.impl.PostoServiceImpl;
import com.muralis.desafio.sincronizador.core.domain.service.impl.ProdutoServiceImpl;
import com.muralis.desafio.sincronizador.core.domain.service.impl.TransacaoServiceImpl;
import com.muralis.desafio.sincronizador.core.domain.service.impl.VeiculoServiceImpl;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Component
public class Sincronizacao {
	@Autowired
	TransacaoServiceImpl transacaoService;
	@Autowired
	PostoServiceImpl postoService;
	@Autowired
	EmpresaServiceImpl empresaService;
	@Autowired
	VeiculoServiceImpl veiculoService;
	@Autowired
	ProdutoServiceImpl produtoService;
	
	ValidaListaTransacao valLista = new ValidaListaTransacao();

	public void sincronizarTransacoes() {
		long inicio = System.currentTimeMillis();
		int qtdeItensTotal = 0;
		int qtdeItensComErro = 0;
		int qtdeItensComSucesso = 0;
		Arquivo arquivo = new Arquivo();

		try {

			List<TransacaoDTO> lista = arquivo.ler("arquivo/transacoes2.csv", ",");
			log.info("[Desafio sincronizador - sincronizando transações] - inicio da sincronização as {}", LocalDateTime.now());
			List<Transacao> lista_transacao = new ArrayList<>();

			for (TransacaoDTO itens : lista) {
				log.info("[Desafio sincronizador - sincronizando transações] - linha {} as {}",qtdeItensTotal ,LocalDateTime.now());
				
				
				StringBuilder sb = new StringBuilder();
				String msg = valLista.validarItens(itens);
				if (msg != null) {
					sb.append(msg);
				}
				
				if (sb.length() == 0) {
					String descricao = itens.getDescricao();
					String placa = itens.getPlacaVeiculo();
					String idCliente = itens.getIdEmpresa();
					String idPosto = itens.getIdPosto();
					double valor = itens.getValor();
					double valorCal = itens.getValorCalculado();
					double valorUni = itens.getValorUnitario();
					double qtde = itens.getQuantidade();
					String prod = itens.getProduto();
					
					
					Posto posto = postoService.buscarPorIdPosto(idPosto);
					Empresa empresa = empresaService.buscarPorIdCliente(idCliente);
					Veiculo veiculo = veiculoService.buscarPorPlaca(placa);
					Produto produto = produtoService.buscarPorDescricao(prod);
					
					if(posto == null) {
						posto = new Posto(idPosto);
						postoService.salvar(posto);
					}
					if(empresa == null) {
						empresa = new Empresa(idCliente);
						empresaService.salvar(empresa);
					}
					if(veiculo == null) {
						veiculo = new Veiculo(placa);
						veiculoService.salvar(veiculo);
					}
					if(produto == null) {
						produto = new Produto(prod);
						produtoService.salvar(produto);
					}
					
					lista_transacao.add(new Transacao(valor, valorCal, valorUni, qtde, descricao, posto, produto,empresa, veiculo));
					
					qtdeItensComSucesso++;
				} else {
					log.info("[Desafio sincronizador - sincronizando transações] - Linha: {} ,Id tabela: {} ,não pode ser sincronizada",qtdeItensTotal, itens.getIdTabela());
					log.info(sb.toString());

					qtdeItensComErro++;
				}
				qtdeItensTotal++;
			}

			transacaoService.salvarLista(lista_transacao);
			log.info("[Desafio sincronizador - sincronizando transações] - final da sincronização as {}", LocalDateTime.now());
		} catch (Exception e) {
			System.out.println("Erro ao sincronizar: " + e.getMessage());
			e.printStackTrace();
		}
		long fim = System.currentTimeMillis();

		long tempoDeExecucao = fim - inicio;
		log.info("[Desafio sincronizador] - Tempo de execução: {}", tempoDeExecucao);
		log.info("[Desafio sincronizador] - Quantidade de itens processados: {}", qtdeItensTotal);
		log.info("[Desafio sincronizador] - Quantidade de itens processados com sucesso: {}", qtdeItensComSucesso);
		log.info("[Desafio sincronizador] - Quantidade de itens processados com erros: {}", qtdeItensComErro);

	}

}
