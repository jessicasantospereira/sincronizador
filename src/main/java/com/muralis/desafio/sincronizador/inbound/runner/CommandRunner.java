package com.muralis.desafio.sincronizador.inbound.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.muralis.desafio.sincronizador.inbound.controller.Controle;
@Component
public class CommandRunner implements CommandLineRunner{
	@Autowired
	private Controle controle;

	
	@Override
	public void run(String... args) throws Exception {

		controle.menu();

		
	}
	
}
