package agifinancasfx.agifinancasfx.DAO;


import agifinancasfx.agifinancasfx.Model.JDBC_Connection;
import agifinancasfx.agifinancasfx.Model.Usuario;

import java.sql.*;

public class UsuarioDAO {
    private final Connection connection;
    private Connection conexao;

    public UsuarioDAO() throws SQLException {
        this.connection = JDBC_Connection.getConnection();
    }

    public boolean criarUsuario(Usuario usuario) {
        String criarUsuario = "INSERT INTO Agifinancas.usuario (cpf_usuario, nome_usuario, sobrenome_usuario, email_usuario, senha_usuario) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = JDBC_Connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(criarUsuario, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, usuario.getCPF());
            stmt.setString(2, usuario.getNome());
            stmt.setString(3, usuario.getSobrenome());
            stmt.setString(4, usuario.getEmail());
            stmt.setString(5, usuario.getSenha());
            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    usuario.setIdUsuario(rs.getInt(1));
                }
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public Usuario buscarPorEmail (String email) {
        String selectUsuario = "SELECT id_usuario, email_usuario, senha_usuario FROM Agifinancas.usuario WHERE email_usuario = ?";
        try (Connection conn = JDBC_Connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(selectUsuario)) {
            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("id_usuario");
                    String Email = rs.getString("email_usuario");
                    String senha = rs.getString("senha_usuario");
                    return new Usuario(
                        id, Email, senha
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Usuario buscarPorId(int idUsuario) {
        String query = "SELECT cpf_usuario, nome_usuario, sobrenome_usuario, email_usuario, senha_usuario FROM usuario WHERE id_usuario = ?";
        try (Connection conn = JDBC_Connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(6, idUsuario);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Usuario(
                            rs.getString("cpf_usuario"),
                            rs.getString("nome_usuario"),
                            rs.getString("sobrenome_usuario"),
                            rs.getString("email_usuario"),
                            rs.getString("senha_usuario"),
                            rs.getInt("id_usuario")
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

    public void atualizarUsuario(Usuario usuario) {
        String update = "UPDATE usuario SET cpf_usuario = ?, nome_usuario = ?, sobrenome_usuario = ?, email_usuario = ?, senha_usuario = ? WHERE id_usuario = ?";
        try (Connection conn = JDBC_Connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(update)) {
            stmt.setString(1, usuario.getCPF());
            stmt.setString(2, usuario.getNome());
            stmt.setString(3, usuario.getSobrenome());
            stmt.setString(4, usuario.getEmail());
            stmt.setString(5, usuario.getSenha());
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

    public void deletarUsuario(Usuario usuarioAutenticado) {
        String delete = "DELETE FROM usuario WHERE id_usuario = ?";
        try (Connection conn = JDBC_Connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(delete)) {
            stmt.setInt(1, usuarioAutenticado.getIdUsuario());
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
