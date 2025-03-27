package view.orcamento;

import control.OrcamentoControl;
import model.Categoria;
import model.Usuario;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Scanner;

public class OrcamentoMetodo {
    private static int op = 0;
    private static Scanner sc = new Scanner(System.in);
    public static int menuOpcao() {
        int op = 0;
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("----------------------------------------------------");
            System.out.println("|                                                  |");
            System.out.println("| Cadastrar Orçamento para Categoria -> 1          |");
            System.out.println("| Orçamentos -> 2                                  |");
            System.out.println("|                                                  |");
            System.out.println("----------------------------------------------------");
            System.out.println();
            System.out.println("Qual opção deseja?: ");
            op = sc.nextInt();
            sc.nextLine();
            if (op==1||op==2){
                break;
            }else {
                System.out.println("Digite um numero referente ao menu");
            }
        }
        return op;
    }
    public static int obterIdcat(Usuario user) throws SQLException {
        int idCategoria = 0;
        while (true){
            OrcamentoControl.listarCategorias(user.getIdUsuario());
            System.out.println("Selecione uma das categorias: ");
            idCategoria = sc.nextInt();
            sc.nextLine();
            if (OrcamentoControl.validarCategoria(idCategoria, user.getIdUsuario())==1){
                break;
            }else {
                System.out.println("Digite um valor valido");

            }

        }
        return idCategoria;
    }

    public static void cadastrarOrcamento(int idCategoria){
        double limite;
        while (true){
            System.out.println("Qual limite deseja colocar para gastos nessa categoria");
            limite = sc.nextDouble();
            if (limite>0){
                break;
            }else {
                System.out.println("Digite novamente");
            }
        }
        OrcamentoControl.cadastrarLimite(idCategoria, limite);
    }


}
