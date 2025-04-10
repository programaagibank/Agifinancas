package agifinancasfx.agifinancasfx.control;

import agifinancasfx.agifinancasfx.DAO.TransacaoContaDAO;
import agifinancasfx.agifinancasfx.Model.Categoria;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import java.sql.SQLException;


public class CategoriaCardController {
    @FXML
    private Label nomeCategoria;
    @FXML
    private Label valorCategoria;
    @FXML
    private ProgressBar barProgress;
    @FXML
    private Label valorAtual;

    public void setDadosCategoria(Categoria categoria, int id) throws SQLException {
        TransacaoContaDAO contaDAO = new TransacaoContaDAO();
        double total = contaDAO.calcularTotalGastoPorCategoria(id, categoria.getId_categoria());
        System.out.println(total);


        barProgress.setProgress(total/categoria.getLimite());

        nomeCategoria.setText(categoria.getNome());
        valorCategoria.setText("R$ " + categoria.getLimite());
        valorAtual.setText("R$ " +total);
    }
}