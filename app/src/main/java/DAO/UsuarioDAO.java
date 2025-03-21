package DAO;


import model.JDBC_Connection;
import model.Usuario;

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

    public boolean insertUser(Usuario usuario) {
        String insertUser = "INSERT INTO usuario (cpf_usuario, nome_usuario, sobrenome_usuario, senha_usuario, email_usuario) " +
                "VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = JDBC_Connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(insertUser)) {
            stmt.setString(1, usuario.getCPF());
            stmt.setString(2, usuario.getNome());
            stmt.setString(3, usuario.getSobrenome());
            stmt.setString(4, usuario.getSenha());
            stmt.setString(5, usuario.getEmail());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Usuario queryUser(int idUsuario) {
        String query = "SELECT cpf_usuario, nome_usuario, sobrenome_usuario, senha_usuario, email_usuario FROM usuario WHERE id_usuario = ?";
        try (Connection conn = JDBC_Connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idUsuario);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Usuario(
                            rs.getInt("id_usuario"),
                            rs.getString("cpf_usuario"),
                            rs.getString("nome_usuario"),
                            rs.getString("sobrenome_usuario"),
                            rs.getString("senha_usuario"),
                            rs.getString("email_usuario")
                    );
                } else {
                    System.out.println("Nenhum usuário encontrado com ID fornecido.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar usuário: " + e.getMessage());
        }
        return null;
    }

    public void updateUser(Usuario usuario) {
        String update = "UPDATE usuario SET cpf_usuario = ?, nome_usuario = ?, sobrenome_usuario = ?, senha_usuario = ?, email_usuario = ? WHERE id_usuario = ?";
        try (Connection conn = JDBC_Connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(update)) {
            stmt.setString(1, usuario.getCPF());
            stmt.setString(2, usuario.getNome());
            stmt.setString(3, usuario.getSobrenome());
            stmt.setString(4, usuario.getSenha());
            stmt.setString(5, usuario.getEmail());
            stmt.setInt(6, usuario.getIdUsuario());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Usuário atualizado com sucesso.");
            } else {
                System.out.println("Nenhuma atualização realizada. Verifique se o ID é válido.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar informações " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void deleteUser(Usuario usuario) {
        String delete = "DELETE FROM usuario WHERE id_usuario = ?";
        try (Connection conn = JDBC_Connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(delete)) {
            stmt.setInt(1, usuario.getIdUsuario());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Usuário deletado com sucesso.");
            } else {
                System.out.println("Nenhum usuário encontrado com esse ID.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao deletar usuário " + e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean existeUsuario(String cpf) {
        String sql = "SELECT COUNT(*) FROM usuario WHERE cpf_usuario = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
