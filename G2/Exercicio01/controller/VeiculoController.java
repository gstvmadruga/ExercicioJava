package controller;

import java.util.ArrayList;
import modell.*;

public class VeiculoController {
    private ArrayList<Veiculo> lista = new ArrayList<>();

    public void adicionar(Veiculo v) {
        lista.add(v);
    }

    public void listar() {
        for (Veiculo v : lista) {
            v.exibirDados();
        }
    }
}
