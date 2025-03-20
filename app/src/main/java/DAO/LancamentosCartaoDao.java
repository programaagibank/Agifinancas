package DAO;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class LancamentosCartaoDao {
    public class CartaoLancamento {
        private int idLancamento;
        private int idCartao;
        private double valor;
        private Date data;
        private boolean recorrencia;

        // Construtor
        public CartaoLancamento(int idLancamento, int idCartao, double valor, Date data, boolean recorrencia) {
            this.idLancamento = idLancamento;
            this.idCartao = idCartao;
            this.valor = valor;
            this.data = data;
            this.recorrencia = recorrencia;
        }

        // Getters e Setters
        public int getIdLancamento() {
            return idLancamento;
        }

        public void setIdLancamento(int idLancamento) {
            this.idLancamento = idLancamento;
        }

        public int getIdCartao() {
            return idCartao;
        }

        public void setIdCartao(int idCartao) {
            this.idCartao = idCartao;
        }

        public double getValor() {
            return valor;
        }

        public void setValor(double valor) {
            this.valor = valor;
        }

        public Date getData() {
            return data;
        }

        public void setData(Date data) {
            this.data = data;
        }

        public boolean isRecorrencia() {
            return recorrencia;
        }

        public void setRecorrencia(boolean recorrencia) {
            this.recorrencia = recorrencia;
        }

        @Override
        public String toString() {
            return "Lançamento{" +
                    "ID do Lançamento=" + idLancamento +
                    ", ID do Cartão=" + idCartao +
                    ", Valor=" + valor +
                    ", Data=" + data +
                    ", Recorrente=" + (recorrencia ? "Sim" : "Não") +
                    '}';
        }
        public void main(String[] args) {
            // Lista para armazenar os lançamentos de cartões
            List<CartaoLancamento> lancamentos = new ArrayList<>();

            // Criando lançamentos de cartão de exemplo
            lancamentos.add(new CartaoLancamento(1, 100, 150.75, new Date(), true));  // Recorrente
            lancamentos.add(new CartaoLancamento(2, 102, 85.50, new Date(), false)); // Não Recorrente
            lancamentos.add(new CartaoLancamento(3, 101, 200.00, new Date(), true));  // Recorrente
            lancamentos.add(new CartaoLancamento(4, 103, 50.25, new Date(), false)); // Não Recorrente

            // Exibindo os lançamentos
            for (CartaoLancamento lancamento : lancamentos) {
                System.out.println(lancamento);
            }
        }
    }
}
