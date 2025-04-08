package agifinancasfx.agifinancasfx.control;
import agifinancasfx.agifinancasfx.Model.TransacaoConta;
import agifinancasfx.agifinancasfx.DAO.TransacaoContaDAO;
import agifinancasfx.agifinancasfx.Model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import agifinancasfx.agifinancasfx.DAO.TransacaoContaDAO.*;



public class TransacaoController {
    Usuario usuarioAutenticado = UsuarioSessao.getInstance().getUsuario();

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

            String dataTransacao = dpData.getValue().toString();
            String tipo = toggleTipo.isSelected() ? "Despesa" : "Receita";

            // Criando objeto da transação
            TransacaoConta transacao = new TransacaoConta(idUsuario, idConta, valor, dataTransacao, tipo);

            // Inserindo no banco de dados
            transacaoDAO.inserirTransacao(transacao);



        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar transação: " + e.getMessage());
        }
    }


    private static Parent MenuView;
    private static Scene MenuScene;
    @FXML
    void voltarmenu(ActionEvent event) {
        try {
            if (MenuView == null) {
                GeradorCenas cenas = new GeradorCenas();
                cenas.gerarNovoStage("Home.fxml", "Home", false, event);
            }
        } catch (IOException e) {
            e.printStackTrace();
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



}


