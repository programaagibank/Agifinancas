package DAO;

import model.*;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MetaDAO {
    private Connection conexao;

    public MetaDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void inserirMeta(Meta meta) throws SQLException {
        String sql = "INSERT INTO meta (id_usuario, nome, valor, validade) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, meta.getId_usuario());
            stmt.setString(1, meta.getNome());
            stmt.setString(3, meta.getValor());
            stmt.setDate(4, meta.getValidade());
            stmt.executeUpdate();
        }
    }
}

