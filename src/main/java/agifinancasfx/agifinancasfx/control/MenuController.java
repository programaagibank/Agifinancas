package agifinancasfx.agifinancasfx.control;

import agifinancasfx.agifinancasfx.DAO.TransacaoContaDAO;
import agifinancasfx.agifinancasfx.DAO.TransacaoDTO;
import agifinancasfx.agifinancasfx.Model.TransacaoConta;
import agifinancasfx.agifinancasfx.Model.Usuario;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    Usuario usuarioAutenticado = UsuarioSessao.getInstance().getUsuario();
    @FXML
    private Label labelSaldo;
    @FXML
    private Label nameUser;
    @FXML
    private Label labelReceita;
    @FXML
    private Label labelDespesas;
    @FXML
    public Button categoriaBtn;
    @FXML
    private VBox listaTransacao;

    public MenuController() {}

    public void setNomeUsuarioLabel(Label nomeUsuarioLabel) {
        nomeUsuarioLabel.setText("Olá, " + usuarioAutenticado.getNome() + "!");
    }

    @FXML
    private void gerenciarCategorias(ActionEvent event) {
        try {
            GeradorCenas cenas = new GeradorCenas();
            cenas.gerarNovoStage("CardCategoria.fxml", "Gerenciar Categorias", false, event);
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            TransacaoContaDAO dao = new TransacaoContaDAO();
            int idUsuario = usuarioAutenticado.getIdUsuario();
            double receitas = dao.calcularTotalReceitas(idUsuario);
            double despesas = dao.calcularTotalDespesas(idUsuario);
            double saldo = dao.calcularSaldoGeral(idUsuario);
            List<TransacaoDTO> contaList = TransacaoContaDAO.listarTransacoesPorUsuario(idUsuario);


            labelSaldo.setText(String.format("R$ %.2f", saldo));
            labelReceita.setText(String.format("R$ %.2f", receitas));
            labelDespesas.setText(String.format("R$ %.2f", despesas));
            nameUser.setText("Olá, "+usuarioAutenticado.getNome());

            for (TransacaoDTO transacao : contaList) {
                Label tipo = new Label("Tipo: " + transacao.getTipo());
                Label data = new Label("Data: " + transacao.getDataTransacao());
                Label valor = new Label(String.format("Valor: R$ %.2f", transacao.getValor()));

                // Estilo único para todos os textos
                String estiloTexto = "-fx-text-fill: white; -fx-font-weight: bold;";
                tipo.setStyle(estiloTexto);
                data.setStyle(estiloTexto);
                valor.setStyle(estiloTexto);

                tipo.setPrefWidth(120);
                data.setPrefWidth(120);
                valor.setPrefWidth(120);

                HBox linha = new HBox(10, tipo, data, valor);
                linha.setStyle("""
        -fx-padding: 5px;
        -fx-background-color: #1c93fc;
        -fx-border-radius: 5px;
        -fx-background-radius: 5px;
    """);

                listaTransacao.getChildren().add(linha);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void acessarTransacao(javafx.scene.input.MouseEvent mouseEvent) {
        try {
            GeradorCenas.primaryStage.setResizable(false);
            GeradorCenas.loadScene(GeradorCenas.primaryStage, "Transacao");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void entrarCartao(ActionEvent actionEvent) {
        try {
            GeradorCenas.primaryStage.setResizable(false);
            GeradorCenas.loadScene(GeradorCenas.primaryStage, "Cartao");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void acessarRelatorio(ActionEvent actionEvent) {
        try {
            GeradorCenas.primaryStage.setResizable(true);
            GeradorCenas.loadScene(GeradorCenas.primaryStage, "RelatorioAtualizado");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void goRelatorio(ActionEvent actionEvent) {
        try {
            GeradorCenas.primaryStage.setResizable(false);
            GeradorCenas.loadScene(GeradorCenas.primaryStage, "RelatorioAtualizado");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}