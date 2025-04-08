package agifinancasfx.agifinancasfx.DAO;

import agifinancasfx.agifinancasfx.Model.JDBC_Connection;
import agifinancasfx.agifinancasfx.Model.Transacao_meta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Transacao_metaDAO {
    public void inserirTransacao (Transacao_meta transacao){
        String inserir = "INSERT INTO transacao_meta (id_transacao, id_meta, id_conta, valor, data, tipo) VALUES (?,?,?,?, ?, ?)";
        try (Connection conn = JDBC_Connection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(inserir);
            stmt.setInt(1, transacao.getIdTransacao());
            stmt.setInt(2, transacao.getIdMeta());
            stmt.setInt(3, transacao.getIdConta());
            stmt.setDouble(4, transacao.getValor());
            stmt.setDate(5, transacao.getDataTransacao());
            stmt.setString(6, transacao.getTipoTransacao());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Err ao inserir transação " + e.getMessage());
            e.printStackTrace();
        }
    }
    public Transacao_meta consultarTransacao (int idTransacao){
        String consultar = "SELECT * FROM transacao_meta WHERE id_transacao = ?";
        try (Connection conn = JDBC_Connection.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(consultar);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    return new Transacao_meta(
                            rs.getInt("id_transacao"),
                            rs.getInt("id_meta"),
                            rs.getInt("id_conta"),
                            rs.getDouble("valor"),
                            rs.getDate("data"),
                            rs.getString("tipo")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro: não foi encontrada transação " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    public void excluirTransacao (int idTransacao){
        String excluir = "DELETE FROM transacao_meta WHERE id_transacao = ?";
        try (Connection conn = JDBC_Connection.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(excluir);
            stmt.setInt(1, idTransacao);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Registro deletado com sucesso.");
            } else {
                System.out.println("Nenhuma transação encontrada com esse ID.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao deletar registro " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void alterarTransacao (Transacao_meta transacao){
        String atualizar = "UPDATE transacao_meta SET id_transacao = ?, id_meta = ?, id_conta = ?, valor = ?, data = ?, tipo = ? WHERE id_transacao = ?";
        try (Connection conn = JDBC_Connection.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(atualizar);
            stmt.setInt(1, transacao.getIdTransacao());
            stmt.setInt(2, transacao.getIdMeta());
            stmt.setInt(3, transacao.getIdConta());
            stmt.setDouble(4, transacao.getValor());
            stmt.setDate(5, transacao.getDataTransacao());
            stmt.setString(6, transacao.getTipoTransacao());
            stmt.executeUpdate();
            System.out.println("Registro alterado com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar registro " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Transacao_meta> listarTransacoes() {
        List<Transacao_meta> lista = new ArrayList<>();
        String sql = "SELECT * FROM transacao_meta";

        try (Connection conn = JDBC_Connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Transacao_meta t = new Transacao_meta(
                        rs.getInt("id_transacao"),
                        rs.getInt("id_meta"),
                        rs.getInt("id_conta"),
                        rs.getDouble("valor"),
                        rs.getDate("data"),
                        rs.getString("tipo")
                );
                lista.add(t);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar transações: " + e.getMessage());
            e.printStackTrace();
        }
        return lista;
    }

}
