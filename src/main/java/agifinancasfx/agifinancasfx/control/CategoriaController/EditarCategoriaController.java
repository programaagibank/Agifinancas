package agifinancasfx.agifinancasfx.control.CategoriaController;

import agifinancasfx.agifinancasfx.DAO.CategoriaDAO;
import agifinancasfx.agifinancasfx.Model.Categoria;
import agifinancasfx.agifinancasfx.Model.Usuario;
import agifinancasfx.agifinancasfx.control.CriarAlertas;
import agifinancasfx.agifinancasfx.control.NavegarPeloApp;
import agifinancasfx.agifinancasfx.control.UsuarioSessao;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.List;
import javafx.fxml.Initializable;
import static java.lang.Double.parseDouble;

public class EditarCategoriaController implements Initializable, NavegarPeloApp {
    private final Usuario usuarioAutenticado = UsuarioSessao.getInstance().getUsuario();
    private final CategoriaDAO dao = new CategoriaDAO();
    private List<Categoria> listaCategorias = new ArrayList<>();
    @FXML
    private ComboBox<String> cbCategorias;
    @FXML
    private TextField nomeCategoria;
    @FXML
    private TextField limiteCategoria;
    private String nomeAntigo;
    public EditarCategoriaController () throws SQLException{}
    public void initialize(URL location, ResourceBundle resources){
        try {
            listaCategorias = dao.consultarCategorias(usuarioAutenticado);
            List<String> nomesCategorias = new ArrayList<>();
            for (Categoria c : listaCategorias) {
                nomesCategorias.add(c.getNome());
            }
            cbCategorias.setItems(FXCollections.observableArrayList(nomesCategorias));
            cbCategorias.setOnAction(e -> preencherCampos());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void preencherCampos() {
        String nomeSelecionado = cbCategorias.getSelectionModel().getSelectedItem();
        for (Categoria c : listaCategorias) {
            if (c.getNome().equals(nomeSelecionado)) {
                nomeCategoria.setText(c.getNome());
                limiteCategoria.setText(String.valueOf(c.getLimite()));
                nomeAntigo = c.getNome();
                break;
            }
        }
    }
    public void atualizarCategoria(ActionEvent event) throws SQLException, IOException {
        String nome = nomeCategoria.getText();
        Double limite = parseDouble(limiteCategoria.getText());
        dao.atualizarCategoria(usuarioAutenticado, nomeAntigo, nome, limite);
        nomeCategoria.clear();
        limiteCategoria.clear();
        cbCategorias.getSelectionModel().clearSelection();
        CriarAlertas.CriarAlerta("Sucesso", "Categoria atualizada com sucesso!", Alert.AlertType.CONFIRMATION);
    }
    @FXML
    private void sairDoApp(ActionEvent event) {
        Platform.exit();
    }
    @FXML
    private void voltarMenu(ActionEvent event) throws IOException {
        NavegarPeloApp.voltarMenu(event);
    }
}
