package modell;

public class Moto extends Veiculo {
    private int cilindrada;

    public Moto(String placa, String modelo, int ano, int cilindrada) {
        super(placa, modelo, ano);
        this.cilindrada = cilindrada;
    }

    public void exibirDados() {
        System.out.println("Moto - Modelo: " + getModelo() + " | Placa: " + getPlaca() + " | Ano: " + getAno() + " | Cilindrada: " + cilindrada + "cc");
    }
}
