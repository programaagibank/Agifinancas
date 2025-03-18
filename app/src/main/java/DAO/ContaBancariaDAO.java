package DAO;

import model.*;

import java.sql.Connection;
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
                double id_conta = ct.getDouble("id_conta");
                System.out.println(saldo + ", " + id_usuario + ", " + id_conta);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar conta: " + e.getMessage());
        }
    }
}

