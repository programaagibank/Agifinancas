package view;

import DAO.UsuarioDAO;
import view.cadastroUsuario.CadastroUsuarioView;

import java.sql.SQLException;

public class MainTeste {
    public static void main(String[] args) throws SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        CadastroUsuarioView cadastroUsuarioView = new CadastroUsuarioView(usuarioDAO);

        cadastroUsuarioView.cadastrarUsuario();
    }
}
