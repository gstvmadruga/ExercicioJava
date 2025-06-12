package model;

public class Terceirizado extends Funcionario {
    private double valorContrato;

    public Terceirizado(String nome, int matricula, double valorContrato) {
        super(nome, matricula);
        this.valorContrato = valorContrato;
    }

    public double getValorContrato() {
        return valorContrato;
    }

    public void setValorContrato(double valorContrato) {
        this.valorContrato = valorContrato;
    }

    @Override
    public double calcularSalario() {
        return valorContrato;
    }

    @Override
    public void exibir() {
        System.out.println("Funcionário Terceirizado:");
        super.exibir();
    }
}

