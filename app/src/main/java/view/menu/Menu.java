package view.menu;

import model.Usuario;
import view.GerenciarCategorias.CategoriaView;
import view.finalizacao.Finalizacaoview;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu extends MenuMetodos {
    public static void menu(Usuario usuarioAutenticado) throws SQLException {
        int resposta;

        Scanner sc = new Scanner(System.in);

        System.out.print(RED+"Entrando");
        for (int i=0; i <=6;i++){
            System.out.print(".");
            Delay(1000);
        }
        System.out.println(RESET);

        logomenu();

        System.out.println(BLUE + "Categorias" + RESET);
        System.out.println("----------------------------------------------------");
        System.out.println("|                                                  |");
        System.out.println("| Gastos fixos -> 1                                |");
        System.out.println("| Gastos excedentes -> 2                           |");
        System.out.println("| Definir meta de economia -> 3                    |");
        System.out.println("| Criar uma reserva de emergência -> 4             |");
        System.out.println("| Gerar alertas definidos pelo usuário -> 5        |");
        System.out.println("|                                                  |");
        System.out.println("| Fechar sistema -> 6                              |");
        System.out.println("----------------------------------------------------");
        System.out.println();
        System.out.print("Qual Categoria deseja?: ");
        resposta = sc.nextInt();

        switch (resposta){
            case 1:
                CategoriaView categoria = new CategoriaView();
                categoria.CriarCategoria(usuarioAutenticado);

                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                Finalizacaoview fechamento = new Finalizacaoview();
                fechamento.Fim();
                break;

        }






    }

}
