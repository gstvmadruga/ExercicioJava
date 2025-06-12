package view;

import controller.FuncionarioController;
import model.*;

import java.util.List;
import java.util.Scanner;

public class Principal {
    private static FuncionarioController controller = new FuncionarioController();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean sair = false;
        while (!sair) {
            mostrarMenu();
            int opcao = lerInt("Escolha uma opção: ");
            try {
                switch (opcao) {
                    case 1 -> cadastrarFuncionario();
                    case 2 -> listarFuncionarios();
                    case 3 -> buscarFuncionario();
                    case 4 -> atualizarFuncionario();
                    case 5 -> removerFuncionario();
                    case 6 -> sair = true;
                    default -> System.out.println("Opção inválida!");
                }
            } catch (EntradaInvalidaException | FuncionarioNaoEncontradoException e) {
                System.out.println("Erro: " + e.getMessage());
            }
            System.out.println();
        }
        System.out.println("Sistema finalizado.");
    }

    private static void mostrarMenu() {
        System.out.println("=== Sistema de Cadastro de Funcionários ===");
        System.out.println("1. Cadastrar funcionário");
        System.out.println("2. Listar todos os funcionários");
        System.out.println("3. Buscar funcionário");
        System.out.println("4. Atualizar funcionário");
        System.out.println("5. Remover funcionário");
        System.out.println("6. Sair");
    }

    private static void cadastrarFuncionario() throws EntradaInvalidaException {
        System.out.println("Tipo de funcionário:");
        System.out.println("1. Efetivo");
        System.out.println("2. Temporário");
        System.out.println("3. Terceirizado");
        int tipo = lerInt("Escolha o tipo: ");

        String nome = lerString("Nome: ");
        int matricula = lerInt("Matrícula: ");

        switch (tipo) {
            case 1 -> {
                double salarioBase = lerDouble("Salário base: ");
                Efetivo e = new Efetivo(nome, matricula, salarioBase);
                controller.adicionarFuncionario(e);
                System.out.println("Funcionário efetivo cadastrado com sucesso!");
            }
            case 2 -> {
                double valorHora = lerDouble("Valor por hora: ");
                int horasTrabalhadas = lerInt("Horas trabalhadas: ");
                Temporario t = new Temporario(nome, matricula, valorHora, horasTrabalhadas);
                controller.adicionarFuncionario(t);
                System.out.println("Funcionário temporário cadastrado com sucesso!");
            }
            case 3 -> {
                double valorContrato = lerDouble("Valor do contrato: ");
                Terceirizado terceirizado = new Terceirizado(nome, matricula, valorContrato);
                controller.adicionarFuncionario(terceirizado);
                System.out.println("Funcionário terceirizado cadastrado com sucesso!");
            }
            default -> System.out.println("Tipo inválido!");
        }
    }

    private static void listarFuncionarios() {
        List<Funcionario> lista = controller.listarFuncionarios();
        if (lista.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
        } else {
            for (Funcionario f : lista) {
                System.out.println("----------------------------");
                f.exibir();
            }
            System.out.println("----------------------------");
        }
    }

    private static void buscarFuncionario() throws FuncionarioNaoEncontradoException {
        System.out.println("Buscar por:");
        System.out.println("1. Matrícula");
        System.out.println("2. Nome");
        int opcao = lerInt("Opção: ");
        if (opcao == 1) {
            int matricula = lerInt("Digite a matrícula: ");
            Funcionario f = controller.buscarPorMatricula(matricula);
            f.exibir();
        } else if (opcao == 2) {
            String nome = lerString("Digite o nome ou parte do nome: ");
            List<Funcionario> encontrados = controller.buscarPorNome(nome);
            if (encontrados.isEmpty()) {
                System.out.println("Nenhum funcionário encontrado com esse nome.");
            } else {
                for (Funcionario f : encontrados) {
                    System.out.println("----------------------------");
                    f.exibir();
                }
                System.out.println("----------------------------");
            }
        } else {
            System.out.println("Opção inválida.");
        }
    }

    private static void atualizarFuncionario() throws FuncionarioNaoEncontradoException, EntradaInvalidaException {
        int matricula = lerInt("Digite a matrícula do funcionário a ser atualizado: ");
        Funcionario antigo = controller.buscarPorMatricula(matricula);
        System.out.println("Dados atuais:");
        antigo.exibir();

        System.out.println("Digite os novos dados:");
        String nome = lerString("Novo nome: ");
        int novaMatricula = lerInt("Nova matrícula: ");

        if (antigo instanceof Efetivo) {
            double salarioBase = lerDouble("Novo salário base: ");
            Efetivo novo = new Efetivo(nome, novaMatricula, salarioBase);
            controller.atualizarFuncionario(matricula, novo);
        } else if (antigo instanceof Temporario) {
            double valorHora = lerDouble("Novo valor por hora: ");
            int horasTrabalhadas = lerInt("Nova quantidade de horas trabalhadas: ");
            Temporario novo = new Temporario(nome, novaMatricula, valorHora, horasTrabalhadas);
            controller.atualizarFuncionario(matricula, novo);
        } else if (antigo instanceof Terceirizado) {
            double valorContrato = lerDouble("Novo valor do contrato: ");
            Terceirizado novo = new Terceirizado(nome, novaMatricula, valorContrato);
            controller.atualizarFuncionario(matricula, novo);
        }
        System.out.println("Funcionário atualizado com sucesso!");
    }

    private static void removerFuncionario() throws FuncionarioNaoEncontradoException {
        int matricula = lerInt("Digite a matrícula do funcionário a ser removido: ");
        controller.removerFuncionario(matricula);
        System.out.println("Funcionário removido com sucesso!");
    }

    private static String lerString(String msg) {
        System.out.print(msg);
        return scanner.nextLine();
    }

    private static int lerInt(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida, digite um número inteiro.");
            }
        }
    }

    private static double lerDouble(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida, digite um número decimal válido.");
            }
        }
    }
}

