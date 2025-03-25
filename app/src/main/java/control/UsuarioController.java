package control;

import DAO.UsuarioDAO;
import model.Usuario;
import view.cadastroUsuario.CadastroUsuarioView;
import view.cadastroUsuario.CadastroUsuarioView;
import control.Senha;

public class UsuarioController {
    private CadastroUsuarioView usuarioView;
    private UsuarioDAO usuarioDAO;

    public UsuarioController(CadastroUsuarioView usuarioView, UsuarioDAO usuarioDAO) {
        this.usuarioView = usuarioView;
        this.usuarioDAO = usuarioDAO;
    }
    public void cadastrarUsuario(Usuario usuario) {
        usuarioView.cabecalho();
        //String[] dados = usuarioView.coletarDados();

        String cpf = usuario.getCPF();
        String nome = usuario.getNome();
        String sobrenome = usuario.getSobrenome();
        String senha = usuario.getSenha();
        String email = usuario.getEmail();

        if (usuarioDAO.existeUsuario(cpf)) {
            usuarioView.mensagemErro("CPF já cadastrado");
            return;
        }
        String senhaHash = Senha.hashSenha(senha);
        if (usuarioDAO.insertUser(usuario)) {
            usuarioView.mensagemSucesso("Usuário cadastrado com sucesso!");
        } else {
            usuarioView.mensagemErro("Erro ao cadastrar usuario");
        }
    }

}
