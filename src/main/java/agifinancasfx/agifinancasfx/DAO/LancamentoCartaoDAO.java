package agifinancasfx.agifinancasfx.DAO;

import agifinancasfx.agifinancasfx.Model.JDBC_Connection;
import agifinancasfx.agifinancasfx.Model.LancamentosCartao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LancamentoCartaoDAO {

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

    public LancamentosCartao queryLancamentosCartao(int idLancamentoCartao) {
        String sql = "SELECT * FROM Agifinancas.lancamentos_cartao WHERE id_lancamento_cartao = ?";
        try (Connection conn = JDBC_Connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idLancamentoCartao);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new LancamentosCartao(
                        rs.getInt("id_lancamento_cartao"),
                        rs.getInt("id_cartao"),
                        rs.getDouble("valor"),
                        rs.getString("data"),
                        rs.getBoolean("recorrencia")
                );
            }

        } catch (SQLException e) {
            System.out.println("Erro ao consultar lançamento: " + e.getMessage());
        }
        return null; // Retorna null caso não encontre
    }

    // READ - Lista todos os lançamentos de um determinado cartão
    public List<LancamentosCartao> listLancamentosCartao(int idCartao) {
        List<LancamentosCartao> lancamentos = new ArrayList<>();
        String sql = "SELECT * FROM Agifinancas.lancamentos_cartao WHERE id_cartao = ?";
        try (Connection conn = JDBC_Connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idCartao);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                lancamentos.add(new LancamentosCartao(
                        rs.getInt("id_lancamento_cartao"),
                        rs.getInt("id_cartao"),
                        rs.getDouble("valor"),
                        rs.getString("data"),
                        rs.getBoolean("recorrencia")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar lançamentos: " + e.getMessage());
        }
        return lancamentos;
    }

    // UPDATE - Atualiza um lançamento existente
    public void updateLancamento(LancamentosCartao lancamento) {
        String sql = "UPDATE Agifinancas.lancamentos_cartao SET id_cartao = ?, valor = ?, data = ?, recorrencia = ? WHERE id_lancamento_cartao = ?";
        try (Connection conn = JDBC_Connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, lancamento.getIdCartao());
            stmt.setDouble(2, lancamento.getValor());
            stmt.setString(3, lancamento.getData());
            stmt.setBoolean(4, lancamento.isRecorrencia());
            stmt.setInt(5, lancamento.getIdLancamentoCartao());

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Lançamento atualizado com sucesso!");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar lançamento: " + e.getMessage());
        }
    }

    // DELETE - Exclui um lançamento pelo ID
    public void deleteLancamento(int idLancamentoCartao) {
        String sql = "DELETE FROM Agifinancas.lancamentos_cartao WHERE id_lancamento_cartao = ?";
        try (Connection conn = JDBC_Connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idLancamentoCartao);

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Lançamento excluído com sucesso!");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao excluir lançamento: " + e.getMessage());
        }
    }
}


