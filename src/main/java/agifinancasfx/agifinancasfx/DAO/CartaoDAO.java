package agifinancasfx.agifinancasfx.DAO;

import agifinancasfx.agifinancasfx.Model.JDBC_Connection;
import agifinancasfx.agifinancasfx.Model.Cartao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartaoDAO {
    public void createCartao(Cartao cartao) {
        String inserirCartao = "INSERT INTO cartao (id_usuario, nome, limite, data_fechamento, data_validade) values (?, ?, ?, ?, ?)";
        try (Connection conexao = JDBC_Connection.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(inserirCartao)) {
            stmt.setInt(1, cartao.getIdUsuario());
            stmt.setString(2, cartao.getNome());
            stmt.setDouble(3, cartao.getLimite());
            stmt.setString(4, cartao.getDataFechamento());
            stmt.setString(5, cartao.getDataValidade());
            stmt.executeUpdate();
            System.out.println("Cartão cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar cartão." + e.getMessage());
        }
    }

    public Cartao buscarPorId(int id_cartao) {
        String sql = "SELECT * FROM cartao WHERE id_cartao = ?";
        try (PreparedStatement stm = JDBC_Connection.getConnection().prepareStatement(sql)) {
            stm.setInt(1, id_cartao);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return new Cartao(
                        rs.getString("nome"),
                        rs.getDouble("limite"),
                        rs.getString("data_fechamento"),
                        rs.getString("data_validade"),
                        rs.getInt("id_cartao"),
                        rs.getInt("id_usuario")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar categoria: " + e.getMessage(), e);
        }
        return null;
    }


    public void atualizarCartao(Cartao cartao) {
        String atualizar = "UPDATE cartao SET nome = ?, limite = ?, data_fechamento = ?, data_validade = ?, id_usuario = ? WHERE id_cartao = ?";
        try (Connection conexao = JDBC_Connection.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(atualizar)) {
            stmt.setString(1, cartao.getNome());
            stmt.setDouble(2, cartao.getLimite());
            stmt.setString(3, cartao.getDataFechamento());
            stmt.setString(4, cartao.getDataValidade());
            stmt.setInt(5, cartao.getIdUsuario());
            stmt.setInt(6, cartao.getIdCartao());
            stmt.executeUpdate();
            System.out.println("Cartão atualizado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar cartão." + e.getMessage());
        }
    }

    public void deletarCartao(Cartao cartao) {
        String deletar = "DELETE FROM cartao WHERE id_cartao = ?";
        try (Connection conexao = JDBC_Connection.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(deletar)) {
            stmt.setInt(1, cartao.getIdCartao());
            stmt.executeUpdate();
            System.out.println("Deletado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao deletar cartão.");
        }
    }

    public void salvarCartao(Cartao cartao) throws SQLException {
        String sql = "INSERT INTO cartao (nome, limite, data_fechamento, data_validade, id_usuario) VALUES (?, ?, ?, " +
                "?, ?)";
        try (Connection connection = JDBC_Connection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cartao.getNome());
            stmt.setDouble(2, cartao.getLimite());
            stmt.setString(3, cartao.getDataFechamento());
            stmt.setString(4, cartao.getDataValidade());
            stmt.setInt(5, cartao.getIdUsuario()); // Associando o id_usuario ao usuário autenticado
            stmt.executeUpdate();
        }
    }




    public List<Cartao> listarCartoesPorUsuario(int idUsuario) throws SQLException {
        List<Cartao> cartoes = new ArrayList<>();
        String sql = "SELECT * FROM cartao WHERE id_usuario = ?";

        try (Connection conn = JDBC_Connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cartao cartao = new Cartao(
                        rs.getString("nome"),
                        rs.getDouble("limite"),
                        rs.getString("data_fechamento"),
                        rs.getString("data_validade"),
                        rs.getInt("id_cartao"),
                        rs.getInt("id_usuario")
                );
                try {
                    cartao.setBandeira(rs.getString("bandeira"));
                } catch (SQLException e) {
                }
                try {
                    cartao.setDiaVencimento(rs.getInt("dia_vencimento"));
                } catch (SQLException e) {
                }
                cartoes.add(cartao);
            }
        }
        return cartoes;
    }
}
