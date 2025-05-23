package agifinancasfx.agifinancasfx.control;
import agifinancasfx.agifinancasfx.DAO.UsuarioDAO;
import agifinancasfx.agifinancasfx.Model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.sql.SQLException;

public class CadastrarController {
    @FXML
    private Button btnCadastrar;

    @FXML
    private Button btnFazerLogin;

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
        String senhaHash = "";
        if (password.equals(passwordagain)) {
            senhaHash = Senha.hashSenha(password);
        }
        Usuario usuario = new Usuario(cpf, nome, sobrenome, senhaHash, email);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        boolean sucesso = usuarioDAO.criarUsuario(usuario);

        if (sucesso) {
            limparCampos();
            try {
                GeradorCenas.primaryStage.setResizable(false);
                GeradorCenas.loadScene(GeradorCenas.primaryStage, "Login");
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
                GeradorCenas.primaryStage.setResizable(false);
                GeradorCenas.loadScene(GeradorCenas.primaryStage, "Login");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

