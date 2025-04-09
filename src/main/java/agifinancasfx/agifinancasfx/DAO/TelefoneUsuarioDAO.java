package agifinancasfx.agifinancasfx.DAO;

import agifinancasfx.agifinancasfx.Model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TelefoneUsuarioDAO {
    public void queryTelefone(TelefoneUsuario telefone) {
        String query = "SELECT id_telefone, id_usuario, ddd_telefone,num_telefone FROM Telefone";
        try (Connection conn = JDBC_Connection.getConnection()) {
            ResultSet tlf = conn.createStatement().executeQuery(query);
            while (tlf.next()) {

                int id_telefone = tlf.getInt("id_telefone");
                int id_usuario = tlf.getInt("id_usuario");
                int ddd_telefone = tlf.getInt("ddd_telefone");
                double num_telefone = tlf.getInt("num_telefone");
                System.out.println(id_telefone + ", " + id_usuario + ", " + ddd_telefone + "" + num_telefone);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar telefone: " + e.getMessage());
        }
    }

    public void insertTelefone(TelefoneUsuario telefone){
        String insertTelefone = "INSERT INTO telefone (id_usuario, id_telefone,ddd_telefone, num_telefone) VALEUS (?,?,?,?)";
        try (Connection conn = JDBC_Connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(insertTelefone)){
            stmt.setDouble(1, telefone.getId_usuario());
            stmt.setInt(2,telefone.getId_telefone());
            stmt.setInt(3,telefone.getDdd_telefone());
            stmt.setDouble(4, telefone.getNum_telefone());
            stmt.executeUpdate();
            System.out.println("Cadastrado com sucesso!");

        } catch (SQLException e) {
        System.out.println("Erro no cadastro");
        }
    }

    public void updateTelefone(TelefoneUsuario telefone) {
        String updateTelefone = "UPDATE telefone SET ddd_telefone = ?, num_telefone = ? WHERE id_usuario = ? AND id_telefone = ?";
        try (Connection conn = JDBC_Connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(updateTelefone)) {

            stmt.setInt(1, telefone.getDdd_telefone());
            stmt.setDouble(2, telefone.getNum_telefone());
            stmt.setInt(3, telefone.getId_usuario());
            stmt.setInt(4, telefone.getId_telefone());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Atualização realizada com sucesso!");
            } else {
                System.out.println("Nenhum telefone encontrado para atualizar.");
            }

        } catch (SQLException e) {
            System.out.println("Erro na atualização: " + e.getMessage());
        }
    }

    public void deleteTelefone(TelefoneUsuario telefone) {
        String deleteTelefone = "DELETE FROM telefone WHERE id_usuario = ? AND id_telefone = ?";
        try (Connection conn = JDBC_Connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(deleteTelefone)) {

            stmt.setInt(1, telefone.getId_usuario());
            stmt.setInt(2, telefone.getId_telefone());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Telefone excluído com sucesso!");
            } else {
                System.out.println("Nenhum telefone encontrado para excluir.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao excluir telefone: " + e.getMessage());
        }
    }




}
