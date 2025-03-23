package model;


import DAO.UsuarioDAO;
import control.Senha;

import java.sql.SQLException;

public class TesteCadastro {
    public static void main(String[] args) throws SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        String senhaUsuario = Senha.hashSenha("1234");
        Usuario usuario = new Usuario("12312312312", "Felipe", "Rodrigues", senhaUsuario, "felipe@email.com");
        usuarioDAO.insertUser(usuario);
    }
}


