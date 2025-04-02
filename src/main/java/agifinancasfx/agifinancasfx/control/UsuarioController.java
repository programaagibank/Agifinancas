package agifinancasfx.agifinancasfx.control;

import agifinancasfx.agifinancasfx.DAO.UsuarioDAO;
import agifinancasfx.agifinancasfx.Model.Usuario;
public class UsuarioController {
    private UsuarioDAO usuarioDAO;

    public UsuarioController(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }
    public void cadastrarUsuario(Usuario usuario) {
        //usuarioView.cabecalho();
        //String[] dados = usuarioView.coletarDados();

        String cpf = usuario.getCPF();
        String nome = usuario.getNome();
        String sobrenome = usuario.getSobrenome();
        String senha = usuario.getSenha();
        String email = usuario.getEmail();

        if (usuarioDAO.existeUsuario(cpf)) {
            //usuarioView.mensagemErro("CPF já cadastrado");
            return;
        }
        String senhaHash = Senha.hashSenha(senha);
        if (usuarioDAO.criarUsuario(usuario)) {
            //usuarioView.mensagemSucesso("Usuário cadastrado com sucesso!");
        } else {
            //usuarioView.mensagemErro("Erro ao cadastrar usuario");
        }
    }

}
