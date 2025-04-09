package agifinancasfx.agifinancasfx.control;
import agifinancasfx.agifinancasfx.DAO.TransacaoContaDAO;
import agifinancasfx.agifinancasfx.DAO.TransacaoDTO;
import agifinancasfx.agifinancasfx.Model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class RelatorioController {

    private final Usuario usuarioAutenticado = UsuarioSessao.getInstance().getUsuario();


        @FXML
        private Button btnCartao;

        @FXML
        private Button btnDespesas;

        @FXML
        private Button btnMenu;

        @FXML
        private DatePicker datePicker;

        @FXML
        private Button idPesquisar;

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
                    cenas.gerarNovoStage("despesa.fxml", "Despesa", false, event);
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
                GeradorCenas.primaryStage.setResizable(true);
                GeradorCenas.loadScene(GeradorCenas.primaryStage, "Home");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }

        private static Parent receitasView;
        private static Scene receitasScene;

        @FXML
        void irReceitas(ActionEvent event) {
            try {
                if (receitasView == null) {
                    GeradorCenas cenas = new GeradorCenas();
                    cenas.gerarNovoStage("receitas.fxml", "Receitas", false, event);
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
                    cenas.gerarNovoStage("minhasReservas.fxml", "Minhas Reservas", false, event);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    @FXML
    private void buscarTransacoes() {
        LocalDate dataSelecionada = datePicker.getValue();

        if (dataSelecionada == null) {
            System.out.println("Selecione uma data para filtrar.");
            return;
        }

        Date dataSql = Date.valueOf(dataSelecionada);
        List<TransacaoDTO> transacoes = TransacaoContaDAO.listarTransacoesPorUsuarioEData(usuarioAutenticado.getIdUsuario(), dataSql);

        vbox.getChildren().clear();

        if (transacoes.isEmpty()) {
            Label vazio = new Label("Nenhuma transação encontrada.");
            vbox.getChildren().add(vazio);
            return;
        }

        for (TransacaoDTO t : transacoes) {
            Label lbl = new Label(
                    "Data: " + t.getDataTransacao() +
                            " | Valor: R$ " + t.getValor() +
                            " | Tipo: " + t.getTipo() +
                            " | Categoria: " + t.getCategoria()
            );
            lbl.setStyle("-fx-padding: 8; -fx-background-color: #eef; -fx-border-color: #ddd;");
            vbox.getChildren().add(lbl);
        }
    }






}
