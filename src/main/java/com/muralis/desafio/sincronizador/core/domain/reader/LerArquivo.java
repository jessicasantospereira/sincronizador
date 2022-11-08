package com.muralis.desafio.sincronizador.core.domain.reader;

import java.util.List;

import com.muralis.desafio.sincronizador.core.domain.dto.TransacaoDTO;

public interface LerArquivo {
	
	public List<TransacaoDTO> ler(String path, String separador);
}
