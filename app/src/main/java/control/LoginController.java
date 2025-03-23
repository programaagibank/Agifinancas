package control;

import DAO.UsuarioDAO;
import model.Usuario;
import control.UsuarioController;
import view.loginUsuario.UsuarioLogin;
import view.menu.Menu;

import java.sql.SQLException;

public class LoginController {
    private UsuarioDAO usuarioDAO;
    private UsuarioLogin usuarioLogin;

    public LoginController(UsuarioDAO usuarioDAO, UsuarioLogin usuarioLogin) {
        this.usuarioDAO = usuarioDAO;
        this.usuarioLogin = usuarioLogin;
    }

        public void login(String email, String pwd) throws SQLException {
            while(true) {
                String Email = email;
                String senha = pwd;
                Usuario usuario = usuarioDAO.buscarPorEmail(email);
                if (usuario != null && Senha.verificaSenha(senha, usuario.getSenha())) {
                    System.out.println("Login bem sucedido.");
                    Menu.Menu();
                    break;
                } else {
                    System.out.println("Email ou senha inválidos!");
                    UsuarioLogin usuarioLogin = new UsuarioLogin();
                    usuarioLogin.dadosLogin();
                }
            }
        }
}
