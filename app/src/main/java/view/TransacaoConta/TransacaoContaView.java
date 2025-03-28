package view.TransacaoConta;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TransacaoContaView {
    private Scanner scanner;

    public TransacaoContaView() {
        this.scanner = new Scanner(System.in);
    }

    public char solicitarTipoTransacao() {
        System.out.print("Tipo (R-Receita/D-Despesa): ");
        String input = scanner.nextLine();
        return input.isEmpty() ? ' ' : input.toUpperCase().charAt(0);
    }

    public double solicitarValor() {
        System.out.print("Valor: R$ ");
        return Double.parseDouble(scanner.nextLine());
    }

    public String solicitarData() {
        System.out.print("Data (dd/mm/aaaa): ");
        String dataInput = scanner.nextLine();

        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat dbFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = inputFormat.parse(dataInput);
            return dbFormat.format(date);
        } catch (ParseException e) {
            System.out.println("Formato de data inválido! Use dd/mm/aaaa");
            return solicitarData();
        }
    }

    public int solicitarConta() {
        System.out.print("ID da Conta: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public String solicitarCategoria() {
        System.out.print("Categoria: ");
        return scanner.nextLine();
    }

    public String solicitarDescricao() {
        System.out.print("Descrição (opcional): ");
        return scanner.nextLine();
    }

    public void mostrarSucesso() {
        System.out.println("Transação registrada com sucesso!");
    }

    public void mostrarErro(String mensagem) {
        System.out.println("Erro: " + mensagem);
    }
}
