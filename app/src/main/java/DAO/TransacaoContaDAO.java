package DAO;

import model.TransacaoConta;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransacaoContaDAO {
    private Connection connection;

    public TransacaoContaDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserirTransacao(TransacaoConta transacaoConta) throws SQLException {
        String sql = "INSERT INTO transacao_conta (id_usuario, id_conta, valor, data, tipo) VALUES (?, ?, ?, ?, ?)";
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
        String sql = "UPDATE transacao_conta SET valor = ?, data = ?, tipo = ? WHERE id_usuario = ? AND id_conta = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, transacaoConta.getValor());
            stmt.setString(2, transacaoConta.getData());
            stmt.setString(3, transacaoConta.getTipo());
            stmt.setInt(4, transacaoConta.getIdUsuario());
            stmt.setInt(5, transacaoConta.getIdConta());
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
                String data = rs.getString("data");
                String tipo = rs.getString("tipo");
                TransacaoConta transacaoConta = new TransacaoConta(idUsuario, idConta, valor, data, tipo);
                transacoes.add(transacaoConta);
            }
        }
        return transacoes;
    }

    public TransacaoConta buscarTransacao(int idUsuario, int idConta) throws SQLException {
        String sql = "SELECT * FROM transacao_conta WHERE id_usuario = ? AND id_conta = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            stmt.setInt(2, idConta);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                double valor = rs.getDouble("valor");
                String data = rs.getString("data");
                String tipo = rs.getString("tipo");
                return new TransacaoConta(idUsuario, idConta, valor, data, tipo);
            }
        }
        return null;
    }
}
