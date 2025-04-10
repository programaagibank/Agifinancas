package agifinancasfx.agifinancasfx.DAO;

import agifinancasfx.agifinancasfx.Model.Categoria;
import agifinancasfx.agifinancasfx.Model.JDBC_Connection;
import agifinancasfx.agifinancasfx.Model.TransacaoConta;
import agifinancasfx.agifinancasfx.Model.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransacaoContaDAO {
    private final Connection connection;

    public TransacaoContaDAO() throws SQLException {
        connection = JDBC_Connection.getConnection();
    }
    public double calcularTotalReceitas(int idUsuario) {
        String sql = "SELECT SUM(valor) FROM transacao_conta WHERE id_usuario = ? AND tipo = 'Receita'";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public double calcularTotalDespesas(int idUsuario) {
        String sql = "SELECT SUM(valor) FROM transacao_conta WHERE id_usuario = ? AND tipo = 'Despesa'";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public double calcularSaldoGeral(int idUsuario) {
        double receitas = calcularTotalReceitas(idUsuario);
        double despesas = calcularTotalDespesas(idUsuario);
        return receitas - despesas;
    }



    public int buscarIdContaPorUsuario(int idUsuario) throws SQLException {
        String sql = "SELECT id_conta FROM conta_bancaria WHERE id_usuario = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id_conta");
            } else {
                throw new SQLException("Conta bancária não encontrada para o usuário com ID: " + idUsuario);
            }
        }
    }




    public void inserirTransacao(TransacaoConta transacaoConta) throws SQLException {
        String sql = "INSERT INTO transacao_conta (id_usuario, id_conta, id_categoria, valor, data_transacao, tipo) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, transacaoConta.getIdUsuario());
            stmt.setInt(2, transacaoConta.getIdConta());
            stmt.setInt(3, transacaoConta.getIdCategoria());
            stmt.setDouble(4, transacaoConta.getValor());
            stmt.setString(5, transacaoConta.getData());
            stmt.setString(6, transacaoConta.getTipo());
            stmt.executeUpdate();
        }
    }

    public void atualizarTransacao(TransacaoConta transacaoConta) throws SQLException {
        String sql = "UPDATE transacao_conta SET valor = ?, data_transacao = ?, tipo = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, transacaoConta.getValor());
            stmt.setString(2, transacaoConta.getData());
            stmt.setString(3, transacaoConta.getTipo());
            stmt.setInt(4, transacaoConta.getId());
            stmt.executeUpdate();
        }
    }

    public void deletarTransacao(int id) throws SQLException {
        String sql = "DELETE FROM transacao_conta WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public List<TransacaoConta> buscarTransacoesPorUsuario(int idUsuario) throws SQLException {
        String sql = "SELECT id_conta FROM transacao_conta WHERE id_usuario = ?";
        List<TransacaoConta> transacoes = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int idConta = rs.getInt("id_conta");
                TransacaoConta transacaoConta = new TransacaoConta(idUsuario, idConta);
                transacoes.add(transacaoConta);
            }
        }
        return transacoes;
    }

    public TransacaoConta buscarTransacao(int id) throws SQLException {
        String sql = "SELECT * FROM transacao_conta WHERE id = ? ";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int idUsuario = rs.getInt("id_usuario");
                int idConta = rs.getInt("id_conta");
                double valor = rs.getDouble("valor");
                String data = rs.getString("data_transacao");
                String tipo = rs.getString("tipo");

                return new TransacaoConta(idUsuario, idConta, valor, data, tipo);
            }
        }
        return null;
    }

    public double resultadoCategoria(Categoria categoria, Usuario user, String dataInicio, String dataFinal) {
        String sql = "SELECT SUM(valor) FROM transacao_conta WHERE id_categoria = ? AND id_usuario = ? AND data_transacao BETWEEN ? AND ?";
        try {
            double valor =0;
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, categoria.getId_categoria());
            stm.setInt(2, user.getIdUsuario());
            stm.setString(3, dataInicio);
            stm.setString(4, dataFinal);
            ResultSet rs = stm.executeQuery();
            if (rs.next()){
                valor = rs.getDouble(1);
            }
            return valor;



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public double calcularTotalGastoPorCategoria(int idUsuario, int idCategoria) {
        String sql = "SELECT SUM(valor) FROM transacao_conta WHERE id_usuario = ? AND id_categoria = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            stmt.setInt(2, idCategoria);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("ID Usuario: " + idUsuario + ", ID Categoria: " + idCategoria);
                return rs.getDouble(1); // ← valor somado
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0; // ← se nada for encontrado
    }
    public static List<TransacaoDTO> listarTransacoesPorUsuario(int idUsuario) {
        List<TransacaoDTO> transacoes = new ArrayList<>();

        String sql = """
        SELECT c.nome AS categoria, t.valor, t.data_transacao, t.tipo
        FROM transacao_conta t
        LEFT JOIN categoria c ON t.id_categoria = c.id_categoria
        WHERE t.id_usuario = ?
        ORDER BY t.data_transacao DESC
    """;

        try (Connection conn = JDBC_Connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                TransacaoDTO transacao = new TransacaoDTO();
                transacao.setCategoria(rs.getString("categoria"));
                transacao.setValor(rs.getBigDecimal("valor"));
                transacao.setDataTransacao(rs.getDate("data_transacao"));
                transacao.setTipo(rs.getString("tipo"));

                transacoes.add(transacao);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Ou use logging
        }

        return transacoes;
    }

    public static List<TransacaoDTO> listarTransacoesPorUsuarioEData(int idUsuario, Date dataInicio) {
        List<TransacaoDTO> transacoes = new ArrayList<>();

        String sql = """
        SELECT c.nome AS categoria, t.valor, t.data_transacao, t.tipo
        FROM transacao_conta t
        LEFT JOIN categoria c ON t.id_categoria = c.id_categoria
        WHERE t.id_usuario = ? AND t.data_transacao >= ?
        ORDER BY t.data_transacao DESC
    """;

        try (Connection conn = JDBC_Connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idUsuario);
            stmt.setDate(2, dataInicio);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                TransacaoDTO transacao = new TransacaoDTO();
                transacao.setCategoria(rs.getString("categoria"));
                transacao.setValor(rs.getBigDecimal("valor"));
                transacao.setDataTransacao(rs.getDate("data_transacao"));
                transacao.setTipo(rs.getString("tipo"));

                transacoes.add(transacao);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return transacoes;
    }


}
