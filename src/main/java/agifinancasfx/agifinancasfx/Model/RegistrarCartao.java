package agifinancasfx.agifinancasfx.Model;

public class RegistrarCartao {
    public class SistemaDePagamento {

        static class Cartao {
            private String numero;
            private String titular;
            private String validade;

            public Cartao(String numero, String titular, String validade) {
                this.numero = numero;
                this.titular = titular;
                this.validade = validade;
            }

            public String getNumero() {
                return numero;
            }

            public String getTitular() {
                return titular;
            }

            public String getValidade() {
                return validade;
            }
        }

        public void registrarCartao(String numero, String titular, String validade) {
            if (numero.isEmpty() || titular.isEmpty() || validade.isEmpty()) {
                System.out.println("Erro: Todos os campos devem ser preenchidos.");
                return;
            }

            Cartao cartao = new Cartao(numero, titular, validade);

            System.out.println("Cartão registrado com sucesso!");
            System.out.println("Número: " + cartao.getNumero());
            System.out.println("Titular: " + cartao.getTitular());
            System.out.println("Validade: " + cartao.getValidade());
        }

        public void main(String[] args) {
            SistemaDePagamento sistema = new SistemaDePagamento();
            sistema.registrarCartao("1234 5678 9876 5432", "João Silva", "12/25");
        }
    }

}
