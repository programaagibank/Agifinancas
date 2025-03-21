package DAO;

import com.mysql.cj.protocol.Resultset;
import model.Categoria;
import model.JDBC_Connection;
import java.sql.ResultSet;
import java.sql.*;

public class CategoriaDAO {

    public static Categoria insert(int idCategoria, int idUsuario, String nome, String tipo) throws SQLException {
        String sql = "INSERT INTO categoria (id_categoria, id_usuario, nome, tipo) VALUES (?, ?, ?, ?)";
        try (Connection conn = JDBC_Connection.getConnection()) {
            PreparedStatement stm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setInt(1, idCategoria);
            stm.setInt(2, idUsuario);
            stm.setString(3, nome);
            stm.setString(4, tipo);
            int rowsAffected = stm.executeUpdate();
            if (rowsAffected > 0) {
                try (ResultSet rs = stm.getGeneratedKeys()) {
                    if (rs.next()) {
                        int generatedId = rs.getInt(1);
                        return new Categoria(generatedId, nome, tipo);
                    }
                } catch (SQLException e) {
                    System.out.println("Erro ao inserir categoria: " + e.getMessage());
                    e.printStackTrace();
                }
            }
            return null;
        }
    }

    public static Categoria buscar(int id){
        String sql = "SELECT nome, tipo FROM categoria WHERE id_categoria = ? AND id_usuario = ?";
        try (Connection conn = JDBC_Connection.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()){
                if (rs.next()){
                    return new Categoria(
                            id, rs.getString("nome"),
                            rs.getString("tipo"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar categoria: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public static Categoria update(int idUsuario, int idCategoria, String nome, String tipo){
        String sql = "UPDATE categoria SET nome = ?, tipo = ? WHERE id_categoria = ? AND id_usuario = ?";
        try (Connection conn = JDBC_Connection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, tipo);
            stmt.setInt(3, idCategoria);
            stmt.setInt(4, idUsuario);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                return new Categoria(
                    idUsuario, idCategoria, nome, tipo);
            }
        }    catch (SQLException e) {
            System.out.println("Erro ao atualizar categoria: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public static Categoria delete(int idCategoria, int idUsuario){
        String sql = "DELETE FROM categoria WHERE id_categoria = ? AND id_usuario = ?";
        try (Connection conn = JDBC_Connection.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idCategoria);
            stmt.setInt(2, idUsuario);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Categoria deletado com sucesso!");
                return new Categoria();
            }
        }   catch (SQLException e) {
            System.out.println("Erro ao deletar categoria: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

}
