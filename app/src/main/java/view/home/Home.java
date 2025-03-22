package view.home;

import DAO.UsuarioDAO;
import view.cadastroUsuario.CadastroUsuarioView;

import java.sql.SQLException;
import java.util.Scanner;

public class Home extends HomeMetodos {
    public static void main(String[] args) throws SQLException {
        Logo();
        Delay(500);


        System.out.println(Assistente + " Olá, Eu sou assistente da AgiFinaças"+ Sorrindo);
        Delay(1000);


        System.out.print(Assistente + " Você já tem Conta?:");
        Scanner sc = new Scanner(System.in);
        String resposta = sc.nextLine().toUpperCase();

        while (!resposta.equals("SIM") && !resposta.equals("NAO")){
            System.out.println("Por favor, responda sim ou nao");
            resposta = sc.nextLine().toUpperCase();
        }

        if (resposta.equals("NAO")){
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            CadastroUsuarioView cadastro = new CadastroUsuarioView(usuarioDAO);
            cadastro.cabecalho();
            cadastro.cadastrarUsuario();
        }
        else {

        }





    }
}
