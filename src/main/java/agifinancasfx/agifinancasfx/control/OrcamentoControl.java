package agifinancasfx.agifinancasfx.control;

import agifinancasfx.agifinancasfx.DAO.CategoriaDAO;
import agifinancasfx.agifinancasfx.DAO.TransacaoContaDAO;
import agifinancasfx.agifinancasfx.Model.Categoria;
import agifinancasfx.agifinancasfx.Model.Usuario;
import java.sql.SQLException;
import java.util.List;

public class OrcamentoControl {
    public static void listarCategorias(Usuario usuarioAutenticado) throws SQLException {
        CategoriaDAO catDao = new CategoriaDAO();
        List<Categoria> lisCat = catDao.consultarCategorias(usuarioAutenticado);
        for (Categoria cat : lisCat) {
            System.out.printf("%d - %s - %.2f\n", cat.getId_categoria(), cat.getNome(), cat.getLimite());
        }
    }

    public static int validarCategoria(int idCategoria, int idUser) {
        try {
            CategoriaDAO catDao = new CategoriaDAO();
            ;
            return (catDao.validacao(idCategoria, idUser) != null) ? 1 : 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void cadastrarLimite(int id, double limite) {
        try {
            CategoriaDAO catDao = new CategoriaDAO();
            catDao.criarLimite(id, limite);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Categoria> listLimite(Usuario usuario){
        try {
            CategoriaDAO categoriaDAO = new CategoriaDAO();
            return categoriaDAO.listaLimites(usuario);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static double valorAtualCategoria(Categoria categoria, Usuario user, String dataInicial, String dataFinal){
        try {
            TransacaoContaDAO trdao = new TransacaoContaDAO();
            return trdao.resultadoCategoria(categoria, user, dataInicial, dataFinal);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
