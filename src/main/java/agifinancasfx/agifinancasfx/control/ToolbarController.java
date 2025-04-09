package agifinancasfx.agifinancasfx.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ToolbarController implements NavegarPeloApp {

    private String currentScreen;
    // Lista de botões
    List<Button> listButton = new ArrayList<>();

    // Função que é executada ao clicar/tocar em um dos botões de navegação
    @FXML
    public void menuClick(ActionEvent event) {
        Button button = (Button)event.getSource(); //pegando o botao que foi clicado
        if(!listButton.contains(button)) {
            listButton.add(button);
        }
        for (Button otherButton : listButton) {
            if (otherButton.equals(button)) {
                button.setStyle("-fx-background-color: rgba(0, 0, 0, 0.05)");
            } else {
                otherButton.setStyle("-fx-background-color: transparent");
            }
        }
    }

    @FXML
    public void goHome(ActionEvent event) {
        try {
            GeradorCenas.primaryStage.setResizable(false);
            GeradorCenas.loadScene(GeradorCenas.primaryStage, "Home");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @FXML
    public void transacao(ActionEvent event) {
        try {
            GeradorCenas.primaryStage.setResizable(false);
            GeradorCenas.loadScene(GeradorCenas.primaryStage, "Transacao");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @FXML
    public void relatorio(ActionEvent event) {
        try {
            GeradorCenas.primaryStage.setResizable(false);
            GeradorCenas.loadScene(GeradorCenas.primaryStage, "RelatorioAtualizado");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void cartao(ActionEvent actionEvent) {
        try {
            GeradorCenas.primaryStage.setResizable(false);
            GeradorCenas.loadScene(GeradorCenas.primaryStage, "Cartao");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
