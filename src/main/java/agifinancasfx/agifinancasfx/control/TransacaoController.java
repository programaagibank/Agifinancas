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
import agifinancasfx.agifinancasfx.DAO.ContaBancariaDAO;



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
                System.out.println("Preencha todos os campos obrigatórios.");
                return;
            }

            // Convertendo valor de forma segura
            double valor;
            try {
                valor = Double.parseDouble(txtValor.getText().replace(",", "."));
            } catch (NumberFormatException e) {
                System.out.println("Erro: O valor informado não é um número válido.");
                return;
            }

            // Obtendo valores da interface gráfica
            int idUsuario = usuarioAutenticado.getIdUsuario(); // Substitua com o ID do usuário autenticado
            int idConta = 1; // Substitua com a conta correta
            String dataTransacao = dpData.getValue().toString();
            String tipo = toggleTipo.isSelected() ? "Despesa" : "Receita"; // desespesa ou receita?

            // Criando objeto da transação
            TransacaoConta transacao = new TransacaoConta(idUsuario, idConta, valor, dataTransacao, tipo);

            // Inserindo no banco de dados
            transacaoDAO.inserirTransacao(transacao);




        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar transação: " + e.getMessage());
        }
    }
    @FXML
    void voltarmenu(ActionEvent event) {
        try {
            // Carregando o arquivo FXML
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/agifinancasfx/agifinancasfx/view/Menu.fxml"));
            Parent arquivo = fxmlLoader.load();

            // Obtendo a cena atual a partir do evento
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Criando uma nova cena com o FXML carregado
            Scene scene = new Scene(arquivo);

            // Definindo a nova cena no Stage
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void onCartao(ActionEvent event) {

    }

    @FXML
    void voltarrelatorio(ActionEvent event) {

    }



}


