package view.cadastroUsuario;

import java.util.Scanner;

public class UsuarioView {
    private VisualCadastroUsuario visualCadastroUsuario;

    public UsuarioView() {
        visualCadastroUsuario = new VisualCadastroUsuario();
    }
    public void cabecalho() {
        visualCadastroUsuario.cabecalho();
    }

    public String[] coletarDados() {
        Scanner sc = new Scanner(System.in);

        System.out.println("⇒ Digite seu nome: ");
        String nome = sc.nextLine();
        System.out.println("⇒ Digite seu sobrenome: ");
        String sobrenome = sc.nextLine();
        System.out.println("⇒ Digite seu CPF: ");
        String cpf = sc.nextLine();
        System.out.println("⇒ Digite seu email: ");
        String email = sc.nextLine();
        System.out.println("⇒ Digite sua senha: ");
        String senha = sc.nextLine();
        return new String[]{nome, sobrenome, cpf, email, senha};
    }
    public void mensagemErro(String mensagem) {
        visualCadastroUsuario.mensagemErro(mensagem);
    }
    public void mensagemSucesso(String mensagem) {
        visualCadastroUsuario.mensagemSucesso(mensagem);
    }
}
