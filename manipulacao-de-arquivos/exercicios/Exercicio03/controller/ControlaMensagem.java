package controller;

import model.MensagemModel;

public class MensagemController {
    private MensagemModel model;

    public MensagemController() {
        model = new MensagemModel();
    }

    public void atualizarMensagem(String texto) {
        model.setMensagem(texto);
    }

    public String obterMensagem() {
        return model.getMensagem();
    }
}
