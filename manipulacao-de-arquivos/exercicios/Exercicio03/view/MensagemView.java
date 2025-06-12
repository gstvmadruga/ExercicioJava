package view;

import controller.MensagemController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MensagemView extends Application {
    private MensagemController controller = new MensagemController();

    @Override
    public void start(Stage primaryStage) {
        TextField campoTexto = new TextField();
        Button botaoEnviar = new Button("Enviar");
        Label labelMensagem = new Label();

        botaoEnviar.setOnAction(e -> {
            String texto = campoTexto.getText();
            controller.atualizarMensagem(texto);
            labelMensagem.setText(controller.obterMensagem());
        });

        VBox layout = new VBox(10);
        layout.setPadding(new javafx.geometry.Insets(15));
        layout.getChildren().addAll(campoTexto, botaoEnviar, labelMensagem);

        Scene scene = new Scene(layout, 300, 150);
        primaryStage.setTitle("Simulador de Mensagens - MVC");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
