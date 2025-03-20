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

    public void insert(Categoria categoria) throws SQLException {
        String sql = "INSERT INTO categoria (id_usuario, nome, tipo) VALUES (?, ?, ?)";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, categoria.getId_usuario());
        stm.setString(2, categoria.getNome());
        stm.setString(2, categoria.getTipo());
        stm.executeUpdate();
    }
}
