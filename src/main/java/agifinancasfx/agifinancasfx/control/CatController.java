package agifinancasfx.agifinancasfx.control;

import agifinancasfx.agifinancasfx.DAO.CategoriaDAO;
import agifinancasfx.agifinancasfx.Model.Categoria;
import agifinancasfx.agifinancasfx.Model.Usuario;
import agifinancasfx.agifinancasfx.control.UsuarioSessao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CatController {
    @FXML
    private VBox vboxCategorias;

    private final Usuario usuarioAutenticado = UsuarioSessao.getInstance().getUsuario();

    public CatController() {}

    public void initialize() {
        try {
            CategoriaDAO categoriaDAO = new CategoriaDAO();
            List<Categoria> listaCategorias = categoriaDAO.listarCategoriasPorUsuario(usuarioAutenticado.getIdUsuario());

            for (Categoria categoria : listaCategorias) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CardCategoria.fxml"));
                    Parent card = loader.load();

                    CategoriaCardController cardController = loader.getController();
                    cardController.setDadosCategoria(categoria, usuarioAutenticado.getIdUsuario());

                    vboxCategorias.getChildren().add(card);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void goAddCategoria(javafx.event.ActionEvent actionEvent) {
        // implementar ação de adicionar categoria aqui, se necessário
    }
}
