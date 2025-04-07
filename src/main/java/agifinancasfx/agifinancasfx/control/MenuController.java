package agifinancasfx.agifinancasfx.control;

import agifinancasfx.agifinancasfx.DAO.TransacaoContaDAO;
import agifinancasfx.agifinancasfx.DAO.TransacaoDTO;
import agifinancasfx.agifinancasfx.Model.Usuario;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
public class MenuController implements NavegarPeloApp {
    Usuario usuarioAutenticado = UsuarioSessao.getInstance().getUsuario();
    @FXML
    Label nomeUsuario;
    public MenuController() throws SQLException {}
    @FXML
    public void setNomeUsuario(Label nomeUsuario) {
        nomeUsuario.setText("Olá, " + usuarioAutenticado.getNome() + "!");
    }
    @FXML
    public void initialize() {
        setNomeUsuario(nomeUsuario);
        carregarTransacoes(usuarioAutenticado.getIdUsuario());
    }
    @FXML
    private VBox listaTransacao;

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
    public void carregarTransacoes(int idUsuario) {
        listaTransacao.getChildren().clear();

        List<TransacaoDTO> transacoes = TransacaoContaDAO.listarTransacoesPorUsuario(idUsuario);

        for (TransacaoDTO t : transacoes) {
            Label label = new Label(
                    t.getCategoria() + "\n" +
                            "R$ " + t.getValor() + "\n" +
                            new SimpleDateFormat("dd/MM/yyyy").format(t.getDataTransacao())
            );

            label.setStyle("-fx-font-size: 14px; -fx-padding: 8px; -fx-background-color: #e8e8e8; -fx-background-radius: 8; -fx-min-width: 250px");
            label.setTextFill(t.getTipo().equalsIgnoreCase("DESPESA") ? Color.RED : Color.GREEN);

            listaTransacao.getChildren().add(label);
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
