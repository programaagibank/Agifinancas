package agifinancasfx.agifinancasfx.control;

import agifinancasfx.agifinancasfx.DAO.UsuarioDAO;
import agifinancasfx.agifinancasfx.Model.Usuario;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;

public class LoginController {
    @FXML
    private TextField emailText;
    @FXML
    private PasswordField passwordText;
    @FXML
    private Button btnSair;
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    Usuario usuarioAutenticado;
    public void setUsuarioDAO(UsuarioDAO dao) {
        this.usuarioDAO = dao;
    }

    public LoginController() throws SQLException {}
    @FXML
    public void fazerLogin(ActionEvent actionEvent) throws SQLException {
        Usuario usuario = this.usuarioDAO.buscarPorEmail(emailText.getText());
        if (usuario != null && Senha.verificaSenha(passwordText.getText(), usuario.getSenha())) {
            System.out.println("Login bem sucedido.");
            this.usuarioAutenticado = this.usuarioDAO.buscarPorEmail(emailText.getText());
            UsuarioSessao.getInstance().setUsuario(usuarioAutenticado);
            // Navegar para view Menu
            try {
                // Carregar FXML do Menu
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/agifinancasfx/agifinancasfx/view/Menu.fxml"));
                Parent menuRoot = loader.load();

                // buscar stage atual
                Stage stage = (Stage) emailText.getScene().getWindow();

                // Criar nova scene com menu root
                Scene menuScene = new Scene(menuRoot, 320, 640); 

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
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/agifinancasfx/agifinancasfx/view/CadastroUsuario.fxml"));
            Parent cadastroRoot = loader.load();
            Stage stage = (Stage) emailText.getScene().getWindow();
            Scene cadastroScene = new Scene(cadastroRoot, 320, 640);
            stage.setScene(cadastroScene);
            stage.setTitle("Cadastro");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void sairDoApp(ActionEvent event) {
        Platform.exit();
    }

    public void esqueceuSenha(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/agifinancasfx/view/esqueceuSenha.fxml"));
            Parent esqueceuSenhaRoot = loader.load();
            Stage stage = (Stage) emailText.getScene().getWindow();
            Scene esqueceuSenhaScene = new Scene(esqueceuSenhaRoot);
            stage.setScene(esqueceuSenhaScene);
            stage.setTitle("Alterar Senha");
            stage.show();
        } catch (Exception e) {
            System.out.println("Erro ao efetuar troca de senha" + e.getMessage());
            e.printStackTrace();
        }
    }
}
