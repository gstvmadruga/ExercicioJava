package model;

public class Efetivo extends Funcionario {
    private double salario;
    private String cargo;

    public Efetivo(String nome, String matricula, double salario, String cargo) {
        super(nome, matricula);
        this.salario = salario;
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Tipo: Efetivo");
        System.out.println("Nome: " + getNome());
        System.out.println("Matrícula: " + getMatricula());
        System.out.println("Salário: " + salario);
        System.out.println("Cargo: " + cargo);
    }
}

