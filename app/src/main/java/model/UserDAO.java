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
    public void queryUser (User user) {
        String query = "SELECT cpf_usuario, nome_usuario, sobrenome_usuario, senha_usuario FROM usuario";
        try (Connection conn = JDBC_Connection.getConnection()) {
            ResultSet rs = conn.createStatement().executeQuery(query);
            while (rs.next()) {
                String CPF = rs.getString("cpf_usuario");
                String nome = rs.getString("nome_usuario");
                String sobrenome = rs.getString("sobrenome_usuario");
                String senha = rs.getString("senha_usuario");
                System.out.println(CPF + ", " + nome + ", " + sobrenome + ", " + senha);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar usuário: " + e.getMessage());
        }
    }
}
