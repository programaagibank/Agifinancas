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
import javafx.scene.control.ComboBox;
import javafx.fxml.Initializable;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ExcluirCategoriaController implements Initializable, NavegarPeloApp{
    @FXML
    private ComboBox<String> cbCategorias;
    public Usuario usuarioAutenticado = UsuarioSessao.getInstance().getUsuario();
    public CategoriaDAO dao = new CategoriaDAO();
    private String nomeCategoriaSelecionada;
    public ExcluirCategoriaController() throws SQLException {
    }
    public void initialize(URL location, ResourceBundle resources){
        try {
            List<Categoria> listaCategorias = dao.consultarCategorias(usuarioAutenticado);
            List<String> nomesCategorias = new ArrayList<>();
            for (Categoria c : listaCategorias) {
                nomesCategorias.add(c.getNome());
            }
            cbCategorias.setItems(FXCollections.observableArrayList(nomesCategorias));
            cbCategorias.setOnAction(e -> {
                nomeCategoriaSelecionada = cbCategorias.getSelectionModel().getSelectedItem();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void excluirCategoria(ActionEvent event) throws SQLException, ClassNotFoundException {
        if (nomeCategoriaSelecionada != null && !nomeCategoriaSelecionada.isEmpty()) {
            boolean confirmado = CriarAlertas.confirmarExclusao(nomeCategoriaSelecionada);
            if (confirmado) {
                dao.deletar(usuarioAutenticado, nomeCategoriaSelecionada);
                CriarAlertas.CriarAlerta("Sucesso", "Categoria \"" + nomeCategoriaSelecionada + "\" excluída com sucesso!");
                cbCategorias.getItems().remove(nomeCategoriaSelecionada);
                nomeCategoriaSelecionada = null;
            }
        } else {
            CriarAlertas.CriarAlerta("Atenção", "Selecione uma categoria para excluir.");
        }
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
