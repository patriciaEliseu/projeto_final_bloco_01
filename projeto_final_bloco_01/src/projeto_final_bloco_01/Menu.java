package projeto_final_bloco_01;

import java.util.InputMismatchException;
import java.util.Scanner;

import projeto_final_bloco_01.util.Cores;

public class Menu {
	
		private static final Scanner leia = new Scanner(System.in);

		

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

					

					keyPress();
					break;
				case 2:
					System.out.println(Cores.TEXT_BLACK + "Listar todos os Produtos\n\n");

					

					keyPress();
					break;
				case 3:
					System.out.println(Cores.TEXT_BLACK + "Consultar dados dos Produtos - por ID\n\n");

					

					keyPress();
					break;
				case 4:
					System.out.println(Cores.TEXT_BLACK + "Atualizar dados do Produto\n\n");

					

					keyPress();
					break;
				case 5:
					System.out.println(Cores.TEXT_BLACK + "Apagar o Produto\n\n");

					

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

}
