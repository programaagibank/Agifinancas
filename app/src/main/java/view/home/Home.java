package view.home;

import view.cadastroUsuario.UsuarioView;
import view.loginUsuario.LoginView;

import java.util.Scanner;

public class Home extends HomeMetodos {
    public static void main(String[] args) {
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
            UsuarioView cadastro = new UsuarioView();
            cadastro.cabecalho();
            cadastro.coletarDados();
        }
        else {
            LoginView login = new LoginView();
            login.dadosLogin();
        }





    }
}
