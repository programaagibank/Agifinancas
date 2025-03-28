package DAO;

import model.Categoria;
import model.JDBC_Connection;
import model.Usuario;
import org.checkerframework.checker.units.qual.A;

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

    public void atualizarCategoria(Usuario usuarioAutenticado, String nome, String novoNome) throws SQLException {
        String sql = "UPDATE categoria SET nome = ? WHERE id_usuario = ? AND nome = ?";
        PreparedStatement stm;
        try {
            stm = conn.prepareStatement(sql);
            stm.setString(1, novoNome);
            stm.setString(2, usuarioAutenticado.getNome());
            stm.setString(3, nome);
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

    public void deletar(Usuario usuarioAutenticado, String nome) throws SQLException {
        String sql = "DELETE FROM categoria WHERE id_usuario = ? AND nome = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, usuarioAutenticado.getIdUsuario());
            stmt.setString(2, nome);
            stmt.executeUpdate();
        }
    }

    public Categoria buscarPorId(int id_categoria) {
        String sql = "SELECT * FROM categoria WHERE id_usuario = ?";
        try (PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setInt(1, id_categoria);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return new Categoria(
                        rs.getInt("id_usuario"),
                        rs.getString("nome"),
                        rs.getString("tipo"),
                        rs.getDouble("limite")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar categoria: " + e.getMessage(), e);
        }
        return null;
    }

    public List<Categoria> consultarCategorias(Usuario usuarioAutenticado) {
        String sql = "SELECT nome, tipo, limite FROM Agifinancas.categoria WHERE id_usuario = ?";
        List<Categoria> categorias = new ArrayList<>();
        try (PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setInt(1, usuarioAutenticado.getIdUsuario());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Categoria categoria = new Categoria(
                        rs.getString("nome"),
                        rs.getString("tipo"),
                        rs.getDouble("limite")
                );
                //categoria.setId_categoria(rs.getInt("id_categoria"));
                categorias.add(categoria);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar categorias do usuário: " + e.getMessage(), e);
        }
        return categorias;
    }
    public Categoria CriarCategoria(Usuario usuarioAutenticado, Categoria categoria) {
        String sql = " INSERT INTO categoria (id_usuario, nome, tipo, limite) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, usuarioAutenticado.getIdUsuario());
            stmt.setString(2, categoria.getNome());
            stmt.setString(3, categoria.getTipo());
            stmt.setDouble(4, categoria.getLimite());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar categoria: " + e.getMessage(), e);
        }
        return null;
    }
    public void criarLimite(int idCat, double limite){
        String sql = "UPDATE categoria SET limite = ? WHERE id_categoria = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setDouble(1, limite);
            stmt.setInt(2, idCat);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar categoria: " + e.getMessage(), e);
        }
    }

    public Categoria validacao(int id_categoria, int idUser) {
        String sql = "SELECT * FROM categoria WHERE id_categoria = ? AND id_usuario = ?";
        try (PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setInt(1, id_categoria);
            stm.setInt(2, idUser);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return new Categoria(
                        rs.getInt("id_usuario"),
                        rs.getString("nome"),
                        rs.getString("tipo"),
                        rs.getDouble("limite")

                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar categoria: " + e.getMessage(), e);
        }
        return null;
    }
    public List<Categoria> listaLimites(Usuario user){
        String sql = "SELECT * FROM categoria WHERE limite > 0 AND id_usuario = ?";
        List<Categoria> cat = new ArrayList<>();
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, user.getIdUsuario());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Categoria categoria = new Categoria(
                        rs.getInt("id_usuario"),
                        rs.getString("nome"),
                        rs.getString("tipo"),
                        rs.getDouble("limite")
                );
                categoria.setId_categoria(rs.getInt("id_categoria"));
                cat.add(categoria);
            }
            return cat;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}



