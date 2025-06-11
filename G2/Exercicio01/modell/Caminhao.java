package modell;

public class Caminhao extends Veiculo {
    private double capacidadeCarga;

    public Caminhao(String placa, String modelo, int ano, double capacidadeCarga) {
        super(placa, modelo, ano);
        this.capacidadeCarga = capacidadeCarga;
    }

    public void exibirDados() {
        System.out.println("Caminhão - Modelo: " + getModelo() + " | Placa: " + getPlaca() + " | Ano: " + getAno() + " | Carga: " + capacidadeCarga + " toneladas");
    }
}
