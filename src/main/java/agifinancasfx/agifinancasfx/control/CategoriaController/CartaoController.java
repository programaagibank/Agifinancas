package agifinancasfx.agifinancasfx.control.CategoriaController;

import agifinancasfx.agifinancasfx.DAO.CartaoDAO;
import agifinancasfx.agifinancasfx.Model.Cartao;
import agifinancasfx.agifinancasfx.Model.Usuario;
import agifinancasfx.agifinancasfx.control.CriarAlertas;
import agifinancasfx.agifinancasfx.control.GeradorCenas;
import agifinancasfx.agifinancasfx.control.NavegarPeloApp;
import agifinancasfx.agifinancasfx.control.UsuarioSessao;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class CartaoController implements Initializable {
    @FXML
    private ListView<Cartao> listaCartoes;

    @FXML
    private Button btnAdicionarCartao;

    @FXML
    private VBox transacoesContainer;

    @FXML
    private Button btnMenu;

    @FXML
    private Button btnRelatorio;

    @FXML
    private Button btnCartao;

    private final Usuario usuarioAutenticado = UsuarioSessao.getInstance().getUsuario();
    private final CartaoDAO cartaoDAO = new CartaoDAO();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        configurarListView();
        try {
            carregarCartoesUsuario();
        } catch (SQLException e) {
            CriarAlertas.CriarAlerta("Erro", "Erro ao carregar cartões: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void configurarListView() {
        listaCartoes.setCellFactory(new Callback<ListView<Cartao>, ListCell<Cartao>>() {
            @Override
            public ListCell<Cartao> call(ListView<Cartao> param) {
                return new ListCell<Cartao>() {
                    @Override
                    protected void updateItem(Cartao cartao, boolean empty) {
                        super.updateItem(cartao, empty);

                        if (empty || cartao == null) {
                            setText(null);
                            setGraphic(null);
                            setStyle("-fx-background-color: transparent;");
                        } else {
                            setStyle("-fx-padding: 0 0 10 0;");
                            setGraphic(criarCartaoPreview(cartao));
                            setOnMouseClicked(event -> {
                                if (event.getClickCount() == 1) {
                                    abrirExtratoCartao(cartao); // Chama o método ao clicar
                                }
                            });
                        }
                    }
                };
            }
        });
    }

        private VBox criarCartaoPreview(Cartao cartao) {
        VBox cartaoBox = new VBox();
        cartaoBox.getStyleClass().add("cartao-3d");
        cartaoBox.setSpacing(10);
        cartaoBox.setPadding(new Insets(15));

        Label nomeLabel = new Label(cartao.getNome());
        nomeLabel.getStyleClass().add("cartao-detalhes-nome");

        // Verifica se a bandeira existe antes de exibir
        String bandeira = (cartao.getBandeira() != null) ? cartao.getBandeira() : "Sem bandeira";
        Label bandeiraLabel = new Label(bandeira);
        bandeiraLabel.getStyleClass().add("cartao-detalhes-texto");

        Label limiteLabel = new Label(String.format("Limite: R$ %.2f", cartao.getLimite()));
        limiteLabel.getStyleClass().add("cartao-detalhes-texto");

        cartaoBox.getChildren().addAll(nomeLabel, bandeiraLabel, limiteLabel);

        return cartaoBox;
    }

    private void abrirExtratoCartao(Cartao cartao) {
        try {
            // Salva o cartão selecionado na sessão
            UsuarioSessao.getInstance().setCartaoSelecionado(cartao);

            // Carrega o novo FXML no mesmo Stage
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/agifinancasfx/agifinancasfx/view/ExtratoCartao.fxml"));
            Parent root = loader.load();

            // Obtém o Stage atual a partir de qualquer nó
            Stage stage = (Stage) listaCartoes.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Extrato do Cartão");
            stage.show();
        } catch (IOException e) {
            CriarAlertas.CriarAlerta("Erro", "Não foi possível abrir o extrato do cartão.", Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }






    private void carregarCartoesUsuario() throws SQLException {
        List<Cartao> cartoes = cartaoDAO.listarCartoesPorUsuario(usuarioAutenticado.getIdUsuario());
        listaCartoes.getItems().clear();
        listaCartoes.getItems().addAll(cartoes);
    }

    @FXML
    public void adicionarCartao(ActionEvent event) {
        try {
            GeradorCenas cenas = new GeradorCenas();
            cenas.gerarNovoStage("CadastroCartao.fxml", "Adicionar Cartão", false, event);
        } catch (IOException e) {
            CriarAlertas.CriarAlerta("Erro", "Erro ao abrir a tela de cadastro de cartões: " + e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }


    @FXML
    public void voltarMenu(ActionEvent event) throws IOException {
        NavegarPeloApp.voltarMenu(event);
    }

    @FXML
    public void voltarrelatorio(ActionEvent event) throws IOException {
        NavegarPeloApp.voltarRelatorio(event);
    }

    @FXML
    public void onCartao(ActionEvent event) {
        try {
            GeradorCenas cenas = new GeradorCenas();
            cenas.gerarNovoStage("Cartao.fxml", "Meus Cartões", false, event);
        } catch (IOException e) {
            CriarAlertas.CriarAlerta("Erro", "Não foi possível abrir a tela de cartões.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    public void sairDoApp(ActionEvent event) {
        // Finaliza o programa
        Platform.exit();
        System.exit(0); // Garante que o processo é encerrado
    }
}