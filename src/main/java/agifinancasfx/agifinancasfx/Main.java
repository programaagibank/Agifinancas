package agifinancasfx.agifinancasfx;

import agifinancasfx.agifinancasfx.control.GeradorCenas;
import agifinancasfx.agifinancasfx.control.LoginController;
import agifinancasfx.agifinancasfx.DAO.*;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
<<<<<<< HEAD
        // Carregar arquivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Login.fxml"));
        Parent root = loader.load();

        // Buscar controller e settar DAO
        LoginController controller = loader.getController();
        controller.setUsuarioDAO(new UsuarioDAO()); // Certificar-se de DAO estar implementado

        // Settar o stage
        primaryStage.setTitle("Login System");
        primaryStage.setScene(new Scene(root, 386, 639));
        primaryStage.show();
=======
        primaryStage.setWidth(320);
        primaryStage.setHeight(640);
        LoginController controller = GeradorCenas.trocarScene(primaryStage, "Login.fxml", "Login", false); //loader.getController();
        controller.setUsuarioDAO(new UsuarioDAO());
>>>>>>> feature/fxAnderson
    }

    public static void main(String[] args) {
        launch(args);
    }
}