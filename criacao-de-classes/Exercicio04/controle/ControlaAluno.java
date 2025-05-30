package controle;

import dominio.Aluno;
import java.util.Scanner;
import java.util.InputMismatchException;

public class GerenciadorAluno {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Digite o nome do aluno: ");
            String nome = scanner.nextLine();

            Aluno aluno = new Aluno(nome);
            double nota = -1; // Inicializa com valor inválido
            boolean notaValida = false;

            while (!notaValida) {
                System.out.print("Digite a nota do aluno (0 a 10): ");
                try {
                    nota = scanner.nextDouble();
                    scanner.nextLine(); // Consome a nova linha
                    
                    aluno.setNota(nota);
                    notaValida = aluno.validarNota();

                    if (!notaValida) {
                        System.out.println("Nota inválida. Por favor, digite um valor entre 0 e 10.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, digite um número.");
                    scanner.nextLine(); // Limpa o buffer
                }
            }

            System.out.println("\n--- Classificação do Aluno ---");
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("Nota: " + aluno.getNota());
            System.out.println("Situação: " + aluno.classificarAluno());

        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
