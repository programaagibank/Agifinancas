package agifinancasfx.agifinancasfx;

import agifinancasfx.agifinancasfx.control.GeradorCenas;
import agifinancasfx.agifinancasfx.control.LoginController;
import agifinancasfx.agifinancasfx.DAO.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setWidth(320);
        primaryStage.setHeight(640);

        GeradorCenas.trocarScene(primaryStage, "Login.fxml", "Login", false); //loader.getController();
    }

    public static void main(String[] args) {
        launch(args);
    }
}