package view.saldo;

public class Saldoview extends SaldoMetodos {
    public static void startsaldo(){
        saldologo();

        System.out.println(YELLOW);
        System.out.println(" O saldo será calculado a partir das receitas e despesas registradas em suas contas");
        System.out.println(RESET);

        System.out.println(RED+"As receitas registradas pelo usuario foram:"+RESET);
        // Aqui ira apresentar todas as receitas registradas pelo usuario

        System.out.println(RED+"As despesas registrada pelo usuario foram:"+RESET);
        // Aqui ira apresentar todas as despesas registradas pelo usuario

        System.out.println(RED+ "Saldo"+ RESET);
        // Aqui ira apresentar o saldo calculado

    }
}
