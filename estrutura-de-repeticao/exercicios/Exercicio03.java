package contagemregressiva;

import java.util.Scanner;

public class ContagemRegressivaDoWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número inteiro positivo para a contagem regressiva: ");
        int numero = scanner.nextInt();

        if (numero < 0) {
            System.out.println("Por favor, digite um número positivo.");
        } else {
            System.out.println("\nContagem regressiva:");
            int contador = numero;

            // Loop do-while para contagem regressiva
            do {
                System.out.println(contador);
                contador--; // Decrementa o contador
            } while (contador >= 0);
        }

        scanner.close();
    }
}
