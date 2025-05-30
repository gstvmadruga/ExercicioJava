package somannaturais;

import java.util.Scanner;

public class SomaNNaturais {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número N: ");
        int n = scanner.nextInt();

        int soma = 0;
        
        // Loop for para iterar de 1 até N
        for (int i = 1; i <= n; i++) {
            soma += i; // Acumula a soma
        }

        System.out.println("A soma dos primeiros " + n + " números naturais é: " + soma);

        scanner.close();
    }
}
