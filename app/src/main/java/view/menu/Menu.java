package view.menu;

public class Menu extends MenuMetodos {
    public static void main(String[] args) {
        System.out.print(BLUE + "###############"+RESET);
        System.out.print(GREEN + " AgiFinanças "+RESET);
        System.out.print(BLUE + "###############\n"+RESET);
        System.out.println();
        Delay(500);


        System.out.println(Assistente + " Olá, Eu sou assistente da AgiFinaças"+ Sorrindo);
        Delay(1000);


        System.out.print(Assistente + " Você já tem Conta?:");
        Scanner sc = new Scanner(System.in);
        String resposta = sc.nextLine().toUpperCase();

        while (!resposta.equals("SIM") || !resposta.equals("NAO")){
            System.out.print("Por favor, responda sim ou nao");
            resposta = sc.nextLine().toUpperCase();
        }





    }
}
