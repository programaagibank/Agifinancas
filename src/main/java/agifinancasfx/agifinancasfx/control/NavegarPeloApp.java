package agifinancasfx.agifinancasfx.control;

import javafx.event.ActionEvent;

import java.io.IOException;

public interface NavegarPeloApp {
    static void voltarMenu(ActionEvent event) throws IOException {
        GeradorCenas cenas = new GeradorCenas();
        cenas.gerarNovoStage("Menu.fxml", "Menu", false, event);
    }
}
