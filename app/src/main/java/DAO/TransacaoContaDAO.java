package DAO;

import model.JDBC_Connection;
import model.TransacaoConta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransacaoContaDAO {
    private final Connection connection;

    public TransacaoContaDAO() throws SQLException {
        connection = JDBC_Connection.getConnection();
    }

    public void inserirTransacao(TransacaoConta transacaoConta) throws SQLException {
        String sql = "INSERT INTO transacao_conta (id_usuario, id_conta, valor, data_transacao, tipo) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, transacaoConta.getIdUsuario());
            stmt.setInt(2, transacaoConta.getIdConta());
            stmt.setDouble(3, transacaoConta.getValor());
            stmt.setString(4, transacaoConta.getData());
            stmt.setString(5, transacaoConta.getTipo());
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

    public void deletarTransacao(int idUsuario, int idConta) throws SQLException {
        String sql = "DELETE FROM transacao_conta WHERE id_usuario = ? AND id_conta = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            stmt.setInt(2, idConta);
            stmt.executeUpdate();
        }
    }

    public List<TransacaoConta> buscarTransacoesPorUsuario(int idUsuario) throws SQLException {
        String sql = "SELECT * FROM transacao_conta WHERE id_usuario = ?";
        List<TransacaoConta> transacoes = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int idConta = rs.getInt("id_conta");
                double valor = rs.getDouble("valor");
                String data = rs.getString("data_transacao");
                String tipo = rs.getString("tipo");
                TransacaoConta transacaoConta = new TransacaoConta(idUsuario, idConta, valor, data, tipo);
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

    public static void main(String[] args) {
        TransacaoContaDAO trcdao = null;
        try {
            trcdao = new TransacaoContaDAO();
            TransacaoConta teste = new TransacaoConta(1, 1, 100, "2025-03-19", "deposito");
            TransacaoConta transacoes = trcdao.buscarTransacao(2);
            String iduser = transacoes.getData();
            System.out.println(iduser);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
