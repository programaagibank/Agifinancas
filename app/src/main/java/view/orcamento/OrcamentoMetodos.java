package view.orcamento;

public class OrcamentoMetodos {
    //Cores
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    //Delay
    public static void Delay(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            // Trata a exceção internamente (ou relança como uma exceção não verificada)
            Thread.currentThread().interrupt(); // Restaura o estado de interrupção
            throw new RuntimeException("Thread interrompida durante o delay", e);
        }

    }

    public static void logoorcamento(){
        System.out.println(CYAN);
        System.out.println(" ██████╗ ██████╗  ██████╗ █████╗ ███╗   ███╗███████╗███╗   ██╗████████╗ ██████╗ ");
        System.out.println("██╔═══██╗██╔══██╗██╔════╝██╔══██╗████╗ ████║██╔════╝████╗  ██║╚══██╔══╝██╔═══██╗");
        System.out.println("██║   ██║██████╔╝██║     ███████║██╔████╔██║█████╗  ██╔██╗ ██║   ██║   ██║   ██║");
        System.out.println("██║   ██║██╔══██╗██║     ██╔══██║██║╚██╔╝██║██╔══╝  ██║╚██╗██║   ██║   ██║   ██║");
        System.out.println("╚██████╔╝██║  ██║╚██████╗██║  ██║██║ ╚═╝ ██║███████╗██║ ╚████║   ██║   ╚██████╔╝");
        System.out.println(" ╚═════╝ ╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝╚═╝  ╚═══╝   ╚═╝    ╚═════╝ ");
        System.out.println("                                                                                ");
        System.out.println(RESET);

    }


}
