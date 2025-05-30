package controle;

import dominio.Animal;
import dominio.Cachorro;
import dominio.Gato;

public class TestaAnimais {
    public static void main(String[] args) {
        Cachorro rex = new Cachorro("Rex", 5);

        Gato mimi = new Gato("Mimi", 3);

        System.out.println("Informações e sons dos animais:");
        System.out.println("-------------------------------");

        rex.exibirInfo();
        rex.emitirSom();
        
        System.out.println(); 

        mimi.exibirInfo();
        mimi.emitirSom();
    }
}
