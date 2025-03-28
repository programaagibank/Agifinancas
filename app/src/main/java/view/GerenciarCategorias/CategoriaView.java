package view.GerenciarCategorias;

import control.CategoriaController.CategoriaController;
import model.Usuario;
import model.Categoria;
import java.sql.SQLException;
import java.util.Scanner;

public class CategoriaView {
    private CategoriaController categoriaController = new CategoriaController( this);
    Scanner sc = new Scanner(System.in);

    public CategoriaView() throws SQLException {
    }

    public Categoria CriarCategoria(Usuario usuarioAutenticado) throws SQLException {
        String tipo;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Dê um nome à categoria: ");
        String nome = scanner.next();
        System.out.println("Qual o limite da categoria? ");
        double limite = scanner.nextDouble();
        System.out.println("Qual o tipo da categoria? ");
        System.out.println("1- Receita");
        System.out.println("2- Gastos");
        if (scanner.nextInt() == 1) {tipo = "Receita";} else {tipo = "Gastos";}
        Categoria categoria = new Categoria(usuarioAutenticado.getIdUsuario(), nome, tipo, limite);
        CategoriaController controller = new CategoriaController( this);
        try {
            controller.criarCategoria(usuarioAutenticado, categoria);
            System.out.println("Nome da categoria: " + categoria.getNome());
            System.out.println("Tipo da categoria: " + categoria.getTipo());
            System.out.println("Limite da categoria: " + categoria.getLimite());
            return categoria;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void excluirCategoria(Usuario usuarioAutenticado) throws SQLException, ClassNotFoundException {
        System.out.println("Qual o nome da categoria a ser excluída? ");
        String nome = sc.next();
        categoriaController.excluirCategoria(usuarioAutenticado, nome);
    }
    public void listarCategorias(Usuario usuarioAutenticado) throws SQLException, ClassNotFoundException {
        categoriaController.exibirCategorias(usuarioAutenticado);
    }
    public void atualizarCategoria(Usuario usuarioAutenticado) throws SQLException {
        System.out.println("Insira o nome da categoria a ser alterado: ");
        String nome = sc.next();
        System.out.println("Insira o novo nome da categoria: ");
        String novoNome = sc.next();
        //categoriaController.atualizarNomeCategoria(usuarioAutenticado, nome, novoNome);
    }
}
