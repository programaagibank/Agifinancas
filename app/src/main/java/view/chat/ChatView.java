package view.chat;

import model.Usuario;

import java.util.Scanner;

public class ChatView {
    private Scanner scanner;
    private ChatMetodo chatMetodo;
    // declarar os DAOs

    public ChatView(/* passar os DAOs aqui no construtor */) {
        this.scanner = new Scanner(System.in);
        this.chatMetodo = new ChatMetodo();
    }
    public void iniciarChat(Usuario usuarioAutenticado) {
        chatMetodo.cabecalhoChat();
    }
    private void cadastrarReceitaMensal() {
        chatMetodo.cabecalhoReceitaMensal();

        try {
            System.out.print("Qual é a sua receita mensal? ");
            double receitaMensal = scanner.nextDouble();

            System.out.print("Deseja salvar essa receita em uma conta específica? (S/N): ");
            String respostaReceita = scanner.next();
            String nomeConta;
            if (respostaReceita.equals("S")) {
                System.out.print("Qual o nome da conta? ");
                nomeConta = scanner.nextLine();
            } else {
                nomeConta = "Conta Secundária";
            }
            // lógica para salvar a receita mensal no banco (DAOs)
            chatMetodo.mensagemSucesso("Receita salva com sucesso na conta: " + nomeConta);
        } catch (Exception e) {
            chatMetodo.mensagemErro("Erro ao cadastrar a receita mensal" + e.getMessage());
        }
    }
    private void cadastrarCartaoCredito() {
        chatMetodo.cabecalhoCartaoCredito();
        try {
            System.out.print("Qual o nome do cartão? (ex: Agi, Itaú, American Express): ");
            String nomeCartao = scanner.nextLine();
            System.out.print("Qual o Limite do seu cartão? ");
            double limiteCartao = scanner.nextDouble();
            System.out.print("Qual a data de vencimento da fatura? ");
            int diaVencimento = Integer.parseInt(scanner.nextLine());

            // lógica para salvar o cartão de crédito no banco (DAOs)
            chatMetodo.mensagemSucesso("Cartão de crédito cadastrado!");
        } catch (Exception e) {
            chatMetodo.mensagemErro("Erro ao cadastrar o cartão de crédito" + e.getMessage());
        }
    }
    private void cadastrarDespesaFixa() {
        chatMetodo.cabecalhoDespesaFixa();

        try {
            System.out.print("Qual a descrição da despesa? (ex: Aluguel, Supermercado, Seguro): ");
            String descricaoDespesa = scanner.nextLine();
            System.out.print("Qual o valor da despesa? ");
            double valorDespesa = scanner.nextDouble();
            System.out.print("Qual a data de vencimento da despesa? (dd/mm/yyyy): ");
            String dataVencimentoDespesa = scanner.nextLine();

            chatMetodo.mostrarCategoriasChat();
            System.out.print("Categoria: ");
            String nomeCategoria = scanner.nextLine();

            // lógica para salvar as despesas fixas no banco (DAOs)
            chatMetodo.mensagemSucesso("Despesa fixa cadastrada!");
        } catch (Exception e) {
            chatMetodo.mensagemErro("Erro ao cadastrar uma despesa fixa" + e.getMessage());
        }
    }
}
