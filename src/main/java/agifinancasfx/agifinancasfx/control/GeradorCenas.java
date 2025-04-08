package agifinancasfx.agifinancasfx.control;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;

public class GeradorCenas {
    public static Stage primaryStage;

    public void gerarNovoStage(String fxmlPath, String titulo, Boolean resizable, ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(GeradorCenas.class.getResource("/view/" + fxmlPath));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle(titulo);
        stage.setResizable(resizable);
        stage.show();
    }
    public static <T> T trocarScene(Stage stage, String fxmlPath, String titulo, boolean resizable) throws IOException {
        FXMLLoader loader = new FXMLLoader(GeradorCenas.class.getResource("/view/"+ fxmlPath));
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.setTitle(titulo);
        stage.setResizable(resizable);
        stage.show();
        return loader.getController();
    }

    public static void loadScene(Stage stage , String fxml) throws IOException {
        FXMLLoader fxmlLoginLoader = new FXMLLoader(GeradorCenas.class.getResource("/view/" + fxml + ".fxml"));
        Parent root = fxmlLoginLoader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}