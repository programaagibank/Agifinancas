package view.home;

public class HomeMetodos {
    //Cores
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    //Emojis
    public static final String Assistente = "\uD83D\uDC69\uD83C\uDFFD\u200D\uD83E\uDDB1";
    public static final String Sorrindo = "\uD83D\uDE01";
    public static final String Coracao = "\uD83D\uDC9A\uD83D\uDC99";


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

    // logotipo
    public static void Logo(){
        System.out.println(CYAN);
        System.out.println(" █████╗   ██████╗  ██╗ ███████╗ ██╗ ███╗   ██╗  █████╗  ███╗   ██╗  ██████╗  █████╗  " +
                "███████╗");
        System.out.println("██╔══██╗ ██╔════╝  ██║ ██╔════╝ ██║ ████╗  ██║ ██╔══██╗ ████╗  ██║ ██╔════╝ ██╔══██╗ " +
                "██╔════╝");
        System.out.println("███████║ ██║  ███╗ ██║ █████╗   ██║ ██╔██╗ ██║ ███████║ ██╔██╗ ██║ ██║      ███████║ " +
                "███████╗");
        System.out.println("██╔══██║ ██║   ██║ ██║ ██╔══╝   ██║ ██║╚██╗██║ ██╔══██║ ██║╚██╗██║ ██║      ██╔══██║ " +
                "╚════██║");
        System.out.println("██║  ██║ ╚██████╔╝ ██║ ██║      ██║ ██║ ╚████║ ██║  ██║ ██║ ╚████║ ╚██████╗ ██║  ██║ " +
                "███████║");
        System.out.println("╚═╝  ╚═╝  ╚═════╝  ╚═╝ ╚═╝      ╚═╝ ╚═╝  ╚═══╝ ╚═╝  ╚═╝ ╚═╝  ╚═══╝  ╚═════╝ ╚═╝  ╚═╝ " +
                "╚══════╝");
        System.out.println(RESET);

    }

}
