package view.loginUsuario;

import DAO.UsuarioDAO;
import control.LoginController;

import java.sql.SQLException;
import java.util.Scanner;

public class LoginView {
    private LoginController controller;
    public LoginView() {
    }

    public void dadosLogin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("⇒ Insira seu email: ");
        String email = sc.nextLine();
        System.out.println("⇒ Insira sua senha: ");
        String senha = sc.nextLine();
        UsuarioDAO dao;
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
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
