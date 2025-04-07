package agifinancasfx.agifinancasfx.control;

import agifinancasfx.agifinancasfx.Model.Usuario;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController implements NavegarPeloApp {
    Usuario usuarioAutenticado = UsuarioSessao.getInstance().getUsuario();
    @FXML
    public Button categoriaBtn;
    @FXML
    Label nomeUsuarioLabel;
    public MenuController() {}
    @FXML
    public void initialize() {
        setNomeUsuarioLabel(nomeUsuarioLabel);
    }

    public void setNomeUsuarioLabel(Label nomeUsuarioLabel) {
        nomeUsuarioLabel.setText("Olá, " + usuarioAutenticado.getNome() + "!");
    }

    @FXML
    private void gerenciarCategorias(ActionEvent event) {
        try {
            GeradorCenas cenas = new GeradorCenas();
            cenas.gerarNovoStage("Categoria.fxml", "Gerenciar Categorias", false, event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void abrirTransacoes(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo1/Transacoes.fxml"));
            Parent transacoesRoot = loader.load();

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            Scene transacoesScene = new Scene(transacoesRoot, 800, 600);

            stage.setScene(transacoesScene);
            stage.setTitle("Transações");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void abrirMetas(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo1/Metas.fxml"));
            Parent metasRoot = loader.load();

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            Scene metasScene = new Scene(metasRoot, 800, 600);

            stage.setScene(metasScene);
            stage.setTitle("Metas");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void abrirRelatorios(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo1/Relatorios.fxml"));
            Parent relatoriosRoot = loader.load();

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            Scene relatoriosScene = new Scene(relatoriosRoot, 800, 600);

            stage.setScene(relatoriosScene);
            stage.setTitle("Relatórios");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void atualizarCategorias(ActionEvent event) {
        try {
            GeradorCenas cenas = new GeradorCenas();
            cenas.gerarNovoStage("EditarCategoria2.fxml", "Gerenciar Categorias", false, event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void excluirCategoria(ActionEvent event) {
        try {
            GeradorCenas cenas = new GeradorCenas();
            cenas.gerarNovoStage("ExcluirCategoria.fxml", "Excluir Categorias", false, event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void voltarMenu(ActionEvent event) throws IOException {
        NavegarPeloApp.voltarMenu(event);
    }
    @FXML
    private void sairDoApp(ActionEvent event) {
        Platform.exit();
    }
}
