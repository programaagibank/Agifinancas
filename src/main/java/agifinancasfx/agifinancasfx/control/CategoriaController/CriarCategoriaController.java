package agifinancasfx.agifinancasfx.control.CategoriaController;

import agifinancasfx.agifinancasfx.DAO.CategoriaDAO;
import agifinancasfx.agifinancasfx.Model.Categoria;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import agifinancasfx.agifinancasfx.Model.Usuario;
import agifinancasfx.agifinancasfx.control.CriarAlertas;
import agifinancasfx.agifinancasfx.control.GeradorCenas;
import agifinancasfx.agifinancasfx.control.NavegarPeloApp;
import agifinancasfx.agifinancasfx.control.UsuarioSessao;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class CriarCategoriaController implements Initializable {
    @FXML
    public ComboBox<String> cbDescricao;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cbDescricao.getItems().clear();
        cbDescricao.getItems().addAll("Receita", "Despesa");
    }
    @FXML
    public TextField txtNomeCategoria;
    @FXML
    public TextField txtLimiteCategoria;
    @FXML
    public javafx.scene.control.Button btnAddCategoria;
    private final Usuario usuarioAutenticado = UsuarioSessao.getInstance().getUsuario();
    private final CategoriaDAO dao = new CategoriaDAO();

    public CriarCategoriaController() throws SQLException {
    }
    @FXML
    public void adicionarCategoria(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        Categoria categoria = new Categoria(usuarioAutenticado.getIdUsuario(), txtNomeCategoria.getText(), cbDescricao.getValue(), Double.parseDouble(txtLimiteCategoria.getText()));
        dao.CriarCategoria(usuarioAutenticado, categoria);
        txtNomeCategoria.clear();
        txtLimiteCategoria.clear();
        cbDescricao.getSelectionModel().clearSelection();
        CriarAlertas.CriarAlerta("Sucesso", "Categoria cadastrada com sucesso!", Alert.AlertType.CONFIRMATION);
        GeradorCenas cenas = new GeradorCenas();
        cenas.gerarNovoStage("Menu.fxml", "Menu", false, event);
    }

    @FXML
    public void voltarMenu(ActionEvent event) throws IOException {
        NavegarPeloApp.voltarMenu(event);
    }
    public void voltarrelatorio(ActionEvent event) {
    }
    public void onCartao(ActionEvent event) {
    }
    public void sairDoApp(ActionEvent event) {
        Platform.exit();
    }

}
