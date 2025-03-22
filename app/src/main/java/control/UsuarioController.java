package control;

import DAO.UsuarioDAO;
import model.Usuario;
import view.cadastroUsuario.UsuarioView;

public class UsuarioController {
    private UsuarioView usuarioView;
    private UsuarioDAO usuarioDAO;

    public UsuarioController(UsuarioView usuarioView, UsuarioDAO usuarioDAO) {
        this.usuarioView = usuarioView;
        this.usuarioDAO = usuarioDAO;
    }
    public void cadastrarUsuario() {
        usuarioView.cabecalho();
        String[] dados = usuarioView.coletarDados();

        String nome = dados[0];
        String sobrenome = dados[1];
        String cpf = dados[2];
        String email = dados[3];
        String senha = dados[4];

        if (usuarioDAO.existeUsuario(cpf)) {
            usuarioView.mensagemErro("CPF já cadastrado");
            return;
        }
        Usuario usuario = new Usuario(cpf, nome, sobrenome, email, senha);
        if (usuarioDAO.insertUser(usuario)) {
            usuarioView.mensagemSucesso("Usuário cadastrado com sucesso!");
        } else {
            usuarioView.mensagemErro("Erro ao cadastrar usuario");
        }
    }
}
