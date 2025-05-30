package dominio;

public class Moto extends Veiculo {
    private int cilindradas;

    public Moto(String marca, String modelo, int ano, int cilindradas) {
        super(marca, modelo, ano);
        this.cilindradas = cilindradas;
    }
    @Override
    public void exibirDados() {
        System.out.println("--- Moto ---");
        super.exibirDados(); 
        System.out.println("Cilindradas: " + this.cilindradas + "cc");
    }
    public int getCilindradas() {
        return cilindradas;
    }
}
