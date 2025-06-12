package model;

public abstract class Funcionario implements Exibivel {
    protected String nome;
    protected int matricula;

    public Funcionario(String nome, int matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public abstract double calcularSalario();

    @Override
    public void exibir() {
        System.out.println("Nome: " + nome);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Salário: R$ " + calcularSalario());
    }
}
