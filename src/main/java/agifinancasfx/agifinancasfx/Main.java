package agifinancasfx.agifinancasfx;

import agifinancasfx.agifinancasfx.control.GeradorCenas;
import javafx.application.Application;
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