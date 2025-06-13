package model;

public class Terceirizado extends Funcionario {
    private String empresaTerceirizada;

    public Terceirizado(String nome, String matricula, String empresaTerceirizada) {
        super(nome, matricula);
        this.empresaTerceirizada = empresaTerceirizada;
    }

    public String getEmpresaTerceirizada() {
        return empresaTerceirizada;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Tipo: Terceirizado");
        System.out.println("Nome: " + getNome());
        System.out.println("Matrícula: " + getMatricula());
        System.out.println("Empresa Terceirizada: " + empresaTerceirizada);
    }
}


