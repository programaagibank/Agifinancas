package control;

import DAO.ContaBancariaDAO;
import model.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SaldoController {
    public static double saldoGeral(Usuario user){
        ContaBancariaDAO contaBancariaDAO = new ContaBancariaDAO();
        return contaBancariaDAO.saldoGeral(user);
    }
}
