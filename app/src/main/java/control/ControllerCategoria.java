package control;
import DAO.CategoriaDAO;
import model.Categoria;
import java.sql.SQLException;
import java.sql.SQLOutput;

public class ControllerCategoria {
    private CategoriaDAO categoriaDAO;
    public ControllerCategoria() {
        this.categoriaDAO = new CategoriaDAO();
    }

    public Categoria criarCategoria (int idUsuario, String nome, String tipo){
        try {
            Categoria categoria = CategoriaDAO.insert(idUsuario, nome, tipo);
            if (categoria != null) {
                System.out.println("Categoria criada com sucesso! " + categoria);
            } else {
                System.out.println("Falha ao criar categoria! ");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao criar categoria: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
