package agifinancasfx.agifinancasfx.control;

import agifinancasfx.agifinancasfx.DAO.ContaBancariaDAO;
import agifinancasfx.agifinancasfx.Model.Usuario;

public class SaldoController {
    public static double saldoGeral(Usuario usuarioAutenticado){
        ContaBancariaDAO contaBancariaDAO = new ContaBancariaDAO();
        return ContaBancariaDAO.saldoGeral(usuarioAutenticado);
    }
}
