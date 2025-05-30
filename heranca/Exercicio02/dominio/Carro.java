package dominio;

public class Carro extends Veiculo {
    private int quantidadePortas;

    public Carro(String marca, String modelo, int ano, int quantidadePortas) {
        // Chama o construtor da classe base (Veiculo)
        super(marca, modelo, ano);
        this.quantidadePortas = quantidadePortas;
    }

    @Override
    public void exibirDados() {
        System.out.println("--- Carro ---");
        super.exibirDados(); // Chama o método da classe base
        System.out.println("Quantidade de Portas: " + this.quantidadePortas);
    }

    public int getQuantidadePortas() {
        return quantidadePortas;
    }
}
