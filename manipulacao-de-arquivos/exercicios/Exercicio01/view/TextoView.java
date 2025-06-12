package view;

import controller.TextoController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class TextoView extends Application {

    private TextoController controller = new TextoController();

    @Override
    public void start(Stage primaryStage) {
        TextArea areaTextoEntrada = new TextArea();
        areaTextoEntrada.setPromptText("Digite aqui...");

        Button btnSalvar = new Button("Salvar");
        Button btnLer = new Button("Ler");

        TextArea areaTextoLido = new TextArea();
        areaTextoLido.setEditable(false);

        btnSalvar.setOnAction(e -> {
            String texto = areaTextoEntrada.getText();
            controller.salvarTexto(texto);
        });

        btnLer.setOnAction(e -> {
            String textoLido = controller.lerTexto();
            areaTextoLido.setText(textoLido);
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(15));
        layout.getChildren().addAll(
            new Label("Texto para Salvar:"), areaTextoEntrada,
            btnSalvar, btnLer,
            new Label("Texto Lido do Arquivo:"), areaTextoLido
        );

        Scene scene = new Scene(layout, 400, 500);
        primaryStage.setTitle("Leitura e Escrita de Arquivo - MVC");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
