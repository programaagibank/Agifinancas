package agifinancasfx.agifinancasfx.control;
import agifinancasfx.agifinancasfx.DAO.UsuarioDAO;
import agifinancasfx.agifinancasfx.Model.Usuario;
import agifinancasfx.agifinancasfx.control.LoginController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node; // Corrigido: Usando Node do JavaFX
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class CadastrarController {
    @FXML
    private Button btnCadastrar;

    @FXML
    private Button btnFazerLoginCadastro;

    @FXML
    private Label lblNovoUsuario;

    @FXML
    private Label lblPossuiCadastro;

    @FXML
    private TextField txtCPF;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNome;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private PasswordField txtPasswordAgain;

    @FXML
    private TextField txtSobrenome;

    @FXML
    void cadastrarUsuario(ActionEvent event) throws SQLException {
        String nome = txtNome.getText().trim();
        String cpf = txtCPF.getText().trim();
        String email = txtEmail.getText().trim();
        String password = txtPassword.getText();
        String passwordagain = txtPasswordAgain.getText();
        String sobrenome = txtSobrenome.getText().trim();

        // Criando um objeto Usuario
        String senhaHash = "";
        if (password.equals(passwordagain)) {
            senhaHash = Senha.hashSenha(password);
        }
        Usuario usuario = new Usuario(cpf, nome, sobrenome, senhaHash, email);

        // Chamando o DAO e atribuindo o objeto Usuario
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        boolean sucesso = usuarioDAO.criarUsuario(usuario);

        if (sucesso) {
            limparCampos();
            try {
                // Carregando o arquivo FXML
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/agifinancasfx/agifinancasfx/view/Login.fxml"));
                Parent arquivo = fxmlLoader.load();
                // Obtendo a cena atual a partir do evento
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                // Criando uma nova cena com o FXML carregado
                Scene scene = new Scene(arquivo, 320, 640);

                // Definindo a nova cena no Stage
                stage.setScene(scene);
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    // Método para limpar os campos após um cadastro bem-sucedido
    private void limparCampos() {
        txtCPF.clear();
        txtNome.clear();
        txtSobrenome.clear();
        txtEmail.clear();
        txtPassword.clear();
        txtPasswordAgain.clear();
    }
    private static Parent loginView;
    private static Scene loginScene;

    @FXML
    void fazerLogin(ActionEvent event) {
        try {
            if (loginView == null) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/agifinancasfx/agifinancasfx/view/Login.fxml"));
                loginView = fxmlLoader.load();
                loginScene = new Scene(loginView, 320, 640);
            }

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(loginScene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    @FXML
//    void fazerLogin(ActionEvent event) {
//        try {
//            // Carregando o arquivo FXML
//            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/agifinancasfx/agifinancasfx/view/Login.fxml"));
//            Parent arquivo = fxmlLoader.load();
//            LoginController loginController = fxmlLoader.getController();
//            loginController.setUsuarioDAO(new UsuarioDAO());
//
//            // Obtendo a cena atual a partir do evento
//            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//
//            // Criando uma nova cena com o FXML carregado
//            Scene scene = new Scene(arquivo, 320, 640);
//
//            // Definindo a nova cena no Stage
//            stage.setScene(scene);
//            stage.show();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
}

