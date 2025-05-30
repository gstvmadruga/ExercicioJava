package primosintervalo;

import java.util.Scanner;

public class PrimosIntervalo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número inicial do intervalo: ");
        int inicio = scanner.nextInt();

        System.out.print("Digite o número final do intervalo: ");
        int fim = scanner.nextInt();

        if (inicio > fim) {
            System.out.println("Intervalo inválido. O número inicial deve ser menor ou igual ao final.");
            scanner.close();
            return; // Encerra o programa se o intervalo for inválido
        }

        System.out.println("\nNúmeros primos no intervalo [" + inicio + ", " + fim + "]:");

        for (int numero = inicio; numero <= fim; numero++) {
            boolean ehPrimo = true;

            if (numero < 2) {
                ehPrimo = false;
            }
      
            for (int i = 2; i * i <= numero; i++) { 
                if (numero % i == 0) {
                    ehPrimo = false;
                    break; // Se encontrar um divisor, não é primo, pode parar a verificação
                }
            }

            if (ehPrimo) {
                System.out.print(numero + " ");
            }
        }
        System.out.println(); // Nova linha ao final

        scanner.close();
    }
}
