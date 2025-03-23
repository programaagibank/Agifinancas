package view.loginUsuario;

import DAO.UsuarioDAO;
import com.mysql.cj.log.Log;
import control.LoginController;

import java.sql.SQLException;
import java.util.Scanner;

public class UsuarioLogin {
    private LoginController controller;
    public UsuarioLogin() {
    }

    public void dadosLogin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("⇒ Insira seu email: ");
        String email = sc.nextLine();
        System.out.println("⇒ Insira sua senha: ");
        String senha = sc.nextLine();
        UsuarioDAO dao = null;
        try {
            dao = new UsuarioDAO();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        LoginController controller = new LoginController(dao, this);
        try {
            controller.login(email, senha);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
