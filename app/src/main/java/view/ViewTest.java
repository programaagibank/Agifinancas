package view;

import java.io.Console;
import java.util.Scanner;

public class ViewTest {

    static class User {
        private String name;
        private String email;
        private String phone;
        private String password;

        public User(String name, String email, String phone, String password) {
            this.name = name;
            this.email = email;
            this.phone = phone;
            this.password = password;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public String toString() {
            return "User [Name: " + name + ", Email: " + email + ", Phone: " + phone + "]";
        }
    }

    static class UserInputView {
        private Scanner scanner;

        public UserInputView() {
            this.scanner = new Scanner(System.in);
        }

        public String getStringInput(String prompt) {
            System.out.println(prompt);
            return scanner.nextLine().trim();
        }

        public String getValidEmail() {
            String email;
            while (true) {
                email = getStringInput("Digite seu e-mail:");
                if (email.contains("@") && email.contains(".")) {
                    break; // Validação simples de email
                } else {
                    System.out.println("E-mail inválido! Por favor, insira um e-mail válido.");
                }
            }
            return email;
        }

        public String getValidPhone() {
            String phone;
            while (true) {
                phone = getStringInput("Digite seu número de telefone (apenas números):");
                if (phone.matches("\\d{10,11}")) {  // Validação simples para 10 ou 11 dígitos
                    break;
                } else {
                    System.out.println("Número de telefone inválido! Por favor, insira um número válido.");
                }
            }
            return phone;
        }

        public String getPasswordInput(String prompt) {
            Console console = System.console();
            if (console == null) {
                System.out.println("Erro: Console não disponível.");
                return null;
            }
            char[] passwordArray = ((java.io.Console) console).readPassword(prompt);
            return new String(passwordArray);
        }

        public User getUserDetails() {
            String name = getStringInput("Digite seu nome:");
            String email = getValidEmail();
            String phone = getValidPhone();
            String password = getPasswordInput("Crie uma senha:");
            return new User(name, email, phone, password);
        }

        public void displayUserDetails(User user) {
            System.out.println("Detalhes do Usuário:");
            System.out.println(user);
        }

        public String changePassword() {
            return getPasswordInput("Digite sua nova senha:");
        }
    }

    public static void main(String[] args) {
        UserInputView inputView = new UserInputView();

        // Solicitar os dados do usuário
        User user = inputView.getUserDetails();

        // Exibir os dados inseridos (sem mostrar a senha)
        inputView.displayUserDetails(user);

        // Alterar a senha do usuário
        String newPassword = inputView.changePassword();
        user.setPassword(newPassword);  // Atualizar a senha

        System.out.println("Senha alterada com sucesso!");

        // Exibir os detalhes atualizados do usuário
        inputView.displayUserDetails(user);

        // Inserir a senha novamente para autenticação
        String enteredPassword = inputView.getPasswordInput("Digite a senha novamente para autenticação:");
        if (enteredPassword.equals(user.getPassword())) {
            System.out.println("Senha correta. Autenticação bem-sucedida.");
        } else {
            System.out.println("Senha incorreta. Tentativa de autenticação falhou.");
        }
    }
}
