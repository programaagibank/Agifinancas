package agifinancasfx.agifinancasfx;

import agifinancasfx.agifinancasfx.control.GeradorCenas;
import agifinancasfx.agifinancasfx.control.LoginController;
import agifinancasfx.agifinancasfx.DAO.*;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setWidth(320);
        primaryStage.setHeight(640);
        LoginController controller = GeradorCenas.trocarScene(primaryStage, "/agifinancasfx/agifinancasfx/view/Login.fxml", "Login", false); //loader.getController();
        controller.setUsuarioDAO(new UsuarioDAO());
    }

    public static void main(String[] args) {
        launch(args);
    }
}