package controllers;

import java.util.List;
import java.util.Scanner;

import entities.Cliente;
import repositories.ClienteRepository;

public class ClienteController {

	// método para realizar um fluxo de cadastro de clientes
	public void cadastrarCliente() {

		System.out.println("\n*** CADASTRO DE CLIENTES ***\n");
		Scanner scanner = new Scanner(System.in);

		try {

			Cliente cliente = new Cliente();

			System.out.print("INFORME O NOME.........: ");
			cliente.setNome(scanner.nextLine());

			System.out.print("INFORME O EMAIL........: ");
			cliente.setEmail(scanner.nextLine());

			System.out.print("INFORME O TELEFONE.....: ");
			cliente.setTelefone(scanner.nextLine());

			System.out.print("INFORME O CPF..........: ");
			cliente.setCpf(scanner.nextLine());

			ClienteRepository clienteRepository = new ClienteRepository();
			clienteRepository.create(cliente);

			System.out.println("\nCliente cadastrado com sucesso!");
		} catch (Exception e) {
			System.out.println("\nFalha ao cadastrar cliente: " + e.getMessage());
		} finally {
			scanner.close();
		}
	}

	// método para realizar um fluxo de edição de clientes
	public void atualizarCliente() {

		System.out.println("\n*** ATUALIZAÇÃO DE CLIENTES ***\n");
		Scanner scanner = new Scanner(System.in);

		try {

			System.out.print("INFORME O ID DO CLIENTE: ");
			Integer idCliente = Integer.parseInt(scanner.nextLine());

			// consultando o cliente no banco de dados através do id..
			ClienteRepository clienteRepository = new ClienteRepository();
			Cliente cliente = clienteRepository.findById(idCliente);

			// verificando se o cliente foi encontrado
			if (cliente != null) {
				System.out.print("ALTERE NOME DO CLIENTE: ");
				cliente.setNome(scanner.nextLine());

				System.out.print("ALTERE O EMAIL DO CLIENTE: ");
				cliente.setEmail(scanner.nextLine());

				System.out.print("ALTERE O CPF DO CLIENTE: ");
				cliente.setCpf(scanner.nextLine());

				System.out.print("ALTERE O TELEFONE DO CLIENTE: ");
				cliente.setTelefone(scanner.nextLine());
			} else {
				System.out.println("\nCliente não encontrado.");
			}
		} catch (Exception e) {
			System.out.println("\nFalha ao atualizar cliente: " + e.getMessage());
		} finally {
			scanner.close();
		}
	}

	// método para realizar um fluxo de exclusão de clientes
	public void excluirCliente() {

		System.out.println("\n*** Exclusão de clientes***\n");
		Scanner scanner = new Scanner(System.in);

		try {
			Integer idInteger = Integer.parseInt(scanner.nextLine());

			// buscando i cliente no banco de dados através do id
			ClienteRepository clienteRepository = new ClienteRepository();
			Cliente cliente = clienteRepository.findById(idInteger);

			// verificando se o cliente foi encerrado
			if (cliente != null) {

				// excluindo o cliente
				clienteRepository.delete(cliente);

				System.out.println("\nCliente excluído com sucesso!");

			} else {

				System.out.println("\nCliente não encontrado!");

			}
		} catch (Exception e) {
			System.out.println("\nFalha ao excluir cliente: " + e.getMessage());
		} finally {
			scanner.close();
		}
	}

	// métodos para realizar um fluxo de consulta de clientes
	public void consultarClientes() {

		System.out.println("\n*** Consulta de clientes ***\n");

		try {
			ClienteRepository clienteRepository = new ClienteRepository();
			List<Cliente> lista = clienteRepository.findAll();

			for (Cliente cliente : lista) {

				System.out.println("ID do cliente: " + cliente.getIdCliente());
				System.out.println("Nome do cliente: " + cliente.getNome());
				System.out.println("CPF do cliente: " + cliente.getCpf());
				System.out.println("Email do cliente: " + cliente.getEmail());
				System.out.println("Telefone do cliente: " + cliente.getTelefone());

			}

		} catch (Exception e) {

		}
	}

}
