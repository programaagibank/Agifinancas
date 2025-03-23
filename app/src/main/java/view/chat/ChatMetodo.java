package view.chat;

public class ChatMetodo {

    String bold = "\033[1m";  // Ativa o negrito
    String reset = "\033[0m"; // Reseta o formato (negrito, cor, etc.)
    String cyan = "\u001B[36m";

    public void cabecalhoChat() {

        System.out.println(cyan);
        System.out.println(bold + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println(bold + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println(bold + "⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣾⣿⣿⣿⣿⣿⣿⣿⣷⣶⣶⣤⡀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println(bold + "⠀⠀⠀⠀⠀⠀⠀⣰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣆⠀⠀⠀⠀⠀⠀");
        System.out.println(bold + "⠀⠀⠀⠀⠀⠀⣰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀");
        System.out.println(bold + "⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠋⠀⠻⣿⣿⣿⣿⡆⠀⠀⠀⠀⠀");
        System.out.println(bold + "⠀⠀⠀⠀⠀⠸⣿⣿⣿⣿⣿⣿⡿⠟⠋⠁⠀⠀⠀⠀⠈⠛⢿⣿⡇⠀⠀⠀⠀⠀");
        System.out.println(bold + "⠀⠀⠀⠀⠀⠀⣿⣿⠁⢐⠒⠒⠂⠀⠀⠀⠀⠐⠒⠖⡂⠀⢸⣿⠁⠀⠀⠀⠀⠀");
        System.out.println(bold + "⠀⠀⠀⠀⠀⠀⣿⡟⡸⠋⠉⢩⣁⠀⠀⠀⠀⣪⠍⠉⠙⢇⣀⣿⠀⠀⠀⠀⠀⠀");
        System.out.println(bold + "⠀⠀⠀⠀⠀⠀⠐⠙⠃⠀⠘⠿⠟⠀⠀⠀⠀⠻⠿⠀⠀⠈⠁⡕⠀⠀⠀⠀⠀⠀");
        System.out.println(bold + "⠀⠀⠀⠀⣠⣶⣴⡀⠀⠀⠀⠀⠀⠀⠄⠀⠀⠀⠀⠀⠀⠀⠀⣶⣴⣄⠀⠀⠀⠀" );
        System.out.println(bold + "⠀⠀⠐⣾⣿⣿⣿⣷⡀⠀⠀⠀⠸⣦⣤⣤⡶⠁⠀⠀⠀⢀⣼⣿⣿⣿⣷⠂⠀⠀");
        System.out.println(bold + "⠀⠀⠀⠀⠉⠛⠿⠿⠿⠗⠀⠀⠀⠈⠉⠁⠀⠀⠀⠀⠲⠿⠿⠿⠛⠉⠀⠀⠀⠀");
        System.out.println(bold + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println(bold + "⇒ Bem-vindo ao agiFinanças, eu sou a Gih ⇐");
        System.out.println(bold + "Para começar, me responda algumas perguntas que vou montar seu perfil tudo bem?");
        System.out.println(reset);
    }
    public void cabecalhoReceitaMensal() {
        System.out.println(cyan);
        System.out.println(bold + "Cadastro de receita mensal");
        System.out.println(reset);
    }
    public void cabecalhoCartaoCredito() {
        System.out.println(cyan);
        System.out.println(bold + "Cadastro de cartão de crédito" + reset);
        System.out.println(cyan + "Informe sua receita mensal para começar seu planejamento financeiro");
        System.out.println(reset);
    }
    public void cabecalhoDespesaFixa() {
        System.out.println(cyan);
        System.out.println(bold + "Cadastro de despesa fixa/recorrente" + reset);
    }
    public void mostrarCategoriasChat() {
        System.out.println(cyan);
        System.out.println(bold + "Categorias disponíveis: Alimentação - Saúde - Transporte - Moradia - Lazer" + reset);
    }
    public void mensagemSucesso(String mensagem) {
        System.out.println(cyan);
        System.out.println(bold + mensagem + reset);
    }
    public void mensagemErro(String mensagem) {
        System.out.println(cyan);
        System.out.println(bold + mensagem + reset);
    }
}
