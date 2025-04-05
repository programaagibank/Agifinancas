package agifinancasfx.agifinancasfx.control.CategoriaController;

import agifinancasfx.agifinancasfx.DAO.CategoriaDAO;
import agifinancasfx.agifinancasfx.Model.Categoria;
import agifinancasfx.agifinancasfx.Model.Usuario;
import agifinancasfx.agifinancasfx.control.UsuarioSessao;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.fxml.Initializable;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ExcluirCategoriaController implements Initializable {
    @FXML
    private ComboBox<String> cbCategorias;
    private List<Categoria> listaCategorias = new ArrayList<>();
    public Usuario usuarioAutenticado = UsuarioSessao.getInstance().getUsuario();
    public CategoriaDAO dao = new CategoriaDAO();

    public ExcluirCategoriaController() throws SQLException {
    }
    public void initialize(URL location, ResourceBundle resources){
        try {
            listaCategorias = dao.consultarCategorias(usuarioAutenticado);
            List<String> nomesCategorias = new ArrayList<>();
            for (Categoria c : listaCategorias) {
                nomesCategorias.add(c.getNome());
            }
            cbCategorias.setItems(FXCollections.observableArrayList(nomesCategorias));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void excluirCategoria(ActionEvent event) throws SQLException, ClassNotFoundException {

    }
}
