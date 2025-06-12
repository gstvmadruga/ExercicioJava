package model;

public class Efetivo extends Funcionario {
    private double salario;

    public Efetivo(String nome, String matricula, double salario) {
        super(nome, matricula);
        this.salario = salario;
    }

    @Override
    public String exibirDados() {
        return "Efetivo - Nome: " + nome + ", Matrícula: " + matricula + ", Salário: " + salario;
    }

    @Override
    public void atualizarDados(String... dados) {
        this.salario = Double.parseDouble(dados[0]);
    }
}
