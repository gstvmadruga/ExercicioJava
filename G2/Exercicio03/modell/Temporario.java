package model;

public class Temporario extends Funcionario {
    private int diasContrato;

    public Temporario(String nome, String matricula, int diasContrato) {
        super(nome, matricula);
        this.diasContrato = diasContrato;
    }

    public int getDiasContrato() {
        return diasContrato;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Tipo: Temporário");
        System.out.println("Nome: " + getNome());
        System.out.println("Matrícula: " + getMatricula());
        System.out.println("Dias de Contrato: " + diasContrato);
    }
}

