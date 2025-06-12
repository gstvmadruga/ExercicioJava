package controller;

import model.ContadorPalavrasModel;

public class ContadorPalavrasController {
    private ContadorPalavrasModel model;

    public ContadorPalavrasController() {
        model = new ContadorPalavrasModel();
    }

    public int obterQuantidadePalavras() {
        try {
            return model.contarPalavras();
        } catch (Exception e) {
            System.out.println("Erro ao contar palavras: " + e.getMessage());
            return -1;
        }
    }
}
