package agifinancasfx.agifinancasfx.control;

import agifinancasfx.agifinancasfx.Model.Cartao;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class ExtratoCartaoController implements Initializable {

    @FXML
    private Label lblNomeCartao;

    @FXML
    private Label lblLimiteCartao;

    @FXML
    private Label lblFatura;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("ExtratoCartaoController inicializado com sucesso!");

        Cartao cartaoSelecionado = UsuarioSessao.getInstance().getCartaoSelecionado();
        if (cartaoSelecionado != null) {
            lblNomeCartao.setText(cartaoSelecionado.getNome());
            lblLimiteCartao.setText(String.format("LIMITE: R$ %.2f", cartaoSelecionado.getLimite()));
            lblFatura.setText("FATURA ATUAL: R$ 0,00"); // Ajuste conforme necessário
        } else {
            System.out.println("Nenhum cartão selecionado foi encontrado.");
        }
    }
    @FXML
    public void sairDoApp(ActionEvent event) {
        // Finaliza o programa
        Platform.exit();
        System.exit(0); // Garante que o processo é encerrado
    }
}