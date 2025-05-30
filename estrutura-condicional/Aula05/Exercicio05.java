package conversao;

import java.util.Scanner;

public class ConceitoNota {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a nota (0 a 10): ");
        int nota = scanner.nextInt();

        char conceito;

        if (nota >= 0 && nota <= 10) {
            switch (nota) {
                case 10:
                case 9:
                    conceito = 'A';
                    break;
                case 8:
                case 7:
                    conceito = 'B';
                    break;
                case 6:
                case 5:
                    conceito = 'C';
                    break;
                case 4:
                case 3:
                    conceito = 'D';
                    break;
                case 2:
                case 1:
                case 0:
                    conceito = 'E';
                    break;
                default: 
                    break;
            }
            System.out.println("Conceito: " + conceito);
        } else {
            System.out.println("Nota inválida.");
        }

        scanner.close();
    }
}
