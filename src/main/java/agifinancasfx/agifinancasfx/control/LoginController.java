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
        if (usuario != null && Senha.verificaSenha(passwordText.getText(), usuario.getSenha())) {
            CriarAlertas.CriarAlerta("Info", "Login efetuado com sucesso!");
            this.usuarioAutenticado = this.usuarioDAO.buscarPorEmail(emailText.getText());
            UsuarioSessao.getInstance().setUsuario(usuarioAutenticado);
            // Navegar para view Menu
            try {
                // Carregar FXML do Menu
                GeradorCenas cenas = new GeradorCenas();
                cenas.gerarNovoStage("/agifinancasfx/agifinancasfx/view/Menu.fxml", "Menu", false, actionEvent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            CriarAlertas.CriarAlerta("Info", "Email ou senha inválidos!");
        }
    }

    @FXML
    private void fazerCadastro(ActionEvent event) {
        try {
            GeradorCenas cenas = new GeradorCenas();
            cenas.gerarNovoStage("/agifinancasfx/agifinancasfx/view/CadastroUsuario.fxml", "Cadastro", false, event);
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
            cenas.gerarNovoStage("/agifinancasfx/view/esqueceuSenha.fxml", "Esqueceu senha", false, event);
        } catch (Exception e) {
            System.out.println("Erro ao efetuar troca de senha" + e.getMessage());
            e.printStackTrace();
        }
    }
}
