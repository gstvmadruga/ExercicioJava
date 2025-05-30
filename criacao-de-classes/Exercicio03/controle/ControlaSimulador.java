package controle;

import dominio.Elevador;
import java.util.Scanner;
import java.util.InputMismatchException;

public class SimuladorElevador {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Elevador elevador = null;

        while (elevador == null) {
            try {
                System.out.print("Digite o número total de andares do prédio (ex: 5 para Térreo + 4 andares): ");
                int totalAndaresPredio = scanner.nextInt();
                scanner.nextLine(); // Consome a nova linha
                
                if (totalAndaresPredio <= 0) {
                     System.out.println("Número de andares inválido. Deve ser maior que zero.");
                } else {
                    elevador = new Elevador(totalAndaresPredio);
                    System.out.println("Elevador inicializado no térreo (andar 0). Último andar: " + elevador.getTotalAndares());
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                scanner.nextLine(); // Limpa o buffer
            }
        }

        int opcao = 0;

        do {
            System.out.println("\n--- Simulador de Elevador ---");
            elevador.exibirAndar(); // Mostra o andar atual antes das opções
            System.out.println("1. Subir");
            System.out.println("2. Descer");
            System.out.println("3. Sair da Simulação");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consome a nova linha

                switch (opcao) {
                    case 1:
                        elevador.subir();
                        break;
                    case 2:
                        elevador.descer();
                        break;
                    case 3:
                        System.out.println("Encerrando a simulação do elevador.");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } catch (InputMismatchException e) {
                 System.out.println("Opção inválida. Por favor, digite um número (1, 2 ou 3).");
                 scanner.nextLine(); // Limpa o buffer do scanner
                 opcao = 0; // Reseta a opção para continuar no loop
            }

        } while (opcao != 3);

        scanner.close();
    }
}
