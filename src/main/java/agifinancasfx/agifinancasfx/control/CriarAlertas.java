package agifinancasfx.agifinancasfx.control;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.Optional;

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
    public static boolean confirmarExclusao(String nomeCategoria) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmar Exclusão");
        alert.setHeaderText("Excluir categoria");
        alert.setContentText("Tem certeza que deseja excluir a categoria \"" + nomeCategoria + "\"?");

        ButtonType btnSim = new ButtonType("Sim");
        ButtonType btnCancelar = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(btnSim, btnCancelar);

        Optional<ButtonType> resultado = alert.showAndWait();
        return resultado.isPresent() && resultado.get() == btnSim;
    }
}
