package anobissexto;

import java.util.Scanner;

public class VerificaAnoBissexto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um ano: ");
        int ano = scanner.nextInt();

        boolean bissexto = false;

        // Critério 1: Divisível por 4
        if (ano % 4 == 0) {
            // Critério 2: Se divisível por 100, também deve ser por 400
            if (ano % 100 == 0) {
                if (ano % 400 == 0) {
                    bissexto = true;
                }
            } else {
                // Se não for divisível por 100, mas é por 4, é bissexto
                bissexto = true;
            }
        }

        if (bissexto) {
            System.out.println(ano + " é um ano bissexto.");
        } else {
            System.out.println(ano + " não é um ano bissexto.");
        }

        scanner.close();
    }
}
