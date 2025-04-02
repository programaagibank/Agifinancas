package agifinancasfx.agifinancasfx;

import agifinancasfx.agifinancasfx.control.LoginController;
import agifinancasfx.agifinancasfx.DAO.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Carregar arquivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/agifinancasfx/agifinancasfx/view/Login.fxml"));
        Parent root = loader.load();

        // Buscar controller e settar DAO
        LoginController controller = loader.getController();
        controller.setUsuarioDAO(new UsuarioDAO()); // Certificar-se de DAO estar implementado

        // Settar o stage
        primaryStage.setTitle("Login System");
        primaryStage.setScene(new Scene(root, 386, 639));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}