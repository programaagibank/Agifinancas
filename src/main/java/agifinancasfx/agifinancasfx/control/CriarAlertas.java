package agifinancasfx.agifinancasfx.control;

import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class CriarAlertas {
    public CriarAlertas() {}

    public static void CriarAlerta(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.getDialogPane().setPrefWidth(250);
        alert.getDialogPane().setPrefHeight(100);
        alert.getDialogPane().getStylesheets().add(CriarAlertas.class.getResource("/agifinancasfx/agifinancasfx/view/style.css").toExternalForm());
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
