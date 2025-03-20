package view.cadastroUsuario;

public class VisualCadastroUsuario {

    public void cabecalho() {
        System.out.println("\u001B[36m");
        System.out.println(" ██████╗  █████╗  ██████╗   █████╗  ███████╗ ████████╗ ██████╗   ██████╗ ");
        System.out.println("██╔════╝ ██╔══██╗ ██╔══██╗ ██╔══██╗ ██╔════╝ ╚══██╔══╝ ██╔══██╗ ██╔═══██╗");
        System.out.println("██║      ███████║ ██║  ██║ ███████║ ███████╗    ██║    ██████╔╝ ██║   ██║");
        System.out.println("██║      ██╔══██║ ██║  ██║ ██╔══██║ ╚════██║    ██║    ██╔══██╗ ██║   ██║");
        System.out.println("╚██████╗ ██║  ██║ ██████╔╝ ██║  ██║ ███████║    ██║    ██║  ██║ ╚██████╔╝");
        System.out.println(" ╚═════╝ ╚═╝  ╚═╝ ╚═════╝  ╚═╝  ╚═╝ ╚══════╝    ╚═╝    ╚═╝  ╚═╝  ╚═════╝ ");
        System.out.println("                                                                  ");
        System.out.println("\u001B[0m");
    }

    public void mensagemErro(String mensagem) {
        System.out.println("\u001B[31m" + mensagem + "\u001B[0m");
    }
    public void mensagemSucesso(String mensagem) {
        System.out.println("\u001B[32m" + mensagem + "\u001B[0m");
    }
}
