package model;


import DAO.CategoriaDAO;
import DAO.UsuarioDAO;
import control.Senha;

import java.sql.SQLException;

public class TesteCadastro {
    public static void main(String[] args) throws SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        //categoriaDAO.CriarCategoria("Alimentação", 2000.0, "Despesa");
//        String senhaUsuario = Senha.hashSenha("1234");
//        Usuario usuario = new Usuario("12312312312", "Felipe", "Rodrigues", senhaUsuario, "felipe@email.com");
//        usuarioDAO.insertUser(usuario);
    }
}


