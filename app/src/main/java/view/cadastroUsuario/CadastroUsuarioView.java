package view.cadastroUsuario;

import DAO.UsuarioDAO;
import control.Senha;
import model.Usuario;
import view.chat.ChatView;

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

        System.out.println("⇒ Digite seu CPF: ");
        String cpf = scanner.nextLine();
        System.out.println("⇒ Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.println("⇒ Digite seu sobrenome: ");
        String sobrenome = scanner.nextLine();
        System.out.println("⇒ Digite seu email: ");
        String email = scanner.nextLine();
        System.out.println("⇒ Digite sua senha: ");
        String senha = scanner.nextLine();

        if (usuarioDAO.existeUsuario(cpf)) {
            mensagemErro("CPF já cadastrado");
            return;
        }
        String senhaHash = Senha.hashSenha(senha);
        Usuario usuario = new Usuario(cpf, nome, sobrenome, senhaHash, email);
        if (usuarioDAO.insertUser(usuario)) {
            mensagemSucesso("Usuario cadastrado com sucesso");
            Usuario usuarioAutenticado = new Usuario(usuario.getIdUsuario(), email, senhaHash);
            view.chat.ChatView chatView = new view.chat.ChatView();
            chatView.iniciarChat(usuarioAutenticado);
        } else {
            mensagemErro("Erro ao cadastrar usuario");
        }

    }

    private void redirecionarChat(Usuario usuarioAutenticado) {
        System.out.println("\nPor favor aguarde...");

        int tempoTotal = 3000;
        int barra = 30;
        int intervalo = tempoTotal / barra;

        System.out.println("[");
        for (int i = 0; i <= barra; i++) {
            try {
                Thread.sleep(intervalo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int porcentagem = (i * 100) / barra;
            System.out.println("█");
        }
        System.out.println("] 100%\n");
        ChatView chatView = new ChatView();
        chatView.iniciarChat(usuarioAutenticado);
    }

    public void mensagemErro(String mensagem) {
        cadastroUsuarioMetodos.mensagemErro(mensagem);
    }

    public void mensagemSucesso(String mensagem) {
        cadastroUsuarioMetodos.mensagemSucesso(mensagem);
    }
}
