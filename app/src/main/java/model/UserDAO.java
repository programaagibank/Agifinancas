package model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public void insertUser (User user){
        String insertUser = "INSERT INTO usuario (cpf_usuario, nome_usuario, sobrenome_usuario, senha_usuario) VALUES (?, ?, ?, ?)";
        try (Connection conn = JDBC_Connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(insertUser)){
            stmt.setString(1, user.getCPF());
            stmt.setString(2, user.getNome());
            stmt.setString(3, user.getSobrenome());
            stmt.setString(4, user.getSenha());
            stmt.executeUpdate();
            System.out.println("Cadastro realizado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar cliente: " +e.getMessage());
        }
    }
    public User queryUser (int idUsuario) {
        String query = "SELECT cpf_usuario, nome_usuario, sobrenome_usuario, senha_usuario, email_usuario FROM usuario WHERE id_usuario = ?";
        try (Connection conn = JDBC_Connection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setInt(1, idUsuario);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new User(
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
        }  catch (SQLException e) {
            System.out.println("Erro ao consultar usuário: " + e.getMessage());
        }
        return null;
    }
    public void updateUser (User user) {
        String update = "UPDATE usuario SET cpf_usuario = ?, nome_usuario = ?, sobrenome_usuario = ?, senha_usuario = ?, email_usuario = ? WHERE id_usuario = ?";
        try (Connection conn = JDBC_Connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(update)){
            stmt.setString(1, user.getCPF());
            stmt.setString(2, user.getNome());
            stmt.setString(3, user.getSobrenome());
            stmt.setString(4, user.getSenha());
	    stmt.setString(5, user.getEmail());
	    stmt.setInt (6, user.getId());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Usuário atualizado com sucesso.");
            } else {
                System.out.println("Nenhuma atualização realizada. Verifique se o ID é válido.");
            }
        } catch (SQLException e){
            System.out.println("Erro ao atualizar informações " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void deleteUser (User user) {
        String delete = "DELETE FROM usuario WHERE id_usuario = ?";
        try (Connection conn = JDBC_Connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(delete)){
            stmt.setInt(1, user.getId());
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
}
