package com.muralis.desafio.sincronizador.core.domain.reader;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.muralis.desafio.sincronizador.core.domain.dto.TransacaoDTO;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class Arquivo implements LerArquivo {

	@Override
	public List<TransacaoDTO> ler(String path, String separador) {
		List<TransacaoDTO> itens = new ArrayList<>();
		log.info("[Desafio sincronizador - leitura de arquivo] - iniciando processo de leitura de arquivo as: {}", LocalDateTime.now());
		try (Scanner scanner = new Scanner(new File(path))) {
			String linha = scanner.nextLine();
			while (scanner.hasNextLine()) {
				TransacaoDTO transacao = new TransacaoDTO();
				linha = scanner.nextLine();
				
				String[] partes = linha.split(separador);
				transacao.setIdTabela(partes[0].replaceAll("[^a-zA-Z0-9]", ""));
				transacao.setValor(Double.parseDouble(partes[3]));
				transacao.setProduto(partes[13]);
				transacao.setDescricao(partes[16]);
				transacao.setQuantidade(Double.parseDouble(partes[18]));
				transacao.setValorUnitario(Double.parseDouble(partes[19]));
				transacao.setIdEmpresa(partes[20]);
				transacao.setIdPosto(partes[21]);
				transacao.setPlacaVeiculo(partes[24].replaceAll("[^a-zA-Z0-9]", ""));

				transacao.setValorCalculado(transacao.getValorUnitario() * transacao.getQuantidade());

				itens.add(transacao);
			}
			
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		log.info("[Desafio sincronizador - leitura de arquivo] - finalizando processo de leitura de arquivo as: {}", LocalDateTime.now());
		return itens;
	}
	

}
