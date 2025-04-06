package agifinancasfx.agifinancasfx.control.CategoriaController;

import agifinancasfx.agifinancasfx.DAO.CategoriaDAO;
import agifinancasfx.agifinancasfx.Model.Categoria;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
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
import javafx.scene.layout.VBox;

import static java.lang.Double.parseDouble;


public class CategoriaController implements Initializable {
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

    public CategoriaController() throws SQLException {
    }
    @FXML
    public void adicionarCategoria(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        Categoria categoria = new Categoria(usuarioAutenticado.getIdUsuario(), txtNomeCategoria.getText(), cbDescricao.getValue(), Double.parseDouble(txtLimiteCategoria.getText()));
        dao.CriarCategoria(usuarioAutenticado, categoria);
        System.out.println("Categoria cadastrada com sucesso!");
        txtNomeCategoria.clear();
        txtLimiteCategoria.clear();
        cbDescricao.getSelectionModel().clearSelection();
        CriarAlertas.CriarAlerta("Sucesso", "Categoria cadastrada com sucesso!");
        GeradorCenas cenas = new GeradorCenas();
        cenas.gerarNovoStage("/agifinancasfx/agifinancasfx/view/Menu.fxml", "Menu", false, event);
    }


    public List<Categoria> exibirCategorias(ActionEvent event) throws SQLException, ClassNotFoundException {
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
