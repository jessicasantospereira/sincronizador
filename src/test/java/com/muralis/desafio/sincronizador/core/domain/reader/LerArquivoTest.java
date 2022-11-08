package com.muralis.desafio.sincronizador.core.domain.reader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;



public class LerArquivoTest {
	

	@Test
	void lerArquivoCsv() throws IOException{
		FileReader filereader = new FileReader("src/test/resources/csv/teste.csv");
		Scanner scanner = new Scanner(filereader);
		
		String linha = scanner.nextLine();
		while (scanner.hasNextLine()) {
			linha = scanner.nextLine();
			
			assertInstanceOf(String.class, linha);
			
			String[] partes = linha.split(";");
			
			assertNotNull(partes);
			assertNotNull(partes[2]);
			assertNotNull(partes[5]);

			assertEquals(9, partes.length);
		}

	}

}
