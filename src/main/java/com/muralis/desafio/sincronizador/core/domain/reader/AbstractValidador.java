package com.muralis.desafio.sincronizador.core.domain.reader;

public abstract class AbstractValidador {

	protected boolean ehNulo(String texto) {
		if (texto.isEmpty() || texto == null) {
			return true;
		}
		return false;
		

	}

	protected boolean maiorQueZero(double num) {
		if (num == 0 || num < 0) {
			return true;
		}
		return false;
	}

	protected boolean validaPlaca(String placa) {

		if (placa.length() != 7) {
			return true;
		}
		if (!placa.substring(0, 3).matches("[A-Z]*")) {
			return true;
		}

		String placaFinal = placa.substring(3);
		if (!placaFinal.substring(0, 1).matches("[0-9]*")) {
			return true;
		}
		if (!placaFinal.substring(1, 2).matches("[A-Z0-9]*")) {
			return true;
		}
		if (!placaFinal.substring(2).matches("[0-9]*")) {
			return true;
		}

		return false;

	}

}
