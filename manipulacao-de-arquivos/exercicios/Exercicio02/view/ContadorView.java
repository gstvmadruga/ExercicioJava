package view;

import controller.ContadorPalavrasController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ContadorPalavrasView extends Application {
    private ContadorPalavrasController controller = new ContadorPalavrasController();

    @Override
    public void start(Stage primaryStage) {
        Button btnContar = new Button("Contar Palavras");
        Label resultado = new Label();

        btnContar.setOnAction(e -> {
            int total = controller.obterQuantidadePalavras();
            resultado.setText("Total de palavras: " + total);
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(15));
        layout.getChildren().addAll(btnContar, resultado);

        Scene scene = new Scene(layout, 300, 150);
        primaryStage.setTitle("Contador de Palavras - MVC");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
