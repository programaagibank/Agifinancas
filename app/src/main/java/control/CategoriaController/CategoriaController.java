package control.CategoriaController;

import DAO.CategoriaDAO;
import model.Categoria;
import view.GerenciarCategorias.CategoriaView;
import java.sql.SQLException;
import model.Usuario;

public class CategoriaController {
    private Usuario usuario;
    private CategoriaDAO dao = new CategoriaDAO();
    private CategoriaView categoria;

    public CategoriaController(Usuario usuarioAutenticado, CategoriaView categoriaView) throws SQLException {
        this.usuario = usuarioAutenticado;
        this.categoria = categoriaView;
    }
    public Categoria criarCategoria(Usuario usuarioAutenticado, Categoria categoria) throws SQLException, ClassNotFoundException {
        dao.CriarCategoria(usuarioAutenticado, categoria);
        System.out.println("Categoria cadastrada com sucesso!");
        return categoria;
    }
}
