package view;

import controller.FuncionarioController;
import modell.*;

import java.util.List;
import java.util.Scanner;

public class Principal {
    private static FuncionarioController controller = new FuncionarioController();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    cadastrarFuncionario();
                    break;
                case 2:
                    listarFuncionarios();
                    break;
                case 3:
                    buscarFuncionario();
                    break;
                case 4:
                    atualizarFuncionario();
                    break;
                case 5:
                    removerFuncionario();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            System.out.println(); 
        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("---- Sistema de Cadastro de Funcionários ----");
        System.out.println("1. Cadastrar Funcionário");
        System.out.println("2. Listar Funcionários");
        System.out.println("3. Buscar Funcionário");
        System.out.println("4. Atualizar Funcionário");
        System.out.println("5. Remover Funcionário");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarFuncionario() {
        System.out.println("\n---- Cadastro de Funcionário ----");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();

        System.out.println("Tipo de Funcionário:");
        System.out.println("1. Efetivo");
        System.out.println("2. Temporário");
        System.out.println("3. Terceirizado");
        System.out.print("Escolha o tipo: ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); 

        Funcionario novoFuncionario = null;
        try {
            switch (tipo) {
                case 1:
                    System.out.print("Salário: ");
                    double salario = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Cargo: ");
                    String cargo = scanner.nextLine();
                    novoFuncionario = new Efetivo(nome, matricula, salario, cargo);
                    break;
                case 2:
                    System.out.print("Dias de Contrato: ");
                    int diasContrato = scanner.nextInt();
                    scanner.nextLine();
                    novoFuncionario = new Temporario(nome, matricula, diasContrato);
                    break;
                case 3:
                    System.out.print("Empresa Terceirizada: ");
                    String empresaTerceirizada = scanner.nextLine();
                    novoFuncionario = new Terceirizado(nome, matricula, empresaTerceirizada);
                    break;
                default:
                    System.out.println("Tipo de funcionário inválido.");
                    return;
            }
            controller.cadastrarFuncionario(novoFuncionario);
        } catch (EntradaInvalidaException e) {
            System.err.println("Erro ao cadastrar: " + e.getMessage());
        } catch (java.util.InputMismatchException e) {
            System.err.println("Erro de entrada: Valor inválido para o tipo de dado esperado.");
            scanner.nextLine(); 
        }
    }

    private static void listarFuncionarios() {
        System.out.println("\n---- Lista de Funcionários ----");
        List<Funcionario> funcionarios = controller.listarFuncionarios();
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
        } else {
            for (Funcionario f : funcionarios) {
                f.exibirInformacoes();
                System.out.println("--------------------");
            }
        }
    }

    private static void buscarFuncionario() {
        System.out.println("\n---- Buscar Funcionário ----");
        System.out.print("Digite o nome ou matrícula do funcionário: ");
        String termoBusca = scanner.nextLine();

        try {
            Funcionario funcionarioEncontrado = controller.buscarFuncionario(termoBusca);
            System.out.println("Funcionário encontrado:");
            funcionarioEncontrado.exibirInformacoes();
        } catch (FuncionarioNaoEncontradoException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void atualizarFuncionario() {
        System.out.println("\n---- Atualizar Funcionário ----");
        System.out.print("Digite a matrícula do funcionário a ser atualizado: ");
        String matriculaAntiga = scanner.nextLine();

        try {
            controller.buscarFuncionario(matriculaAntiga);

            System.out.println("Digite os novos dados do funcionário:");
            System.out.print("Novo Nome: ");
            String novoNome = scanner.nextLine();
            System.out.print("Nova Matrícula: ");
            String novaMatricula = scanner.nextLine();

            System.out.println("Tipo de Funcionário (1. Efetivo, 2. Temporário, 3. Terceirizado): ");
            System.out.print("Escolha o tipo: ");
            int tipo = scanner.nextInt();
            scanner.nextLine(); 

            Funcionario funcionarioAtualizado = null;
            switch (tipo) {
                case 1:
                    System.out.print("Novo Salário: ");
                    double novoSalario = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Novo Cargo: ");
                    String novoCargo = scanner.nextLine();
                    funcionarioAtualizado = new Efetivo(novoNome, novaMatricula, novoSalario, novoCargo);
                    break;
                case 2:
                    System.out.print("Novos Dias de Contrato: ");
                    int novosDiasContrato = scanner.nextInt();
                    scanner.nextLine();
                    funcionarioAtualizado = new Temporario(novoNome, novaMatricula, novosDiasContrato);
                    break;
                case 3:
                    System.out.print("Nova Empresa Terceirizada: ");
                    String novaEmpresaTerceirizada = scanner.nextLine();
                    funcionarioAtualizado = new Terceirizado(novoNome, novaMatricula, novaEmpresaTerceirizada);
                    break;
                default:
                    System.out.println("Tipo de funcionário inválido.");
                    return;
            }
            controller.atualizarFuncionario(matriculaAntiga, funcionarioAtualizado);
        } catch (FuncionarioNaoEncontradoException e) {
            System.err.println(e.getMessage());
        } catch (EntradaInvalidaException e) {
            System.err.println("Erro ao atualizar: " + e.getMessage());
        } catch (java.util.InputMismatchException e) {
            System.err.println("Erro de entrada: Valor inválido para o tipo de dado esperado.");
            scanner.nextLine(); 
        }
    }

    private static void removerFuncionario() {
        System.out.println("\n---- Remover Funcionário ----");
        System.out.print("Digite a matrícula do funcionário a ser removido: ");
        String matricula = scanner.nextLine();

        try {
            controller.removerFuncionario(matricula);
        } catch (FuncionarioNaoEncontradoException e) {
            System.err.println(e.getMessage());
        }
    }
}
