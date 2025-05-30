package controle;

import dominio.CaixaEletronico;
import java.util.Scanner;
import java.util.InputMismatchException;

public class SimuladorCaixa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CaixaEletronico caixa = null;
        double saldoInicial = -1;

        while (saldoInicial < 0) {
             try {
                System.out.print("Digite o saldo inicial do caixa eletrônico: R$ ");
                saldoInicial = scanner.nextDouble();
                scanner.nextLine(); 
                if (saldoInicial < 0) {
                    System.out.println("Saldo inicial não pode ser negativo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um valor numérico para o saldo.");
                scanner.nextLine(); 
                saldoInicial = -1; 
            }
        }
        
        caixa = new CaixaEletronico(saldoInicial);
        System.out.println("Caixa Eletrônico inicializado.");
        caixa.exibirSaldo();

        int opcao = 0;

        while (opcao != 3) {
            System.out.println("\n--- Caixa Eletrônico ---");
            System.out.println("1. Sacar (múltiplos de R$ 10)");
            System.out.println("2. Exibir Saldo");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcao) {
                    case 1:
                        System.out.print("Digite o valor para sacar: R$ ");
                        try {
                            double valorSaque = scanner.nextDouble();
                            scanner.nextLine(); 
                            caixa.sacar(valorSaque);
                        } catch (InputMismatchException e) {
                            System.out.println("Valor inválido. Por favor, digite um número.");
                            scanner.nextLine(); 
                        }
                        break;
                    case 2:
                        caixa.exibirSaldo();
                        break;
                    case 3:
                        System.out.println("Obrigado por usar o Caixa Eletrônico.");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida. Por favor, digite um número (1, 2 ou 3).");
                scanner.nextLine(); 
                opcao = 0; 
            }
        }

        scanner.close();
    }
}
