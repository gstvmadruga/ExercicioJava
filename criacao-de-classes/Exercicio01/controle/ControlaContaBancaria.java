package controle;

import dominio.ContaBancaria;
import java.util.Scanner;

public class GerenciadorConta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do titular da conta: ");
        String titular = scanner.nextLine();

        ContaBancaria conta = new ContaBancaria(titular);
        System.out.println("Conta criada para " + conta.getTitular() + ".");

        int opcao = 0;

        while (opcao != 4) {
            System.out.println("\n--- Menu da Conta Bancária ---");
            System.out.println("1. Depositar");
            System.out.println("2. Sacar");
            System.out.println("3. Consultar Saldo");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consome a nova linha deixada pelo nextInt()

                switch (opcao) {
                    case 1:
                        System.out.print("Digite o valor para depositar: ");
                        if (scanner.hasNextDouble()) {
                            double valorDeposito = scanner.nextDouble();
                            scanner.nextLine(); // Consome a nova linha
                            conta.depositar(valorDeposito);
                        } else {
                            System.out.println("Entrada inválida. Por favor, digite um número.");
                            scanner.nextLine(); // Limpa o buffer
                        }
                        break;
                    case 2:
                        System.out.print("Digite o valor para sacar: ");
                         if (scanner.hasNextDouble()) {
                            double valorSaque = scanner.nextDouble();
                            scanner.nextLine(); // Consome a nova linha
                            conta.sacar(valorSaque);
                        } else {
                            System.out.println("Entrada inválida. Por favor, digite um número.");
                            scanner.nextLine(); // Limpa o buffer
                        }
                        break;
                    case 3:
                        conta.exibirSaldo();
                        break;
                    case 4:
                        System.out.println("Saindo do sistema. Obrigado!");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } else {
                 System.out.println("Opção inválida. Por favor, digite um número entre 1 e 4.");
                 scanner.nextLine(); // Limpa o buffer do scanner
                 opcao = 0; // Reseta a opção para continuar no loop
            }
        }

        scanner.close();
    }
}
