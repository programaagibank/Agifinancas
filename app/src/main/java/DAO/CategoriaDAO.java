package DAO;

import model.Categoria;
import model.JDBC_Connection;
import java.sql.ResultSet;
import java.sql.*;

public class CategoriaDAO {

    public static Categoria insert(int idUsuario, String nome, String tipo) throws SQLException {
        String sql = "INSERT INTO categoria (id_usuario, nome, tipo) VALUES ( ?, ?, ?)";
        try (Connection conn = JDBC_Connection.getConnection()) {
            PreparedStatement stm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setInt(1, idUsuario);
            stm.setString(2, nome);
            stm.setString(3, tipo);
            int rowsAffected = stm.executeUpdate();
            if (rowsAffected > 0) {
                try (ResultSet rs = stm.getGeneratedKeys()) {
                    if (rs.next()) {
                        int generatedId = rs.getInt(1);
                        return new Categoria(generatedId, nome, tipo);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }

    public static Categoria buscar(int idCategoria, int idUsuario){
        String sql = "SELECT nome, tipo FROM categoria WHERE id_categoria = ? AND id_usuario = ?";
        try (Connection conn = JDBC_Connection.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idCategoria);
            stmt.setInt(2, idUsuario);
            try (ResultSet rs = stmt.executeQuery()){
                if (rs.next()){
                    return new Categoria(
                            idCategoria,
                            rs.getString("nome"),
                            rs.getString("tipo"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Categoria update(int idCategoria, int idUsuario, String nome, String tipo){
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
                     idCategoria, idUsuario, nome, tipo);
            }
        }    catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean delete(int idCategoria, int idUsuario){
        String sql = "DELETE FROM categoria WHERE id_categoria = ? AND id_usuario = ?";
        try (Connection conn = JDBC_Connection.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idCategoria);
            stmt.setInt(2, idUsuario);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
