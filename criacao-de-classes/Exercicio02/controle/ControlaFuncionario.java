package controle;

import dominio.Funcionario;
import java.util.Scanner;
import java.util.InputMismatchException;

public class GerenciadorFuncionario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Digite o nome do funcionário: ");
            String nome = scanner.nextLine();

            System.out.print("Digite o salário base do funcionário: ");
            double salarioBase = scanner.nextDouble();
            scanner.nextLine(); // Consome a nova linha

            System.out.print("Digite a categoria do funcionário (A, B ou C): ");
            String categoria = scanner.nextLine();

            Funcionario funcionario = new Funcionario(nome, salarioBase, categoria);

            double salarioFinal = funcionario.calcularSalarioFinal();

            System.out.println("\n--- Dados do Funcionário ---");
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Salário Base: R$ " + funcionario.getSalarioBase());
            System.out.println("Categoria: " + funcionario.getCategoria());
            System.out.println("Salário Final (com bônus): R$ " + String.format("%.2f", salarioFinal));

        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida. Por favor, insira um valor numérico para o salário.");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
