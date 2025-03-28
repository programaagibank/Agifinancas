package control.CategoriaController;

import DAO.CategoriaDAO;
import model.Categoria;
import view.GerenciarCategorias.CategoriaView;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;

import model.Usuario;

public class CategoriaController {
    private Usuario usuario;
    private CategoriaDAO dao = new CategoriaDAO();
    private CategoriaView categoria;

    public CategoriaController( CategoriaView categoriaView) throws SQLException {
        this.categoria = categoriaView;
    }
    public void criarCategoria(Usuario usuarioAutenticado, Categoria categoria) throws SQLException, ClassNotFoundException {
        dao.CriarCategoria(usuarioAutenticado, categoria);
        System.out.println("Categoria cadastrada com sucesso!");
    }
    public void excluirCategoria(Usuario usuarioAutenticado, String nome) throws SQLException, ClassNotFoundException {
        dao.deletar(usuarioAutenticado, nome);
        System.out.println("Categoria excluida com sucesso!");
    }

    public List<Categoria> exibirCategorias(Usuario usuarioAutenticado) throws SQLException, ClassNotFoundException {
        try {
            List<Categoria> categorias = dao.consultarCategorias(usuarioAutenticado);
            categorias.sort(Comparator.comparing(Categoria::getNome));

            if (categorias.isEmpty()) {
                System.out.println("Nenhuma categoria encontrada para este usuário.");

            }

            System.out.println("\n===== LISTA DE CATEGORIAS =====");
            for (Categoria categoria : categorias) {
                System.out.printf("Nome: %s | Tipo: %s | Limite: %.2f\n",
                        categoria.getNome(),
                        categoria.getTipo(),
                        categoria.getLimite()
                );
            }
            System.out.println("================================\n");

        } catch (RuntimeException e) {
            System.err.println("Erro ao consultar categorias: " + e.getMessage());
        }

        return List.of();
    }
}
