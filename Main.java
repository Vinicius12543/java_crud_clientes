package principal;

import java.util.Scanner;

import controllers.ClienteController;

public class Main {

	public static void main(String[] args) {

		ClienteController clienteController = new ClienteController();
		Scanner scanner = new Scanner(System.in);

		try {
			System.out.println("(1) Cadastrar cliente");
			System.out.println("(2) Atualizar cliente");
			System.out.println("(3) Excluir cliente");
			System.out.println("(4) Consultar todos os clientes");

			System.out.println("\n Informe a opção desejada: ");
			Integer opcao = Integer.parseInt(scanner.nextLine());

			switch (opcao) {
			case 1:
				clienteController.cadastrarCliente();
				break;
			case 2:
				clienteController.atualizarCliente();
				break;
			case 3:
				clienteController.excluirCliente();
				break;
			case 4:
				clienteController.consultarClientes();
			default:
				System.out.println("\nOpcão inválida");
			}

		} catch (Exception e) {

		}
	}

}
