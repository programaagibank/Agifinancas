//package agifinancasfx.agifinancasfx.control.CategoriaController;
//
//import agifinancasfx.agifinancasfx.DAO.CategoriaDAO;
//import agifinancasfx.agifinancasfx.DAO.TransacaoDTO;
//import agifinancasfx.agifinancasfx.Model.Categoria;
//import agifinancasfx.agifinancasfx.Model.Usuario;
//import agifinancasfx.agifinancasfx.control.GeradorCenas;
//import agifinancasfx.agifinancasfx.control.NavegarPeloApp;
//import agifinancasfx.agifinancasfx.control.UsuarioSessao;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.event.ActionEvent;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.Label;
//import javafx.scene.layout.VBox;
//import javafx.scene.paint.Color;
//import java.io.IOException;
//import java.net.URL;
//import java.sql.SQLException;
//import java.text.SimpleDateFormat;
//import java.util.List;
//import java.util.ResourceBundle;
//
//public class TelaCategoriaController implements Initializable, NavegarPeloApp {
//    @FXML
//    private VBox listaCategorias;
//    @FXML
//    private String nomeCategoriaSelecionada;
//    @FXML
//    private ComboBox<String> modificarCategorias;
//    CategoriaDAO dao = new CategoriaDAO();
//
//    public TelaCategoriaController() throws SQLException {
//    }
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources){
//        try {
//            Usuario usuarioAutenticado = UsuarioSessao.getInstance().getUsuario();
//            carregarCategorias(usuarioAutenticado.getIdUsuario());
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//    @FXML
//    public void carregarCategorias(Usuario usuarioAutenticado) throws SQLException {
//        listaCategorias.getChildren().clear();
//        List<Categoria> categorias = dao.consultarCategorias(usuarioAutenticado);
//
//        for (Categoria c : categorias) {
//            Label label = new Label(
//                    c.getNome() + "\n" +
//                            "R$ " + c.getLimite() + "\n" +
//                            "R$ " + c.getValor();
//
//            );
//            label.setTextFill(c.getTipo().equalsIgnoreCase("DESPESA") ? Color.RED : Color.GREEN);
//            listaCategorias.getChildren().add(label);
//        }
//    }
//    public void excluirCategoria(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
//        GeradorCenas cenas = new GeradorCenas();
//        cenas.gerarNovoStage("ExcluirCategoria.fxml", "Excluir Categoria", false, event);
//
//    }
//
//
//
//}
