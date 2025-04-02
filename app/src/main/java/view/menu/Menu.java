package view.menu;

import DAO.TransacaoContaDAO;
import control.TransacaoContaController;
import model.Usuario;
import view.GerenciarCategorias.CategoriaView;
import view.GerenciarCategorias.Categorias;
import view.TransacaoConta.TransacaoContaView;
import view.chatSuporte.ChatSuporte;
import view.finalizacao.Finalizacaoview;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu extends MenuMetodos {
    public static void menu(Usuario usuarioAutenticado) throws SQLException, ClassNotFoundException {
        int resposta;

        Scanner sc = new Scanner(System.in);

        System.out.print(RED+"Entrando");
//        for (int i=0; i <=6;i++){
//            System.out.print(".");
//            Delay(1000);
//        }
        System.out.println(RESET);

        logomenu();

        System.out.println(BLUE + "Categorias" + RESET);
        System.out.println("----------------------------------------------------");
        System.out.println("|                                                  |");
        System.out.println("| Gastos fixos -> 1                                |");
        System.out.println("| Transações -> 2                                  |");
        System.out.println("| Gastos excedentes -> 3                           |");
        System.out.println("| Definir meta de economia -> 4                    |");
        System.out.println("| Criar uma reserva de emergência -> 5             |");
        System.out.println("| Gerar alertas definidos pelo usuário -> 6        |");
        System.out.println("| Chat de Suporte -> 7                             |");
        System.out.println("|                                                  |");
        System.out.println("| Fechar sistema -> 8                              |");
        System.out.println("----------------------------------------------------");
        System.out.println();
        System.out.print("Qual Categoria deseja?: ");
        resposta = sc.nextInt();

        switch (resposta){
            case 1:
                Categorias categorias = new Categorias();
                categorias.startcategoria(usuarioAutenticado);

                break;
            case 2:
                try {
                    TransacaoContaView view = new TransacaoContaView();
                    TransacaoContaDAO dao = new TransacaoContaDAO();
                    TransacaoContaController controller = new TransacaoContaController(view, dao);
                    controller.cadastrarTransacao(usuarioAutenticado);
                } catch (SQLException e) {
                    System.out.println("Erro no banco de dados: " + e.getMessage());
                }
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                ChatSuporte chat = new ChatSuporte();
                chat.iniciarChatSuporte(usuarioAutenticado);
                break;
            case 7:
                Finalizacaoview fechamento = new Finalizacaoview();
                fechamento.Fim();
                break;

        }






    }

}
