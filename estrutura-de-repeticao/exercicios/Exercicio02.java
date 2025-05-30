package tabuada;

import java.util.Scanner;

public class TabuadaWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número inteiro para ver a tabuada: ");
        int numero = scanner.nextInt();

        System.out.println("\nTabuada de " + numero + ":");

        int contador = 1;
        
        // Loop while para iterar de 1 a 10
        while (contador <= 10) {
            int resultado = numero * contador;
            System.out.println(numero + " x " + contador + " = " + resultado);
            contador++; // Incrementa o contador
        }

        scanner.close();
    }
}
