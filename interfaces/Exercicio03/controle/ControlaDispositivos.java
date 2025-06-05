package controle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Smartphone smartphone = new Smartphone();
        Televisao televisao = new Televisao();

        while (true) {
            System.out.println("\nEscolha o dispositivo:");
            System.out.println("1 - Smartphone");
            System.out.println("2 - Televisão");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            int opcaoDispositivo = scanner.nextInt();

            if (opcaoDispositivo == 0) {
                System.out.println("Programa encerrado.");
                break;
            }

            System.out.println("1 - Ligar");
            System.out.println("2 - Desligar");
            System.out.print("Ação: ");
            int acao = scanner.nextInt();

            DispositivoEletronico dispositivo = null;

            switch (opcaoDispositivo) {
                case 1:
                    dispositivo = smartphone;
                    break;
                case 2:
                    dispositivo = televisao;
                    break;
                default:
                    System.out.println("Opção de dispositivo inválida.");
                    continue;
            }

            if (acao == 1) {
                dispositivo.ligar();
            } else if (acao == 2) {
                dispositivo.desligar();
            } else {
                System.out.println("Ação inválida.");
            }
        }

        scanner.close();
    }
}
