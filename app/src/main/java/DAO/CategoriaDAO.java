package DAO;

import model.Categoria;
import model.JDBC_Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
    private Connection conn = JDBC_Connection.getConnection();

    public CategoriaDAO() throws SQLException {
    }

    public void update(Categoria categoria) {
        String sql = "UPDATE categoria SET nome = ?, tipo = ? WHERE id_categoria = ?";
        PreparedStatement stm = null;
        try {
            stm = conn.prepareStatement(sql);
            stm.setString(1, categoria.getNome());
            stm.setString(2, categoria.getTipo());
            stm.setInt(3, categoria.getId_categoria());
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insert(Categoria categoria) {
        String sql = "INSERT INTO categoria (id_usuario, nome, tipo) VALUES (?, ?, ?)";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, categoria.getId_usuario());
            stm.setString(2, categoria.getNome());
            stm.setString(3, categoria.getTipo());
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

    public Categoria buscarPorId(int id_categoria) {
        String sql = "SELECT * FROM categoria WHERE id_categoria = ?";
        try (PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setInt(1, id_categoria);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return new Categoria(
                        rs.getInt("id_usuario"),
                        rs.getString("nome"),
                        rs.getString("tipo")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar categoria: " + e.getMessage(), e);
        }
        return null;
    }

    public List<Categoria> buscarPorUsuario(int id_usuario) {
        String sql = "SELECT * FROM categoria WHERE id_usuario = ?";
        List<Categoria> categorias = new ArrayList<>();
        try (PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setInt(1, id_usuario);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Categoria categoria = new Categoria(
                        rs.getInt("id_usuario"),
                        rs.getString("nome"),
                        rs.getString("tipo")
                );
                categoria.setId_categoria(rs.getInt("id_categoria"));
                categorias.add(categoria);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar categorias do usuário: " + e.getMessage(), e);
        }
        return categorias;
    }


}
