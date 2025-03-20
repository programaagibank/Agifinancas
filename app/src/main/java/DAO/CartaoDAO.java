package DAO;

import model.JDBC_Connection;
import model.Cartao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
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
    public void consultaCartao (Cartao cartao){
        String query = "SELECT id_usuario, nome, limite, data_fechamento, data_validade FROM cartao";
        try(Connection conexao = JDBC_Connection.getConnection();
            ResultSet rs = conexao.createStatement().executeQuery(query)){
            int id_user = rs.getInt(1);
            String nomeCartao = rs.getString(2);
            Double limiteCartao = rs.getDouble(3);
            Date dataFechamento = rs.getDate(4);
            Date dataVencimento = rs.getDate(5);
            System.out.println("Consulta concluída!");
            System.out.println("Id usuário: " + id_user + "Nome do cartão: " + nomeCartao + "Limite do cartão: " + limiteCartao + "Data de fechamento: " + dataFechamento + "Data de vendcimento: " + dataVencimento);
        } catch (SQLException e) {
            System.out.println("Erro ao consultar dados do cartão " + e.getMessage());
        }
    }

    public void atualizarCartao(Cartao cartao) {
        String atualizar = "UPDATE cartao SET nome = ?, limite = ?, data_fechamento = ?, data_validade = ? id_usuario = ?";
        try (Connection conexao = JDBC_Connection.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(atualizar)) {
            stmt.setString(1, cartao.getNome());
            stmt.setDouble(2, cartao.getLimite());
            stmt.setString(3, cartao.getDataFechamento());
            stmt.setString(4, cartao.getDataValidade());
            stmt.executeUpdate();
            System.out.println("Cartão atualizado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar cartão." + e.getMessage());
        }
    }

    public void deletarCartao(Cartao cartao){
        String deletar = "DELETE FROM cartao WHERE id_usuario = ?";
        try (Connection conexao = JDBC_Connection.getConnection();
        PreparedStatement stmt = conexao.prepareStatement(deletar)){
            stmt.executeUpdate();
            System.out.println("Deletado com sucesso!");
        }catch(SQLException e) {
            System.out.println("Erro ao deletar cartão.");
        }
    }

    public static void main(String[] args) {
//        Cartao cr = new Cartao("card01", 1000, "2026-01-01", "2026-02-01",1);
//        CartaoDAO crdao = new CartaoDAO();
//        crdao.createCartao(cr);
        try {
            Connection conn = JDBC_Connection.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
