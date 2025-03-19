package DAO;

import model.JDBC_Connection;
import model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    private final Connection connection;
    private Connection conexao;

    public UsuarioDAO() throws SQLException {
        this.connection = JDBC_Connection.getConnection();
    }
    public boolean existeUsuario(String cpf) {
        String sql = "SELECT COUNT(*) FROM usuario WHERE cpf_usuario = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) >0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean iserirUsuario(User usuario) {
        String sql = "INSERT INTO usuario (cpf_usuario, nome_usuario, sobrenome_usuario, email_usuario, " +
                "senha_usuario) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, usuario.getCPF());
            stmt.setString(2, usuario.getNome());
            stmt.setString(3, usuario.getSobrenome());
            stmt.setString(4, usuario.getEmail());
            stmt.setString(5, usuario.getSenha());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
