package DAO;

import model.ContaBancaria;
import model.JDBC_Connection;
import model.LancamentosCartao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LancamentoCartaoDAO {
    public LancamentosCartao queryLancamentosCartao(int idLancamentoCartao) {

    }
    public List <LancamentosCartao> listLancamentosCartao(int idCartao) {
    }
        public void insertLancamento(LancamentosCartao lancamentos ) {
        String sql = "INSERT INTO Agifinancas.lancamentos_cartao (id_cartao, valor, data, recorrencia) VALUES (?, ?, ?, ?)";
        try (Connection conn = JDBC_Connection.getConnection()) {
             PreparedStatement stmt = conn.prepareStatement(sql);

                stmt.setInt(1, lancamentos.getIdCartao());
                stmt.setDouble(2, lancamentos.getValor());
                stmt.setString(3, lancamentos.getData());
                stmt.setBoolean(4, lancamentos.isRecorrencia());

                int linhasAfetadas = stmt.executeUpdate();
                if (linhasAfetadas > 0){
                    System.out.println("Dados salvo com sucesso!" );
                }

        } catch (SQLException e) {
            System.out.println("Erro ao inserir lançamento.: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
            // Lista para armazenar os lançamentos de cartões
            List<LancamentosCartao> lancamentos = new ArrayList<>();
            LancamentoCartaoDAO lancamentoCartaoDAO = new LancamentoCartaoDAO();

            // Criando lançamentos de cartão de exemplo
            lancamentos.add(new LancamentosCartao(1, 100, 150.75, new String(), true));  // Recorrente
            lancamentos.add(new LancamentosCartao(2, 102, 85.50, new String(), false)); // Não Recorrente
            lancamentos.add(new LancamentosCartao(3, 101, 200.00, new String(), true));  // Recorrente
            lancamentos.add(new LancamentosCartao(4, 103, 50.25, new String(), false)); // Não Recorrente
            lancamentoCartaoDAO.insertLancamento(new LancamentosCartao(4, 3, 50.25, "2025-03-12", false)); // Não Recorrente

            // Exibindo os lançamentos
            for (LancamentosCartao lancamento : lancamentos) {
                System.out.println(lancamento);
            }
    }
}



