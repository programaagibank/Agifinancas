package DAO;

import model.Categoria;
import model.JDBC_Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategoriaDAO {
    private Connection conn = JDBC_Connection.getConnection();

    public CategoriaDAO() throws SQLException {
    }

    public void insert(Categoria categoria){
        String sql = "INSERT INTO categoria (id_usuario, nome, tipo) VALUES (?, ?, ?)";
        PreparedStatement stm = null;
        try {
            stm = conn.prepareStatement(sql);
            stm.setInt(1, categoria.getId_usuario());
            stm.setString(2, categoria.getNome());
            stm.setString(2, categoria.getTipo());
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void update(Categoria categoria){
        String sql = "INSERT INTO categoria (id_usuario, nome, tipo) VALUES (?, ?, ?)";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, categoria.getId_usuario());
            stm.setString(1, categoria.getNome());
            stm.setString(1, categoria.getTipo());
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM categoria WHERE id_categoria = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }


}
