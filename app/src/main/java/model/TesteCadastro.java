package model;


import DAO.UsuarioDAO;

import java.sql.SQLException;

public class TesteCadastro {
    public static void main(String[] args) throws SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = new Usuario("12345678901", "felipe", "martins", "1234", "felipe123@gmail.com");
        usuarioDAO.insertUser(usuario);
    }
}


