package AtividadeMain;

import java.util.HashSet;
import java.util.Scanner;

public class AtividadeMain {

    public static void main(String[] args) {

        char iniciar = 'S';
        char escolha = 'S';
        int opcao;
        String cor = "";
        HashSet<String> cores = new HashSet<>();
        Scanner ler = new Scanner(System.in);

        while (iniciar == 'S') {

            System.out.println("\nEscolha uma opção:\n1-Adicionar Cor\n2-Listar Cores\n3-Apagar todas as cores\n4-Buscar cor\n5-Remover cor da lista\n6-Sair\nOpção:");
            opcao = ler.nextInt();

            switch (opcao) {
                case 1:
                    adicionarCor(cores, ler, escolha);
                    break;
                case 2:
                    listarCores(cores);
                    break;
                case 3:
                    limparlista(cores, escolha, ler, iniciar);
                    break;
                case 4:
                    buscarCor(cores, cor, ler, escolha);
                    break;
                case 5:
                    removerCor(cores, cor, ler, escolha);
                    break;
                case 6:
                    System.out.println("\nFinalizando......");
                    iniciar = 'X';
                    break;
                default:
                    System.out.println("\nOpção Invalida!");
                    break;
            }
        }
    }

    public static void adicionarCor(HashSet cores, Scanner ler,  char escolha) {
        limparBuffer(ler);

        if (cores.size() >= 0 && cores.size() <= 1) {
            while (escolha == 'S' || escolha == 's') {

                System.out.println("\nInforme a cor: ");
                String cor = ler.nextLine();
                cores.add(cor);

                if (cores.size() >= 0 && cores.size() <= 1) {
                    System.out.println("\nDeseja adicionar uma nova cor? S/N");
                    escolha = ler.nextLine().charAt(0);
                } else {
                    System.out.println("Lista cheia!");
                    escolha = 'n';
                }
            }
        } else
            System.out.println("Lista cheia!");
    }

    public static Scanner limparBuffer(Scanner ler) {
        ler.nextLine();
        return ler;
    }

    public static void listarCores(HashSet cores) {
        System.out.println("\n-----Suas cores-----");
        for (Object C : cores) {
            System.out.print("\nCor: " + C + "\n");
        }
        if (cores.isEmpty()) {// isEmpty ele verifica se a lista ta vazia
            System.out.println("\nLista vazia!");
        }
    }

    public static void limparlista(HashSet cores, char escolha, Scanner ler, char iniciar) {
        limparBuffer(ler);

        if (cores.isEmpty()) {
            System.out.println("Lista vazia!");
        } else
            while (iniciar == 'S' || iniciar == 's') {
                System.out.println("\nDeseja realmente excluir todos as cores? S/N");
                escolha = ler.nextLine().charAt(0);
                if (escolha == 'S' || escolha == 's') {
                    cores.clear();
                    System.out.println("\nExcluido !");
                } else
                    System.out.println("\nCancelado!");
                iniciar = 'N';
            }
    }

    public static void buscarCor(HashSet cores, String cor, Scanner ler, char escolha) {
        limparBuffer(ler);
        if (cores.isEmpty()) {
            System.out.println("\nLista vazia!");
        } else {
            while (escolha == 'S' || escolha == 's') {

                System.out.println("\nInforme o nome da cor: ");
                cor = ler.nextLine();

                if (cores.contains(cor)) {

                    System.out.println("A cor: " + cor + " está na lista!");
                } else {
                    System.out.println("A cor: " + cor + " não está na lista!");
                }

                System.out.println("Deseja buscar uma nova Cor?: S/N");
                escolha = ler.nextLine().charAt(0);
                if (escolha == 'S' || escolha == 's') {
                    escolha = 'S';
                } else {
                    escolha = 'N';
                }
            }
        }
    }

    public static void removerCor(HashSet cores, String cor, Scanner ler, char escolha) {
        limparBuffer(ler);

        if (cores.isEmpty()) {
            System.out.println("\nLista vazia!");
        } else {
            while (escolha == 'S' || escolha == 's') {

                System.out.println("\nInforme o nome da cor: ");
                cor = ler.nextLine();

                if (cores.contains(cor)) {
                    cores.remove(cor);
                    System.out.println("Cor: " + cor + " removida!");
                } else {
                    System.out.println("A cor: " + cor + " não está na lista!");
                }
                System.out.println("Deseja remover uma nova Cor?: S/N");
                escolha = ler.nextLine().charAt(0);
                if (escolha == 'S' || escolha == 's') {
                    escolha = 'S';
                } else {
                    escolha = 'N';
                }
            }
        }
    }
}