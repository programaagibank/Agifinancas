package agifinancasfx.agifinancasfx;

import agifinancasfx.agifinancasfx.control.GeradorCenas;
import javafx.application.Application;
import javafx.stage.Stage;

import static agifinancasfx.agifinancasfx.control.GeradorCenas.primaryStage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        primaryStage.setWidth(320);
        primaryStage.setHeight(640);
        primaryStage.setResizable(true);
        GeradorCenas.loadScene(primaryStage, "Login"); //loader.getController();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
