package agifinancasfx.agifinancasfx.control;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.Optional;

public class CriarAlertas {
    public CriarAlertas() {}

    public static void CriarAlerta(String titulo, String mensagem, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.getDialogPane().setPrefWidth(250);
        alert.getDialogPane().setPrefHeight(100);
        alert.getDialogPane().getStylesheets().add(CriarAlertas.class.getResource("/view/style.css").toExternalForm());
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
    public static boolean confirmarExclusao(String nomeCategoria) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.getDialogPane().setPrefWidth(250);
        alert.getDialogPane().setPrefHeight(100);
        alert.setTitle("Confirmar Exclusão");
        alert.setHeaderText(null);
        alert.setContentText("Tem certeza que deseja excluir a categoria \"" + nomeCategoria + "\"?");
        ButtonType btnSim = new ButtonType("Sim");
        ButtonType btnCancelar = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(btnSim, btnCancelar);
        Optional<ButtonType> resultado = alert.showAndWait();
        return resultado.isPresent() && resultado.get() == btnSim;
    }
}
