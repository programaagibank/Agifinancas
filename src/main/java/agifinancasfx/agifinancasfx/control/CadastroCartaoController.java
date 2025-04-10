package agifinancasfx.agifinancasfx.control;

import agifinancasfx.agifinancasfx.DAO.CartaoDAO;
import agifinancasfx.agifinancasfx.Model.Cartao;
import agifinancasfx.agifinancasfx.Model.Usuario;
import agifinancasfx.agifinancasfx.control.CriarAlertas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class CadastroCartaoController implements Initializable {

    @FXML
    private TextField txtNomeCartao;

    @FXML
    private TextField txtLimite;

    @FXML
    private DatePicker dpData;

    private final CartaoDAO cartaoDAO = new CartaoDAO();
    private final Usuario usuarioAutenticado = UsuarioSessao.getInstance().getUsuario();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("CadastroCartaoController inicializado com sucesso!");
    }

    @FXML
    private void salvarCartao(ActionEvent event) {
        try {
            // Validação dos campos
            String nomeCartao = txtNomeCartao.getText();
            String limiteStr = txtLimite.getText();
            LocalDate dataVencimento = dpData.getValue();

            if (nomeCartao.isEmpty() || limiteStr.isEmpty() || dataVencimento == null) {
                CriarAlertas.CriarAlerta("Erro", "Preencha todos os campos antes de salvar.", javafx.scene.control.Alert.AlertType.ERROR);
                return;
            }

            // Conversão do limite
            double limite = Double.parseDouble(limiteStr);

            // Criação do objeto Cartao
            Cartao novoCartao = new Cartao();
            novoCartao.setNome(nomeCartao);
            novoCartao.setLimite(limite);
            novoCartao.setDataFechamento("2025-12-15"); // Exemplo; ajuste conforme necessário
            novoCartao.setDataValidade("2027-12-15"); // Exemplo; ajuste conforme necessário
            novoCartao.setIdUsuario(UsuarioSessao.getInstance().getUsuario().getIdUsuario());

            // Salvando no banco
            CartaoDAO cartaoDAO = new CartaoDAO();
            cartaoDAO.salvarCartao(novoCartao);

            // Feedback ao usuário
            CriarAlertas.CriarAlerta("Sucesso", "Cartão cadastrado com sucesso!", Alert.AlertType.INFORMATION);

            // Fechar a janela atual e recarregar Cartao.fxml
            ((javafx.stage.Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow()).close();

            GeradorCenas.primaryStage.setResizable(false);
            GeradorCenas.loadScene(GeradorCenas.primaryStage, "Cartao");

        } catch (NumberFormatException e) {
            CriarAlertas.CriarAlerta("Erro", "Informe um valor válido para o limite.", Alert.AlertType.ERROR);
        } catch (SQLException | IOException e) {
            CriarAlertas.CriarAlerta("Erro", "Erro ao salvar o cartão: " + e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }
}
