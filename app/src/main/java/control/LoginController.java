package control;

import DAO.UsuarioDAO;
import model.Usuario;
import view.loginUsuario.LoginView;
import view.menu.Menu;

import java.sql.SQLException;

public class LoginController {
    private UsuarioDAO usuarioDAO;
    private LoginView loginView;
    Usuario usuarioAutenticado;

    public LoginController(UsuarioDAO usuarioDAO, LoginView loginView) {
        this.usuarioDAO = usuarioDAO;
        this.loginView = loginView;
    }

    public Usuario login(String email, String pwd) throws SQLException {
        String Email = email;
        String senha = pwd;
        Usuario usuario = usuarioDAO.buscarPorEmail(email);
        if (usuario != null && Senha.verificaSenha(senha, usuario.getSenha())) {
            System.out.println("Login bem sucedido.");
            usuarioAutenticado = usuarioDAO.buscarPorEmail(email);
            Menu.menu(usuarioAutenticado);
        } else {
            System.out.println("Email ou senha inválidos!");
            LoginView loginView = new LoginView();
            loginView.dadosLogin();
        }
        return null;
    }
}
