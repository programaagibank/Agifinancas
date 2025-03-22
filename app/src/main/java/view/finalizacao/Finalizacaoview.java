package view.finalizacao;

public class Finalizacaoview extends FinalizacaoMetodos {

    public static void Fim() {
        Logofim();

        Delay(500);

        System.out.println(Assistente + "Até logo!" + Mão);

        Delay(500);

        System.out.print(RED + "Encerrando sistema ");

        for (int i = 0; i <=5; i++){
            System.out.print(".");
            Delay(1000);
        }
    }

}
