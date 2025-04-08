package agifinancasfx.agifinancasfx.control;
import agifinancasfx.agifinancasfx.DAO.CategoriaDAO;
import agifinancasfx.agifinancasfx.Model.Categoria;
import agifinancasfx.agifinancasfx.Model.TransacaoConta;
import agifinancasfx.agifinancasfx.DAO.TransacaoContaDAO;
import agifinancasfx.agifinancasfx.Model.Usuario;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import agifinancasfx.agifinancasfx.DAO.TransacaoContaDAO.*;



public class TransacaoController implements Initializable {
    Usuario usuarioAutenticado = UsuarioSessao.getInstance().getUsuario();
    public static String tipoTransacao;


    @FXML
    private ComboBox<String> cbDescricao;

    @FXML
    private Button btnAdicionar;

    @FXML
    private Button btnCartao;

    @FXML
    private Button btnRelatorio;


    @FXML
    private Button btnmenu;

    @FXML
    private DatePicker dpData;

    @FXML
    private VBox historicoContainer;

    @FXML
    private ToggleButton toggleTipo;

    @FXML
    private TextField txtDescricao;

    @FXML
    private TextField txtValor;

    private TransacaoContaDAO transacaoDAO;

    // Construtor correto sem exceções
    public TransacaoController() {
        try {
            this.transacaoDAO = new TransacaoContaDAO(); // Inicializa o DAO corretamente
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco: " + e.getMessage());
        }
    }

    @FXML
    void adiconartransacao(ActionEvent event) {
        cadastrarTransacao();
    }

    private void cadastrarTransacao() {
        try {
            // Verifica se os campos obrigatórios estão preenchidos
            CategoriaDAO catDAO = new CategoriaDAO();
            if (dpData.getValue() == null || txtValor.getText().isEmpty()) {

                return;
            }

            // Convertendo valor de forma segura
            double valor;
            try {
                valor = Double.parseDouble(txtValor.getText().replace(",", "."));
            } catch (NumberFormatException e) {

                return;
            }

            // Obtendo valores da interface gráfica
            int idUsuario = usuarioAutenticado.getIdUsuario();
            int idConta = transacaoDAO.buscarIdContaPorUsuario(idUsuario);
            String nomeCategoria = cbDescricao.getValue();
            int idCategoria = catDAO.buscarIdPorNomeECodigoUsuario(nomeCategoria, idUsuario);


            String dataTransacao = dpData.getValue().toString();
            String tipo = tipoTransacao;

            // Criando objeto da transação
            TransacaoConta transacao = new TransacaoConta(idUsuario, idConta, idCategoria, valor, dataTransacao, tipo);

            // Inserindo no banco de dados
            transacaoDAO.inserirTransacao(transacao);

            txtValor.clear();

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar transação: " + e.getMessage());
        }
    }


    private static Parent MenuView;
    private static Scene MenuScene;
    @FXML
    void voltarmenu(ActionEvent event) {
        try {
            GeradorCenas.primaryStage.setResizable(false);
            GeradorCenas.loadScene(GeradorCenas.primaryStage, "Home");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }

    private static Parent CartaoView;
    private static Scene CartaoScene;

    @FXML
    void onCartao(ActionEvent event) {
        try {
            if (CartaoView == null) {
                GeradorCenas cenas = new GeradorCenas();
                cenas.gerarNovoStage("Cartao.fxml", "Cartao", false, event);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void voltarrelatorio(ActionEvent event) {

    }


    public void alterarTipo(ActionEvent actionEvent) {
        if (tipoTransacao.equals("Receita")){
            toggleTipo.setText("Despesa");
            toggleTipo.setStyle("-fx-text-fill: red;");
            tipoTransacao = "Despesa";
        }else {
            toggleTipo.setText("Receita");
            toggleTipo.setStyle("-fx-text-fill: green;");
            tipoTransacao = "Receita";
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CategoriaDAO catDAO = null;
        try {
            catDAO = new CategoriaDAO();
            toggleTipo.setText("Receita");
            toggleTipo.setStyle("-fx-text-fill: green;");
            tipoTransacao = "Receita";

            List<Categoria> categoriaList = catDAO.listarCategorias(usuarioAutenticado.getIdUsuario());
            List<String> nomes = new ArrayList<>();
            for (Categoria c : categoriaList) {
                nomes.add(c.getNome());
            }
            cbDescricao.setItems(FXCollections.observableArrayList(nomes));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void clickReturnHome(MouseEvent mouseEvent) {

    }
}


