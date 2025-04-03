package agifinancasfx.agifinancasfx.control;

import agifinancasfx.agifinancasfx.DAO.UsuarioDAO;
import agifinancasfx.agifinancasfx.Model.Usuario;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.SQLException;

public class LoginController {
    @FXML
    private TextField emailText;
    @FXML
    private PasswordField passwordText;
    @FXML private Label loginSucedidoLabel;
    private UsuarioDAO usuarioDAO;
    Usuario usuarioAutenticado;

    public void setLoginSucedidoLabel(Label loginSucedidoLabel, Usuario usuarioAutenticado) {
        loginSucedidoLabel.setText("Login bem sucedido, bem vindo de volta " + usuarioAutenticado.getNome());
    }
    public void setLoginFalhoLabel(Label loginSucedidoLabel, Usuario usuarioAutenticado) {
        loginSucedidoLabel.setText("Email ou senha inválidos!");
    }

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
            setLoginSucedidoLabel(loginSucedidoLabel, usuario);
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
                Scene menuScene = new Scene(menuRoot, 412, 912);




                // Settar nova scene
                stage.setScene(menuScene);
                stage.setTitle("Menu Principal");
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setLoginFalhoLabel(loginSucedidoLabel, usuarioAutenticado);
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
