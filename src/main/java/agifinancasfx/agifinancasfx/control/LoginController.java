package agifinancasfx.agifinancasfx.control;

import agifinancasfx.agifinancasfx.DAO.UsuarioDAO;
import agifinancasfx.agifinancasfx.Model.Usuario;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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

        if (emailText.getText().isEmpty() || passwordText.getText().isEmpty()) {
            CriarAlertas.CriarAlerta("Erro", "Campos não podem ser vazios!", Alert.AlertType.ERROR);
        } else {
            if (usuario != null && Senha.verificaSenha(passwordText.getText(), usuario.getSenha())) {
                // Remove alerta de login efetuado com sucesso
                this.usuarioAutenticado = this.usuarioDAO.buscarPorEmail(emailText.getText());
                UsuarioSessao.getInstance().setUsuario(usuarioAutenticado);
                try {
                    GeradorCenas.primaryStage.setResizable(false);
                    GeradorCenas.loadScene(GeradorCenas.primaryStage, "Home");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                CriarAlertas.CriarAlerta("Erro", "Email ou senha inválidos!", Alert.AlertType.ERROR);
            }
        }
    }


    @FXML
    private void fazerCadastro(ActionEvent event) {
        try {
            GeradorCenas.primaryStage.setResizable(false);
            GeradorCenas.loadScene(GeradorCenas.primaryStage, "CadastroUsuario");
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
            GeradorCenas cenas = new GeradorCenas();
            cenas.gerarNovoStage("esqueceuSenha.fxml", "Redefinir senha", false, event);
        } catch (Exception e) {
            CriarAlertas.CriarAlerta("Erro", "Erro na solicitação", Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }
}
