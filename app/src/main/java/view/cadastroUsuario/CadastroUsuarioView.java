package view.cadastroUsuario;

import DAO.UsuarioDAO;
import model.Usuario;

import java.util.Scanner;

public class CadastroUsuarioView {
    private UsuarioDAO usuarioDAO;
    private Scanner scanner;
    private CadastroUsuarioMetodos cadastroUsuarioMetodos;

    public CadastroUsuarioView(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
        this.scanner = new Scanner(System.in);
        this.cadastroUsuarioMetodos = new CadastroUsuarioMetodos();
    }
    public void cabecalho() {
        cadastroUsuarioMetodos.cabecalho();
    }

    public void cadastrarUsuario() {
        cabecalho();

        System.out.println("⇒ Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.println("⇒ Digite seu sobrenome: ");
        String sobrenome = scanner.nextLine();
        System.out.println("⇒ Digite seu CPF: ");
        String cpf = scanner.nextLine();
        System.out.println("⇒ Digite seu email: ");
        String email = scanner.nextLine();
        System.out.println("⇒ Digite sua senha: ");
        String senha = scanner.nextLine();

        if (usuarioDAO.existeUsuario(cpf)) {
            mensagemErro("CPF já cadastrado");
            return;
        }
        Usuario usuario = new Usuario(0, nome, sobrenome, cpf, email, senha);
        if (usuarioDAO.insertUser(usuario)) {
            mensagemSucesso("Usuario cadastrado com sucesso");
        } else  {
            mensagemErro("Erro ao cadastrar usuario");
        }
    }
    public void mensagemErro(String mensagem) {
        cadastroUsuarioMetodos.mensagemErro(mensagem);
    }
    public void mensagemSucesso(String mensagem) {
        cadastroUsuarioMetodos.mensagemSucesso(mensagem);
    }
}
