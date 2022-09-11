package aplicativos;

import java.io.IOException;
import java.util.Scanner;

public class AppPilotos {
    public static void main(String[] args) throws InterruptedException, IOException {
        int MAX_ELEMENTOS = 20;
        int opcao, qtdCadastrados = 0;
        Pessoa[] pilotos = new Pessoa[MAX_ELEMENTOS];
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - Cadastrar piloto");
            System.out.println("2 - Listar pilotos cadastrados");
            System.out.println("3 - Localizar piloto pelo CPF");
            System.out.println("4 - Aumentar espaço de armazenamento");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = in.nextInt();
            in.nextLine(); // Tira o ENTER que ficou na entrada na instrução anterior

            if (opcao == 1) {
                // Se não tem mais espaço no vetor, caio fora
                if (qtdCadastrados == MAX_ELEMENTOS) {
                    System.out.println("\nNão há espaço para cadastrar novos pilotos.");
                    voltarMenu(in);
                    continue;
                }

                System.out.print("Nome: ");
                final String nome = in.next();
                System.out.print("CPF: ");
                String CPF = in.next();

                Pessoa piloto = new Pessoa(nome, CPF);
                pilotos[qtdCadastrados] = piloto;                    
                qtdCadastrados++;
                voltarMenu(in) ;

                System.out.println("\nPiloto cadastrado com sucesso.");
                voltarMenu(in);
                
            } else if (opcao == 2) {
                // Se não tem ninguém cadastrado no vetor, caio fora

                    for(int i = 0; i < qtdCadastrados; i++){
                        
                    System.out.println("Nome: " + pilotos[i].getnome());
                    System.out.println("Cpf:" + pilotos[i].getcpf());
                
                    }
                if (qtdCadastrados == 0) {
                    System.out.println("\nNão há motoristas cadastrados para exibir.");
                    voltarMenu(in);
                    continue;
                }

                // Exiba os pilotos aqui

                voltarMenu(in);
            } else if (opcao == 3) {

                System.out.print("Digite o CPF que você deseja procurar: ");
                String buscaCpf = in.nextLine();

                for (int i = 0; i < qtdCadastrados; i++) {

                  if (pilotos[i].getcpf().equals(buscaCpf)) {
                    System.out.print("O Piloto que você desejou é: ");
                    System.out.print(pilotos[i].getnome());

                  }
                  }
            } else if (opcao == 4) {
    
                System.out.printf("Coloque a quantidade máxima que você deseja adicionar (o atual é: " + MAX_ELEMENTOS + ":) ");
                        int novoTamanho = in.nextInt();
                        in.nextLine();

                        if (novoTamanho <= MAX_ELEMENTOS){
                                System.out.println("O novo tamanho que você deseja precisa ser maior do que o tamanho atual, Por favor insira um valor maior.");
                                voltarMenu(in);
                        
                                continue;
                            }   
            
                               Pessoa[] novoVetor = new Pessoa[novoTamanho];
                                for (int i = 0; i < qtdCadastrados; i++) {
                                    novoVetor[i] = pilotos[i];

                                }

                                    pilotos = novoVetor;
                                    MAX_ELEMENTOS = novoTamanho;
                    }   
            else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Fim do programa!");

        in.close();
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
        
        System.out.flush();
    }
}