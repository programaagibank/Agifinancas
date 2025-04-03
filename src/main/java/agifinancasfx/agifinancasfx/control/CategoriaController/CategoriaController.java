package agifinancasfx.agifinancasfx.control.CategoriaController;

import agifinancasfx.agifinancasfx.DAO.CategoriaDAO;
import agifinancasfx.agifinancasfx.Model.Categoria;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import agifinancasfx.agifinancasfx.Model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class CategoriaController {
    private Categoria categoria;
    private Usuario usuarioAutenticado;
    private CategoriaDAO dao = new CategoriaDAO();
    public CategoriaController() throws SQLException {
    }
    public void setUsuarioAutenticado(Usuario usuarioAutenticado) {
        this.usuarioAutenticado = usuarioAutenticado;
    }
    @FXML
    private void excluirCategoria(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String nome = "";
        dao.deletar(usuarioAutenticado, nome);
        System.out.println("Categoria excluida com sucesso!");
    }
    @FXML
    private List<Categoria> exibirCategorias(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
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
    @FXML
    private void atualizarCategoria(ActionEvent actionEvent/*, Usuario usuarioAutenticado, String propriedade, String nome, String novoValor*/) throws SQLException {
        String propriedade = "";
        String nome = "";
        String novoValor = "";
        dao.atualizarCategoria(usuarioAutenticado, propriedade, nome, novoValor);
    }
    @FXML
    private void criarCategoria(ActionEvent event) throws SQLException, ClassNotFoundException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/agifinancasfx/agifinancasfx/view/criarCategoria.fxml"));
            dao.CriarCategoria(usuarioAutenticado, categoria);
            System.out.println("Categoria cadastrada com sucesso!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

