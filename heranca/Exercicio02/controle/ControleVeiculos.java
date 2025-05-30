package controle;

import dominio.Carro;
import dominio.Moto;
import dominio.Veiculo; 

public class TestaVeiculos {
    public static void main(String[] args) {
        Carro meuCarro = new Carro("Toyota", "Corolla", 2023, 4);

        Moto minhaMoto = new Moto("Honda", "CB 500F", 2022, 500);

        System.out.println("Exibindo informações dos veículos:");
        System.out.println("---------------------------------");

        meuCarro.exibirDados();
        
        System.out.println(); 

        minhaMoto.exibirDados();
    }
}
