package com.muralis.desafio.sincronizador.inbound.controller;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.muralis.desafio.sincronizador.core.domain.dto.EmpresaDTO;
import com.muralis.desafio.sincronizador.core.domain.dto.PostoDTO;
import com.muralis.desafio.sincronizador.core.domain.dto.ProdutoDTO;
import com.muralis.desafio.sincronizador.core.domain.dto.VeiculoDTO;
import com.muralis.desafio.sincronizador.core.domain.reader.Sincronizacao;
import com.muralis.desafio.sincronizador.inbound.facade.IFacadeEmpresa;
import com.muralis.desafio.sincronizador.inbound.facade.IFacadePosto;
import com.muralis.desafio.sincronizador.inbound.facade.IFacadeProduto;
import com.muralis.desafio.sincronizador.inbound.facade.IFacadeTransacao;
import com.muralis.desafio.sincronizador.inbound.facade.IFacadeVeiculo;
@Component
public class Controle {

	
	static Scanner teclado = new Scanner(System.in);



	@Autowired
	private IFacadeTransacao facadeTransacao;
	@Autowired
	private IFacadeEmpresa facadeEmpresa;
	@Autowired
	private IFacadePosto facadePosto;
	@Autowired
	private IFacadeVeiculo facadeVeiculo;
	@Autowired
	private IFacadeProduto facadeProduto;

	public void menu() {
		int opcao = 0;

		System.out.println("\nSelecione uma opção no menu: ");
		System.out.println("1 - Sincronizar planilha");
		System.out.println("2 - Buscar posto (id)");
		System.out.println("3 - Buscar todos os postos");
		System.out.println("4 - Buscar empresa (id)");
		System.out.println("5 - Buscar todas as empresas");
		System.out.println("6 - Buscar veículo (placa)");
		System.out.println("7 - Buscar todos os veículos");
		System.out.println("8 - Buscar produtos (id)");
		System.out.println("9 - Buscar todos os produtos");
		System.out.println("10 - Sair");

		try {
			opcao = Integer.parseInt(Controle.teclado.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Por favor informe uma opção válida.");
			this.menu();
		}

		switch (opcao) {
		case 1:
			facadeTransacao.sincronizar();
			
			this.menu();
			break;
		case 2:
			System.out.println("Informe o ID do posto: ");
			String idPosto = Controle.teclado.nextLine();

			PostoDTO postoBusca = facadePosto.buscarEstabelecimento(idPosto);

			if (postoBusca == null) {
				System.out.println("ID não encontrado");
			} else {
				System.out.println(postoBusca);
			}
			this.menu();
			break;
		case 3:
			List<PostoDTO> listaPosto = facadePosto.buscarPostos();
			for (PostoDTO posto : listaPosto) {
				System.out.println(posto);
			}
			this.menu();
			break;
		case 4:
			System.out.println("Informe o ID da empresa: ");
			String id_empresa = Controle.teclado.nextLine();

			EmpresaDTO empresaBusca = facadeEmpresa.buscarCliente(id_empresa);

			if (empresaBusca == null) {
				System.out.println("ID não encontrado");
			} else {
				System.out.println(empresaBusca);
			}
			this.menu();
			break;
		case 5:

			List<EmpresaDTO> listaEmpresa = facadeEmpresa.buscarEmpresas();
			for (EmpresaDTO empresa : listaEmpresa) {
				System.out.println(empresa);
			}
			this.menu();
			break;
		case 6:
			System.out.println("Informe a placa do veículo: ");
			String placa = Controle.teclado.nextLine();

			VeiculoDTO veiculoBusca = facadeVeiculo.buscarPlaca(placa);
			if (veiculoBusca == null) {
				System.out.println("Veículo não encontrado");

			} else {
				System.out.println(veiculoBusca);
			}
			this.menu();
			break;
		case 7:

			List<VeiculoDTO> listaVeiculo = facadeVeiculo.buscarVeiculos();
			for (VeiculoDTO veiculo : listaVeiculo) {
				System.out.println(veiculo);
			}
			this.menu();
			break;
		case 8:
			System.out.println("Informe o ID do produto desejado: ");
			int idProd = Integer.parseInt(Controle.teclado.nextLine());

//			Optional<Produto> produtoBusca = produtoService.buscaPorId(id_prod);
			ProdutoDTO produtoBusca = facadeProduto.buscarProduto(idProd);
			if (produtoBusca == null) {
				System.out.println("Produto não encontrado");

			} else {
				System.out.println(produtoBusca);
			}
			this.menu();
			break;
		case 9:

			List<ProdutoDTO> listaProduto = facadeProduto.buscarProdutos();
			for (ProdutoDTO produto : listaProduto) {
				System.out.println(produto);
			}
			this.menu();
			break;
		case 10:
			System.out.println("Até a próxima!");

			System.exit(0);
		default:
			System.out.println("Opção inválida");

			this.menu();
			break;
		}
	}

}
