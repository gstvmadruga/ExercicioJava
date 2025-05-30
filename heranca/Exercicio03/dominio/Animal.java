package dominio;

public class Animal {
    protected String nome;
    protected int idade;

    public Animal(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void emitirSom() {
        System.out.println("Som genérico de animal");
    }

    public void exibirInfo() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + this.idade + " anos");
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }
}
