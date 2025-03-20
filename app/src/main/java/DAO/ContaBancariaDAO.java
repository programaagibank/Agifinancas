package DAO;

import model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ContaBancariaDAO {
    public void queryConta(ContaBancaria conta) {
        String query = "SELECT id_conta, id_usuario, saldo FROM Conta";
        try (Connection conn = JDBC_Connection.getConnection()) {
            ResultSet ct = conn.createStatement().executeQuery(query);
            while (ct.next()) {

                double saldo = ct.getDouble("saldo");
                double id_usuario = ct.getDouble("id_usuario");
                int id_conta = ct.getInt("id_conta");
                System.out.println(saldo + ", " + id_usuario + ", " + id_conta);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar conta: " + e.getMessage());
        }
    }

    public void insertConta(ContaBancaria conta) {
        String insertConta = "INSERT INTO Conta (id_usuario, saldo) VALUES (?, ?)";
        try (Connection conn = JDBC_Connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(insertConta)) {

            stmt.setInt(1,conta.getId_conta());
            stmt.setDouble(2, conta.getSaldo());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Conta cadastrada com sucesso!");
            } else {
                System.out.println("Erro ao cadastrar conta.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao inserir conta: " + e.getMessage());
        }
    }

    public void updateConta(ContaBancaria conta) {
        String updateConta = "UPDATE Conta SET saldo = ? WHERE id_conta = ?";
        try (Connection conn = JDBC_Connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(updateConta)) {

            stmt.setDouble(1, conta.getSaldo());  // Atualiza o saldo
            stmt.setInt(2, conta.getId_conta());  // Identifica a conta pela chave primária

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Conta atualizada com sucesso!");
            } else {
                System.out.println("Nenhuma conta encontrada para atualizar.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar conta: " + e.getMessage());
        }
    }

    public void deleteConta(ContaBancaria conta) {
        String deleteConta = "DELETE FROM Conta WHERE id_conta = ?";
        try (Connection conn = JDBC_Connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(deleteConta)) {

            stmt.setInt(1, conta.getId_conta());  // Identifica a conta pela chave primária

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Conta excluída com sucesso!");
            } else {
                System.out.println("Nenhuma conta encontrada para excluir.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao excluir conta: " + e.getMessage());
        }
    }



}

