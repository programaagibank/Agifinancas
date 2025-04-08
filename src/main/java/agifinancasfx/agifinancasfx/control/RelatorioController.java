package agifinancasfx.agifinancasfx.control;
import agifinancasfx.agifinancasfx.DAO.Transacao_metaDAO;
import agifinancasfx.agifinancasfx.Model.Transacao_meta;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.List;

public class RelatorioController {




        @FXML
        private Button btnCartao;

        @FXML
        private Button btnDespesas;

        @FXML
        private Button btnMenu;

        @FXML
        private Button btnReceitas;

        @FXML
        private Button btnReservas;

        @FXML
        private ScrollPane scrollPane;

        @FXML
        private VBox vbox;
         private static Parent cartaoView;
         private static Scene cartaoScene;

        @FXML
        void irCartao(ActionEvent event) {
            try {
                if (cartaoView == null) {
                    GeradorCenas cenas = new GeradorCenas();
                    cenas.gerarNovoStage("Cartao.fxml", "Cartao", false, event);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        private static Parent despesaView;
        private static Scene despesaScene;

        @FXML
        void irDespesas(ActionEvent event) {
            try {
                if (despesaView == null) {
                    GeradorCenas cenas = new GeradorCenas();
                    cenas.gerarNovoStage("DespesasA.fxml", "Despesa", false, event);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        private static Parent MenuView;
        private static Scene MenuScene;

        @FXML
        void irMenu(ActionEvent event) {
            try {
                if (MenuView == null) {
                    GeradorCenas cenas = new GeradorCenas();
                    cenas.gerarNovoStage("Home.fxml", "Home", false, event);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        private static Parent receitasView;
        private static Scene receitasScene;

        @FXML
        void irReceitas(ActionEvent event) {
            try {
                if (receitasView == null) {
                    GeradorCenas cenas = new GeradorCenas();
                    cenas.gerarNovoStage("ReceitasA.fxml", "Receitas", false, event);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        private static Parent minhasreservasView;
        private static Scene minhasreservasScene;

        @FXML
        void irReservas(ActionEvent event) {
            try {
                if (despesaView == null) {
                    GeradorCenas cenas = new GeradorCenas();
                    cenas.gerarNovoStage("MetasA.fxml", "Minhas Reservas", false, event);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    @FXML
    public void initialize() {
        Transacao_metaDAO dao = new Transacao_metaDAO();
        List<Transacao_meta> transacoes = dao.listarTransacoes();

        for (Transacao_meta t : transacoes) {
            // Aqui você pode criar visualmente um bloco para cada transação
            Label lbl = new Label("ID: " + t.getIdTransacao()
                    + " | Meta: " + t.getIdMeta()
                    + " | Conta: " + t.getIdConta()
                    + " | Valor: R$" + t.getValor()
                    + " | Data: " + t.getDataTransacao()
                    + " | Tipo: " + t.getTipoTransacao());

            lbl.setStyle("-fx-background-color: #f0f0f0; -fx-padding: 10; -fx-border-color: #ccc;");
            vbox.getChildren().add(lbl);
        }
    }




}
