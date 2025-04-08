package agifinancasfx.agifinancasfx.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

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
}
