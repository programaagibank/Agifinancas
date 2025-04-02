package agifinancasfx.agifinancasfx.control;

import agifinancasfx.agifinancasfx.DAO.UsuarioDAO;
import agifinancasfx.agifinancasfx.Model.Usuario;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.SQLException;

public class LoginController {
    @FXML
    private TextField emailText;
    @FXML
    private PasswordField passwordText;
    private UsuarioDAO usuarioDAO;
    Usuario usuarioAutenticado;
    public void setUsuarioDAO(UsuarioDAO dao) {
        this.usuarioDAO = dao;
    }

    public LoginController(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }
    public LoginController() {}
    @FXML
    private void fazerLogin(ActionEvent actionEvent) throws SQLException {
        Usuario usuario = this.usuarioDAO.buscarPorEmail(emailText.getText());
        if (usuario != null && Senha.verificaSenha(passwordText.getText(), usuario.getSenha())) {
            System.out.println("Login bem sucedido.");
            this.usuarioAutenticado = this.usuarioDAO.buscarPorEmail(emailText.getText());

            // Navegar para view Menu
            try {
                // Carregar FXML do Menu
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/agifinancasfx/agifinancasfx/view/Menu.fxml"));
                Parent menuRoot = loader.load();

                // buscar stage atual
                Stage stage = (Stage) emailText.getScene().getWindow();

                // Criar nova scene com menu root
                Scene menuScene = new Scene(menuRoot, 412, 912); // Adjust size as needed

                // Settar nova scene
                stage.setScene(menuScene);
                stage.setTitle("Menu Principal");
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Email ou senha inválidos!");
        }
    }

    @FXML
    private void fazerCadastro(ActionEvent event) {
        // TODO: Implement cadastro functionality
        System.out.println("Cadastro clicked");
    }

    @FXML
    private void sairDoApp(ActionEvent event) {
        Platform.exit();
    }
}
