package mediaturma;

import java.util.Scanner;

public class MediaTurma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a quantidade de alunos na turma: ");
        int quantidadeAlunos = scanner.nextInt();

        double somaNotas = 0;

        for (int i = 1; i <= quantidadeAlunos; i++) {
            System.out.print("Digite a nota do aluno " + i + ": ");
            double nota = scanner.nextDouble();
            somaNotas += nota; // Acumula a soma das notas
        }

        double media = 0;
        if (quantidadeAlunos > 0) {
            media = somaNotas / quantidadeAlunos;
            System.out.println("\nA média das notas da turma é: " + media);
        } else {
            System.out.println("\nNão há alunos na turma para calcular a média.");
        }

        scanner.close();
    }
}
