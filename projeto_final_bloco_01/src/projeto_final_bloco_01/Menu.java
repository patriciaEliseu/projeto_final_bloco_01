package projeto_final_bloco_01;

import java.util.InputMismatchException;
import java.util.Scanner;

import projeto_final_bloco_01.controller.ProdutoController;
import projeto_final_bloco_01.model.Bijuteria;
import projeto_final_bloco_01.model.Decoracao;
import projeto_final_bloco_01.model.Produtos;
import projeto_final_bloco_01.util.Cores;

public class Menu {
	
		private static final Scanner leia = new Scanner(System.in);

		private static final ProdutoController produtoController = new ProdutoController();

		public static void main(String[] args) {

			int opcao;

			

		while (true) {

				System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
						+ "*****************************************************");
				System.out.println("                                                     ");
				System.out.println("                Lidia Artesanatos                    ");
				System.out.println("                                                     ");
				System.out.println("*****************************************************");
				System.out.println("                                                     ");
				System.out.println("            1 - Criar Produto                        ");
				System.out.println("            2 - Listar todos os Produtos             ");
				System.out.println("            3 - Buscar Produto por ID                ");
				System.out.println("            4 - Atualizar Dados do Produto           ");
				System.out.println("            5 - Apagar Produto                       ");
				System.out.println("            0 - Sair                                 ");
				System.out.println("                                                     ");
				System.out.println("*****************************************************");
				System.out.println("Entre com a opção desejada:                          ");
				System.out.println("                                                     " + Cores.TEXT_RESET);

				
				try {
					opcao = leia.nextInt();
					leia.nextLine();
				} catch (InputMismatchException e) {
					opcao = -1;
					System.out.println("\nDigite um número inteiro entre 0 e 5");
					leia.nextLine();
				}

				// Se a opção for 0, o sistema será finalizado (System.exit(0))
				if (opcao == 0) {
					System.out.println(Cores.TEXT_BLACK_BOLD + "\nLidia Artesanatos - Seus Artesanatos ficaram mais bonitos!");
					sobre();
					leia.close();
					System.exit(0);
				}

				
				switch (opcao) {
				case 1:
					System.out.println(Cores.TEXT_BLACK + "Criar Produto\n\n");

					cadastrarProduto();

					keyPress();
					break;
				case 2:
					System.out.println(Cores.TEXT_BLACK + "Listar todos os Produtos\n\n");

					listarProdutos();

					keyPress();
					break;
				case 3:
					System.out.println(Cores.TEXT_BLACK + "Consultar dados dos Produtos - por ID\n\n");

					procurarProdutoPorId();
					
					keyPress();
					break;
				case 4:
					System.out.println(Cores.TEXT_BLACK + "Atualizar dados do Produto\n\n");

					atualizarProduto();

					keyPress();
					break;
				case 5:
					System.out.println(Cores.TEXT_BLACK + "Apagar o Produto\n\n");

					deletarProduto();

					keyPress();
					break;
				default:
					System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
					keyPress();
					break;
				}
			}
		}

		// Exibe informações sobre o projeto e a pessoa desenvolvedora
		public static void sobre() {
			System.out.println("\n*********************************************************");
			System.out.println("Projeto Desenvolvido por: Patrícia Gonçalves Eliseu");
			System.out.println("Generation Brasil - generation@generation.org");
			System.out.println("github.com/patriciaEliseu");
			System.out.println("***********************************************************");
		}

		// Método responsável por aguardar o usuário pressionar a tecla Enter para
		// continuar
		public static void keyPress() {
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para continuar...");
			leia.nextLine();
		}
		
		private static void listarProdutos() {
			produtoController.listarTodos();
		}
		
		private static void cadastrarProduto() {
			System.out.print("Digite a descrição do produto: ");
			leia.skip("\\R");
			String descricao = leia.nextLine();
			
			System.out.print("Digite o tipo do produto( 1 - Deco | 2 - Biju): ");
			int tipo = leia.nextInt();
			
			System.out.print("Digite o Artesao do produto: ");
			String artesao = leia.nextLine();
			
			System.out.print("Digite o preco do produto: ");
			float preco = leia.nextFloat();
			
			switch (tipo) {
			case 1 -> {
				
				produtoController
						.cadastrar(new Decoracao (produtoController.gerarId(),  tipo, descricao,artesao, preco));
			}
			case 2 -> {
				System.out.print("Digite o genero do material:  ");
				String genero = leia.nextLine();
				leia.nextLine();
				produtoController.cadastrar(
						new Bijuteria(produtoController.gerarId(), tipo, descricao, artesao, preco,  genero ));
			}
			default -> System.out.println(Cores.TEXT_RED + "Tipo de Produto inválido!" + Cores.TEXT_RESET);
			}
		}
			
		private static void procurarProdutoPorId() {
			
			System.out.print("Digite o Id do produto: ");
			int id = leia.nextInt();
			leia.nextLine();

			produtoController.procurarPorId(id);
			
		}
		
		
		private static void deletarProduto() {

			System.out.print("Digite o id do produto: ");
			int numero = leia.nextInt();
			leia.nextLine();

			Produtos produto = produtoController.buscarNaCollection(numero);

			
			if (produto != null) {

				
				System.out.print("\nTem certeza que deseja excluir este produto? (S/N): ");
				String confirmacao = leia.nextLine();

				if (confirmacao.equalsIgnoreCase("S")) {
					produtoController.deletar(numero);
				} else {
					System.out.println("\nOperação cancelada!");
				}

			} else {
				System.out.printf("\nO produto id %d não foi encontrado!", numero);
			}
		}

		private static void atualizarProduto() {

			System.out.print("Digite o id do produto: ");
			int numero = leia.nextInt();
			leia.nextLine();

			
			Produtos produto = produtoController.buscarNaCollection(numero);

			
			if (produto != null) {

			
				int tipo = produto.getTipo(); 
				String descricao = produto.getDescricao();
				String artesao = produto.getArtesao();
				float preco = produto.getPreco();
				

				
				System.out.printf(
						"tipo de produto: %d\nDigite o novo tipo do produto. (Pressione ENTER para manter o valor atual): ",
						tipo);
				int entrada = leia.nextInt();

				
				tipo = entrada.isEmpty() ? tipo : entrada;

				
				System.out.printf(
						"Descrição atuall: %s\nDigite a nova descriçao do produto. (Pressione ENTER para manter o valor atual): ",
						descricao);
				entrada = leia.nextLine();
				descricao = entrada.isEmpty() ? descricao : entrada;

				
				

				// Se a conta for do tipo Conta Corrente
				switch (tipo) {
				case 1 -> {

				
					
					produtoController.atualizar(new Decoracao(numero, tipo, descricao,artesao, preco));

				}
				
				case 2 -> {

					String genero = ((Bijuteria) produto).getGenero();

					
					System.out.printf(
							"Genero atual é: %s\nDigite o novo Gẽnero. (Pressione ENTER para manter o valor atual): ",
							genero);
					entrada = leia.nextLine();
					genero = entrada.isEmpty() ? genero : entrada;
					produtoController.atualizar(new Bijuteria(numero, tipo, descricao, artesao, preco,  genero));
				}
				
				default -> System.out.println(Cores.TEXT_RED + "Tipo de Biju inválido!" + Cores.TEXT_RESET);
				}

			} else {
				// Caso a conta não exista
				System.out.printf("\nO produto de id %d não foi encontrado!", numero);
			}

		}

		
			


}
