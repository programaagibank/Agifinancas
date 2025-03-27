package view.orcamento;

import control.OrcamentoControl;
import model.Categoria;
import model.Usuario;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Scanner;

public class OrcamentoView {
    private static Scanner sc = new Scanner(System.in);
    public static void startOrcamento(Usuario user) throws SQLException {
        int op = OrcamentoMetodo.menuOpcao();

        int idCategoria;
        switch (op){
            case 1:
                idCategoria = OrcamentoMetodo.obterIdcat(user);
                OrcamentoMetodo.cadastrarOrcamento(idCategoria);
                break;
            case 2:
                String dataInicial, dataFinal, ano, mes;
                System.out.println("Digite o ano que deseja consultar:");
                ano = sc.nextLine();
                System.out.println("Digite o mes que deseja consultar: ");
                mes = sc.nextLine();
                dataInicial = ano+"-"+mes+"-01";
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate data = LocalDate.parse(dataInicial, formatter);

                // Último dia do mês dessa data
                LocalDate ultimoDiaDoMes = data.with(TemporalAdjusters.lastDayOfMonth());

                // Converter o último dia do mês de volta para string no mesmo formato
                dataFinal = ultimoDiaDoMes.format(formatter);

                List<Categoria> listOrcamento = OrcamentoControl.listLimite(user);
                for (Categoria categoria : listOrcamento){
                    double valorAtual = OrcamentoControl.valorAtualCategoria(categoria, user, dataInicial,dataFinal);
                    System.out.printf("Categoria: %s --- Limite: R$ %.2f --- Atual: %.2f\n", categoria.getNome(), categoria.getLimite(), valorAtual);
                }
                break;
        }

    }
}
