package agifinancasfx.agifinancasfx.DAO;

import agifinancasfx.agifinancasfx.Model.*;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MetaDAO {
    private JDBC_Connection conexao;

    public MetaDAO(JDBC_Connection conexao) {
        this.conexao = conexao;
    }

    public void inserirMeta(Meta meta) throws SQLException {
        String sql = "INSERT INTO meta (id_usuario, nome, valor, validade) VALUES (?, ?, ?, ?)";
        try (Connection conn = JDBC_Connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, meta.getId_usuario());
            stmt.setString(1, meta.getNome());
            stmt.setString(3, meta.getValor());
            stmt.setDate(4, meta.getValidade());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    meta.setId(generatedKeys.getInt(1));
                }
            }
        }
    }
    public Meta buscarMeta(int id) throws SQLException {
        String sql = "SELECT * FROM meta WHERE id_usuario = ?";
        try (Connection conn = JDBC_Connection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Meta(
                            rs.getInt("id_meta"),
                            rs.getInt("id_usuario"),
                            rs.getString("nome"),
                            rs.getString("valor"),
                            rs.getDate("validade")
                    );
                }
            }
        }
        return null;
    }
    public List<Meta> listarMeta(int idUsuario) throws SQLException {
        List<Meta> metas = new ArrayList<>();
        String sql = "SELECT * FROM meta ORDER BY id_meta DESC";
        try (Connection conn = JDBC_Connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    metas.add(new Meta(
                            rs.getInt("id_meta"),
                            rs.getInt("id_usuario"),
                            rs.getString("nome"),
                            rs.getString("valor"),
                            rs.getDate("validade")
                    ));
                }
            }
        }
        return metas;
    }
    public void excluirMeta(int id) throws SQLException {
        String sql = "DELETE FROM meta WHERE id_meta = ?";
        try (Connection conn = JDBC_Connection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

