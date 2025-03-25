package view.chatSuporte;

public class ChatSuporteMetodo {
    String bold = "\033[1m";
    String reset = "\033[0m";
    String cyan = "\u001B[36m";
    String red = "\033[31m";
    String green = "\033[32m";

    public void cabecalhoSuporte() {
        System.out.println(cyan + bold);
        System.out.println("███████╗ ██╗   ██╗ ██████╗   ██████╗  ██████╗  ████████╗ ███████╗");
        System.out.println("██╔════╝ ██║   ██║ ██╔══██╗ ██╔═══██╗ ██╔══██╗ ╚══██╔══╝ ██╔════╝");
        System.out.println("███████╗ ██║   ██║ ██████╔╝ ██║   ██║ ██████╔╝    ██║    █████╗  ");
        System.out.println("╚════██║ ██║   ██║ ██╔═══╝  ██║   ██║ ██╔══██╗    ██║    ██╔══╝  ");
        System.out.println("███████║ ╚██████╔╝ ██║      ╚██████╔╝ ██║  ██║    ██║    ███████╗");
        System.out.println("╚══════╝  ╚═════╝  ╚═╝       ╚═════╝  ╚═╝  ╚═╝    ╚═╝    ╚══════╝");
        System.out.println("                                                                 ");
        System.out.println(reset);
    }
    public void mostrarPerguntasFrequentes() {
        System.out.println(cyan + bold + "\nPerguntas Frequentes:" + reset);
        System.out.println(bold + "1 - Como cadastrar uma transação?");
        System.out.println("2 - Como definir uma meta?");
        System.out.println("3 - Como Cadastrar uma categoria?");
        System.out.println("4 - Digite sua dúvida aqui: ");
        System.out.println(reset);
    }
    public void mostrarRespostaPadrao() {
        System.out.println(bold + "Acesse nosso site para essa informação" + reset);
    }
}
