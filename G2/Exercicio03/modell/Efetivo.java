package model;

public class Efetivo extends Funcionario {
    private double salarioBase;

    public Efetivo(String nome, int matricula, double salarioBase) {
        super(nome, matricula);
        this.salarioBase = salarioBase;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    @Override
    public double calcularSalario() {
        return salarioBase;
    }

    @Override
    public void exibir() {
        System.out.println("Funcionário Efetivo:");
        super.exibir();
    }
}

