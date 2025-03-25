package view.chatSuporte;

import model.Usuario;
import view.finalizacao.Finalizacaoview;

import java.util.Scanner;

public class ChatSuporte {
    private Scanner scanner;
    private ChatSuporteMetodo chatSuporteMetodo;

    public ChatSuporte() {
        scanner = new Scanner(System.in);
        this.chatSuporteMetodo = new ChatSuporteMetodo();
    }

    public void iniciarChatSuporte(Usuario usuarioAutenticado) {
        chatSuporteMetodo.cabecalhoSuporte();
        respostaSuporte();
    }

    private void respostaSuporte() {
        chatSuporteMetodo.mostrarPerguntasFrequentes();
        System.out.println("\nEscolha uma opção: (1 - 4)");
        int opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                System.out.println("\nPara cadastrar transação:\nAcesse Menu - Gastos Fixos");
                break;
            case 2:
                System.out.println("\nPara cadastrar metas:\nAcesse Menu - Metas");
                break;
            case 3:
                System.out.println("\nPara cadastrar categorias:\nAcesse Menu - Categorias");
                break;
            case 4:
                System.out.println("\nDigite sua duvida: ");
                String duvida = scanner.nextLine();
                chatSuporteMetodo.mostrarRespostaPadrao();
                break;
            case 5:
                Finalizacaoview.Fim();
                System.out.println(0);
                break;
            default:
                System.out.println("\nOpção inválida!");
        }
    }
}
