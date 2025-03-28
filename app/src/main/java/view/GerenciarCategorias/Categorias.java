package view.GerenciarCategorias;

import model.Categoria;
import model.Usuario;
import view.GerenciarCategorias.CategoriaView;

import java.sql.SQLException;
import java.util.Scanner;

public class Categorias {
    public static void startcategoria(Usuario usuarioAutenticado) throws SQLException, ClassNotFoundException {
        int opcao;
        Scanner sc = new Scanner(System.in);
        CategoriaView categoriaView = new CategoriaView();


        System.out.println("Opções");
        System.out.println("------------------------------------------------------------");
        System.out.println("|                                                          |");
        System.out.println("| Criar uma nova categoria de despesa ou receita -> 1      |");
        System.out.println("| Visualizar todas as categorias -> 2                      |");
        System.out.println("| Alterar o limite da categoria  -> 3                      |");
        System.out.println("| Deletar categoria  -> 4                                  |");
        System.out.println("|                                                          |");
        System.out.println("------------------------------------------------------------");
        System.out.println();
        System.out.println("Qual opção deseja?: ");
        opcao = sc.nextInt();

        switch (opcao){
            case 1:
                categoriaView.CriarCategoria(usuarioAutenticado);
                // Aqui o usuario podera criar uma nova categoria de despesa ou receita, preenchendo os campos do banco de dados
                break;
            case 2:
                categoriaView.listarCategorias(usuarioAutenticado);
                // Aqui o usuario podera vizualizar todas as categorias
                break;
            case 3:
                categoriaView.listarCategorias(usuarioAutenticado);
                categoriaView.atualizarCategoria(usuarioAutenticado);
                // Aqui o usuario podera alterar o limite da categoria desejada
                break;
            case 4:
                categoriaView.excluirCategoria(usuarioAutenticado);
                // Aqui o usuario podera deletar a categoria desejada
                break;


        }

    }
}
