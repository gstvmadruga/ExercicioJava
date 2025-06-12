package controller;

import model.TextoModel;

public class TextoController {
    private TextoModel model;

    public TextoController() {
        model = new TextoModel();
    }

    public void salvarTexto(String texto) {
        try {
            model.gravarTexto(texto);
        } catch (Exception e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }

    public String lerTexto() {
        try {
            return model.lerTexto();
        } catch (Exception e) {
            return "Erro ao ler o arquivo.";
        }
    }
}
